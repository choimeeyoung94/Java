package chap04_openapi.b_naver_captcha;

public class ApiResponse {
  private boolean result;
  private String responseTime;
  
  public boolean isResult() {
    return result;
  }
  public void setResult(boolean result) {
    this.result = result;
  }
  public String getResponseTime() {
    return responseTime;
  }
  public void setResponseTime(String responseTime) {
    this.responseTime = responseTime;
  }
  
  @Override
  public String toString() {
    return "ApiResponse [result=" + result + ", responseTime=" + responseTime + "]";
  }
  
  
}
