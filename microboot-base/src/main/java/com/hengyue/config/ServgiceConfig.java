package com.hengyue.config;

import com.hengyue.service.impl.IMessageServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 表示此处微配置项
 */
@Configuration
public class ServgiceConfig {
    @Bean(name = "configService")
    public IMessageServiceImpl getMessageService(){
        return  new IMessageServiceImpl();
    }


}
