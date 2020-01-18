package com.example.amazons3.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;

@Configuration
public class AmazonConfiguration {

    private static final String ACCESS_KEY = "CHAVE";
    private static final String SECRET_KEY = "CHAVE_AQUI";
    private static final String REGION = "sa-east-1";

    @Bean
    public BasicAWSCredentials basicAWSCredentials(){
        return new BasicAWSCredentials(ACCESS_KEY, SECRET_KEY);
    }

    @Bean
    public AmazonS3 amazonS3() {
        return AmazonS3ClientBuilder.standard().withRegion(REGION)
                .withCredentials(new AWSStaticCredentialsProvider(basicAWSCredentials())).build();
    }
}