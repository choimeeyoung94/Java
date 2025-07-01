package chap07_access_modifier;

public class Main {

  public static void main(String[] args) {
    Car car1 = new Car();
    car1.printInfo();
    
    Car car2 = new Car("X6", 12000, new Brand("BMW", "Germany"));
    car2.printInfo();
    
    Car car3 = new Car("G80", 22000, "Genesis", "KOREA");
    car3.printInfo();
    
    // Getter는 필드값을 확인할 때 사용한다
    System.out.println(car1.getModel());
    System.out.println(car1.getPrice());
    System.out.println(car1.getBrand().getName());
    System.out.println(car1.getBrand().getNation());

    car2.setModel("");
    car2.setPrice(0);
    car2.getBrand().setName("");
    car2.getBrand().setNation("");
    car2.printInfo();
    
    // Setter는 필드값을 수정할 때 사용한다
    car3.setModel("Sorento");
    car3.setPrice(40000);
    car3.setBrand(new Brand("Kia", "Korea"));
    car3.printInfo();
  }

}
