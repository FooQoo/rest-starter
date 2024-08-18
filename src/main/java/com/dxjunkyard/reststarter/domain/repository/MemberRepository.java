package com.dxjunkyard.reststarter.domain.repository;

import com.dxjunkyard.reststarter.domain.model.Member;
import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

@Repository
public interface MemberRepository extends ReactiveCrudRepository<Member, Long> {
    Flux<Member> findAll();
}
