package pl.tjanek.sleek.post;

/**
 * Post
 * @author Tomasz Janek
 */
public final class Post {

    public final String name;
    public final String label;

    public Post(String name) {
        this.name = name;
        this.label = name.toUpperCase();
    }
}
