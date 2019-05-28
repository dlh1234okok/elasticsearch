package com.dlh.springbootes;

import com.dlh.springbootes.controller.JestController;
import com.dlh.springbootes.entity.User;
import com.dlh.springbootes.test.TestProperties;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootEsApplicationTests {

	@Autowired
	private TestProperties testProperties;

	@Autowired
	private JestController jestController;

	@Test
	public void contextLoads() {
		System.out.println(testProperties.getUserName());
		testProperties.get();
		System.out.println(testProperties.getUserName());
	}

	@Test
	public void test1(){
		User user = new User();
		user.setId("1");
		user.setName("zs");
		user.setPwd("123");
		user.setCreatedAt((long) 111111);
		System.out.println(jestController.testRedis("111"));
	}
}

