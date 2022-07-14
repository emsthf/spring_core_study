package hello.core;

import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MemberApp {

    public static void main(String[] args) {
        // 순수 자바 코드식인 AppConfig 방식
//        AppConfig appConfig = new AppConfig();
//        MemberService memberService = appConfig.memberService();

        // 스프링은 모든게 ApplicationContext로 시작한다. 이게 스프링 컨테이너라고 보면 된다.
        // 얘가 @Bean 객체들을 관리해준다.
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);  // AppConfig 안에 있는 @Bean들을 객체 생성해서 스프링 컨테이너에 집어넣어 관리해줌
        MemberService memberService = applicationContext.getBean("memberService", MemberService.class);  // getBean으로 이름과 타입으로 꺼내 사용한다.

        Member member = new Member(1L, "memberA", Grade.VIP);
        memberService.join(member);

        Member findMember = memberService.findMember(1L);
        System.out.println("new member = " + member.getName());
        System.out.println("findMember = " + findMember.getName());
    }
}
