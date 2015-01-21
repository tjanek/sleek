package pl.tjanek.sleek;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Arrays;

@Controller("/blog")
public class BlogController {

    @RequestMapping("/")
    String index(Model model) {
        model.addAttribute("posts", Arrays.asList("Some post", "Other post"));
        return "index";
    }
}
