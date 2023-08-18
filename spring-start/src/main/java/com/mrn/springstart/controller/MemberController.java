package com.mrn.springstart.controller;


import com.mrn.springstart.domain.MemberDto;
import com.mrn.springstart.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class MemberController {
    private final MemberService memberService;

    @Autowired
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @GetMapping("/members/new")
    public String createForm() {
        return "members/createMemberForm";
    }

    @PostMapping("/members/new")
    public String create(MemberForm form){

        MemberDto memberDto = new MemberDto();
        memberDto.setName(form.getName());

        memberService.join(memberDto);
        return "redirect:/";
    }

    @GetMapping("/members")
    public String list(Model model){
        List<MemberDto> members = memberService.findMembers();
        model.addAttribute("members", members);

        return "members/memberList";


    }


}