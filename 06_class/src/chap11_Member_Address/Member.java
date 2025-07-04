package chap11_Member_Address;

// 문제. 필드를 이용한 생성자를 만들고 정보를 출력하는 printInfo() 메소드를 구현하세요.

public class Member {

  private Address home;  //------ 집주소
  private Address delivery;  //-- 배송지주소
 
  public Member(Address home, Address delivery) {
    this.home = home;
    this.delivery = delivery;
  }

  public Address getHome() {
    return home;
  }


  public Address getDelivery() {
    return delivery;
  }

 
  
  
}
