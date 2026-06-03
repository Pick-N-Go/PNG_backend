package com.project.picngo.external.controller;

import com.project.picngo.external.DirectionsClient;
import com.project.picngo.external.WeatherClient;
import com.project.picngo.external.dto.DirectionsResponse;
import com.project.picngo.external.dto.GoldenHourResponse;
import com.project.picngo.external.dto.WeatherForecastResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ExternalApiController {

    private final WeatherClient weatherClient;
    private final DirectionsClient directionsClient;

    // 1. 길찾기 API (바로 출발 시 호출)
    @GetMapping("/directions")
    public ResponseEntity<DirectionsResponse> getDirections(
            @RequestParam Double startLat,
            @RequestParam Double startLng,
            @RequestParam Double goalLat,
            @RequestParam Double goalLng
    ) {
        return ResponseEntity.ok(directionsClient.getTravelInfo(startLat, startLng, goalLat, goalLng));
    }

    // 2. 단기 예보 조회 (여행 계획 날씨)
    @GetMapping("/weather/forecast")
    public ResponseEntity<List<WeatherForecastResponse>> getWeatherForecast(
            @RequestParam Double lat,
            @RequestParam Double lng,
            @RequestParam String date
    ) {
        return ResponseEntity.ok(weatherClient.getForecast(lat, lng, date));
    }

    // 3. 골든아워 조회 (스팟별/홈 화면)
    @GetMapping("/spots/{id}/golden-hour")
    public ResponseEntity<GoldenHourResponse> getSpotGoldenHour(
            @PathVariable Long id,
            @RequestParam String date
    ) {
        // 실제로는 id(SpotId)를 통해 DB에서 위경도를 조회한 후 API를 호출합니다.
        Double mockLat = 37.5665;
        Double mockLng = 126.9780;
        return ResponseEntity.ok(weatherClient.getGoldenHour(mockLat, mockLng, date));
    }
}
