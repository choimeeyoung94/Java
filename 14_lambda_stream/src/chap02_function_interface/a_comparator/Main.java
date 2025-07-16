package chap02_function_interface.a_comparator;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Main {
  public static void main(String[] args) {
    
    // 사과 무게를 기준으로 오름차순 정렬하는 Comparator
    Comparator<Apple> byWeight = ( o1, o2) -> (int)(o2.getWeight() - o1.getWeight()); // 오름차순 정렬시: o1 - o2, 내림차순 정렬시: o2 - o1
    
    // 사과를 저장하는 List
    List<Apple> apples = new ArrayList<Apple>();
    apples.add(new Apple(100.0));
    apples.add(new Apple(250.0));
    apples.add(new Apple(500.0));
    apples.add(new Apple(400.0));
    apples.add(new Apple(200.0));
    
    // List 정렬하기
    apples.sort(byWeight);
    
    // 확인
    for (Apple apple : apples) {
      System.out.println(apple);
    }
    
    
  }
}
