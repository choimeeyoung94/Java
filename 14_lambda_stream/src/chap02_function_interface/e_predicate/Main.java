package chap02_function_interface.e_predicate;

import java.util.function.IntPredicate;
import java.util.function.Predicate;

/*
 * java.util.function.Predicate<T>
 * 
 * 1. 매개변수가 있고 boolean 타입의 값을 반환하는 메소드를 가진 인터페이스
 * 2. 추상 메소드
 *    boolean test(T t);
 * 3. 주요 인터페이스
 *    1) Predicate<T>          boolean test(T);
 *    2) IntPredicate          boolean test(int);
 *    3) DoublePredicate       boolean test(double);
 * */

public class Main {
  public static void main(String[] args) {
    
    Predicate<Integer> p1 = t -> t > 0;
    System.out.println(p1.test(10) ? "양수" : "음수");
    System.out.println(p1.test(-10) ? "양수" : "음수");
    
    IntPredicate p2 = t -> t % 2 == 1;
    System.out.println(p2.test(3) ? "홀수" : "짝수");
    System.out.println(p2.test(4) ? "홀수" : "짝수");
    
    Predicate<String> over4 = s -> s.length() >= 4;// 문자열이 4글자 이상인지 검증
    applyPredicate("Java", over4); 
    applyPredicate("Jsp", over4); 
    
    Predicate<Integer> pass = n -> n >= 60;// 정수값이 60 이상인지 검증
    applyPredicate(60, pass);
    applyPredicate(50, pass);
    
    
  }
  
  public static <T> void applyPredicate(T t, Predicate<T> p) {// Predicate에는 체크해야 될 조건을 전달
    if (p.test(t)) {
      System.out.println(t + "은(는) 조건에 부합합니다.");
    } else {
      System.out.println(t + "은(는) 조건에 부합하지 않습니다.");
    }
  }
  
  
}
