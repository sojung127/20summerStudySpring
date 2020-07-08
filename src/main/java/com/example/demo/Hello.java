package com.example.demo;

public class Hello {
    String name;
    Printer printer;

    public Hello(){

    }

    public void setName(String name){
        this.name=name;
    }

    public void setPrinter(Printer printer){
        this.printer = printer;
    }

    public String sayHello(){
        return "com.example.demo.Hello "+name;
    }

    public void print(){
        this.printer.print(sayHello());
    }
}
