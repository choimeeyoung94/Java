package chap01_connect;

public class Main {
  public static void main(String[] args) {
    
    try {
      DBConnection.getConnection(); // https://dev.mysql.com/downloads/file/?id=538917 , https://dev.mysql.com/downloads/connector/j/
      System.out.println("DB 접속 성공");
    } catch (Exception e) {
      e.printStackTrace();
    }

  }
}
