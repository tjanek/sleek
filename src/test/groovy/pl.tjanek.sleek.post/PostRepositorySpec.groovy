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
        def allPosts = postRepository.allPosts

        then:
        allPosts[postNumber].link == link

        where:
        postNumber || link
        0          || "2015-02-16-first-post"
        1          || "2015-02-17-second-post"
    }
}
