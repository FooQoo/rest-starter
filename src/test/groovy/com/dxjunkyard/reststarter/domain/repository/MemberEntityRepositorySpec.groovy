package com.dxjunkyard.reststarter.domain.repository

import com.dxjunkyard.reststarter.infrastructure.db.repository.crud.MemberCrudRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ActiveProfiles
import org.springframework.test.context.jdbc.Sql
import spock.lang.Specification

@SpringBootTest
@ActiveProfiles("test")
@Sql(["classpath:/schema/member_schema.sql", "classpath:/data/import_member.sql"])
class MemberEntityRepositorySpec extends Specification {

    @Autowired
    MemberCrudRepository memberRepository

    def "findAll"() {
        when:
        final actual = memberRepository.findAll()

        then:
        actual.size() == 3
    }
}
