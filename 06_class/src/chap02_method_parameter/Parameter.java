package chap02_method_parameter;

import java.util.Arrays;

/*
 * 
 * 메소드 형식
 * 
 * 반환타입 메소드명(매개변수1, 매개변수2, ...) {
 *  메소드 본문 코드
 *  return 반환값
 * }
 * 
 * 1. 반환타입과 반환값이 명시 된다
 * 2. 메소드이름만 작성해서 사용한다
 * 3. void 반환이 없다
 * 4. 메소드명 camelcase
 * */
public class Parameter {
 
  /**
   * 
   * @param msg
   */
  void methodA() {
    System.out.println("methodA");
  }
  
  /**
   * 
   * @param x 정수를 전달 받음
   */
  void methodB(int x) {
    System.out.println("methodB: " + x);
  }
  
  void methodC(int[] items) {
    System.out.println("methodC: " + Arrays.toString(items));
  }
  
  /**
   * 
   * @param items 가변 인자이므로 0개 이상의 정수 값을 전달 받음 (int[]과 동일하게 동작)
   * */
  void methodD(int... items) {
    System.out.println("methodD: " + Arrays.toString(items));
  }
  
  
  /**
   * 1개 이상의 정수 값을 전달 받는 메소드
   * @param first 반드시 전달 받는 정수 값
   * @param arrays 0개 이상의 정수 값
   */
  // 1개 이상의 정수 값을 전달 받는 메소드E 만들어보기
  void methodE(int first, int...arrays) {   
    System.out.println("methodE: " +first + ","
        + " " +  Arrays.toString(arrays));
  }
 
  /***
   * 기본 타입과 참조 타입의 동작을 비교하기 위한 메소드
   * @param number 기본 타입 매개변수
   * @param numbers 참조타입
   */
  void methodF(int number, int[] numbers) {
    number = 10;
    numbers[0] = 10;
    numbers[1] = 20;
    numbers[2] = 30;
    
  }
  
  /**
   * 클래스 타입의 매개변수 활용하기
   * @param car 클래스 Car 타입의 객체가 전달되는 매개변수
   * @param region String 문자열이 전달되는 매개변수
   */
  void methodG(Car car, String region) {
    car.drive(region);
  }
  
  
  
}
