package com.straws.reststarter.presentation.controller;

import com.straws.reststarter.application.service.MemberService;
import com.straws.reststarter.domain.model.Member;
import com.straws.reststarter.presentation.dto.response.MemberListResponse;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("/v1")
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    @GetMapping("/member/list")
    public MemberListResponse findAll() {
        final List<Member> members = memberService.findAll();
        return MemberListResponse.of(members);
    }
}
