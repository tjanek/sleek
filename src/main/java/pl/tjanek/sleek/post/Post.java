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

    public String getAt() {
        return this.templateFilename.substring(0, 10);
    }

    public String getName() {
        return this.templateFilename.substring(11).replaceAll("-", " ");
    }

    public String getLink() {
        return this.templateFilename;
    }

}
