package com.straws.reststarter.presentation.dto.response;

import com.straws.reststarter.domain.model.Member;
import java.io.Serial;
import java.io.Serializable;
import java.util.List;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor(staticName = "of")
@Getter
public class MemberListResponse implements Serializable {

    @Serial
    private static final long serialVersionUID = -116789077993324331L;

    private final List<Member> members;
}
