package chap09_interface.a_overview;

public class Main {
  public static void main(String[] args) {
    
    // 인터페이스를 구현클래스 객체의 타입으로 사용한다
    Animal lion = new Lion();
    lion.move();      // 추상 메소드를 오버라이드 한 메소드
    lion.eat();      // 디폴트 메소드
    Animal.breath(); // 정적 메소드
  }
}
