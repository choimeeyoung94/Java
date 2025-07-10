package chap01_File;

import java.io.File;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/*
 * java.io.File
 * 
 * 1. 파일과 디렉터리(폴더)에 대한 정보를 관리하고, 생성/삭제 등 작업을 지원하는 클래스이다
 * 2. 파일 시스템의 파일이나 디렉터리에 대한 추상화로 인해 쉽게 작업을 처리할 수 있다
 * 3. 파일과 디렉터리의 실제 입출력(읽기/쓰기)을 담당하는 클래스는 아니다.
 * 4. 주요 기능
 *    1) 파일/디렉터리 조작
 *      생성, 삭제, 이름 변경 등
 *    2) 파일/디렉터리 정보 확인
 *      존재 여부, 경로, 이름, 크기 등
 * */

/*
 * 파일/디렉터리 경로
 * 
 * 1. 경로 구분자 (Separator)
 *    1) Windows      : 역슬래시 (자바에서는 역슬래시를 이스케이프 처리 : \\)
 *    2) MacOS/Linux  : 슬래시 (/)
 *    3) Windows를 이용한 개발과 Linux를 이용한 배포가 서로 다른 경로 구분자를 필요로 하므로 다음과 같이 해결한다
 *      (1) File.separator 필드를 활용한다 (운영체제에 따라서 자동으로 경로 구분자가 선택된다)
 *      (2) Windows에서 개발할때도 슬래시(/)를 사용한다 (대부분 슬래시, 역슬래시 모두 경로 구분자로 인식하도록 호환성을 제공한다)
 *      
 * 2. 예약된 디렉터리
 *    1) 현재 디렉터리  : .
 *    2) 상위 디렉터리  : ..
 *    3) 루트 디렉터리  : /
 *    4)   홈 디렉터리  : ~
 * */





public class Main {
  
  public static void handling() {
    
    // 디렉터리 만들기
    
    
    // 1. 생성할 디렉터리를 File 객체로 생성 (디렉터리를 여기서 만드는 건 아니다)
    File dir = new File("D:/dev/Java/storage");
    
    // 2. 디렉터리 생성 (없으면 만드는 방식으로 진행)
    if (dir.exists() == false) { // !dir.exists()
      dir.mkdir();
      System.out.println("디렉터리가 생성되었습니다.");
    } else {
      System.out.println("이미 존재하는 디렉터리");
    }
    
    // 디렉터리 삭제
    if (dir.exists()) {
      dir.delete();
      System.out.println("디렉터리가 삭제되었습니다.");
    } else {
      System.out.println("존재하지 않는 디렉터리");
    }
    
    // 실습 현재날짜를 디렉터리 이름으로 사용해서 생성하시오
    
    
    LocalDateTime localDateTime = LocalDateTime.now();
    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
    
    
    File dir2 = new File("D:/" + dtf.format(localDateTime));
    
    if (dir2.exists() == false) {
      dir2.mkdirs();
      System.out.println("디렉터리 생성완료!");
    } else {
      System.out.println("이미 존재하는 디렉토리");
    }

  }
  
  public static void deleteDirectoryTree(String pathname) {
    // 파라미터로  전달된 디렉터리를 모두 삭제하세요
    // 비어있는 디렉터리만 삭제할 수 있으므로 아래 과정이 필요하다
    // D:/2025/07/10 삭제 -> D:/2025/07 삭제 -> D:/2025 삭제
    
    File dir = new File(pathname); // 최초 호출 시 "D:/2025/07/10" 경로
                                   // 다음 호출 시 "D:/2025/07" 경로
                                   // 다음 호출 시 "D:/2025" 경로
                                   // 다음 호출 시 "D:" 경로(루트 경로로 인식 : 부모 디렉터리가 없는 경우 종료)
    
    
   if (dir.getParentFile() == null) { // 부모 디렉터리가 없으면!
     return;
   }
    
    dir.delete(); //  D:/2025/07/10 삭제
                  //  다음 호출 시 "D:/2025/07" 삭제
                  //  다음 호출 시 "D:/2025" 삭제
    
    deleteDirectoryTree(dir.getParent());
  }
  
  
  
  
  public static void information() {
    
    // JAVA_HOME 디렉터리를 File 객체로 생성
    File dir = new File("C:/Program Files/Java/jdk-17");
    
    // JAVA_HOME 디렉터리에 포함된 모든 파일/디렉터리를 File[] 배열로 가져온다
    File[] files = dir.listFiles();
    
    StringBuilder sb = new StringBuilder();
    // 하나씩 정보 확인
    for (File file : files) {
      
      // 수정한 날짜
      sb.append(String.format("%-30s", new SimpleDateFormat("yyyy-MM-dd a hh:mm").format(file.lastModified())));
      
      // 유형 (파일/디렉터리)
      sb.append(String.format("%-10s", file.isDirectory() ? "<DIR>" : ""));
      
      // 크기
      sb.append(String.format("%10s", file.isFile() ? new DecimalFormat("#,##0").format(file.length()) : ""));
      
      // 이름
     sb.append(" ").append(file.getName()).append("\n");
      
    }
    
    System.out.println(sb.toString());
    
  }
  
  
  
  
  public static void main(String[] args) {
    //handling();
    deleteDirectoryTree("D:/2025/07/10"); // D:/2025/07/10 디렉터리를 모두 삭제하세요
    //information();
  }
}
