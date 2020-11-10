package com.birdsnail.springboot.customconfig.pojo;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @Author : BirdSnail
 * @Date : 2020/11/10
 */
@ConfigurationProperties(prefix = "user", ignoreInvalidFields = true)
public class UserInfo {
    private String username;
    private String password;
    private Integer age;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
