package chap04_random;

import java.security.SecureRandom;
import java.util.UUID;

public class Main {
  
  public static void mathRandom() {
    /*
     * java.lang.Math
     * 
     * 1. 수학 관련 메소드를 가지고 있는 클래스
     * 2. 정적 메소드로 구성되어 있어서 객체를 생성할 필요가 없다
     * */
    System.out.println(Math.random());               // 0.0 <= 난수 < 1.0
    System.out.println(Math.random() * 3);           // 0.0 <= 난수 < 3.0
    System.out.println((int) (Math.random() * 3));     // 0 <= 난수 < 3
    System.out.println((int) (Math.random() * 3 + 1)); // 1 <= 난수 < 4
    
    
    // 주사위 던지기
    int dice = (int) (Math.random() * 6 + 1);
    System.out.println("주사위: " + dice);
    
  }
  
  public static void secureRandom() {
    
    /*
     * java.security.SecureRandom
     * 
     * 1. 암호학적으로 강력한 난수 생성기를 제공하는 클래스
     * 2. 시드(seed) 기반 난수 생성기이지만, 동일한 시드라도 동일한 결과를 보장하지 않는다
     * 3. 암호화 키, 토큰, 세션ID 등 보안이 필요한 값에는 SecureRandom 사용이 권장된다 
     * */
    
    // 디폴트 생성자 (기본 알고리즘 사용)
    SecureRandom secureRandom = new SecureRandom();
    
    // 아래 시드 작업들은 생략 가능
       
    // 시드로 사용할 난수 바이트 배열 생성
    byte[] bytes = new byte[16];
    secureRandom.nextBytes(bytes);
    
    // 시드 적용
    secureRandom.setSeed(bytes);
    
    // 난수 만들기
    System.out.println(secureRandom.nextDouble()); // 0.0 <= 난수 < 1.0
    System.out.println(secureRandom.nextInt());    // int 범위 중 하나의 난수
    System.out.println(secureRandom.nextInt(5));   // 0 <= 난수 < 5
    System.out.println(secureRandom.nextInt(5) + 1); // 1 <= 난수 < 6
    System.out.println(secureRandom.nextInt(1,5)); // 1 <= 난수 < 5 (JDK 17 이상)
    
  }
  
  public static void uuid() {
    
    /*
     * java.util.UUID
     * 
     * 1. 범용 고유 식별자(Universal Unique Identifier)를 생성하고 다루기 위한 클래스
     * 2. 128비트(16바이트) 크기의 고유한 값을 생성한다
     * 3. 32자리 16진수와 4개의 하이픈(-)으로 구성된 문자열을 생성한다
     *    (8-4-4-4-12)
     * 4. 전세계적으로 중복 값을 생성할 확률이 극히 낮아 충돌 위험이 거의 없다
     * 5. 데이터베이스 PK값, 파일명 중복 방지 등의 용도로 사용할 수 있다
     * */
    
    // 랜덤 UUID 생성 방식(버전 4) - 난수 기반의 가장 일반적인 방법
    UUID uuid = UUID.randomUUID();
    String randomText = uuid.toString();
    System.out.println(randomText);
    System.out.println(randomText.replace("-", "")); // 4개의 하이픈(-) 제거
    System.out.println(randomText.replace("-", "").substring(0, 16));
    
    
  }
  
  
  
  
  
  public static void main(String[] args) {
    mathRandom();
    secureRandom();
    uuid();
    
    
    
  }
}
