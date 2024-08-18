package com.dxjunkyard.reststarter.domain.model.search;

import java.util.Objects;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.lang.Nullable;

@RequiredArgsConstructor
public class MemberSearchCondition {

    @Nullable
    private final String name;

    @Nullable
    private final Integer companyPositionId;

    public boolean hasCondition() {
        return Objects.nonNull(name)
                || Objects.nonNull(companyPositionId);
    }

    public Optional<String> getName() {
        return Optional.ofNullable(name);
    }

    public Optional<Integer> getCompanyPositionId() {
        return Optional.ofNullable(companyPositionId);
    }
}
