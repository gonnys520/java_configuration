package org.gonnys.controller;

import java.sql.Connection;

import javax.sql.DataSource;

import org.gonnys.config.RootConfig;
import org.gonnys.mapper.TimeMapper;
import org.gonnys.service.SampleBean;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {RootConfig.class})
@Log4j
public class SampleTests {

	@Setter(onMethod_ = @Autowired)
	private SampleBean bean;
	
	@Setter(onMethod_ = @Autowired)
	private DataSource ds;
	
	@Setter(onMethod_ = @Autowired)
	private TimeMapper mapper;
	
	
	@Test
	public void testTime() {
		log.info(mapper.getTime());
	}
	
	@Test
	public void testCon() {
		
		try(Connection con = ds.getConnection()){
			log.info(con);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testExist() {
		log.info("========================");
		log.info(bean.doA("ABCED"));
		log.info("==================");
	}
	
	@Test
	public void testTransaction() {
		String str = "내가 누군지알아?";
		bean.doB(str);
	}
}
