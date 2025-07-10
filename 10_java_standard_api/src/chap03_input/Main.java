package chap03_input;

import java.util.Scanner;

/*
 * java.util.Scanner
 * 
 * 1. 사용자가 콘솔 창으로 데이터를 입력할 때 사용할 수 있다
 * 2. 표준 입력 스트림(System.in)으로부터 데이터를 입력받을 수 있도록 Scanner 객체를 생성한다
 *    사용자로부터 데이터를 입력받을 수 있다
 * 3. 주요 메소드
 *    1) next()             공백 없는 문자열 입력
 *    2) nextLine()         공백 포함된 문자열 입력
 *    3) nextInt()          int 입력
 *    4) nextLong()         long 입력
 *    5) nextDouble()       double 입력
 *    6) next().charAt(0)   char 입력
 * */

public class Main {
  public static void main(String[] args) {

    boolean isDone = false;
    
    while (!isDone) {
      try {
        
        
        // 표준 입력 스트림(키보드)으로부터 데이터를 입력 받는 Scanner 객체 생성
        Scanner sc = new Scanner(System.in);
       
        System.out.print("이름을 입력하세요 >>> ");
        String name = sc.next();
        System.out.println("입력된 이름은 " + name + "입니다.");
        
        System.out.print("나이를 입력하세요 >>> ");
        int age = sc.nextInt();
        System.out.println("입력된 나이는 " + age + "입니다.");
        
        System.out.print("키를 입력하세요 >>> ");
        double height = sc.nextDouble();
        System.out.println("입력된 키는 " + height + "입니다.");
       
        // 입력 리소스 사용 후 반납
        sc.close();
        
        isDone = true;
      } catch (Exception e) {
        System.out.println("올바른 타입의 정보를 입력해야 한다");
        isDone = false;
      }
    }
    
    
    
    
    
    
    
    
  }
}
