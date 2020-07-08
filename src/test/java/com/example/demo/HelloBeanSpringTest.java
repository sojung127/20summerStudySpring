package com.example.demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "file:src/main/java/webapp/WEB-INF/beans.xml")
public class HelloBeanSpringTest {
    @Autowired
    private ApplicationContext context;

    @Test
    public void bean1(){
        Hello hello = (Hello) context.getBean("hello");
        assertEquals("Hello Spring",hello.sayHello());
        hello.print();
        assertEquals(context.getBean("printer").toString(),"Hello Spring");

        Hello hello1 = context.getBean("hello",Hello.class);
        hello1.print();
        assertSame(hello,hello1);

    }
}
