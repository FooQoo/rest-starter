package com.straws.reststarter.domain.repository


import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ActiveProfiles
import org.springframework.test.context.jdbc.Sql
import spock.lang.Specification

@SpringBootTest
@ActiveProfiles("test")
@Sql(["classpath:/schema/member_schema.sql", "classpath:/data/import_member.sql"])
class MemberRepositorySpec extends Specification {

    @Autowired
    MemberRepository memberRepository

    def "findAll"() {
        when:
        final actual = memberRepository.findAll()

        then:
        actual.size() == 3
    }
}
