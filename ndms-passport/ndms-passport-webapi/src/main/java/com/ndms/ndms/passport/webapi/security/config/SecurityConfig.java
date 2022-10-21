package com.ndms.ndms.passport.webapi.security.config;

import com.ndms.ndms.passport.webapi.filter.JwtAuthorityFilter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

/**
 * 時間:2022/10/13  下午 08:15
 * 俊翔，好好加油，找到好工作
 * 項目名:ndms
 */

@Configuration
@Slf4j
//@EnableWebSecurity
//@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

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
            "/**/emp/login"
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
