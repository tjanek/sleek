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

    def "should return valid post links"() {
        when:
        def allPosts = postRepository.allPosts

        then:
        allPosts[postNumber].link == link

        where:
        postNumber || link
        0          || "2015-02-16-first-post"
        1          || "2015-02-17-second-post"
    }

    def "should return posts content"() {
        expect:
        postRepository.getPostContentByName(postName) == postContent

        where:
        postName                 || postContent
        "2015-02-16-first-post"  || "#First post\n\n[First post](http://example.com/2015-02-16-first-post)"
        "2015-02-17-second-post" || "#Second post\n\n[Second post](http://example.com/2015-02-17-second-post)"
    }
}
