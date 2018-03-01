package smart.service;

import com.smart.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.testng.Assert;
import org.testng.annotations.*;

//@ContextConfiguration("classpath*:spring-context.xml" )
public class UserServiceTest {

    @Autowired
    private UserService userService;

    ApplicationContext context = new ClassPathXmlApplicationContext("classpath:spring-context.xml");

    @Test
    public void hasMatchUser(){
        UserService userService = context.getBean(UserService.class);
        boolean b1 = userService.hasMatchUser("admin","123456");
        boolean b2 = userService.hasMatchUser("admin","1111");

        Assert.assertTrue(b1);
        Assert.assertTrue(b2);

    }

}
