package com.example.demo.commun.core.config;

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MvcResult;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.util.Set;

public abstract class AbstractControllerTest {

    @Autowired
    public ObjectMapper mapper;

    private static String getResponseContentAsString(final MvcResult mvcResult) throws UnsupportedEncodingException {
        return mvcResult.getResponse().getContentAsString(StandardCharsets.UTF_8);
    }

    public <T> T getMvcResult(final MvcResult mvcResult, final Class<T> valueType) throws IOException {
        return mapper.readValue(getResponseContentAsString(mvcResult), valueType);
    }

    public <T> Set<T> getMvcResultAsSet(final MvcResult mvcResult, final Class<T> classSetType) throws IOException {
        // TODO : ou use ex mapper.readValue(contentAsString, new TypeReference<List<ContratDTO>>()
        final String contentAsString = getResponseContentAsString(mvcResult);
        final JavaType setType = mapper.getTypeFactory().constructCollectionType(Set.class, classSetType);
        return mapper.readValue(contentAsString, setType);
    }
}
