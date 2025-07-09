package chap02_date_time;

import java.text.SimpleDateFormat;
import java.util.Date;

/*
 * java.util.Date
 * 
 * 1. 자바에서 날짜와 시간을 표현하기 위해 사용하는 가장 오래된 클래스 중 하나
 * 2. 1970년 1월 1일 00:00:00 UTC (Epoch Time) 기준으로 밀리초 단위의 특정 시점을 나타낸다
 * 3. 현대 자바(JDK 1.8 이상)에서는 java.time 패키지의 클래스들로 대체되었다
 * */


/*
 * java.text.SimpleDateFormat
 * 
 * 1. 날짜와 시간을 특정 형식의 문자열로 변환하거나, 그 반대 작업을 수행하는 클래스이다
 * 2. java.time 패키지를 이용하는 경우 DateTimeFormatter 클래스를 대신 사용한다.
 * 3. 주요 패턴
 *    yyyy 4자리 년도
 *    MM   2자리 월
 *    dd   2자리 일
 *    E    요일
 *    a    오전/오후
 *    HH   2자리 시 (0~23)
 *    hh   2자리 시 (1~12)
 *    mm   2자리 분
 *    ss   2자리 초
 *    SSS  3자리 밀리초
 * */

public class Class01_Date_SimpleDateFormat {
    
  public static void main(String[] args) {
      
    // Date 객체 (디폴트 생성 시 현재 날짜와 시간을 가진 객체가 생성)
    Date date = new Date();
    System.out.println("형식없는날짜시간: " + date);
    
    // SimpleDateFormat 객체 (팬턴을 문자열로 전달해서 생성)
    SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
    SimpleDateFormat sdf2 = new SimpleDateFormat("yy년 MM월 dd일 E a HH:mm");
    
    // Date에 패턴 적용
    String date1 = sdf1.format(date);
    String date2 = sdf2.format(date);
    System.out.println("date1: " + date1);
    System.out.println("date2: " + date2);
    
  }
}
