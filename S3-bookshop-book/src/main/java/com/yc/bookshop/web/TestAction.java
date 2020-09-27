package com.yc.bookshop.web;

import javax.sql.DataSource;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestAction {
 
	@Autowired
	DataSource dataSource;
	
	@Test
	public void contextLoads() throws Exception{
		System.out.println("获取的数据库连接为:"+dataSource.getConnection());
	}

	
	
}
