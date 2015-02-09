import pl.tjanek.sleek.post.Post
import spock.lang.Specification

class PostSpecification extends Specification {

    def "should return valid date and name from post filename"() {
        given:
        Post post = new Post(filename)

        expect:
        post.name() == name
        post.at() == at

        where:
        filename                | name         | at
        "2015-02-01-first-post" | "First post" | "2015-02-01"
    }
}