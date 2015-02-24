package pl.tjanek.sleek.post

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.SpringApplicationContextLoader
import org.springframework.test.context.ContextConfiguration
import pl.tjanek.sleek.SleekApplication
import spock.lang.Specification

@ContextConfiguration(loader = SpringApplicationContextLoader.class, classes = SleekApplication.class)
class PostRepositorySpec extends Specification {

    @Autowired
    PostRepository postRepository

    def "should return 2 posts"() {
        expect:
        postRepository.getAllPosts().size() == 2
    }
}
