package pl.tjanek.sleek.template;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.tjanek.sleek.template.engine.DefaultRawTemplateEngine;
import pl.tjanek.sleek.template.engine.TemplateEngine;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.Map;

/**
 * Processor for available template engines.
 * @author Tomasz Janek
 */
@Component
public class TemplatesProcessor {

    @Autowired(required = false)
    private List<TemplateEngine> availableTemplateEngines = Lists.newArrayList();

    private Map<String, TemplateEngine> templateEnginesDefinitionsByExtension = Maps.newConcurrentMap();

    @PostConstruct
    public void init() {
        registerTemplateEngines();
    }

    public String processTemplate(Template template) {
        TemplateEngine templateEngine = lookupSupportedTemplateEngine(template);
        return templateEngine.processDocument(template.content);
    }

    private TemplateEngine lookupSupportedTemplateEngine(Template template) {
        TemplateEngine templateEngine = templateEnginesDefinitionsByExtension.get(template.extension);
        if (templateEngine == null) {
            templateEngine = new DefaultRawTemplateEngine();
        }
        return templateEngine;
    }

    private void registerTemplateEngines() {
        for (TemplateEngine templateEngine : availableTemplateEngines) {
            registerTemplateEngine(templateEngine);
        }
    }

    private void registerTemplateEngine(TemplateEngine templateEngine) {
        templateEnginesDefinitionsByExtension.put(templateEngine.supportedExtension(), templateEngine);
    }
}
