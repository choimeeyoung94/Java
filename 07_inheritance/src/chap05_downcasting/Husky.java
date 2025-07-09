package chap05_downcasting;

public class Husky extends Dog{
  
  @Override
  public void bark() {
    System.out.println("워프워프워프");
  }
  
  public void pullSnowSled() {
    System.out.println("허스키는 눈썰매를 끌 수 있다.");
  }
}
