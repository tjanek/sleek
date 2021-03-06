import pl.tjanek.sleek.post.Post
import spock.lang.Specification

class PostSpec extends Specification {

    def "should return valid date and name from post filename"() {
        given:
        Post post = new Post(filename)

        expect:
        post.name == name
        post.at == at
        post.link == filename

        where:
        filename                | name         | at
        "2015-02-01-first-post" | "first post" | "2015-02-01"
    }
}