package chap04_method_overloading;

import java.util.Arrays;

public class View {
  /*
   * 메소드 오버로딩(Method Overloading)
   * 
   * 1. 같은 이름의 메소드를 여러개 만들 수 있다
   * 2. 반드시 매개변수가 서로 달라야 한다 (개수 또는 타입)
   * 3. 반환타입 상관없다
   * */
  void print(int x) {
     System.out.println("View x: " + x);
  }
  
  void print(double x) {
    System.out.println("View x: " + x); 
  }
  
  void print(String[] items) {
    if (items == null) {
      return;
    }
    System.out.println("View items: " + Arrays.toString(items));
  }
  
  void print(Car car) {
    if (car == null) {
      return;
    }
    System.out.println("View car: " + car.getModel());
  }
  
  
  
}
