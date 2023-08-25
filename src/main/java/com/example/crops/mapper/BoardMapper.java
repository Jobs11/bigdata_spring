package com.example.crops.mapper;

import com.example.crops.domain.BoardVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BoardMapper {
   public void register(BoardVO boardVO); //게시물 등록 메서드

    public BoardVO read(int id);

    public void update(BoardVO boardVO);

    public void delete(int id);

    public List<BoardVO> listAll();

    void increaseViews(int id);
}
