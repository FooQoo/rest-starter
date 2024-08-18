package com.dxjunkyard.reststarter.presentation.controller;

import com.dxjunkyard.reststarter.application.service.MemberService;
import com.dxjunkyard.reststarter.presentation.dto.request.MemberSearchRequest;
import com.dxjunkyard.reststarter.presentation.dto.response.MemberCountResponse;
import com.dxjunkyard.reststarter.presentation.dto.response.MemberListResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springdoc.api.annotations.ParameterObject;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/v1/member")
public class MemberController {

    private final MemberService memberService;

    @Operation(summary = "社員数を取得する",
            responses = {
                    @ApiResponse(responseCode = "200")
            })
    @GetMapping("/count")
    public Mono<MemberCountResponse> count() {
        return memberService.count()
                .map(MemberCountResponse::from);
    }

    @Operation(summary = "社員を検索する",
            responses = {
                    @ApiResponse(responseCode = "200")
            })
    @GetMapping("/search")
    public Mono<MemberListResponse> search(
            @ParameterObject @Validated final MemberSearchRequest request) {
        return memberService.search(request.toCondition())
                .collectList()
                .map(MemberListResponse::from);
    }
}
