package com.dxjunkyard.reststarter.presentation.controller;

import com.dxjunkyard.reststarter.application.service.MemberService;
import com.dxjunkyard.reststarter.presentation.dto.response.MemberListResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/v1")
public class MemberController {

    private final MemberService memberService;

    @GetMapping("/member/list")
    public Mono<MemberListResponse> findAll() {
        return memberService.findAll()
                .collectList()
                .map(MemberListResponse::of);
    }
}
