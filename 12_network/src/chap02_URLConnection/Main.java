package chap02_URLConnection;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;

import java.net.URL;



/**
 * java.net.URLConnection
 * 
 * 1. 자바 애플리케이션과 URL 간의 통신 링크를 나타내는 추상 클래스
 * 2. URL을 통해 네이워크 리소스에 접근하여 데이터를 읽거나 쓸 수 있는 표준 API를 제공
 * 3. java.net.URL 객체의 openConnection() 메소드를 호출하여 URLConnection 클래스의 하위 클래스의 객체를 얻을 수 있다
 * 4. HTTP 프로토콜의 경우 HttpURLConnection 클래스가 하위 클래스로 지원된다
 * 5. 데이터 입출력의 경우 바이트 기반 스트림이 사용되기 때문에 입력 스트림(getInputStream())과 출력 스트림(getOutputStream())을 이용해 서버와 데이터를 주고 받을 수 있다
 * 
 * */


public class Main {
  
  public static void byteStream() throws MalformedURLException, IOException {
    
    // 웹사이트의 이미지 내려받기
    URL url = new URL("https://image7.coupangcdn.com/image/coupang/common/logo_coupang_w350.png"); //쿠팡서버로 부터 정보를 입력받으려고 한다 (inputStream이 필요)
    
   HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection(); // 접속 링크 얻어내기
   httpURLConnection.connect(); // 실제 접속 (getInputStream(), getOutputStream(), getResponseCode() 등 실제 접속을 유발하는(트리거) 다른 메소드를 함께 사용하는 경우 생략 가능)
   
   // 스트림을 얻어내거나 ResponseCode를 언어내는 코드를 작성하게 돼면 httpURLConnection.connect()은 안적어도 된다
   int responseCode = httpURLConnection.getResponseCode(); // HTTP  상태코드 (200: OK, 404: NOT FOUND 등)
   
   BufferedInputStream in = null; // 이미지 서버로부터 데이터를 입력 받는 버퍼스트림
   
   if (responseCode == HttpURLConnection.HTTP_OK) { // if (responseCode == 200)
     in = new BufferedInputStream(httpURLConnection.getInputStream()); // 접속 링크로부터 입력 스트림을 받아서 버퍼를 추가한 방식
     
   } else {
     in = new BufferedInputStream(httpURLConnection.getErrorStream()); // 에러 전용 입력 스트림으로 에러 사유를 받아볼 수 있도록 처리
   }

   String filename = url.getFile().substring(url.getFile().lastIndexOf("/") + 1); // filename = logo_coupang_w350.png

   File file = new File(filename); // 저장 디렉터리 저장 없이 파일 명만 전달
   
   BufferedOutputStream out = null; // 이미지 서버로부터 받은 데이터를 로컬에 출력하기 위한 버퍼스트림
   out = new BufferedOutputStream(new FileOutputStream(file)); 
   

   byte[] b = new byte[1024]; // 1KB 단위로 이미지 서버로부터 데이터를 받아온다
   int readByte = 0; // 실제로 읽은 데이터의 바이트 수
   while ((readByte = in.read(b)) != -1) {// 파일의 끝 EOF == -1에 도달하지 않았다면 계속 읽어오기
     out.write(b, 0, readByte); // 실제로 읽은 데이터만 출력스트림으로 보내기 (로컬로 보내기)
     
   }
   
   out.close();
   in.close();
   httpURLConnection.disconnect(); // 접속 링크 끊기
   
   System.out.println(file.getPath() + " 파일이 다운로드되었습니다.");
  }
  
  public static void charStream() throws MalformedURLException, IOException {
    URL url = new URL("https://www.google.com/robots.txt");
    
    /*
     * Server read
     * InputStreamReader
     * BufferedReader
     * 
     * local write
     * BufferedWriter
     * 
     * */
    
    HttpURLConnection con = (HttpURLConnection) url.openConnection();
    con.connect();
    
    int responseCode = con.getResponseCode();
    
    BufferedReader in = null;
    
    if (responseCode == HttpURLConnection.HTTP_OK) {
      in = new BufferedReader(new InputStreamReader(con.getInputStream()));
    } else {
    
      in = new BufferedReader(new InputStreamReader(con.getErrorStream()));
    }
       
   String filename = url.getFile().substring(url.getFile().lastIndexOf("/") + 1);
   
   File file = new File(filename);
   
   BufferedWriter out = new BufferedWriter(new FileWriter(file, true));
   
   String line;
   while ((line = in.readLine()) != null) {
     out.write(line);
     out.newLine();
   }
   
   out.close();
   in.close();
   con.disconnect(); // 접속 링크 끊기
    
  System.out.println("로컬에 파일 저장 완료: " + file.getPath());
    
    
    
    
    
    
    
    
  }
  
  
  public static void main(String[] args) {
    
    
    try {
      //byteStream();
      charStream();
    } catch (MalformedURLException e) {
      System.out.println("URL 형식이 잘못되었습니다.");
    } catch (IOException e) {
      System.out.println("데이터 입출력이 잘못되었습니다.");
    }
    
  }
}
