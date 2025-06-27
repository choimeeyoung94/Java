package chap02_loop;

public class WhileEx {

  public static void main(String[] args) {
    
    // 1 ~ 100 누적하기
    int total = 0;
    int x = 0;
    while(x < 100) {
       total += ++x; 
       
    }
    System.out.println(total);
    
    
    // 1~ 100 사이의 홀수만 누적
    int oddTotal = 0;
    int odd = 1;
    while (odd <= 100 ) {
      if  (odd % 2 == 1) {
        oddTotal += odd;
      }
      odd++;  
    }
    System.out.println(oddTotal);
  }

}
