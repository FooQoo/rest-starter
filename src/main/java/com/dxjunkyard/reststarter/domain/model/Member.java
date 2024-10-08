package com.dxjunkyard.reststarter.domain.model;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
@Builder
public class Member {

    private final Integer memberId;
    private final String name;
    private final CompanyPosition companyPosition;
}
