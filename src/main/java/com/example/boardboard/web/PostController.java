package com.example.boardboard.web;

import com.example.boardboard.domain.service.BoardService;
import com.example.boardboard.web.dto.PostRequestDTO;
import com.example.boardboard.web.dto.PostResponseDTO;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RequiredArgsConstructor
@RestController
public class PostController {

    private final BoardService boardService;


    //    @GetMapping("/posts")
//    private List<BoardResponseDTO> getBoard(Pageable pageable){
//
//        return boardService.findAll(pageable);
//    }

    @GetMapping("/posts")
    private List<PostResponseDTO> getBoard(@RequestParam(value = "page",required = false,defaultValue = "0") Integer page,
                                @RequestParam(value = "size" ,required = false,defaultValue = "10") Integer size) {
        PageRequest pageRequest = PageRequest.of(page,size);
        return boardService.findAll(pageRequest);
    }

    @PostMapping("/post")
    private ResponseEntity<String> posting(@RequestBody PostRequestDTO postRequestDTO) {
        boardService.post(postRequestDTO.toEntity());
        return new ResponseEntity<>("OK",HttpStatus.OK);
    }
}
