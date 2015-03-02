package pl.tjanek.sleek.template.engine;

import java.nio.charset.Charset;

/**
 * Default template engine for not supported template extensions.
 * @author Tomasz Janek
 */
public class DefaultRawTemplateEngine implements TemplateEngine {

    @Override
    public String processDocument(byte[] documentContent) {
        return new String(documentContent, Charset.forName("UTF-8"));
    }

    @Override
    public String supportedExtension() {
        return "*";
    }
}
