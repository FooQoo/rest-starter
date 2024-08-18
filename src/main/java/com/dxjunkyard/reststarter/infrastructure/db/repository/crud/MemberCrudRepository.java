package com.dxjunkyard.reststarter.infrastructure.db.repository.crud;

import com.dxjunkyard.reststarter.infrastructure.db.entity.MemberEntity;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
public interface MemberCrudRepository extends ReactiveCrudRepository<MemberEntity, Long> {

    /**
     * 社員一覧を取得する.
     *
     * @return 社員数一覧
     */
    @NonNull
    Mono<Long> count();
}
