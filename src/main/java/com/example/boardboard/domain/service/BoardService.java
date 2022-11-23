package com.example.boardboard.domain.service;

import com.example.boardboard.domain.entity.board.Board;
import com.example.boardboard.domain.entity.board.BoardRepository;
import com.example.boardboard.web.dto.BoardResponseDTO;
import java.awt.print.Pageable;
import java.util.List;
import java.util.stream.Collectors;
import javax.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class BoardService {

    private final BoardRepository boardRepository;

    @Transactional()
    public List<BoardResponseDTO> findAll(PageRequest pageRequest){

      Page<Board> boards = boardRepository.findAll(pageRequest);
      return boards.getContent().stream().map(BoardResponseDTO :: new).collect(Collectors.toList());
    }

    @Transactional()
    public void post(Board board){

        boardRepository.save(board);
    }

}
