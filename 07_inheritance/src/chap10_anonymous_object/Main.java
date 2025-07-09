package chap10_anonymous_object;

/*
 * 클래스를 이용한 익명 객체 (Anonymous Object)
 * 
 * 1. 클래스를 상속해서 이름 없는 서브클래스를 즉석에서 선언하고 객체로 생성하는 방법
 * 2. 한 번만 사용할 목적의 임시 객체가 필요할 때 유용하다
 * 3. 문법
 *    슈퍼클래스 참조변수 = new 슈퍼클래스(매개변수, ...) {
 *      @Override  // 필요시 진행
 *      void method() {...}
 *    }
 * */


/*
 * 인터페이스를 이용한 익명 객체 (Anonymous Object)
 * 
 * 1. 인터페이스(또는 추상클래스)를 구현할 때(상속할 때) 구현클래스(서브클래스)를 즉석에서 선언하고 객체로 생성하는 방법
 * 2. 대표적으로 이벤트 처리와 같이 한 번만 처리하는 작업에서 많이 활용된다
 * 3. 문법
 *    인터페이스 참조변수 new 인터페이스(매개변수,...) {
 *      @Override //필수
 *      void method() {...}
 *    }
 * */




public class Main {
  public static void main(String[] args) {
    
    // 서브클래스 Chihuahua 없이 chihuahua 객체 만들기
    Dog chihuahua = new Dog() { // new Dog() {} 부분이 익명 객체이다
      @Override
      public void bark() {
        System.out.println("앙앙앙!");
      }
    };
    chihuahua.bark();
    
    Dog husky = new Dog() {
      @Override
      public void bark() {
        System.out.println("크앙크앙크앙!");
      }
    };
    husky.bark();
    
    // 구현클래스 ConfirmButton 없이 confirmButton 객체 만들기
    Button confirmButton = new Button() {
      
      @Override
      public void onClick() {
        System.out.println("메인페이지로 이동합니다.");
      }
    };
    
    confirmButton.onClick();
    
    Button signInButton = new Button() {
      
      @Override
      public void onClick() {
        System.out.println("회원가입 페이지로 이동합니다.");
      }
    };
    signInButton.onClick();
    
    WebService.signUp(new Button() {
      
      @Override
      public void onClick() {
        System.out.println("회원 가입 후 메인페이지로 이동합니다.");
      }
    });
    WebService.createPost(new Button() {
      
      @Override
      public void onClick() {
        System.out.println("게시글 작성 후 게시글 목록 페이지로 이동");
      }
    });
    
  }
}
