package com.example.boardboard.web.dto;

import com.example.boardboard.domain.entity.board.Board;
import lombok.Builder;
import lombok.Getter;

@Getter
public class BoardResponseDTO {

    private Long id;
    private String name;
    private String comment;

    @Builder
    public BoardResponseDTO(Board board){

        this.id = board.getId();
        this.name = board.getName();
        this.comment = board.getComment();
    }
}
