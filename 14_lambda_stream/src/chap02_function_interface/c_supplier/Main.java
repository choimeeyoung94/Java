package chap02_function_interface.c_supplier;

import java.util.Optional;
import java.util.function.DoubleSupplier;
import java.util.function.IntSupplier;
import java.util.function.Supplier;

/*
 * java.util.function.Supplier<T>
 * 
 * 1. 매개변수가 없고 반환값이 존재하는 메소드 (매개변수로 화살표 함수를 필요로 한다)
 * 2. 추상 메소드
 *    T get();
 * 3. 주요 인터페이스
 *    1) Supplier<T>     T get();
 *    2) IntSupplier     int getAsInt();
 *    3) DoubleSupplier  double getAsDouble();
 * */


public class Main {
  public static void main(String[] args) {
    
    Supplier<String> s1 = () -> "Java";
    System.out.println(s1.get());
   
    IntSupplier s2 = () -> (int) (Math.random() * 10 + 1);
    System.out.println(s2.getAsInt());
    
    double[] numbers = {1.1, 2.2, 3.3, 4.4, 5.5};
    
    DoubleSupplier s3 = () -> {
      double sum = 0;
      for (double number: numbers) {
        sum += number;
      }
      return sum;
    };
    
    System.out.println(s3.getAsDouble()); // numbers 배열 요소의 합 구해보세요;
    
    Optional<String> opt = Optional.empty();
    System.out.println(opt.orElseGet(() -> "Java")); // Optional 객체에 값이 없으면 Supplier가 제공한 값을 반환
    System.out.println(opt.orElse("Java")); // Optional 객체에 값이 없으면 "Java"를 반환
  }
}
