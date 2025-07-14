package chap04_openapi.b_naver_captcha;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Map;
import java.util.Scanner;

import com.google.gson.reflect.TypeToken;

import com.google.gson.Gson;

public class NaverOpenAPI {
  public final static String clientId = "qj5j24Ogz4oIruk_3mQt";
  public final static String clientsecret = "oop6J7KgaS";
  
  
  
  /**
   * 캡차 키 요청 후 발급 받은 캡차 키를 반환하는 메소드
   * @return 네이버로부터 발급 받은 캡차 키 
   * */
  public static String captchaKey() throws Exception {
    
    String apiUrl = "https://openapi.naver.com/v1/captcha/nkey?code=0";
   
    URL url = new URL(apiUrl);
    HttpURLConnection con = (HttpURLConnection) url.openConnection();
   
    con.setRequestMethod("GET"); // 기본 메소드는 GET이므로 생략 가능하다 (반드시 대문자로 작성)
    con.setRequestProperty("X-Naver-Client-Id", clientId);
    con.setRequestProperty("X-Naver-Client-Secret", clientsecret);
    con.connect(); // 실제 접속이 이루어진다
    // 응답
    int responseCode = con.getResponseCode();
    BufferedReader in = null;
    if (responseCode == HttpURLConnection.HTTP_OK) {
      in = new BufferedReader(new InputStreamReader(con.getInputStream()));
    } else {
      in = new BufferedReader(new InputStreamReader(con.getErrorStream()));
    }

    StringBuilder sb = new StringBuilder(); 
    String line = null;
    if  ((line = in.readLine()) != null) {
      sb.append(line);
    }
    //System.out.println(sb.toString());
    
    Gson gson = new Gson();
    Type type = new TypeToken<Map<String, String>>(){}.getType();
    Map<String, String> map = gson.fromJson(sb.toString(), type);
    System.out.println(map);
   
    in.close();
    con.disconnect();
     
    // 캡차키 반환
    return map.get("key");
  }
  
  /**
   * 캡차 이미지를 요청하는 메소드
   * @param key 발급 받은 캡차 키
   * @return 캡차 이미지 발급 성공 시 true 실패 시 false 
   * @throws Exception 
   * */
  public static boolean captchaImage(String key) throws Exception {
    
    // 요청
    String apiURL = "https://openapi.naver.com/v1/captcha/ncaptcha.bin?key=" + key;
    URL url = new URL(apiURL);
    HttpURLConnection con = (HttpURLConnection) url.openConnection();
   
    con.setRequestMethod("GET"); // 기본 메소드는 GET이므로 생략 가능하다 (반드시 대문자로 작성)
    con.setRequestProperty("X-Naver-Client-Id", clientId);
    con.setRequestProperty("X-Naver-Client-Secret", clientsecret);
    
    // 응답 (캡차 이미지 내려 받기)
    int responseCode = con.getResponseCode();
    BufferedInputStream in = null;
    if (responseCode == 200) {
      in = new BufferedInputStream(con.getInputStream());
    } else {
     System.out.println(error(con.getErrorStream()));
     return false;
    }
    
   String filename = System.currentTimeMillis() + ".jpg";
   File file = new File(filename); 
   BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(file)); 
   
   byte[] b = new byte[1024];
   int readByte = 0;
   while ((readByte = in.read(b)) != -1) {
     out.write(b, 0, readByte);
   }
   
   
   out.close();
   in.close();
   con.disconnect();
  
   System.out.println("캡차 이미지 파일명: " + filename);
   
   return true;
   
  }
  
  
  /*
   * 캡차 이미지 요청이 실패하는 경우 실패 사유를 반환하는 메소드
   * @param in 에러 스트림
   * @return 실패 사유
   * */
  private static String error(InputStream in) {
    StringBuilder sb = null;
    try (BufferedReader reader =  new BufferedReader(new InputStreamReader(in))) {
      sb = new StringBuilder();
      String line = null;
      while ((line = reader.readLine()) != null) {
        sb.append(line);
      }
      
    } catch (IOException e) {
      throw new RuntimeException("API 요청 및 응답 실패", e);
    }
    
    
    
    
    return sb.toString();
  }
  
  
  
  /**
   * 캡차 이미지를 보고 사용자가 입력한 값이 올바른지 판단하는 메소드
   * @param key 발급받은 캡차 키
   * @throws Exception 
   * */
  public static void validateInput(String key) throws Exception {
    
    Scanner scanner = new Scanner(System.in);
    String value = scanner.next();
    
    // 요청
    String apiUrl = "https://openapi.naver.com/v1/captcha/nkey?code=1&key=" + key + "&value=" + value ;
    
    URL url = new URL(apiUrl);
    HttpURLConnection con = (HttpURLConnection) url.openConnection();
   
    con.setRequestMethod("GET"); // 기본 메소드는 GET이므로 생략 가능하다 (반드시 대문자로 작성)
    con.setRequestProperty("X-Naver-Client-Id", clientId);
    con.setRequestProperty("X-Naver-Client-Secret", clientsecret);
    con.connect();
    
    // 응답
    int responseCode = con.getResponseCode();
    BufferedReader in = null;
    if (responseCode == HttpURLConnection.HTTP_OK) {
      in = new BufferedReader(new InputStreamReader(con.getInputStream()));
    } else {
      in = new BufferedReader(new InputStreamReader(con.getErrorStream()));
    }

    StringBuilder sb = new StringBuilder(); 
    String line = null;
    if  ((line = in.readLine()) != null) {
      sb.append(line);
    }
    //System.out.println(sb.toString());
    
    // 역직렬화
    Gson gson = new Gson();
    ApiResponse response = gson.fromJson(sb.toString(), ApiResponse.class);
    System.out.println(response.isResult());
    System.out.println(response.getResponseTime() + "s");
    
    System.out.println();
    
    in.close();
    con.disconnect();
    scanner.close();
  }
  
  
  
}
