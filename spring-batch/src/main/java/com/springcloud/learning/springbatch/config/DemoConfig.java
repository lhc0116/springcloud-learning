package com.springcloud.learning.springbatch.config;

import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableBatchProcessing
public class DemoConfig {

    @Autowired
    private JobBuilderFactory jobBuilderFactory;

    @Autowired
    private StepBuilderFactory stepBuilderFactory;

    /*@Bean
    public Job footballJob() {
        return jobBuilderFactory.get("footballJob")
                .start(playerLoad())
                .next(gameLoad())
                .next(playerSummarization())
                .end()
    }

    private Flow playerLoad() {

    }

    private Flow gameLoad() {

    }

    private Flow playerSummarization() {

    }*/
}