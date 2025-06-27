package chap03_ex;

public class LogicEx {

  public static void main(String[] args) {
    int x = 10;
    int y = 20;
    
    System.out.println(x > 0 && y > 0);  // && 논리 AND (모두 만족하면 true, 아니면 false)
    System.out.println(x > 0 || y > 0);  // || 논리 OR (하나라도 만족하면 true, 아니면 false)
    System.out.println(!(x > 0));        // ! : 논리 NOT (true와 false를 서로 바꿈)
    
    
  }

}
