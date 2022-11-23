package com.example.boardboard.domain.service;

import com.example.boardboard.domain.entity.map.Map;
import com.example.boardboard.domain.entity.map.MapRepository;
import com.example.boardboard.web.dto.MapResponseDTO;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class MapService {

    private final MapRepository mapRepository;

    public List<MapResponseDTO> findMarkers(){

        List<Map> mapList = mapRepository.findAll();

        return mapList.stream().map(MapResponseDTO::new).collect(Collectors.toList());
    }
}
