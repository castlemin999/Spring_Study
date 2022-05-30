package hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloController {
    // http의 GET
    @GetMapping("hello")
    public String hello(Model model){
        model.addAttribute("data", "hello!!");
        /*
        controller에서 리턴값으로 문자를 반환하면 뷰 리졸버가 화면을 찾아서 처리함
        SpringBoot에서 return은 resources/templates/*.html을 매핑
        여기서는 return이 hello 이니까 resources/templates/hello.html
        */
        return "hello";
    }

    @GetMapping("hello-mvc")
    public String helloMvc(@RequestParam("name") String name, Model model){
        model.addAttribute("name", name);
        return "hello-template";
    }
}
