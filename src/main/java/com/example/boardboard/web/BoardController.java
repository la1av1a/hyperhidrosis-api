package com.example.boardboard.web;

import com.example.boardboard.domain.entity.board.Board;
import com.example.boardboard.domain.service.BoardService;
import com.example.boardboard.web.dto.BoardRequestDTO;
import com.example.boardboard.web.dto.BoardResponseDTO;
import java.awt.print.Pageable;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class BoardController {

    private final BoardService boardService;


    //    @GetMapping("/posts")
//    private List<BoardResponseDTO> getBoard(Pageable pageable){
//
//        return boardService.findAll(pageable);
//    }

    @GetMapping("/posts")
    private List<BoardResponseDTO> getBoard(@RequestParam(value = "page",required = false,defaultValue = "0") Integer page,
                                @RequestParam(value = "size" ,required = false,defaultValue = "10") Integer size) {
        PageRequest pageRequest = PageRequest.of(page,size);
        return boardService.findAll(pageRequest);
    }

    @PostMapping("/post")
    private HttpEntity<String> posting(@RequestBody BoardRequestDTO boardRequestDTO) {
        boardService.post(boardRequestDTO.toEntity());
        return new HttpEntity<>("OK");
    }
}
