package com.dxjunkyard.reststarter.presentation.dto.request;

import com.dxjunkyard.reststarter.domain.model.search.MemberSearchCondition;
import io.swagger.v3.oas.annotations.Parameter;
import jakarta.validation.constraints.NotBlank;
import org.springframework.lang.NonNull;

public record MemberSearchRequest(
        @Parameter(description = "The name of the member. This is an exact match.")
        @NotBlank
        String name,
        @Parameter(description = "The company position ID of the member.")
        Integer companyPositionId
) {

    @NonNull
    public MemberSearchCondition toCondition() {
        return new MemberSearchCondition(name, companyPositionId);
    }
}
