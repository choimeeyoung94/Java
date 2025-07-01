package chap04_ex_answer;

public class Ex05 {

  public static void main(String[] args) {
    
    // 다음 정수형 배열이 오름차순으로 정렬되어 있으면 
    // boolean result 변수에 true, 아니면 false를 저장하세요.
    
    int[] numbers = {1, 2, 3, 4, 5, 0};
    
    // 오름차순 정렬이 맞다고 가정하면서 시작
    boolean result = true;
    
    for (int i = 0; i < numbers.length - 1; i++ ) {
      if (numbers[i] > numbers[i + 1]) {  // 오름차순 정렬 조건을 만족하지 않는 경우가 발생하면,
        result = false;                   // result에 false 저장 후 반복문 종료
        break;
      }
    }
    
    System.out.println("오름차순 정렬? " + result);
    
  }
  
}
