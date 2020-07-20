package myspring.controller;

import myspring.di.xml.Hello;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloController {
    @Autowired
    private Hello helloBean;

    @RequestMapping("/hello.do")
    public String Hello(Model model){
        String msg = helloBean.sayHello();
        model.addAttribute("greet",msg);
        return "hello.jsp";
    }
}
