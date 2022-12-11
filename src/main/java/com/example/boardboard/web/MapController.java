package com.example.boardboard.web;

import com.example.boardboard.domain.service.MapService;
import com.example.boardboard.web.dto.MapResponseDTO;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RequiredArgsConstructor
@RestController
public class MapController {

    private final MapService mapService;

    @GetMapping("/check")
    private HttpStatus healthCheck(){

        return HttpStatus.OK;
    }

    @GetMapping("/marker")
    private List<MapResponseDTO> getMarker(){

        return mapService.findMarkers();
    }
}
