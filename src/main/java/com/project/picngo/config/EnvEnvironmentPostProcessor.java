package com.project.picngo.config;

import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.EnvironmentPostProcessor;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.MapPropertySource;

import java.util.HashMap;
import java.util.Map;

public class EnvEnvironmentPostProcessor implements EnvironmentPostProcessor {

    @Override
    public void postProcessEnvironment(ConfigurableEnvironment environment, SpringApplication application) {
        try {
            Dotenv dotenv = Dotenv.configure().ignoreIfMissing().load();
            Map<String, Object> envMap = new HashMap<>();
            dotenv.entries().forEach(entry -> envMap.put(entry.getKey(), entry.getValue()));

            // .env 파일의 속성들을 스프링 환경 변수의 최우선 순위로 등록합니다.
            environment.getPropertySources().addFirst(new MapPropertySource("dotenvProperties", envMap));
        } catch (Exception e) {
            // .env 파일이 없거나 오류가 발생하면 조용히 넘어갑니다 (클라우드 환경 등에서는 OS 환경변수를 사용하므로)
        }
    }
}
