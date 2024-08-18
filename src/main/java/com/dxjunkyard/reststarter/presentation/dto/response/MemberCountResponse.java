package com.dxjunkyard.reststarter.presentation.dto.response;

import com.dxjunkyard.reststarter.domain.model.Count;
import io.swagger.v3.oas.annotations.media.Schema;

public record MemberCountResponse(
        @Schema(description = "The number of members")
        Long total
) {
    public static MemberCountResponse from(final Count count) {
        return new MemberCountResponse(count.getValue());
    }
}
