package com.example.crops.controller;

import com.example.crops.domain.BoardVO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/board/*")
public class BoardController {

    @GetMapping("/testBoardList")
    public void testBoardList(Model model) {
        List<BoardVO> boardList = new ArrayList<>();


        for (int i=0;i<9;i++){
            BoardVO boardVO = new BoardVO();
            Long a = Long.valueOf(i);
            boardVO.setId(a);
            boardVO.setTitle("제목 :" + i);
            boardVO.setUserId("작성자 : " + i);
            boardVO.setContent("글내용 :" + i);
            boardVO.setCreateDate(new Date());
            boardVO.setCnt(0L);
            boardList.add(boardVO);
        }
        model.addAttribute("boardList", boardList);
        System.out.println(model);
    }

}