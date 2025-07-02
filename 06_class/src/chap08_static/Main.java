package chap08_static;

public class Main {

  public static void main(String[] args) {
    Counter counter1 = new Counter();
    Counter counter2 = new Counter();
    Counter counter3 = new Counter();
    
    // static 멤버는 클래스를 이용해서 접근한다
    System.out.println("생성된 Counter 객체 수:" + Counter.count);
    Counter.viewCount();
    
    // 인스턴스 메소드는 인스턴스를 이용해서 호출한다
    counter1.printInfo();
    counter2.printInfo();
    counter3.printInfo();
  }

}
