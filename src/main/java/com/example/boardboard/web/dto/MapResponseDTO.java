package com.example.boardboard.web.dto;

import com.example.boardboard.domain.entity.map.Map;
import lombok.Builder;
import lombok.Getter;

@Getter
public class MapResponseDTO {

    private Long id;
    private String name;
    private Double latitude;
    private Double longitude;

    @Builder
    public MapResponseDTO(Map map){
        this.id = map.getId();
        this.name = map.getName();
        this.latitude = map.getLatitude();
        this.longitude = map.getLongitude();
    }
}
