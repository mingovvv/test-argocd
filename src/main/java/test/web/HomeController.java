package test.web;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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

    @ResponseBody
    @GetMapping("/health")
    public ResponseEntity<String> healthCheck() {
        return ResponseEntity
                .status(Response.SC_OK)
                .body("this is a health check");
    }

}
