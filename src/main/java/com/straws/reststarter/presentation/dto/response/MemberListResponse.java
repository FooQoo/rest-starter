package com.straws.reststarter.presentation.dto.response;

import com.straws.reststarter.domain.model.Member;
import java.util.List;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor(staticName = "of")
@Getter
public class MemberListResponse {
    private final List<Member> members;
}
