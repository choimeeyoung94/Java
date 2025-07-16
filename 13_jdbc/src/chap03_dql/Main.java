package chap03_dql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
  public static void singleRow() throws Exception {
    
    //----- 단일 행 결과 저장하기 (tbl_user)
    
    //----- 검색 결과를 어디에 저장할 것인가?
    UserDTO user = null;
    
    //----- DB 접속
    Connection con = DBConnection.getConnection();
    
    //----- 쿼리문
    String sql = "SELECT uid, nickname FROM tbl_user WHERE uid = ?";
    
    //----- PreparedStatement 객체 생성 (쿼리문 실행 객체)
    PreparedStatement ps = con.prepareStatement(sql);
    
    //----- 조회할 사용자 번호 입력 받기
    Scanner sc = new Scanner(System.in);
    System.out.print("조회할 사용자 번호 입력 >>> ");
    int uid = sc.nextInt();
    sc.close();
    
    //----- 입력 받는 값으로 파라미터 바인딩
    ps.setInt(1, uid);  //--------- 1번째 ?에 uid 바인딩
    
    //----- 쿼리문 실행 (DQL은 executeQuery() 메소드를 호출합니다.)
    ResultSet rs = ps.executeQuery();  //----- 중요) 현재 커서는 검색 결과 이전에 위치하고 있습니다.
                                       //            반드시 next() 메소드의 호출이 한 번 이상 필요합니다.
    
    //----- 결과 확인
    if (rs.next()) {
      user = new UserDTO();
      user.setUid( rs.getInt(1) );
      user.setNickname( rs.getString(2) );
      System.out.println("검색 결과: " + user);
    } else {
      System.out.println("검색 결과 없음");
    }
    
    //----- 자원 반납
    rs.close();
    ps.close();
    con.close();
    
  }
  
  public static void multipleRow() throws Exception {
    
    //----- 다중 행 결과 저장하기 (tbl_user)
    
    //----- 검색 결과를 어디에 저장할 것인가?
    List<UserDTO> users = new ArrayList<UserDTO>();
    
    //----- DB 접속
    Connection con = DBConnection.getConnection();
    
    //----- 쿼리문
    String sql = "SELECT uid, nickname FROM tbl_user LIMIT 0, 10";  // 첫 번째 행(Row)부터 10개 가져오기
    
    //----- PreparedStatement 객체 생성 (쿼리문 실행 객체)
    PreparedStatement ps = con.prepareStatement(sql);
   
    //----- 쿼리문 실행 (DQL은 executeQuery() 메소드를 호출합니다.)
    ResultSet rs = ps.executeQuery();  //----- 중요) 현재 커서는 검색 결과 이전에 위치하고 있습니다.
                                       //            반드시 next() 메소드의 호출이 한 번 이상 필요합니다.
    
    // 결과 확인
    while (rs.next()) {  // 결과 행(Row)을 하나씩 찾아가는 방식입니다.
      UserDTO user = new UserDTO();
      user.setUid( rs.getInt(1) );
      user.setNickname( rs.getString(2) );
      users.add(user);  //----- ArrayList에 user 객체 저장하기
    }
    System.out.println("검색 결과: " + users);
    
    //----- 자원 반납
    rs.close();
    ps.close();
    con.close();
    
  }

  public static void join() throws Exception {
    
    //----- 조인으로 다중 행 결과 저장하기 (tbl_user, tbl_board)
    
    //----- 검색 결과를 어디에 저장할 것인가?
    List<BoardDTO> boards = new ArrayList<BoardDTO>();
    
    //----- DB 접속
    Connection con = DBConnection.getConnection();
    
    //----- 쿼리문
    StringBuilder sb = new StringBuilder();
    sb.append("SELECT u.uid, nickname, bid, title, content, created_at, modified_at");
    sb.append("  FROM tbl_user AS u INNER JOIN tbl_board AS b");
    sb.append("    ON u.uid = b.uid");
    sb.append(" LIMIT 0, 10");
    String sql = sb.toString();
    
    //----- PreparedStatement 객체 생성 (쿼리문 실행 객체)
    PreparedStatement ps = con.prepareStatement(sql);
   
    //----- 쿼리문 실행 (DQL은 executeQuery() 메소드를 호출합니다.)
    ResultSet rs = ps.executeQuery();  //----- 중요) 현재 커서는 검색 결과 이전에 위치하고 있습니다.
                                       //            반드시 next() 메소드의 호출이 한 번 이상 필요합니다.
    
    // 결과 확인
    while (rs.next()) {  // 결과 행(Row)을 하나씩 찾아가는 방식입니다.
      UserDTO user = new UserDTO();
      user.setUid( rs.getInt(1) );
      user.setNickname( rs.getString(2) );
      BoardDTO board = new BoardDTO();
      board.setBid( rs.getInt(3) );
      board.setUser(user);
      board.setTitle( rs.getString(4) );
      board.setContent( rs.getString(5) );
      board.setCreatedAt( rs.getTimestamp(6) );
      board.setModifiedAt( rs.getTimestamp(7) );
      boards.add(board);  //----- ArrayList에 board 객체 저장하기
    }
    for (BoardDTO board : boards) {
      System.out.println(board);
    }

    //----- 자원 반납
    rs.close();
    ps.close();
    con.close();
    
  }
  
  public static void main(String[] args) {
    try {
       singleRow();
      // multipleRow();
      //join();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
