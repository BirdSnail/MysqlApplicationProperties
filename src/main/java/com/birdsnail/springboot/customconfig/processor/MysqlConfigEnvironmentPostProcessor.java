package com.birdsnail.springboot.customconfig.processor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.env.EnvironmentPostProcessor;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.MapPropertySource;
import org.springframework.core.env.MutablePropertySources;
import org.springframework.core.env.PropertySource;

import java.sql.*;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 加载mysql中的配置信息
 *
 * @Author : BirdSnail
 * @Date : 2020/11/9
 */
public class MysqlConfigEnvironmentPostProcessor implements EnvironmentPostProcessor {

    @Override
    public void postProcessEnvironment(ConfigurableEnvironment environment, SpringApplication application) {
        MutablePropertySources propertySources = environment.getPropertySources();
        MysqlLoader loader = new MysqlLoader();
        loader.load("mysql_property_source")
                .forEach(propertySources::addLast);
    }

    static class MysqlLoader {

        private static final String URL = "jdbc:mysql://localhost:3306/springboot_test?characterEncoding=utf8&connectTimeout=1000&socketTimeout=3000&autoReconnect=true&serverTimezone=Asia/Shanghai";
        private static final String SELECT_KEY_VALUE = "select config_key, config_value from springboot_properties";


        public List<PropertySource<?>> load(String name) {
            try (Connection conn = DriverManager.getConnection(URL, "root", "test");
                 Statement statement = conn.createStatement();
                 final ResultSet rs = statement.executeQuery(SELECT_KEY_VALUE)) {

                Map<String, Object> result = new HashMap<>();
                while (rs.next()) {
                    final String config_key = rs.getString("config_key");
                    final String config_value = rs.getString("config_value");
                    result.put(config_key, config_value);
                }
                System.out.println("配置信息：" + result);
                return Collections
                        .singletonList(new MapPropertySource(name, result));
            } catch (SQLException exception) {
                exception.printStackTrace();
            }
            return Collections.emptyList();
        }
    }
}