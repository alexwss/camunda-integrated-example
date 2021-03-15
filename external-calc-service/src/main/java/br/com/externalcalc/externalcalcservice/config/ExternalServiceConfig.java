package br.com.externalcalc.externalcalcservice.config;

import lombok.extern.slf4j.Slf4j;
import org.camunda.bpm.client.ExternalTaskClient;
import org.camunda.bpm.client.task.ExternalTaskHandler;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Configuration;

@Slf4j
@Configuration
public class ExternalServiceConfig implements InitializingBean {

    @Autowired
    private ApplicationContext context;

    @Value("${engine-server.url}")
    private String serverUrl;

    @Override
    public void afterPropertiesSet() throws Exception {

        log.info("-> Initializing external task subscription...");

        ExternalTaskClient client = ExternalTaskClient.create()
                .baseUrl(serverUrl)
                .asyncResponseTimeout(3000)
                .build();

        context.getBeansOfType(ExternalTaskHandler.class).entrySet().forEach(item -> {

            client.subscribe(item.getKey())
                    .handler(item.getValue())
                    .open();

            log.info("-> Subscribed into {}...", item.getKey());
        });

        log.info("-> Finalizing external task subscription....");
    }

}
