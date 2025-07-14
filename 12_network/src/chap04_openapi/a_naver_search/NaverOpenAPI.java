package chap04_openapi.a_naver_search;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.List;
import java.util.Scanner;

import com.google.gson.Gson;

public class NaverOpenAPI {
  public final static String clientId = "qj5j24Ogz4oIruk_3mQt";
  public final static String clientsecret = "oop6J7KgaS";
  
  public static void naverAreaSearch() throws Exception {
    
    // 사용자로부터 검색어 입력 받기
    Scanner scanner = new Scanner(System.in);
    System.out.println("책 검색 API입니다. 검색할 책을 입력하세요 >>> ");
    String query = scanner.nextLine(); // 공백 문자를 포함하여 검색어를 입력 받을 수 있다
    
    // 요청
    String apiURL = "https://openapi.naver.com/v1/search/book.json?query=" + URLEncoder.encode(query, "UTF-8");
    URL url = new URL(apiURL);
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

    StringBuilder sb = new StringBuilder(); // 응답 결과(JSON)를 저장할 객체
    String line = null;
    while ((line = in.readLine()) != null) {
      sb.append(line);
    }
    //System.out.println(sb.toString());
    
    // JSON 문자열 파싱(분석)(with Gson)
    Gson gson = new Gson();
    ApiResponse response = gson.fromJson(sb.toString(), ApiResponse.class);
    List<Item> items = response.getItems();
    for (Item item : items) {
      System.out.println("제목: " + item.getTitle());
      System.out.println("저자: " + item.getPublisher());
      System.out.println("출판사: " + item.getPublisher());
      System.out.println("할인가: " + item.getDiscount());
      System.out.println();
    }
    
    
    
    in.close();
    con.disconnect();
    scanner.close();
    
  }
  
  
}
