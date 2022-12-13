package com.example.boardboard.web.dto;

import com.example.boardboard.domain.entity.board.Post;
import lombok.Builder;
import lombok.Getter;

@Getter
public class PostResponseDTO {

    private Long id;
    private String name;
    private String comment;

    @Builder
    public PostResponseDTO(Post post){

        this.id = post.getId();
        this.name = post.getName();
        this.comment = post.getComment();
    }
}
