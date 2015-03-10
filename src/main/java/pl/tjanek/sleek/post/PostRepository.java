package pl.tjanek.sleek.post;

import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;
import pl.tjanek.sleek.template.TemplatesProcessor;
import pl.tjanek.sleek.template.Template;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

/**
 * Repository for posts
 * @author Tomasz Janek
 */
@Component
public class PostRepository {

    private static final String POST_TEMPLATES_DIR = "/posts/";

    private List<Template> allPostTemplates = Lists.newArrayList();

    @Autowired
    private TemplatesProcessor templatesProcessor;

    public String getPostContentByName(String postName) {
        Template postTemplateByName = findPostTemplateByName(postName);
        return templatesProcessor.processTemplate(postTemplateByName);
    }

    public List<Post> getAllPosts() {
        List<Post> allPosts = Lists.newArrayList();
        for (Template postTemplate : this.allPostTemplates) {
            allPosts.add(new Post(postTemplate.name));
        }
        return allPosts;
    }

    @PostConstruct
    public void init() throws IOException {
        Path postsPath = Paths.get(new ClassPathResource(POST_TEMPLATES_DIR).getURI());
        try (DirectoryStream<Path> postDirectoryStream = Files.newDirectoryStream(postsPath)) {
            for (Path postPath : postDirectoryStream) {
                resolvePostTemplateFromPath(postPath);
            }
        }
    }

    private Template findPostTemplateByName(String name) {
        for (Template postTemplate : this.allPostTemplates) {
            if (postTemplate.name.equals(name)) {
                return postTemplate;
            }
        }
        return null;
    }

    private void resolvePostTemplateFromPath(Path path) throws IOException {
        this.allPostTemplates.add(new Template(Files.readAllBytes(path), path.getFileName().toString()));
    }
}
