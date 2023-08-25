package com.example.crops.service;

import com.example.crops.domain.BoardVO;

import java.util.List;

public interface BoardService {
    public void register(BoardVO boardVO); //게시물 등록 메서드

    public BoardVO read(int id);

    public void update(BoardVO boardVO);

    public void delete(int id);

    public List<BoardVO> listAll();

   public void increaseViews(int id);
}