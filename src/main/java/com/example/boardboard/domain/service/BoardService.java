package com.example.boardboard.domain.service;

import com.example.boardboard.domain.entity.board.Post;
import com.example.boardboard.domain.entity.board.BoardRepository;
import com.example.boardboard.web.dto.PostResponseDTO;
import java.util.List;
import java.util.stream.Collectors;
import javax.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class BoardService {

    private final BoardRepository boardRepository;

    @Transactional()
    public List<PostResponseDTO> findAll(PageRequest pageRequest){

      Page<Post> boards = boardRepository.findAll(pageRequest);
      return boards.getContent().stream().map(PostResponseDTO:: new).collect(Collectors.toList());
    }

    @Transactional()
    public void post(Post post){

        boardRepository.save(post);
    }

}
