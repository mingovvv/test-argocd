package test.web;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @Value("${spring.profiles.active:dev}")
    private String activeProfile;

    @GetMapping("/")
    public String index(Model model) {
        String username = System.getProperty("user.name");
        model.addAttribute("username", username);
        model.addAttribute("profile", activeProfile);
        return "index";
    }
}
