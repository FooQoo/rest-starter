package com.dxjunkyard.reststarter.application.service;

import com.dxjunkyard.reststarter.domain.model.Member;
import com.dxjunkyard.reststarter.domain.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@Service
@RequiredArgsConstructor
public class MemberService {
    private final MemberRepository memberRepository;

    public Flux<Member> findAll() {
        return memberRepository.findAll();
    }
}
