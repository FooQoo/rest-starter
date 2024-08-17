package com.dxjunkyard.reststarter.domain.repository;

import com.dxjunkyard.reststarter.domain.model.Member;
import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberRepository extends CrudRepository<Member, Long> {
    List<Member> findAll();
}
