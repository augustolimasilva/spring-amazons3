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
import java.time.Instant;
import java.util.UUID;

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
            String pathAws;
            String originalNameFile = file.getOriginalFilename();
            String extension = originalNameFile.substring(originalNameFile.lastIndexOf("."), originalNameFile.length());

            String newNameFile = generateNameForThePicture(extension);

            File f = new File(newNameFile);
            copyInputStreamToFile(file.getInputStream(), f);

            PutObjectRequest request = new PutObjectRequest(BUCKET, newNameFile, f);
            amazonS3.putObject(request.withCannedAcl(CannedAccessControlList.PublicRead));
            pathAws = String.format("https://%s.s3-sa-east-1.amazonaws.com/%s", BUCKET , newNameFile);
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

    private String generateNameForThePicture(String extension) {
        UUID uuid = UUID.randomUUID();
        String name = uuid.toString().substring(0, 20) + Instant.now();
        name = name.replace(":", "-");
        return name + extension;
    }

    public BasicAWSCredentials basicAWSCredentials(){
        return new BasicAWSCredentials(ACCESS_KEY, SECRET_KEY);
    }
}
