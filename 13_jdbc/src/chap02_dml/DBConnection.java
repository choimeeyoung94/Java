package chap02_dml;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DBConnection {
 public static Connection getConnection() throws ClassNotFoundException, SQLException, IOException {
    
    //----- jdbc.properties 파일을 읽기 위한 입력 스트림 생성
    File file = new File("jdbc.properties");
    FileInputStream in = new FileInputStream(file);
    
    //----- Properties 객체 생성 및 jdbc.properties 파일 등록
    Properties properties = new Properties();
    properties.load(in);
    
    //----- 드라이버 클래스 (com.mysql.cj.jdbc.Driver) 로드
    Class.forName(properties.getProperty("driver"));
    
    //----- DB 접속
    Connection con = DriverManager.getConnection(
        properties.getProperty("url"), 
        properties.getProperty("user"), 
        properties.getProperty("password"));
    
    //----- DB 접속 링크 반환
    return con;
    
  }
}
