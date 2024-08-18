package com.dxjunkyard.reststarter.domain.model;

import java.io.Serializable;
import java.util.Objects;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Table
public record Member(
        @Id
        @Column(value = "ID")
        Long id,

        @Column(value = "NAME")
        String name
) implements Serializable {

    public Member {
        Objects.requireNonNull(name, "name must not be null");
    }
}
