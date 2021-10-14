package hello.core.member;

public class MemberServiceImpl implements MemberService {

    // 추상화 MemberService 인터페이스도 의존하지만, 구체화된 MemoryMemberRepository 에도 의존
    // DIP 위반 -> DI로 외부에서 넣어줘야한다!
    private final MemberRepository memberRepository = new MemoryMemberRepository();

    @Override
    public void join(Member member) {
        memberRepository.save(member);
    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);

    }
}
