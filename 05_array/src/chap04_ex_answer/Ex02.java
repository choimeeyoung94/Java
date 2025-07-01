package chap04_ex_answer;

public class Ex02 {

  public static void main(String[] args) {
    
    // 다음 정수형 배열에 저장된 모든 요소 중 최대값과 최소값을 출력하세요.
    
    int[] numbers = {42, 17, 93, 120, 117, 59, 24, 28, 39};
    
    // 첫 번째 요소를 초기값으로 설정합니다.
    int max = numbers[0];
    int min = numbers[0];
    
    // 두 번째 요소부터 비교합니다.
    for (int i = 1; i < numbers.length; i++) {
      if (max < numbers[i]) max = numbers[i];  // 최대값(max)보다 큰 요소가 발견되면 해당 요소를 최대값으로 사용합니다.
      if (min > numbers[i]) min = numbers[i];  // 최소값(min)보다 작은 요소가 발견되면 해당 요소를 최소값으로 사용합니다.
    }
    
    System.out.println("최대값: " + max);
    System.out.println("최소값: " + min);
    
  }
  
}
