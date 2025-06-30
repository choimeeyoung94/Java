package chap05_field;

public class Main {

  public static void main(String[] args) {
 
    // 필드 초기화 확인
    Car car = new Car();
    System.out.println(car.model + ", " + car.price);

    // 객체마다 서로 다른 필드 값을 가질 수 있다
    Car car1 = new Car();
    Car car2 = new Car();
//    car1.model = "Sorento";
//    car1.price = 4000;
//    car2.model = "Santafe";
//    car2.price = 5000;
    car1.setInfo("Sorento", 4000);// 인자 (메소드를 호출할때 넘기는 실제값)
    car2.setInfo("Santafe", 5000);// 인자 (메소드를 호출할때 넘기는 실제값)
    car1.printInfo();
    car2.printInfo();
//    System.out.println(car1.model + ", " + car1.price);
//    System.out.println(car2.model + ", " + car2.price);
    Car car3 = new Car();
    car3.setInfo("Staria", 6000);
    car3.printInfo();
  }

}
