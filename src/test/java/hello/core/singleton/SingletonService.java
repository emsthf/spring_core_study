package hello.core.singleton;

public class SingletonService {

    // 1. 자기 자신을 내부에 private로 가지고 있는데 static으로 가지고 있는다. = class 레벨에 올라가기 때문에 딱 1개만 존재하게 됨
    // 자바가 작동할 때 SingletonService의 static 영역의 오른쪽에 new라고 되어있으면 내부적으로 자기 자신을 실행해서 instance에 미리 참조를 넣어놓는다.
    private static final SingletonService instance = new SingletonService();

    // 2. public으로 열어서 객체 인스터스가 필요하면 이 static 메서드를 통해서만 조회하도록 허용한다.
    public static SingletonService getInstance() {
        return instance;
    }

    //3. 생성자를 private으로 선언해서 외부에서 new 키워드를 사용한 객체 생성을 못하게 막는다.
    private SingletonService() {
    }

    public void logic() {
        System.out.println("싱글톤 객체 로직 호출");
    }
}
