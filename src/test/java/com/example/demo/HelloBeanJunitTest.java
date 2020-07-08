package com.example.demo;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import static org.junit.Assert.assertEquals;

public class HelloBeanJunitTest {
    private ApplicationContext context;

    @Before
    public void init(){
        context=new GenericXmlApplicationContext("file:src/main/java/webapp/WEB-INF/beans.xml");
    }

    @Test
    public void bean1(){
        Hello hello = (Hello) context.getBean("hello");
        assertEquals("Hello Spring",hello.sayHello());

        Printer printer=(Printer)context.getBean("printer");
        assertEquals("Hello Spring",printer.toString());
    }

    @Test
    public void bean2(){
        Printer printer = (Printer) context.getBean("printer");
        Printer printer1 = context.getBean("printer",Printer.class);

        assertSame(printer,printer1);
    }

}
