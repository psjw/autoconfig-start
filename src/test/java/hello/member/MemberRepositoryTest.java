package hello.member;

import java.beans.Transient;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
class MemberRepositoryTest {
    @Autowired
    MemberRepository memberRepository;

    @Transactional
    @Test
    void memberTest(){
        Member member = new Member("idA", "memberA");
        memberRepository.initTable();
        memberRepository.save(member);
        Member findMember = memberRepository.find(member.getMemberId());
        Assertions.assertThat(findMember.getMemberId()).isEqualTo(member.getMemberId());
        Assertions.assertThat(findMember.getName()).isEqualTo(member.getName());
    }
}