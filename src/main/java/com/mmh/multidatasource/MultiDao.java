package com.mmh.multidatasource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

/**
 * @author mumh@2423528736@qq.com
 * @date 2019/5/21 15:16
 */
@Configuration
public class MultiDao {

    @Bean(name="primaryJdbcTemplate")
    public JdbcTemplate primaryJdbcTemplate(@Qualifier("primaryDataSource") DataSource source){
        return new JdbcTemplate(source);
    }

    @Bean(name="secondaryJdbcTemplate")
    public JdbcTemplate secondaryJdbcTemplate(@Qualifier("secondaryDataSource") DataSource source){
        return new JdbcTemplate(source);
    }
}
