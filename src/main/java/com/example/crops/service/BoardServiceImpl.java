package com.example.crops.service;

import com.example.crops.domain.BoardVO;
import com.example.crops.mapper.BoardMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class BoardServiceImpl implements BoardService {

    private final BoardMapper boardMapper;


    @Override
    public void register(BoardVO boardVO) {
        boardMapper.register(boardVO);
    }

    @Override
    public BoardVO read(int id) {
        return boardMapper.read(id);
    }

    @Override
    public void increaseViews(int id) {
        boardMapper.increaseViews(id);
    }

    @Override
    public void update(BoardVO boardVO) {
        boardMapper.update(boardVO);
    }

    @Override
    public void delete(int id) {
        boardMapper.delete(id);
    }

    @Override
    public List<BoardVO> listAll() {
        return boardMapper.listAll();
    }
}
