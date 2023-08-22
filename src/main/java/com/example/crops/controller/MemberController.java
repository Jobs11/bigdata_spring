package com.example.crops.controller;

import com.example.crops.domain.MemberVO;
import com.example.crops.service.MemberService;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;

@Controller
@Log4j2
@RequestMapping("/member/*")
@AllArgsConstructor
public class MemberController {
    private MemberService memberService;

    @GetMapping("/insert")
    public void getreg(){

    }

    @PostMapping("/insert")
    public String register(MemberVO member, RedirectAttributes rttr){
        memberService.insert(member);
        rttr.addFlashAttribute("result", member.getId());
        return "redirect:../data/kinidata";
    }

    @GetMapping("/getMem")
    public String getMem(String id, String password, HttpSession session, RedirectAttributes rttr){
        MemberVO login = memberService.getMem(id, password);

        if (login != null) {
            session.setAttribute("LoginVo", login);
        }
        rttr.addFlashAttribute("result", login.getId());
        return "redirect:../data/kinidata";
    }
}
