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
        postRepository.getAllPosts().size() == 2
    }

    def "should return valid post names and dates"() {
        when:
        def allPosts = postRepository.getAllPosts()

        then:
        allPosts[0].getAt() == "2015-02-16"
        allPosts[0].getName() == "first post"
        allPosts[0].getLink() == "2015-02-16-first-post"
        allPosts[1].getAt() == "2015-02-17"
        allPosts[1].getName() == "second post"
        allPosts[1].getLink() == "2015-02-17-second-post"
    }
}
