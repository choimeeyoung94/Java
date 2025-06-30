package chap05_field;

public class Car {
  /*
   * 필드 (Field)
   * 
   * 1. 클래스가 가지는 값
   * 2. 클래스가 선언한 변수 (일반 직역변수와 구분해서 필드라고 부른다)
   * 3. 클래스에 포함된 모든 메소드는 필드를 사용할 수 있다
   * 4. 일반 직역변수와 달리 선언만 하면 자동으로 초기화 된다 (0, false, null 등)
   * */
  // 이 model, price는 클래스 Car에서 선언했으므로 필드이다.
  String model;
  int price;
  
  void setInfo(String model, int price) {
    // this
    // setInfo 메소드를 호출하는 객체(인스턴스)를 의미한다 (참조값)
    // 매개변수 이름과 필드 이름이 같을때 사용한다
    this.model = model;// 필드값으로 저장된다
    this.price = price;// 필드값으로 저장된다
  }
  
  void printInfo() {
    System.out.println(model + ", " + price);
  }
  

}
