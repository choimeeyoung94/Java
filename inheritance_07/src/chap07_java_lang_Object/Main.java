package chap07_java_lang_Object;

public class Main {

  public static void main(String[] args) {
    // Object 타입으로 up-casting
    Object car1 = new Car("123가4567", "Ray");
    
    // down-casting을 통해 carInfo() 메소드를 호출
    if (car1 instanceof Car) {
      ((Car) car1).carInfo();
    }
    
    // car1 인스턴스와 동일한 값을 가지는 car2 인스턴스 생성
    Object car2 = new Car("123가4567", "레이");
    
    // 오버라이드된 equals() 메소드 동작 확인
    System.out.println(car1.equals(car2));
    
    // 오버라이드된 toString() 메소드 동작 확인
    System.out.println(car1); // toString() 메소드는 생략한다
    System.out.println(car2);
    
  }

}
