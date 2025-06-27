package chap01_branch;

public class SwitchEx {

  public static void main(String[] args) {
    
   // 짝수 홀수
   int x = 11;
   switch( x % 2 ) { // 가능한 표현식 타입 : byte, short, int, char, String (불가능: long, float, double, boolean)
     case 0: System.out.println("짝수"); break;
     case 1: System.out.println("홀수"); break;
   }
   
   int y = 10;
   switch(y % 3) {
     case 0: System.out.println("3의 배수"); break;
     default:System.out.println("3의 배수 아님");
   }

   // 학점 (A, B, C, D, F)
   double score = 85.0;
   char grade;
   switch((int)(score / 10)) {
     case 10:
     case 9: grade = 'A'; break;
     case 8: grade = 'B'; break;
     case 7: grade = 'C'; break;
     case 6: grade = 'D'; break;
     default: grade = 'F';
   }
   System.out.println(score + "점은 " + grade + "학점입니다.");
   
   // level에 따른 권한 처리 (break문이 없는 switch문)
   int level = 3;
   String auth = "";
   switch(level) {
     case 3: auth += "A";
     case 2: auth += "B";
     case 1: auth += "C";
   }
   System.out.println(level + ":" + auth);
   
   
   
   
  }

}
