package com.forum.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

// 将properties加载到spring项目中 myconfig.properties
@Component
@Slf4j
@PropertySource(value = {"classpath:myconfig.properties"}, encoding = "utf-8")
@ConfigurationProperties(prefix = "config.data")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PropertiesList {
    private String timeType;
    private String ukEmail;
    private String ukUsername;
    private String ukBoardName;
}
