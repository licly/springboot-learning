package org.charlie.config;

import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import com.fasterxml.jackson.databind.module.SimpleModule;
import jakarta.annotation.Resource;
import org.charlie.interceptor.LoginInterceptor;
import org.charlie.servlet.RegisterServlet;
import org.springframework.boot.autoconfigure.http.HttpMessageConverters;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.core.convert.converter.Converter;
import org.springframework.format.FormatterRegistry;
import org.springframework.http.converter.ByteArrayHttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

import java.io.IOException;
import java.util.Locale;

/**
 * @author Charlie-6327
 * @date 2023/5/2
 */

// @Configuration
@ServletComponentScan("org.charlie")
public class WebConfig implements WebMvcConfigurer {

    @Resource
    private LoginInterceptor loginInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(loginInterceptor).addPathPatterns("/**")
                .excludePathPatterns("/login/**")
                .excludePathPatterns("/static/**");
        registry.addInterceptor(localeChangeInterceptor());
    }

    /**
     * 切换语言拦截器，通过url?lang=zh_CN形式切换
     * @return
     */
    private  LocaleChangeInterceptor localeChangeInterceptor() {
        LocaleChangeInterceptor interceptor = new LocaleChangeInterceptor();
        interceptor.setParamName("lang");
        return interceptor;
    }

    @Bean
    public LocaleResolver localeResolver() {
        SessionLocaleResolver resolver = new SessionLocaleResolver();
        // 设置默认为英文
        resolver.setDefaultLocale(Locale.US);
        return resolver;
    }

    @Bean
    public HttpMessageConverters customConverters() {
        StringHttpMessageConverter stringConverter = new StringHttpMessageConverter();
        ByteArrayHttpMessageConverter byteConverter = new ByteArrayHttpMessageConverter();
        return new HttpMessageConverters(stringConverter, byteConverter);
    }


    @Bean
    public MappingJackson2HttpMessageConverter mappingJackson2HttpMessageConverter() {
        MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

        SimpleModule simpleModule = new SimpleModule();
        simpleModule.addDeserializer(String.class, new StringWithoutSpaceDeserializer(String.class));
        objectMapper.registerModule(simpleModule);

        converter.setObjectMapper(objectMapper);
        return converter;
    }

    public static class StringWithoutSpaceDeserializer extends StdDeserializer<String> {

        protected StringWithoutSpaceDeserializer(Class<?> vc) {
            super(vc);
        }

        @Override
        public String deserialize(JsonParser p, DeserializationContext ctxt) throws IOException, JacksonException {
            return StringUtils.trimAllWhitespace(p.getText());
        }
    }

    @Override
    public void addFormatters(FormatterRegistry registry) {
        registry.addConverter(new CustomConvert());
    }

    public static class CustomConvert implements Converter<String, String> {

        @Override
        public String convert(String source) {
            if (StringUtils.hasText(source)) {
                source = source.trim();
            }
            return source;
        }
    }

    @Bean
    public ServletRegistrationBean<RegisterServlet> registerServlet() {
        var bean = new ServletRegistrationBean<>(
                new RegisterServlet(), "/registerServlet");
        bean.addInitParameter("name", "charlie");
        bean.addInitParameter("sex", "male");
        return bean;
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/assets/**").addResourceLocations("classpath:/assets/");
        registry.addResourceHandler("/dist/**").addResourceLocations("classpath:/dist/");
    }

}
