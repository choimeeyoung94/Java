package chap02_dml;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class Main {
  
public static void insert() throws Exception {
    
    //----- DB 접속
    Connection con = DBConnection.getConnection();
    
    //----- 쿼리문
    String sql = "INSERT INTO tbl_board(uid, title, content) VALUES(?, ?, ?)";
    
    //----- PreparedStatement 객체 생성 (쿼리문 실행 객체)
    PreparedStatement ps = con.prepareStatement(sql);
    
    //----- tbl_board 테이블에 저장할 값 입력 받기
    Scanner sc = new Scanner(System.in);
    System.out.print("사용자 아이디(1,2,3) 입력 >>> "); int uid = sc.nextInt(); sc.nextLine();
    System.out.print("게시글 제목 입력 >>> "); String title = sc.nextLine();
    System.out.print("게시글 내용 입력 >>> "); String content = sc.nextLine();
    sc.close();
    
    //----- 입력 받는 값으로 파라미터 바인딩
    ps.setInt(1, uid);  //--------- 1번째 ?에 uid 바인딩
    ps.setString(2, title);  //---- 2번째 ?에 title 바인딩
    ps.setString(3, content);  //-- 3번째 ?에 content 바인딩
    
    //----- 쿼리문 실행 (DML은 executeUpdate() 메소드를 호출합니다.)
    int count = ps.executeUpdate();  //----- 쿼리문 실행이 성공한 행(Row)의 개수를 반환합니다. (성공 시 1 반환, 실패 시 0 반환)
    
    //----- 결과 확인
    System.out.println(count + " 행이 삽입되었습니다.");
    
    //----- 자원 해제
    ps.close();
    con.close();
    
  }
  
public static void update() throws Exception {
  
  // bid, title, content 입력 받기.
  // 해당 행(Row)의 title, content, modified_at 수정하기.
  
  //----- DB 접속
  Connection con = DBConnection.getConnection();
  
  //----- 쿼리문
  String sql = "UPDATE tbl_board SET title = ?, content = ?, modified_at = CURRENT_TIMESTAMP WHERE bid = ?";
  
  //----- PreparedStatement 객체 생성 (쿼리문 실행 객체)
  PreparedStatement ps = con.prepareStatement(sql);
  
  //----- tbl_board 테이블에 저장할 값 입력 받기
  Scanner sc = new Scanner(System.in);
  System.out.print("수정할 게시글 번호 입력 >>> "); int bid = sc.nextInt(); sc.nextLine();
  System.out.print("수정할 게시글 제목 입력 >>> "); String title = sc.nextLine();
  System.out.print("수정할 게시글 내용 입력 >>> "); String content = sc.nextLine();
  sc.close();
  
  //----- 입력 받는 값으로 파라미터 바인딩
  ps.setString(1, title);  //---- 1번째 ?에 title 바인딩
  ps.setString(2, content);  //-- 2번째 ?에 content 바인딩
  ps.setInt(3, bid);  //--------- 3번째 ?에 bid 바인딩
  
  //----- 쿼리문 실행 (DML은 executeUpdate() 메소드를 호출합니다.)
  int count = ps.executeUpdate();  //----- 쿼리문 실행이 성공한 행(Row)의 개수를 반환합니다. (성공 시 1 반환, 실패 시 0 반환)
  
  //----- 결과 확인
  System.out.println(count + " 행이 수정되었습니다.");
  
  //----- 자원 해제
  ps.close();
  con.close();
  
}

public static void delete() throws Exception {
  
  // bid 입력 받기.
  // 해당 행(Row) 삭제하기.
  
  //----- DB 접속
  Connection con = DBConnection.getConnection();
  
  //----- 쿼리문
  String sql = "DELETE FROM tbl_board WHERE bid = ?";
  
  //----- PreparedStatement 객체 생성 (쿼리문 실행 객체)
  PreparedStatement ps = con.prepareStatement(sql);
  
  //----- tbl_board 테이블에 저장할 값 입력 받기
  Scanner sc = new Scanner(System.in);
  System.out.print("삭제할 게시글 번호 입력 >>> "); int bid = sc.nextInt();
  sc.close();
  
  //----- 입력 받는 값으로 파라미터 바인딩
  ps.setInt(1, bid);  //--------- 1번째 ?에 bid 바인딩
  
  //----- 쿼리문 실행 (DML은 executeUpdate() 메소드를 호출합니다.)
  int count = ps.executeUpdate();  //----- 쿼리문 실행이 성공한 행(Row)의 개수를 반환합니다. (성공 시 1 반환, 실패 시 0 반환)
  
  //----- 결과 확인
  System.out.println(count + " 행이 삭제되었습니다.");
  
  //----- 자원 해제
  ps.close();
  con.close();
  
}

  public static void main(String[] args) throws Exception {
    try {
       //insert();
       //update();
     // delete();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
  
  
  
}
