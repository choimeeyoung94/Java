package chap02_date_time;

import java.text.SimpleDateFormat;
import java.util.Map;

/*
 * System.currentTimeMillis()
 * 
 * 1. 1970년 1월 1일 00:00:00 UTC (Epoch Time) 기준으로 현재 시각을 밀리초 단위로 반환한다 (long 타입)
 * 2. 로그, 만료 시간 계산 등의 작업을 수행할 수 있다
 * 3. 시스템과 OS의 영향을 받는다
 * 
 * */

// second > ms(밀리, 1/1000) > ㎲(마이크로, 1/1000000) > ns(나노, 1/1000000000) > ps (피코, 1000000000000)

/*
 * System.nanoTime()
 * 
 * 1. 임의의 기준 시점으로부터 경과한 나노초 단위 값을 반환 (long 타입)
 * 2. 두 시점의 나노초 값을 빼서 코드 실행 시간, 함수 호출 시간 등 특정 경과 시간을 정확하게 측정하기 위해 사용한다
 *    (성능 테스트용)
 * 3. 실제 정밀도는 하드웨어나 OS에 의해서 달라질 수 있다
 * */





public class class02_System {

  public static void main(String[] args) {
    // System.currentTimeMillis()
    long timestamp = System.currentTimeMillis();
    System.out.println(timestamp);
    
    // with SimpleDateFormat
    SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss.SSS");
    System.out.println(sdf.format(timestamp));
    
    // System.nanoTime()
    long start = System.nanoTime();
    System.out.println("Hello");
    System.out.println("Hello");
    System.out.println("Hello");
    long end = System.nanoTime();
    long elapsed = end - start; // 나노초 단위의 경과시간
    System.out.println("총 걸린시간: " + elapsed / 1000000.0); // 밀리초
   
    
    Map<String, Object> map1 = concatWithString();
    Map<String, Object> map2 =concatWithStringBuilder();
    System.out.println("String 기반" + map1);
    System.out.println("StringBuilder 기반" + map2);
  }
  
  
  // String 클래스로 문자열 연결하기
  public static Map<String, Object> concatWithString() {
    
    long start = System.nanoTime();
    
    String str = "";
    
    for (char ch = 'A'; ch <='z'; ch++) {
      str += ch;
    }
    
    long stop = System.nanoTime();
    
  
    return Map.of("str", str , "elapsed",((stop - start) / 100_0000.0));
  }
  
  // StringBuilder 클래스로 문자열 연결하기
  public static Map<String, Object> concatWithStringBuilder() {
    
    
    long start = System.nanoTime();
    
    StringBuilder sb  = new StringBuilder();
    for (char ch = 'A'; ch <='z'; ch++) {
      sb.append(ch);
    }
    
    long stop = System.nanoTime();
    
    
    
    return Map.of("str", sb.toString() , "elapsed",(stop - start) / 100_0000.0);
  }
  
  
  
  
  

}
