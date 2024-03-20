package dev.langchain4j.local.spring;

import dev.langchain4j.memory.chat.ChatMemoryProvider;
import dev.langchain4j.rag.content.retriever.ContentRetriever;
import org.junit.jupiter.api.Test;
import org.springframework.boot.autoconfigure.AutoConfigurations;
import org.springframework.boot.test.context.runner.ApplicationContextRunner;

class AutoConfigIT {

    private static final String LOCAL_MEMORY_SIZE = "20";

    ApplicationContextRunner contextRunner = new ApplicationContextRunner()
            .withConfiguration(AutoConfigurations.of(AutoConfig.class));

    @Test
    void should_provide_memory() {
        contextRunner
                .withPropertyValues(
                        "langchain4j.local.spring.memory.use-local=true",
                        "langchain4j.local.spring.memory.memory-size=" + LOCAL_MEMORY_SIZE
                )
                .run(context -> {
                    ChatMemoryProvider chatMemoryProvider = context.getBean(ChatMemoryProvider.class);
                });
    }

    @Test
    void should_provide_content_retriver() {
        contextRunner
                .withPropertyValues(
                        "langchain4j.local.spring.content-retriver.use-local=true",
                        "langchain4j.local.spring.content-retriver.maxResults=1",
                        "langchain4j.local.spring.content-retriver.minScore=0.6",
                        "langchain4j.local.spring.content-retriver.contentPath=classpath:petclinic-terms-of-use.txt"
                )
                .run(context -> {

                    ContentRetriever contentRetriever = context.getBean(ContentRetriever.class);
                });
    }

}