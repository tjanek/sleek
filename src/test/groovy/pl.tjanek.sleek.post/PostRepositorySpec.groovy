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

    def "should return all posts"() {
        expect:
        postRepository.allPosts.size() == 2
    }

    def "should return valid post names and dates"() {
        when:
        def allPosts = postRepository.getAllPosts()

        then:
        allPosts[0].at == "2015-02-16"
        allPosts[0].name == "first post"
        allPosts[0].link == "2015-02-16-first-post"
        allPosts[1].at == "2015-02-17"
        allPosts[1].name == "second post"
        allPosts[1].link == "2015-02-17-second-post"
    }
}
