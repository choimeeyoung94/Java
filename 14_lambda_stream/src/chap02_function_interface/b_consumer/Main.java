package chap02_function_interface.b_consumer;

import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.IntConsumer;

/*
 * java.util.function.Consumer<T>
 *
 * 1. 매개변수가 있고 반환값은 없는 메소드를 가진 인터페이스이다 (매개변수로 화살표 함수를 필요로 한다)
 * 2. 추상 메소드
 *    void accept(T t);
 * 3. 주요 종류
 *    1) Consumer<T>                 void accept(T t)
 *    2) BiConsumer<T, U>            void accept(T, U);
 *    3) IntConsumer                 void accept(int);
 *    4) DoubleConsumer              void accept(double);
 *    5) ObjectIntConsumer<T>        void accept(T double); 
 * */



public class Main {
  public static void main(String[] args) {
    
    Consumer<String> c1 = t -> System.out.println("Java" + t);    
    c1.accept("17");
    
    
    BiConsumer<String, String> c2 = (t,u) -> System.out.println(t + u);
    c2.accept("Java", "8");
    
    IntConsumer c3 = t -> System.out.println(t * 2);
    c3.accept(100);
    
    
    
    
    
  }
}
