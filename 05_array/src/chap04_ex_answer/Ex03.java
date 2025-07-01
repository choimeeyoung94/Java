package chap04_ex_answer;

import java.util.Arrays;

public class Ex03 {

  public static void main(String[] args) {
    
    // 다음 배열의 길이를 4로 늘려서 "autumn", "winter"를 저장하세요.
    // Tip. 배열의 길이를 늘일 수는 없으니, 길이가 4인 새로운 배열을 만들고,
    //      기존 배열의 요소를 새로운 배열로 모두 복사한 뒤, 
    //      기존 배열의 참조를 새로운 배열의 참조로 바꿉니다.
    
    String[] seasons = {"spring", "summer"};
    
    // 새로운 임시 배열 생성
    String[] temporary = new String[4];
    
    // 배열을 복사하는 방법 (for 문 없이 가능)
    // COPY seasons.length FROM seasons[0] TO temporary[0]
    System.arraycopy(seasons, 0, temporary, 0, seasons.length);
    
    // 기존 배열의 참조를 새로운 배열의 참조로 바꾸기
    seasons = temporary;
    
    // "autumn", "winter" 추가
    seasons[2] = "autumn";
    seasons[3] = "winter";
    
    System.out.println(Arrays.toString(seasons));
    
  }
  
}
