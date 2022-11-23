package com.example.boardboard.web.dto;

import com.example.boardboard.domain.entity.board.Board;
import com.sun.istack.NotNull;
import lombok.Builder;
import lombok.Getter;

@Getter
public class BoardRequestDTO {

    @NotNull
    private String name;
    @NotNull
    private String password;
    @NotNull
    private String comment;

    @Builder
    public Board toEntity(){

        return Board.builder()
            .name(this.name)
            .password(this.password)
            .comment(this.comment)
            .build();
    }
}
