package myspring.di.xml;

public class Hello {
    String name;
    Printer printer;

    public Hello(){}

    public String sayHello() {
        return "Hello "+name;
    }
}
