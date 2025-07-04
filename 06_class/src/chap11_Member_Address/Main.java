package chap11_Member_Address;

// 문제. 생성자를 호출하여 Member 객체를 만들고 printInfo() 메소드를 호출하여 객체의 정보를 확인하세요.

public class Main {

  public static void main(String[] args) {
    Member member = new Member(new Address("0011", "경기도 의왕시 내손로 14", "204동 901호"), new Address("0012", "경기도 의왕시 내손로 15", "205동 902호" ));
    member.getHome().printInfo();
    member.getDelivery().printInfo();
  }

}
