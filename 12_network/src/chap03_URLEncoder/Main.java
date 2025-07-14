package chap03_URLEncoder;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

/*
 * java.net.URLEncoder
 * 
 * 1. 문자열을 URL 인코딩 형식(application/x-www-form-urlencoded)으로 변환해주는 클래스이다
 * 2. 특수 문자나 한글 같은 비ASCII 문자가 포함될 때 사용한다
 * 3. 인코딩 규칙
 *    1) 알파벳(A-Z, a-z),숫자(0-9), 일부 특수 문자(. - _ *)는 그대로 유지한다
 *    2) 공백 문자는 +로 변환한다
 *    3) 나머지 문자들은 인코딩 된 바이트 값을  %xx(16진수) 형식으로 변환한다
 * 4. 잘못된 인코딩 규칙을 사용하면 java.net.UnsupportedEncodingException 예외가 발생한다 (Checked) 
 * */


public class Main {
  
  /**
   * 전달된 문자열을 UTF-8 인코딩 처리한 결과를 반환하는 메소드
   * @param str
   * @return
   * */
  public static String encodeUTF8(String str) throws UnsupportedEncodingException {
    
    return URLEncoder.encode(str, "UTF-8");
  }
  
  /**
   * UTF-8로 인코딩 된 문자열을 전달 받아서 디코딩 한 결과를 반환하는 메소드
   * @param str
   * @return
   * @throws UnsupportedEncodingException
   * 
   * 
   * */
  public static String decodeUTF8(String str) throws UnsupportedEncodingException {
    return URLDecoder.decode(str, "UTF-8");
  }
  
  public static void main(String[] args) {
    
    // 일반 문자열
    String str = "Hello 반갑습니다.";
    try {
     String encoded = encodeUTF8(str);
     System.out.println(encoded);
     
     // 디코딩 문자열
     String decoded = decodeUTF8(encoded);
     System.out.println(decoded);
     
     
    } catch (UnsupportedEncodingException e) {
      System.out.println("지원되지 안히는 인코딩입니다.");
    }
    
    
  }
}
