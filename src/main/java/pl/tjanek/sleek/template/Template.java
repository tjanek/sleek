package pl.tjanek.sleek.template;

/**
 * Template
 * @author Tomasz Janek
 */
public final class Template {

    public final String name;
    public final String extension;
    public final byte[] content;

    public Template(byte[] content, String name) {
        this.content = content;
        int extIndex = name.indexOf(".");
        this.name = name.substring(0, extIndex);
        this.extension = name.substring(extIndex+1);
    }
}
