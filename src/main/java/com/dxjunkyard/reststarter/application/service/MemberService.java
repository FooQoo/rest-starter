package com.dxjunkyard.reststarter.application.service;

import com.dxjunkyard.reststarter.domain.model.Member;
import com.dxjunkyard.reststarter.domain.repository.MemberRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberService {
    private final MemberRepository memberRepository;

    public List<Member> findAll() {
        return memberRepository.findAll();
    }
}
