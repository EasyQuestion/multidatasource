package com.mmh.multidatasource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.sql.DataSource;
import java.util.List;
import java.util.Map;

@Controller
@SpringBootApplication
public class MultidatasourceApplication {

    public static void main(String[] args) {
        SpringApplication.run(MultidatasourceApplication.class, args);
    }

    @Autowired
    @Qualifier("primaryJdbcTemplate")
    private JdbcTemplate primaryJdbcTemplate;

    @Autowired
    @Qualifier("secondaryJdbcTemplate")
    private JdbcTemplate secondaryJdbcTemplate;

    @RequestMapping("/getGoldStaff")
    @ResponseBody
    public List<Map<String,Object>> getGoldStaff(){
        String sql = " SELECT * FROM GOLD_STAFF";
        List<Map<String,Object>> goldStaff = primaryJdbcTemplate.queryForList(sql);
        return goldStaff;
    }

    @RequestMapping("/getStorageQuarters")
    @ResponseBody
    public String getStorageQuarters(){
        String sql = " SELECT count(*) FROM U_STORAGEQUARTERS";
        String storageCount = secondaryJdbcTemplate.queryForObject(sql,String.class);
        return storageCount;
    }

}
