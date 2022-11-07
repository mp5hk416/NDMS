package com.ndms.ndms.me.webapi.security.config;

import com.ndms.ndms.me.webapi.filter.JwtAuthorityFilter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

/**
 * 時間:2022/10/13  下午 08:15
 * 俊翔，好好加油，找到好工作
 * 項目名:ndms
 */

@Configuration
@Slf4j
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

//    @Bean
//    CorsConfigurationSource corsConfigurationSource(){//針對普通簡單請求前的預檢請求，由於該請求不攜帶cookie，spring security憑證上可能會出錯，故添加該對象
//        CorsConfigurationSource source =   new UrlBasedCorsConfigurationSource();
//        CorsConfiguration corsConfiguration = new CorsConfiguration();
//        corsConfiguration.addAllowedOrigin("*");	//同源配置，*表示任何请求都视为同源，若需指定ip和端口可以改为如“localhost：8080”，多个以“，”分隔；
//        corsConfiguration.addAllowedHeader("Authorization");//header，允许哪些header，本案中使用的是token，此处可将*替换为token；
//        corsConfiguration.addAllowedMethod("*");	//允许的请求方法，PSOT、GET等
//        ((UrlBasedCorsConfigurationSource) source).registerCorsConfiguration("/**",corsConfiguration); //配置允许跨域访问的url
//        return source;
//    }

    @Autowired
    private JwtAuthorityFilter jwtAuthorityFilter;


    String [] urls={
            "/swagger-resources/**",
            "/v2/api-docs/**",
            "/favicon.ico",
            "/",
            "/*.html",
            "/**/*.html",
            "/**/*.css",
            "/**/*.js",
            "/**/emp/login",
            "/**/emp/logout"
    };



    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.cors();

        http.csrf().disable()
                .authorizeRequests()
                .antMatchers(urls)
                .permitAll()
                .anyRequest()
                .authenticated();

        http.addFilterBefore(jwtAuthorityFilter, UsernamePasswordAuthenticationFilter.class);
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        log.debug("創建密碼編碼器組件");
        return new BCryptPasswordEncoder();
    }

    @Bean
    @Override
    protected AuthenticationManager authenticationManager() throws Exception {
        return super.authenticationManager();
    }
}
