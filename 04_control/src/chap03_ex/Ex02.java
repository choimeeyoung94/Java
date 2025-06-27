package chap03_ex;

public class Ex02 {

  public static void main(String[] args) {
    
    // 정수형 변수 3개에 임의의 값을 저장한 뒤, 그 중에서 가장 큰 수를 출력하세요.
    int a = 20;
    int b = 30;
    int c = 5;
    int biggerNum = 0;
    int result = 0;
    if (a > b) {
      biggerNum = a;
    } else {
      biggerNum = b;
    }
    
    if (biggerNum > c) {
      result = biggerNum;
    } else {
      result = c;
    }
    
    System.out.println("가장 큰 수: " + result);
    

  }

}
