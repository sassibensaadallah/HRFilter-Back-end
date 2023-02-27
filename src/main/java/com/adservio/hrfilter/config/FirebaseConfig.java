package com.adservio.hrfilter.config;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import lombok.SneakyThrows;
import org.springframework.context.annotation.Configuration;

import java.io.FileInputStream;
@Configuration
public class FirebaseConfig {
    @SneakyThrows
    public FirebaseConfig() {
        FileInputStream serviceAccount =
                new FileInputStream("firebase.json");

        FirebaseOptions options = new FirebaseOptions.Builder()
                .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                .build();

        FirebaseApp.initializeApp(options);

    }
}
