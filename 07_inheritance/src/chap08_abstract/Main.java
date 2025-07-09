package chap08_abstract;

public class Main {

  public static void main(String[] args) {
   
    // 다형성: 객체에 따라서 동일한 코드가 다르게 동작
    Animal animal;
    
   // animal = new Animal(); // 추상 메소드를 가진 클래스는 객체를 만들 수 없다 (추상클래스 객체는 생성할 수 없다)
    
    
    animal = new Lion();
    animal.move(); // 호출할땐 부모의 메소드가 호출되고 실행할때는 오버라이드된 메소드가 실행된다
    
    animal = new Shark();
    animal.move();
    
    animal = new Eagle();
    animal.move();
    
    animal = new Tiger();
    animal.move();

  }

}
