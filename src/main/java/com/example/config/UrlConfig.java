package com.example.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

/**
 * @Description TODO
 * @Date 2022/4/4 23:32
 * @Version 1.0
 */
@Configuration
public class UrlConfig {
    @Bean
    public CorsFilter corsFilter() {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        CorsConfiguration configuration = new CorsConfiguration();
        /*是否允许请求带有验证信息*/
        configuration.setAllowCredentials(true);
        /*允许访问的客户端域名*/
        configuration.addAllowedOrigin("*");
        /*允许服务端访问的客户端请求头*/
        configuration.addAllowedHeader("*");
        /*允许访问的方法名,GET POST等*/
        configuration.addAllowedMethod("*");
        source.registerCorsConfiguration("/**", configuration);
        return new CorsFilter(source);
    }

}
