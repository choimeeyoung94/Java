package chap06_constructor;

public class Main {

  public static void main(String[] args) {
    // 디폴트 생성자 호출
    Car car1 = new Car();
    car1.printInfo();
    
    Car car2 = new Car("Sorento");
    car2.printInfo();
    
    Car car3 = new Car(5000);
    car3.printInfo();
    
    Car car4 = new Car("Sorento", 6000);
    car4.printInfo();
    
    Car car5 = new Car("Sorento", 7000, new Brand("Genesis","Korea"));
    car5.printInfo();
  }

}
