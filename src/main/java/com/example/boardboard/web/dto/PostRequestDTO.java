package com.example.boardboard.web.dto;

import com.example.boardboard.domain.entity.board.Post;
import com.sun.istack.NotNull;
import lombok.Builder;
import lombok.Getter;

@Getter
public class PostRequestDTO {

    @NotNull
    private String name;
    @NotNull
    private String password;
    @NotNull
    private String comment;

    @Builder
    public Post toEntity(){

        return Post.builder()
            .name(this.name)
            .password(this.password)
            .comment(this.comment)
            .build();
    }
}
