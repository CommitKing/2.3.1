package web.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class InternalController {

    @GetMapping(value = "/internal")
    public String internalPage() {
        return "index";
    }
}
