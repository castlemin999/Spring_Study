package hello.hellospring.repository;

import hello.hellospring.domain.Member;

import java.util.List;
import java.util.Optional;

// 회원 객체를 저장하는 저장소
// 실제로 DB에 접근하여 Data CRUD를 하는 객체
public interface MemberRepository {
    Member save(Member member);
    // Optional null을 반환할때 사용
    Optional<Member> findById(Long id);
    Optional<Member> findByName(String name);
    List<Member> findAll();
}
