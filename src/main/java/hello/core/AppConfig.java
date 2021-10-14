package hello.core;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.member.MemberRepository;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.member.MemoryMemberRepository;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;

// 객체를 생성하고 연결하는 역할과 실행하는 역할이 명확히 분리
// AppConfig 는 객체를 생성하고 연결하는 역할
// 애플리케이션의 실제 동작에 필요한 구현 객체를 생성!
public class AppConfig {

    public MemberService memberService() {
        // 생성자 주입
        return new MemberServiceImpl(memberRepository());
    }

    public OrderService orderService() {
        // 역할
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }

    // 구현으로!
    private DiscountPolicy discountPolicy() {
//        return new FixDiscountPolicy();
        // 사용영역의 변경 없이, 구성 영역인 이곳만 바꿔서 수정 완료!
        return new RateDiscountPolicy();
    }

    private MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }
}
