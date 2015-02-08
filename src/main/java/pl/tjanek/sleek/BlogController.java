package pl.tjanek.sleek;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.tjanek.sleek.post.PostRepository;

@Controller
public class BlogController {

    @Autowired
    private PostRepository postRepository;

    @RequestMapping("/")
    String index(Model model) {
        model.addAttribute("posts", postRepository.getAllPosts());
        return "index";
    }

    @RequestMapping("/post/{name}")
    @ResponseBody
    String post(@PathVariable("name") String postName) {
        return postRepository.getPostContentByName(postName);
    }
}
