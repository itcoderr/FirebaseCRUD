package com.example.Firebase.servicePackage;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
@Service
public class FirebaseIntializer {
    @PostConstruct
    public void intialize() {
    try {
        FileInputStream serviceAccount =
                new FileInputStream("./ServiceAccountKey.json");

        FirebaseOptions options = new FirebaseOptions.Builder()
                .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                .setDatabaseUrl("https://tiaa2-280518.firebaseio.com")
                .build();

        FirebaseApp.initializeApp(options);
    }
    catch (Exception e ){
        e.printStackTrace();
    }
    }
}
