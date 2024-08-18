package com.dxjunkyard.reststarter.domain.model;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
@Builder
public class CompanyPosition {
    private final Integer companyPositionId;
    private final String name;
}
