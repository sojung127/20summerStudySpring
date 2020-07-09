package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.List;

@Component("hello")
public class Hello {
    @Value("Spring")
    String name;

    @Autowired
    @Qualifier("stringPrinter")
    Printer printer;

    List<String> names;
    public Hello(){

    }
    public void setNames(List<String> list){
        this.names=list;
    }
    public List<String> getNames(){ return names; }
    public void setName(String name){
        this.name=name;
    }

    public void setPrinter(Printer printer){
        this.printer = printer;
    }

    public String sayHello(){
        return "Hello "+name;
    }

    public void print(){
        this.printer.print(sayHello());
    }
}
