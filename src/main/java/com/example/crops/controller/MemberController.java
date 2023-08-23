package com.example.crops.controller;

import com.example.crops.domain.MemberVO;
import com.example.crops.service.MemberService;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
    public String register(MemberVO member, Model model){
        // 이미 존재하는 userId인지 확인
        if (memberService.getMemberById(member.getUserId()) != null) {
            model.addAttribute("message", "이미 존재하는 아이디입니다.");
            return "member/insert";  // 회원 가입 페이지로 돌아가면서 메시지 전달
        }

        memberService.insertMember(member);
        return "redirect:/";  // 회원 가입 성공 시 홈페이지로 리다이렉트
    }

    @PostMapping("/login")
    public String login(MemberVO member, Model model, HttpSession session) {
        // 이미 존재하는 userId인지 확인
        MemberVO loggedInMember = memberService.loginMember(member.getUserId(), member.getPassword());
        if (loggedInMember != null) {
            // 로그인 성공 시 세션에 사용자 정보 저장
            session.setAttribute("loggedInMember", loggedInMember);
        }

        return "redirect:/";  // 로그인 성공 시 홈페이지로 리다이렉트
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        // 세션 제거
        session.invalidate();
        return "redirect:/";  // 로그아웃 후 홈페이지로 리다이렉트
    }

}
