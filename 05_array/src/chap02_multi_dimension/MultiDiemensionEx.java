package chap02_multi_dimension;

import java.util.Arrays;

public class MultiDiemensionEx {

  public static void main(String[] args) {
   
    // 2차원 배열이란
    // 1차원 배열이 여러 개 존재하는 경우 이 1차원 배열을 합친것이다
    
    // 2차원 배열 선언
    String[][] seats;
    
    // 배열 생성 (1차원 배열을 만드는 작업)
    seats = new String[3][]; // 1차원 배열이 3개이다
    
    // 1차원 배열 생성 (1차원 배열의 길이를 만드는 작업)
    seats[0] = new String[2]; // 첫번째 1차원 배열의 길이는 2이다 seats[0]이 1차원 배열의 이름
    seats[1] = new String[5]; // 두번째 1차원 배열의 길이는 5이다 seats[1]이 1차원 배열의 이름
    seats[2] = new String[4]; // 세번째 1차원 배열의 길이는 4이다 seats[2]이 1차원 배열의 이름
    
    // 2차원 배열 요소 사용 (인덱스를 2개 사용 : 몇 번째 1차원 배열인가? 1차원 배열 내 몇 번째 요소인가?)
    seats[0][0] = "이동욱";
    seats[0][1] = "신성수";
    
    seats[1][0] = "이유천";
    seats[1][1] = "조기완";
    seats[1][2] = "최미영";
    seats[1][3] = "박진성";
    seats[1][4] = "김민석";
    
    seats[2][0] = "유비";
    seats[2][1] = "이창민";
    seats[2][2] = "권형택";
    seats[2][3] = "김경진";
   
   for (int i = 0; i < seats.length; i++) { // 각 1차원 배열 찾아가기
     for (int j = 0; j < seats[i].length; j++) { // 찾아간 1차원 배열 요소 순회하기
       System.out.print(seats[i][j] + ",");
     }
     System.out.println();
   } 

   
   for (String[] lines: seats) {
     for (String seat : lines)  {
       System.out.print(seat + ",");
     }
     System.out.println();
   }

   /*
    * [Stack]               Reference(참조값)
    * +-------------------+
    * | seats    : 0x100  |
    * +-------------------+
   
    * 
    * [Heap]   
    * | ...               |
    * +-------------------+
    * | seats[0] : 0xAAA  | 0x100
    * +-------------------+
    * | seats[1] : 0xBBB  | 0x104
    * +-------------------+
    * | seats[2] : 0xCCC  | 0x108
    * +-------------------+
    * |  ...              |               [String Constant Pool] -> 문자열 리터럴("")로 생성한 문자열이 저장되는 곳 (JVM이 관리한다)
    * +-------------------+                      +--------+
    * | seats[0][0] : 0x1 | 0xAAA                | 이동욱 | 0x1
    * +-------------------+                      +--------+
    * | seats[0][1] : 0x2 |                      | 신성수 | 0x2
    * +-------------------+                      +--------+
    * | ...               |
    * +-------------------+                      +--------+
    * | seats[1][0] : 0x3 | 0xBBB                | 이유천 | 0x3
    * +-------------------+                      +--------+
    * | seats[1][1] : 0x4 |                      | 조기완 | 0x4
    * +-------------------+                      +--------+
    * | seats[1][2] : 0x5 |                      | 최미영 | 0x5
    * +-------------------+                      +--------+
    * | seats[1][3] : 0x6 |                      | 박진성 | 0x6
    * +-------------------+                      +--------+
    * | seats[1][4] : 0x7 |                      | 김민석 | 0x7
    * +-------------------+                      +--------+
    * | ...               |
    * +-------------------+                      +--------+
    * | seats[2][0] : 0x8 | 0xCCC                | 유  비 | 0x8
    * +-------------------+                      +--------+
    * | seats[2][1] : 0x9 |                      | 이창민 | 0x9
    * +-------------------+                      +--------+
    * | seats[2][2] : 0xA |                      | 권형택 | 0xA
    * +-------------------+                      +--------+
    * | seats[2][3] : 0xB |                      | 김경진 | 0xB
    * +-------------------+                      +--------+
    * | ...               |
    * +-------------------+
    */
   
   a();
   
   
  }
  
  public static void a() {
    String[] array = new String[3];
    b(array);
    System.out.println(Arrays.toString(array));
  }
  
  public static void b(String[] array) {
    array[0] = "a";
    array[1] = "b";
    array[2] = "c";
  }

}
