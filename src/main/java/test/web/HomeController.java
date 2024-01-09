package test.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String index(Model model) {
        String username = System.getProperty("user.name");
        model.addAttribute("username", username);
        return "index";
    }
}
