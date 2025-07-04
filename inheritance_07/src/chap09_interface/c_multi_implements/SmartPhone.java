package chap09_interface.c_multi_implements;

// 인터페이스는 다중 구현할 수 있다
public class SmartPhone implements Camera, Phone {

  @Override
  public void call() {
    System.out.println("통화 가능");
    
  }

  @Override
  public void picture() {
    System.out.println("카메라 가능");
  }
  
}
