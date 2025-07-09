package chap01_string.a_string;

import java.util.Arrays;

public class Main {
 public static void method1() {
    
    // String 은 불변 객체(Immutable)입니다. 
    // 기존 문자열을 변경하지 않고, 계속 새로운 문자열을 생성합니다.
    
    String str = "a";  //-- "a"(신규)
    str += "b";  //-------- "a"(기존), "ab"(신규)
    str += "c";  //-------- "a",(기존) "ab"(기존), "abc"(신규)
    
    System.out.println(str);
    
  }
  
  public static void method2() {
    
    // String Literal이란 ""로 묶는 문자열 데이터를 의미합니다.
    // String Literal은 JVM이 관리하는데 동일한 String Literal은 JVM이 기존 값을 재사용합니다.
    
    /*
     *  ┌--------------┐
     *  │  0x12345678  │ str1
     *  │--------------│
     *  │  0x12345678  │ str2
     *  │--------------│
     *  │      ...     │
     *  │--------------│
     *  │     "ab"     │ 0x12345678
     *  │--------------│
     *  │      ...     │
     *  └--------------┘
     */
    
    String str1 = "ab";
    String str2 = "ab";
    
    System.out.println(str1 == str2);  // 참조비교
    
  }
  
  public static void method3() {
    
    // 문자열 객체는 new String("문자열")으로 생성한 문자열을 의미합니다.
    // 문자열 객체는 항상 새로운 객체를 생성합니다.
    
    /*
     *  ┌--------------┐
     *  │  0x10000000  │ str1
     *  │--------------│
     *  │  0x20000000  │ str2
     *  │--------------│
     *  │     ....     │
     *  │--------------│
     *  │     "ab"     │ 0x10000000
     *  │--------------│
     *  │     ....     │
     *  │--------------│
     *  │     "ab"     │ 0x20000000
     *  │--------------│
     *  │     ....     │
     *  └--------------┘
     */
    
    String str1 = new String("ab");
    String str2 = new String("ab");
    
    System.out.println(str1 == str2);  // 참조비교
    
  }
  
  public static void method4() {
    
    // equals           : 같은 문자열이면 true를 반환합니다.
    // equalsIgnoreCase : 같은 문자열이면 true를 반환합니다. (대소문자를 무시하고 비교합니다. 즉 "A" == "a"입니다.)
    
    String str1 = "a";
    String str2 = "A";
    
    System.out.println(str1.equals(str2));
    System.out.println(str1.equalsIgnoreCase(str2));
    
  }

  public static void method5() {
    
    // length : 문자 개수를 반환합니다.
    
    String str = "hello\n";
    System.out.println(str.length());
    
  }

  public static void method6() {
    
    // charAt : 지정한 인덱스(index)의 문자(char)를 반환합니다.
    
    String str = "hello";
    
    System.out.println(str.charAt(0));
    System.out.println(str.charAt(1));
    System.out.println(str.charAt(2));
    System.out.println(str.charAt(3));
    System.out.println(str.charAt(4));

    for (int i = 0, length = str.length(); i < length; i++) {
      System.out.println(str.charAt(i));
    }
    
  }
  
  public static void method7() {
    
    // indexOf     : 전달한 문자열이 발견된 첫번째 인덱스를 반환, 없으면 -1을 반환합니다.
    // lastIndexOf : 전달한 문자열이 발견된 마지막 인덱스를 반환, 없으면 -1을 반환합니다.
    
    String str = "Hello World Apple";
    
    System.out.println(str.indexOf(" "));  //------ 첫번째 공백의 인덱스
    System.out.println(str.lastIndexOf(" "));  //-- 마지막 공백의 인덱스
    System.out.println(str.lastIndexOf("Z"));  //-- 찾는 문자열이 없는 경우

  }
  
  public static void method8() {
    
    // substring : 인덱스 정보를 이용하여 문자열의 일부를 반환합니다. 

    // 1. substring(int beginIndex)               : beginIndex 부터 끝까지 반환
    // 2. substring(int beginIndex, int endIndex) : beginIndex 부터 endIndex 이전까지 반환
    
    String str = "Hello World";
    
    int spaceIndex = str.indexOf(" ");
    
    System.out.println(str.substring(0, spaceIndex));
    System.out.println(str.substring(spaceIndex + 1));
    
  }
  
  public static void method9() {
    
    // startsWith : 전달한 문자열로 시작하면 true를 반환합니다.
    // endsWith   : 전달한 문자열로 끝나면   true를 반환합니다.
    // contains   : 전달한 문자열을 포함하면 true를 반환합니다.
    
    String str = "admin@example.com";
    
    System.out.println(str.startsWith("."));
    System.out.println(str.endsWith(".com"));
    System.out.println(str.contains("@"));
    
  }
  
  public static void method10() {
    
    // isEmpty : 글자수가 0이면 true를 반환합니다.
    // isBlank : 공백 문자이면  true를 반환합니다. (JDK 11 이상)
    
    String str = "   ";  // 공백 문자 3개
    
    System.out.println(str.isEmpty());  // false (공백 문자가 있으므로)
    System.out.println(str.isBlank());  // true (공백 문자는 blank 문자이므로)
    
  }
  
  public static void method11() {
    
    // trim : 문자열의 앞뒤에 포함된 공백 문자(공백/탭/줄바꿈)를 제거한 새로운 문자열을 반환합니다.
    
    String word = "\n\t HELLO \t\n";  // \n (줄바꿈), \t (탭)
    
    word.trim();  //--------------- trim() 메소드를 호출했다고 해서
    System.out.println(word);  //-- word의 공백이 없어지는 건 아닙니다. (새로운 문자열을 반환한다는 것은 이런 의미입니다.)
    
    System.out.println(word.trim().length());  // 앞뒤 모든 공백 문자를 제거한 뒤 글자 수를 보면 5입니다.
    
  }
  
  public static void method12() {
    
    // replace    : 어떤 문자열을 다른 문자열로 변환한 새로운 문자열을 반환합니다.
    // replaceAll : 어떤 정규식 패턴을 일치하는 문자열을 다른 문자열로 변환한 새로운 문자열을 반환합니다.
    
    String str = "192.168.0.214";
    
    System.out.println(str.replace(".", "_"));
    System.out.println(str.replaceAll(".", "_"));  //----- 정규식 패턴에서 "."는 모든 문자를 의미합니다.
    System.out.println(str.replaceAll("\\.", "_"));

  }
  
  public static void method13() {
    
    // split : 지정한 정규식 패턴으로 문자열을 분리한 문자열 배열(String[])을 반환합니다.
    // join  : 문자열 배열(String[])의 모든 요소를 연결한 새로운 문자열을 반환합니다. 각 요소 사이에 연결할 문자열을 전달할 수 있습니다.
    
    String str = "aaa.bbb.ccc.ddd.txt";
    
    String[] words = str.split("\\.");

    System.out.println(Arrays.toString(words));
    System.out.println(words[words.length - 1]); // 마지막 요소 출력
    System.out.println(String.join(".", words));  // 문자열 배열 words 사이 모든 요소 사이에 "."를 추가하여 연결합니다.
    
  }
  
  public static void method14() {
    
    // toUpperCase : 대문자로 변환한 새로운 문자열을 반환합니다.
    // toLowerCase : 소문자로 변환한 새로운 문자열을 반환합니다.
    
    String str = "I am a Student";
    
    System.out.println(str.toUpperCase());
    System.out.println(str.toLowerCase());
    
  }
  
  public static void method15() {
    
    // format : 형식이 적용된 새로운 문자열을 반환합니다.
    
    // 실수 형식
    double number1 = 100.5;
    System.out.println(String.format("%f", number1));  //------- 실수 그대로
    System.out.println(String.format("%.2f", number1));  //----- 소수 이하 자릿수를 2자리로
    System.out.println(String.format("%10.2f", number1));  //--- 전체 자릿수(정수+실수)를 10자리, 소수 이하 자릿수를 2자리로
    System.out.println(String.format("%010.2f", number1));  //-- 전체 자릿수(정수+실수)를 10자리, 소수 이하 자릿수를 2자리로, 부족한 값은 0을 채워서
    
    // 정수 형식
    int number2 = 123;
    System.out.println(String.format("%o", number2));    // 8진수
    System.out.println(String.format("%x", number2));    // 16진수(0~f)
    System.out.println(String.format("%X", number2));    // 16진수(0~F)
    System.out.println(String.format("%d", number2));    // 10진수
    System.out.println(String.format("%5d", number2));   // 10진수
    System.out.println(String.format("%05d", number2));  // 10진수 : "00123"
    
    // 문자열 형식
    String str = "hello";
    System.out.println(String.format("%s", str));
    System.out.println(String.format("%10s", str));   // 오른쪽 정렬 (공백문자를 문자열의 왼쪽에 배치)
    System.out.println(String.format("%-10s", str));  // 왼쪽 정렬 (공백문자를 문자열의 오른쪽에 배치)
    
  }
  
  public static void main(String[] args) {
    method15();
  }

}
