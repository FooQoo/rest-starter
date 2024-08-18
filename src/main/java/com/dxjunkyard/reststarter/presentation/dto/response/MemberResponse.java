package com.dxjunkyard.reststarter.presentation.dto.response;

import com.dxjunkyard.reststarter.domain.model.Member;
import org.springframework.lang.NonNull;

import java.io.Serializable;
import java.util.Objects;


public record MemberResponse(
        Long id,
        String name
) implements Serializable {
    public MemberResponse {
        Objects.requireNonNull(id, "id must not be null");
        Objects.requireNonNull(name, "name must not be null");
    }

    @NonNull
    public static MemberResponse from(final Member member) {
        return new MemberResponse(member.id(), member.name());
    }
}
