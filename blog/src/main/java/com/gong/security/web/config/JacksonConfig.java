package com.gong.security.web.config;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.jackson.Jackson2ObjectMapperBuilderCustomizer;
import org.springframework.boot.autoconfigure.jackson.JacksonProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.util.List;
import java.util.Locale;

/**
 * Created by SNOW on 2018.01.31.
 * 不知道为什么全局配置不生效
 * ，所以出此下策，后续发现了再回来该吧
 */
@Configuration
@EnableWebMvc
@Slf4j
public class JacksonConfig extends WebMvcConfigurerAdapter {

    //1 jacksonProperties

    //2 jackson2ObjectMapperBuilderCustomizer

    //3 jackson2ObjectMapperBuilder

    //4 jacksonObjectMapper

    //5 MappingJackson2HttpMessageConverter

    @Autowired
    private JacksonProperties jacksonProperties;
//
//    @Autowired
//    private Jackson2ObjectMapperBuilderCustomizer jackson2ObjectMapperBuilderCustomizer;
//
//    @Autowired
//    private Jackson2ObjectMapperBuilder jackson2ObjectMapperBuilder;
//
//    @Autowired
//    private ObjectMapper objectMapper;

    @Autowired
    private MappingJackson2HttpMessageConverter mappingJackson2HttpMessageConverter;

    @Override
    public void extendMessageConverters(
            List<HttpMessageConverter<?>> converters) {
        ObjectMapper objectMapper = new ObjectMapper();
//        objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
//        objectMapper.setLocale(Locale.ENGLISH);
        objectMapper.setSerializationInclusion(jacksonProperties.getDefaultPropertyInclusion());
        objectMapper.setLocale(jacksonProperties.getLocale());
        // 踢掉原有的，可能是被串改了。所以采用这么笨的办法。
        converters.remove(converters.size()-1);
//        MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter(objectMapper);
        converters.add(mappingJackson2HttpMessageConverter);
    }
}
