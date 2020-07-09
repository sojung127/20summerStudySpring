package com.example.demo;

import java.util.List;

public class Hello {
    String name;
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
