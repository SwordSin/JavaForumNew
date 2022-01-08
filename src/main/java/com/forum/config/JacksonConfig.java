package com.forum.config; /**
 * jackjson 配置long ->string , data 格式化
 */

//package com.forum.config;

//import com.fasterxml.jackson.databind.ObjectMapper;
//import com.fasterxml.jackson.databind.module.SimpleModule;
//import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
//import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.Primary;
//import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;

//@Configuration
//public class JacksonConfig {
//    @Value("${my-meta-data.time-type}")
//    private String timeFormatter;
//    @Bean
//    @Primary
//    @ConditionalOnMissingBean(ObjectMapper.class)
//    public ObjectMapper jacksonObjectMapper(Jackson2ObjectMapperBuilder builder)
//    {
//        ObjectMapper objectMapper = builder.createXmlMapper(false).build();
//
//        // 全局配置序列化返回 JSON 处理
//        SimpleModule simpleModule = new SimpleModule();
//        //JSON Long ==> String
//        simpleModule.addSerializer(Long.class, ToStringSerializer.instance);
//        // 格式化时间
//        simpleModule.addSerializer(LocalDateTime.class,new LocalDateTimeSerializer(DateTimeFormatter.ofPattern(timeFormatter)));
////        simpleModule.
//        objectMapper.registerModule(simpleModule);
//        return objectMapper;
//    }
//}
