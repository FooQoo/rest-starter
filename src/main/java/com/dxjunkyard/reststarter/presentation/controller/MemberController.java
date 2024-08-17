package com.dxjunkyard.reststarter.presentation.controller;

import com.dxjunkyard.reststarter.application.service.MemberService;
import com.dxjunkyard.reststarter.domain.model.Member;
import com.dxjunkyard.reststarter.presentation.dto.response.MemberListResponse;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/v1")
public class MemberController {

    private final MemberService memberService;

    @GetMapping("/member/list")
    public MemberListResponse findAll() {
        final List<Member> members = memberService.findAll();
        return MemberListResponse.of(members);
    }
}
