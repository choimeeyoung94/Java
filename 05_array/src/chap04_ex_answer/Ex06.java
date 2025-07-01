package chap04_ex_answer;

import java.util.Arrays;

public class Ex06 {

  public static void main(String[] args) {
    
    // uppers 배열에는 대문자를 순서대로 저장하고, lowers 배열에는 소문자를 순서대로 저장하세요.

    // 아스키코드표의 알파벳은 다음과 같습니다.
    // 'A' == 65, 'a' == 97
    // 'B' == 66, 'b' == 98
    // 'C' == 67, 'c' == 99
    // ...
    // 'Z' == 90, 'z' == 122
    
    char[] uppers = new char[26];
    char[] lowers = new char[26];
    
    for(int i = 0; i < uppers.length; i++) {
      uppers[i] = (char) ('A' + i);
      lowers[i] = (char) (uppers[i] + 32);
    }
    
    System.out.println(Arrays.toString(uppers));
    System.out.println(Arrays.toString(lowers));
    
  }
  
}
