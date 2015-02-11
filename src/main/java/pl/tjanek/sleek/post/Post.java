package pl.tjanek.sleek.post;

/**
 * Post
 * TODO: Get date and post name from meta post config
 * @author Tomasz Janek
 */
public final class Post {

    private final String templateFilename;

    public Post(String templateFilename) {
        this.templateFilename = templateFilename;
    }

    public String at() {
        return this.templateFilename.substring(0, 10);
    }

    public String name() {
        return this.templateFilename.substring(11).replaceAll("-", " ");
    }

}
