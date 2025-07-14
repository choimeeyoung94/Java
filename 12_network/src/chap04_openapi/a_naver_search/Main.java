package chap04_openapi.a_naver_search;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;

public class Main {
  public static void main(String[] args) {
    try {
      NaverOpenAPI.naverAreaSearch();
    } catch (Exception e) {
      if (e instanceof UnsupportedEncodingException) {
        System.out.println("검색어 인코딩 실패");
      } else if (e instanceof MalformedURLException) {
        System.out.println("잘못된 형식의 API URL");
      } else if (e instanceof IOException) {
        System.out.println("API 요청 또는 응답 실패");
      } else {
        System.out.println("알 수 없는 예외 발생");
      }
    }
  }
}
