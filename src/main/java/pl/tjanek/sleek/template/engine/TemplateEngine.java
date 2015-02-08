package pl.tjanek.sleek.template.engine;

/**
 * Process markup language template document to HTML.
 * @author Tomasz Janek
 */
public interface TemplateEngine {

    /**
     * Process document specific markup language into HTML
     * @param documentContent markup language content
     * @return HTML content
     */
    String processDocument(byte[] documentContent);

    /**
     * @return supported markup language file extension for process
     */
    String supportedExtension();

}
