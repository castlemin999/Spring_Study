package hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {
    /*
        controller에서 리턴값으로 문자를 반환하면 뷰 리졸버가 화면을 찾아서 처리함
        SpringBoot에서 return은 resources/templates/*.html을 매핑
        여기서는 return이 hello 이니까 resources/templates/hello.html
    */
    @GetMapping("hello")
    public String hello(Model model){
        model.addAttribute("data", "hello!!");
        return "hello";
    }

    /*
       정적 컨텐츠
       http://localhost:8080/hello-static.html
        -> controller에서 hello-static이 있는지 확인
        ->  mapping이 된 컨트롤러가 없어서 resources: static/hello-static.html을 스프링이 알아서 반환해준다.
        * 파일을 그대로 내려준다.
    */


    /*
        MVC와 템플릿엔진
        http://localhost:8080/hello-mvc?name=spring!!
         -> controller에서 viewResolver가 templates/hello-template.html을 렌더링해서 반환해준다.
    */
    @GetMapping("hello-mvc")
    public String helloMvc(@RequestParam("name") String name, Model model){
        /*
            "name" -> key
             name -> value
        */
        model.addAttribute("name", name);
        return "hello-template";
    }

    /*
        API JSON
        @ResponseBody를 사용하면 HTTP의 Body에 문자 내용을 직접 반환하고 ViewResolver가 아닌 HttpMessageConverter가 동작한다.
        return 값에 따라
        String -> SpringHttpMessageConverter
        JSON -> MappingJackson2HttpMessageConverter
        * Jackson -> JSON 변환 라이브러리
    */
    // String
    @GetMapping("hello-string")
    @ResponseBody
    public String helloString(@RequestParam("name") String name, Model model){
        return "hello " + name; // 이 값 그대로 반환
        // ex) name = spring -> hello spring
    }
    // JSON
    @GetMapping("hello-api")
    @ResponseBody
    public Hello helloApi(@RequestParam("name") String name){
        Hello hello = new Hello();
        hello.setName(name);
        return hello;
    }

    // JSON 으로 반환할 객체
    // property 접근 방식
    static class Hello{
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

}
