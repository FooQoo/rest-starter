package com.dxjunkyard.reststarter.infrastructure.db.entity;

import java.io.Serializable;
import java.util.Objects;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Table(name = "MEMBER")
public record MemberEntity(
        @Id
        @Column("member_id")
        Integer id,

        String name,

        @Column("company_position_id")
        Long companyPositionId
) implements Serializable {

    public MemberEntity {
        Objects.requireNonNull(name, "name must not be null");
    }
}
