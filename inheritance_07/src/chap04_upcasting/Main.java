package chap04_upcasting;


/*
 * up-casting
 * 
 * 1. 서브클래스 타입의 객체(인스턴스)를 슈퍼클래스 타입으로 변환할 수 있다
 * 2. 슈퍼클래스 타입으로 변환된 서브클래스 객체는 슈퍼클래스의 멤버에 접근할 수 있다
 * 3. 자동으로 변환되므로 강제로 캐스팅할 필요가 없다
 * 4. 하나의 타입(슈퍼클래스 타입)으로 여러 객체(서브클래스 타입의 객체)를 관리할 수 있다
 * */


public class Main {
  public static void main(String[] args) {
    
    // 치와와와 허스키가 합쳐서 20마리가 온다
    // 그런데 각각 몇 마리인지는 모른다
    // 어떻게 저장하는가
    
    // 업캐스팅: 자식은 부모타입으로 바꿀수 있다
    // 상속의 진짜 이유는 업캐스팅이다    
    Dog chiuaua = new Chihuahua();
    chiuaua.bark(); // 호출할 땐 Dog의 bark()를 호출하지만, 실행할 땐 Chihuahua의 bark()가 실행된다
                    // 오버라이드 된 메소드의 경우 명시적으로 작성된 타입(Dog)이 아닌 실제 저장된 객체의 타입(Chihuahua)으로 메소드가 연결되면서 (Binding) 실행된다
                    // 명시적으로 작성된 타입과 실행하는 타입이 바뀌는 것을 "동적 바인딩(Dynamic Binding)"이라고 한다
    Dog husky = new Husky();
    husky.bark();

    // 서로 다른 타입의 객체들을 하나의 타입으로 관리하기
    Dog[] dogs = new Dog[20];
    dogs[0] = new Chihuahua();
    dogs[1] = new Husky();
    for (Dog dog : dogs ) {
      if (dog != null) {
        dog.bark();  
      }  
    }
    
    
    
    
    
  }
}
