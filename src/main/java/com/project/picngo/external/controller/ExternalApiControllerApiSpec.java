package com.project.picngo.external.controller;

import com.project.picngo.external.dto.DirectionsResponse;
import com.project.picngo.external.dto.GoldenHourResponse;
import com.project.picngo.external.dto.WeatherForecastResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Tag(name = "외부 API 연동 (External)", description = "길찾기, 기상청, 일출/일몰 외부 API 통신 컨트롤러")
public interface ExternalApiControllerApiSpec {

    @Operation(summary = "길찾기 (이동시간/거리)", description = "카카오모빌리티 API를 이용하여 출발지에서 목적지까지의 자동차 예상 소요 시간과 거리를 조회합니다.")
    ResponseEntity<DirectionsResponse> getDirections(
            @Parameter(description = "출발지 위도") @RequestParam Double startLat,
            @Parameter(description = "출발지 경도") @RequestParam Double startLng,
            @Parameter(description = "목적지 위도") @RequestParam Double goalLat,
            @Parameter(description = "목적지 경도") @RequestParam Double goalLng
    );

    @Operation(summary = "단기 예보 조회", description = "기상청 API를 이용하여 특정 위치의 날씨 예보를 조회합니다.")
    ResponseEntity<List<WeatherForecastResponse>> getWeatherForecast(
            @Parameter(description = "위도") @RequestParam Double lat,
            @Parameter(description = "경도") @RequestParam Double lng,
            @Parameter(description = "조회할 날짜 (yyyyMMdd)") @RequestParam String date
    );

    @Operation(summary = "명소 골든아워 조회", description = "특정 명소의 일출/일몰 시간을 가져와 골든아워(사진 찍기 좋은 시간)를 계산합니다.")
    ResponseEntity<GoldenHourResponse> getSpotGoldenHour(
            @Parameter(description = "명소 ID") @PathVariable Long id,
            @Parameter(description = "조회 날짜 (yyyy-MM-dd)") @RequestParam String date
    );
}
