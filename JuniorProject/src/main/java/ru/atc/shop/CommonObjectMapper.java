package ru.atc.shop;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import javax.annotation.PostConstruct;

import static ch.qos.logback.classic.BasicConfigurator.configure;

public class CommonObjectMapper extends ObjectMapper {
    @PostConstruct
   public void postConstruct() {
       configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
       configure(SerializationFeature.INDENT_OUTPUT, true);
       configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    }
}