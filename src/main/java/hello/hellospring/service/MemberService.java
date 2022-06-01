package hello.hellospring.service;

import hello.hellospring.domain.Member;
import hello.hellospring.repository.MemberRepository;
import hello.hellospring.repository.MemoryMemberRepository;

import java.util.List;
import java.util.Optional;

public class MemberService {

    private final MemberRepository memberRepository = new MemoryMemberRepository();

    /**
     * 회원 가입
     */
    public Long join(Member member) {
        // 같은 이름이 있는 중복 회원 X
        validateDuplicateMember(member);

        memberRepository.save(member);
        return member.getId();
    }


    private void validateDuplicateMember(Member member) {
        // Optional 안에 Member 객체가 있어 Optional의 여러 method를 사용 할 수 가 있다.
        memberRepository.findByName(member.getName())
            // if(null) 로직 대신에 Optional안의 ifPresent method를 사용해서 처리 할 수 있음.
            .ifPresent(m -> {
                throw new IllegalStateException("이미 존재하는 회원입니다.");
            });
    }

    /**
     * 전체 회원 조회
     */
    public List<Member> findMembers(){
        return memberRepository.findAll();
    }

    /**
     * 특정 회원 조회
     */

    public Optional<Member> findOne(Long memberId){
        return memberRepository.findById(memberId);
    }


}
