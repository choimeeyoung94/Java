package ex01_ten_quiz;

import java.security.SecureRandom;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.InputMismatchException;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.UUID;

public class Main {
 public static void method1() {
    
    // 문제1. 새로운 파일명 만들기
    // 기존 파일의 확장자만 그대로 사용하고 파일명은 아래 형식을 참고해서 새로 만드세요.
    // 형식 : 하이픈이 제거된 UUID + 밑줄 + 타임스탬프.확장자
    
    String fileName = "apple.jpg";
    
    int dotIndex = fileName.lastIndexOf(".");
    fileName = fileName.substring(dotIndex);
    
    UUID uuid = UUID.randomUUID();
    String randomText = uuid.toString();
    randomText = randomText.replace("-", "");
    
    LocalDateTime dateTime = LocalDateTime.now();
    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd h:mm:ss");
    String dt = dtf.format(dateTime);
    
    StringBuilder sb = new StringBuilder();
    sb.append(randomText);
    sb.append("_");
    sb.append(dt);
    sb.append(fileName);
    
    System.out.println(sb.toString());
  }
  
  public static Map<String, Object> method2(String id) {
    
    // 문제2. 주민등록번호를 이용해 나이와 성별을 구하고 이를 Map으로 반환하세요.
    // 나이 : 현재년도 - 태어난년도
    //        하이픈 뒤의 숫자가 1,2이면 1900년대생, 3,4이면 2000년대생입니다.
    // 성별 : 하이픈 뒤의 숫자가 1,3이면 "남", 2,4이면 "여"입니다.
    System.out.println(id);
    LocalDate date = LocalDate.now();
    int nowYear = date.getYear();
    System.out.println("현재년도: " + nowYear);
    String birthYear = id.substring(0, 2);
    System.out.println("태어난년도: " + birthYear);
    
    StringBuilder sb = new StringBuilder();
    if (birthYear.equals("1") || birthYear.equals("2")) {
      sb.append("19");
      sb.append(birthYear);
    } else if (birthYear.equals("3") || birthYear.equals("4")) {
      sb.append("20");
      sb.append(birthYear);
    }
    
    birthYear = sb.toString();
    System.out.println("태어난년도: " + birthYear);
    
    int age = nowYear - Integer.parseInt(birthYear);
    System.out.println("나이: " + age);
    int hypenIndex = id.lastIndexOf("-");
    
    char genderCode = id.charAt(hypenIndex + 1);
    
    String gender = "";
    if (genderCode == '1' || genderCode == '3') {
      gender = "남";
    } else if (genderCode == '2' || genderCode == '4') {
      gender = "여";
    }
    System.out.println("성별: " + gender);
    
    
    return null;
  }

  public static void method3() {
    
    // 문제3. 각 나라별 수도를 Map으로 저장해 두고, 아래와 같이 동작하도록 구현하세요.
    // 실행 예시)
    // 프랑스 수도는? >>> 
    // 파리
    // 스위스 수도는? >>> 
    // 베른
    // 영국 수도는? >>> 
    // 런던
    // 독일 수도는? >>> 
    // 베를린
    // 이탈리아 수도는? >>> 
    // 로마
    // 5개 정답 성공
    String inputAnswer = "";
    int count = 0;
    Scanner scanner = new Scanner(System.in);
    Map<String, String> map = Map.of("프랑스", "파리"
                                 , "독일", "베를린"
                                 , "이탈리아", "로마"
                                 , "스위스", "베른"
                                 , "영국", "런던");
   
    for (Map.Entry<String, String> entry : map.entrySet()) {
     System.out.println(entry.getKey() + "수도는? >>> ");
     inputAnswer = scanner.next();
     if (inputAnswer.equals(entry.getValue())) {
       count += 1;
     }
    }
    
    System.out.println(count + "개 정답 성공");
     
     
     
  }
  
  public static void method4() {

    // 문제4. 현재 통장 잔고(balance)가 5000원입니다. 랜덤하게 출금하여 잔고를 0으로 만들고 그 과정을 출력하세요.
    // 실행예시)
    // 출금 전 5000원, 1회 출금액 2917원, 출금 후 2083원
    // 출금 전 2083원, 2회 출금액 1961원, 출금 후 122원
    // 출금 전 122원, 3회 출금액 102원, 출금 후 20원
    // 출금 전 20원, 4회 출금액 2원, 출금 후 18원
    // 출금 전 18원, 5회 출금액 17원, 출금 후 1원
    // 출금 전 1원, 6회 출금액 1원, 출금 후 0원
  
    int balance = 5000;
    int count = 1;
   
    
    while (true) {
      int rest = balance;
      int randomMoney = (int)(Math.random() * balance + 1); 
      balance -= randomMoney;

      if (balance <= 0) {
          balance = 0;
          System.out.println("출금 전 " + rest + "원, " + count + "회 출금액 " + randomMoney + "원, 출금 후 " + balance + "원");
          break;
      }

      System.out.println("출금 전 " + rest + "원, " + count + "회 출금액 " + randomMoney + "원, 출금 후 " + balance + "원");
      count += 1;
  }
    
    
    
    
    
  }
  
  public static void method5() {

    // 문제5. 윷놀이를 진행하세요. "윷"이나 "모"가 나오면 계속 던져야 합니다.
    // 실행예시1) "도", 1칸 이동한다.
    // 실행예시2) "개", 2칸 이동한다.
    // 실행예시3) "걸", 3칸 이동한다.
    // 실행예시4) "윷", "도", 5칸 이동한다.
    // 실행예시5) "모", "윷", "도", 10칸 이동한다.
    
    String[] yuts = {"", "도", "개", "걸", "윷", "모"};
   
    while (true) {
     int randomIndex = (int) (Math.random() * yuts.length);
      
      if (randomIndex == 4 || randomIndex == 5) {
        System.out.println( yuts[randomIndex]  + ", " + randomIndex + "칸 이동한다");
        continue;
      } else if (randomIndex == 1) {
        System.out.println( yuts[randomIndex]  + ", " + randomIndex + "칸 이동한다" );
        break;
      } else if (randomIndex == 2) {
        System.out.println(yuts[randomIndex]  + ", " + randomIndex + "칸 이동한다" );
        break;
      } else if (randomIndex == 3) {
        System.out.println(yuts[randomIndex]  + ", " + randomIndex + "칸 이동한다" );
        break;
      }
    }
    
    
  }

  public static void method6() {
    
    // 문제6. SecureRandom을 이용해 "대문자+소문자+숫자"로 구성된 임의의 인증번호를 만드세요.
    // 실행예시1)
    //   몇 자리의 인증번호를 생성할까요? >>> 4
    //   생성된 4자리 인증번호는 7W5e입니다.
    // 실행예시2)
    //   몇 자리의 인증번호를 생성할까요? >>> 6
    //   생성된 6자리 인증번호는 FB0e3a입니다.
    SecureRandom secureRandom = new SecureRandom();
    Scanner scanner = new Scanner(System.in);

    System.out.print("몇 자리의 인증번호를 생성할까요? >>> ");
    int num = scanner.nextInt();
    String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";

    StringBuilder authCode = new StringBuilder();

    for (int i = 0; i < num; i++) {
        int index = secureRandom.nextInt(chars.length());
        authCode.append(chars.charAt(index));
    }

    System.out.println("생성된 " + num + "자리 인증번호는 " + authCode.toString() + "입니다.");

    scanner.close();
    
  }

  public static void method7() {

    // 문제7. UpDown 게임을 만드세요.
    // 컴퓨터가 1 ~ 10000 사이의 난수를 발생시키면 사용자가 해당 값을 맞추는 게임입니다.
    // 몇 번의 시도만에 성공하는지 결과를 출력하세요.
    // 실행예시)
    // 입력 >>> 5000
    // Down!
    // 입력 >>> 2500
    // Up!
    // ...
    // 입력 >>> 4500
    // 정답입니다. 총 5번만에 성공했습니다.
    
    int answer = (int) (Math.random() * 10000 + 1);
    System.out.println("answer: " + answer);
    int count = 0;
    Scanner scanner = new Scanner(System.in);
    while (true) {
      System.out.println("입력 >>> ");
      int inputNum = scanner.nextInt();
      count += 1;
      if (answer == inputNum) {
        
        System.out.println("정답입니다. 총 " + count + "번만에 성공했습니다.");
        break;
      }
      
      if (answer < inputNum) {
        System.out.println("Down!");
        
      } else if (answer > inputNum) {
        System.out.println("Up!");
      }
    }
  }

  public static void method8() {

    // 문제8. 0~9 사이 난수를 100개 발생시키고 발생한 난수들이 생성된 횟수(빈도수)를 그래프화 하여 출력하세요.
    // 실행예시)
    // 0 : #### 4
    // 1 : ############ 12
    // 2 : ############ 12
    // 3 : ##### 5
    // 4 : ######## 8
    // 5 : ########### 11
    // 6 : ############ 12
    // 7 : ################## 18
    // 8 : ####### 7
    // 9 : ########### 11
    
    int[] array = new int[10];
    
    for (int i = 1; i <= 100; i++) {
      int randomNum = (int) (Math.random() * 9);
      array[randomNum] += 1;
    }  
    
    String sharp = "#";
    for (int i = 0; i < array.length; i++) {
      System.out.print(i + " : " );
      for (int j = 0; j < array[i]; j++) {
        System.out.print(sharp);
      }
      System.out.print(array[i]);
      System.out.println();
    }
  }
  
  public static void method9() {
    
    // 문제9. 5 x 5 숫자 빙고판을 만드세요. 아래 과정을 순차적으로 진행하면 됩니다.
    //
    // 지시사항)
    //   1. 가장 먼저 1 ~ 25 사이 정수를 2차원 배열 bingo에 아래와 같이 순서대로 넣습니다.
    //      1  2  3  4  5
    //      6  7  8  9 10
    //     11 12 13 14 15
    //     16 17 18 19 20
    //     21 22 23 24 25
    //   2. 첫 번째 요소([0][0])부터 마지막 요소([4][4])까지 순회하면서 임의의 요소와 값을 교환합니다.
    //      -----------------------------
    //      순차적으로        랜덤하게
    //      모든요소접근      접근
    //      -----------------------------
    //      bingo[0][0]  <->  bingo[1][4]
    //      bingo[0][1]  <->  bingo[0][2]
    //      bingo[0][2]  <->  bingo[2][1]
    //      ...
    //      bingo[4][4]  <->  bingo[3][1]
    //      -----------------------------
    //
    // 실행예시)
    //  10  9  4 25  2
    //  15  3 13 21  1
    //  14 20 11 19  6
    //   8 17  5 12  7
    //  16 22 18 24 23
    int[][] bingo = new int[5][5];
    int num = 1;
    for (int i = 0; i < 5; i++) {
      for (int j = 0; j < 5; j++) {
        bingo[i][j] = num;
        num+=1;
      }
    }
    
    for (int i = 0; i < 5; i++) {
     for (int j = 0; j < 5; j++) {

       int randomI = (int) (Math.random() * 5);
       int randomJ = (int) (Math.random() * 5);
       int bingoNumber = bingo[randomI][randomJ];
       int temp = bingo[i][j];
       bingo[i][j] = bingoNumber;
     }
      
    }
 
    for (int i = 0; i < 5; i++) {
      for (int j = 0; j < 5; j++) {
        System.out.print(bingo[i][j] + " ");
      }
      System.out.println();
    }
    
  }
  
  public static void method10() {
    
    // 문제10. 야구 게임(숫자 맞추기 게임)
    // 시스템이 4자리의 서로 다른 수를 저장하면 사용자가 저장된 수를 모두 맞추는 게임입니다.
    // 자리수가 맞으면 "스트라이크"
    // 자리수는 틀리지만 존재하는 수이면 "볼"
    // "4 스트라이크"가 게임 종료

    // NumberInputException을 이용하여 다음의 예외 처리를 하세요.
    // NumberInputException 클래스는 직접 만들어야 합니다.
    //  - 입력이 4자리 수가 아닌 경우는 "4자리 숫자를 입력하세요."를 출력하고 다시 입력받으세요.
    //  - 중복된 숫자가 입력된 경우 "중복된 숫자가 입력되었습니다."를 출력하고 다시 입력받으세요.
    //  - InputMismetchException을 이용해 숫자 아닌 값이 입력되면 "숫자만 가능합니다."를 출력하고 다시 입력받으세요.
    //  - 숫자 체크를 위한 numberCheck() 메소드를 제공합니다. 이를 사용해서 처리하세요.
    
    // 실행 예시)
    // 서로 다른 4자리 정수를 입력하세요 >>> 1234
    // 1234 : 0스트라이크, 1볼
    // 서로 다른 4자리 정수를 입력하세요 >>> 5678
    // 5678 : 2스트라이크, 0볼
    // 서로 다른 4자리 정수를 입력하세요 >>> 2679
    // 2679 정답입니다.
    // 3번 만에 맞추셨습니다. 게임을 종료합니다.
    Scanner scanner = new Scanner(System.in);
    while (true) {
      System.out.print("서로 다른 4자리 정수를 입력하세요 >>> ");
      String inputNum = scanner.next();
      
      int copyInputNum = Integer.parseInt(inputNum);
      
      
      String chars = "0123456789";

      SecureRandom secureRandom = new SecureRandom();
      StringBuilder authCode = new StringBuilder();

      for (int i = 0; i < 4; i++) {
          int index = secureRandom.nextInt(chars.length());
          authCode.append(chars.charAt(index));
      }
      
      System.out.println(authCode);
    }
    
    
  }
  
  private static void numberCheck(String str) throws NumberInputException {
    if (str.length() != 4) {
      throw new NumberInputException("4자리 숫자를 입력하세요");
    }
    try {
      Integer.parseInt(str);
    } catch (NumberFormatException e) {
      throw new InputMismatchException("숫자만 가능합니다");
    }   
    int[] cnt = new int[10];
    for (char c : str.toCharArray()) {
      cnt[c-'0']++;  // char c에 저장된 문자 형식의 아라비아 숫자(예: '0')를 숫자 형식(예: 0)으로 변경하기 위해서 '0'을 뺍니다.
      if (cnt[c-'0'] > 1)
        throw new NumberInputException("중복된 숫자가 입력되었습니다.");
    }
  }
  
  public static void main(String[] args) {
    
    // method1(); ~ method10(); 그냥 호출하면 됩니다.
    method10();
    //method2("940713-2063211");
    
    
    
    // method2(); 주민등록번호를 전달해서 실행합니다.
//    Map<String, Object> map = method2("140101-4123456");
//    for(Entry<String, Object> entry : map.entrySet()) {
//      System.out.println(entry.getKey() + ": " + entry.getValue());
//    }

  }
}
