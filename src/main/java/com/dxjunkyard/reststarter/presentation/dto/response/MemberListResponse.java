package com.dxjunkyard.reststarter.presentation.dto.response;

import com.dxjunkyard.reststarter.domain.model.Member;
import java.io.Serializable;
import java.util.List;

public record MemberListResponse(
        List<MemberResponse> members
) implements Serializable {

    public static MemberListResponse of(final List<Member> members) {

        final var memberResponses = members.stream()
                .map(MemberResponse::from)
                .toList();

        return new MemberListResponse(memberResponses);
    }
}
