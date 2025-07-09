package chap05_downcasting;

public class Chihuahua extends Dog {

  @Override
  public void bark() {
    System.out.println("앙앙앙!");
  }
  
  public void getAngry() {
    System.out.println("치와와는 화를 잘 냅니다.");
  }
  
  
}
