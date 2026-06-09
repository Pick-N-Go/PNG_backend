package com.project.picngo.external;

import com.project.picngo.external.dto.DirectionsResponse;

public interface DirectionsClient {
    DirectionsResponse getTravelInfo(Double startLat, Double startLng, Double goalLat, Double goalLng);
    
    Integer getTravelTimeMinutes(Double startLat, Double startLng, Double goalLat, Double goalLng);
}
