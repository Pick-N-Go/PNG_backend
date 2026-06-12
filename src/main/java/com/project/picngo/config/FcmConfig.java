package com.project.picngo.config;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

@Slf4j
@Configuration
public class FcmConfig {

    @Value("${firebase.config.path:}")
    private String firebaseConfigPath;

    @PostConstruct
    public void init() {
        try {
            if (firebaseConfigPath == null || firebaseConfigPath.isEmpty()) {
                log.warn("🔥 Firebase 설정 파일 경로가 없습니다. FCM 초기화를 건너뜁니다.");
                return;
            }

            InputStream serviceAccount = new FileInputStream(firebaseConfigPath);
            FirebaseOptions options = FirebaseOptions.builder()
                    .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                    .build();

            if (FirebaseApp.getApps().isEmpty()) {
                FirebaseApp.initializeApp(options);
                log.info("🔥 Firebase application successfully initialized.");
            }
        } catch (IOException e) {
            log.error("❌ Failed to initialize Firebase App", e);
        }
    }
}
