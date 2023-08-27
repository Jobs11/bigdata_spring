package com.example.crops.controller;

import com.example.crops.domain.BoardVO;
import org.springframework.security.access.prepost.PreAuthorize;
import com.example.crops.service.BoardService;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;
import org.python.antlr.ast.Str;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/board/*")
@AllArgsConstructor
public class BoardController {

    private BoardService boardService;

//    @PreAuthorize("hasAnyRole('USER', 'ADMIN')") // 해당 role 중 하나가 있는 사용자만 접근 가능
    @GetMapping("/BoardRegister")
    public void BoardRegister(){

    }


//    @PreAuthorize("hasAnyRole('USER', 'ADMIN')") // 해당 role 중 하나가 있는 사용자만 접근 가능
    @PostMapping("/BoardRegister")
    public String register(BoardVO boardVO){

        boardService.register(boardVO);
        return "redirect:/board/BoardList";
    }

//    @PreAuthorize("hasAnyRole('USER', 'ADMIN')") // 해당 role 중 하나가 있는 사용자만 접근 가능
    @PostMapping("/BoardUpdate")
    public String update(BoardVO boardVO){
        boardService.update(boardVO);
        System.out.println(boardVO);
        return "redirect:/board/BoardList";
    }


//    @PreAuthorize("hasAnyRole('USER', 'ADMIN')") // 해당 role 중 하나가 있는 사용자만 접근 가능
    @GetMapping("/BoardDelete")
    public String delete(int id){
        boardService.delete(id);
        return "redirect:/board/BoardList";
    }


    @GetMapping("/BoardList")
    public void list(Model model){
        model.addAttribute("boardList",boardService.listAll());
        System.out.println(model);
    }

    @GetMapping("/BoardRead")
    public String readBoard(int id, Model model) {
        // 해당 게시글 조회
        BoardVO board = boardService.read(id);

        // 조회수 증가 처리
        boardService.increaseViews(id);

        model.addAttribute("boardRead", board);
        return "/board/BoardRead";
    }


//    @PreAuthorize("hasAnyRole('USER', 'ADMIN')") // 해당 role 중 하나가 있는 사용자만 접근 가능
    @GetMapping("/BoardUpdate")
    public String updateBoard(int id, Model model) {
        // 해당 게시글 조회
        BoardVO board = boardService.read(id);

        model.addAttribute("boardRead", board);
        return "/board/BoardUpdate";
    }
//    @GetMapping("/testBoardList")
//    public void testBoardList(Model model) {
//        List<BoardVO> boardList = new ArrayList<BoardVO>();
//
//
//        for (int i=0;i<9;i++){
//            BoardVO boardVO = new BoardVO();
//            boardVO.setId(Long.valueOf(i));
//            boardVO.setTitle("제목 :" + i);
//            boardVO.setUserId("작성자 : " + i);
//            boardVO.setContent("글내용 :" + i);
//            boardVO.setCreateDate(new Date());
//            boardVO.setCnt(0L);
//            boardList.add(boardVO);
//        }
//        model.addAttribute("boardList", boardList);
//        System.out.println(model);
//    }


}