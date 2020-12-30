package com.star.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author WP
 * @date 2020/12/30  11:12
 */

@RestController
public class JDBCController {

    @Autowired
    JdbcTemplate jdbcTemplate;


}
