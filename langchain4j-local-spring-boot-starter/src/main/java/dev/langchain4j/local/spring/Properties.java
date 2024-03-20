package dev.langchain4j.local.spring;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.NestedConfigurationProperty;

@Getter
@Setter
@ConfigurationProperties(prefix = Properties.PREFIX)
public class Properties {

    static final String PREFIX = "langchain4j.local.spring";

    @NestedConfigurationProperty
    ContentRetrieverProperties contentRetriver;

    @NestedConfigurationProperty
    LocalMemoryProperties memory;


    @Getter
    @Setter
    public static class ContentRetrieverProperties {
        String maxResults;

        String minScore;

        String contentPath;

    }


    @Getter
    @Setter
    public static class LocalMemoryProperties {

        boolean useLocal;

        int memorySize;
    }

}
