package com.example.amazons3.util;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.CannedAccessControlList;
import com.amazonaws.services.s3.model.PutObjectRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

@Component
public class UploadAws {

    private static final String BUCKET = "project-amazon-s3";
    private static final String ACCESS_KEY = "[ACESS_KEY]";
    private static final String SECRET_KEY = "[SECRET_KEY]";
    private static final String REGION = "sa-east-1";

    final AmazonS3 amazonS3 = AmazonS3ClientBuilder.standard().withRegion(REGION)
            .withCredentials(new AWSStaticCredentialsProvider(basicAWSCredentials())).build();;


    public String write(MultipartFile file) {
        try {
            File f = new File(file.getOriginalFilename());
            String pathAws;
            copyInputStreamToFile(file.getInputStream(), f);

            PutObjectRequest request = new PutObjectRequest(BUCKET, file.getOriginalFilename(), f);
            amazonS3.putObject(request.withCannedAcl(CannedAccessControlList.PublicRead));
            pathAws = String.format("https://%s.s3-sa-east-1.amazonaws.com/%s", BUCKET , file.getOriginalFilename());
            return  pathAws;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private static void copyInputStreamToFile(InputStream inputStream, File file)
            throws IOException {

        try (FileOutputStream outputStream = new FileOutputStream(file)) {

            int read;
            byte[] bytes = new byte[1024];

            while ((read = inputStream.read(bytes)) != -1) {
                outputStream.write(bytes, 0, read);
            }
        }

    }

    public BasicAWSCredentials basicAWSCredentials(){
        return new BasicAWSCredentials(ACCESS_KEY, SECRET_KEY);
    }
}
