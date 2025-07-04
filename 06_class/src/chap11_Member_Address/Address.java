package chap11_Member_Address;

// 문제. 필드를 이용한 생성자를 만들고 정보를 출력하는 printInfo() 메소드를 구현하세요.

public class Address {

  private String zipCode;  //----- 우편번호
  private String roadAddr;  //---- 도로명주소
  private String detailAddr;  //-- 상세주소
  
  public Address(String zipCode, String roadAddr, String detailAddr) {
    this.zipCode = zipCode;
    this.roadAddr = roadAddr;
    this.detailAddr = detailAddr;
  }

  public String getZipCode() {
    return zipCode;
  }

  public void setZipCode(String zipCode) {
    this.zipCode = zipCode;
  }

  public String getRoadAddr() {
    return roadAddr;
  }

  public void setRoadAddr(String roadAddr) {
    this.roadAddr = roadAddr;
  }

  public String getDetailAddr() {
    return detailAddr;
  }

  public void setDetailAddr(String detailAddr) {
    this.detailAddr = detailAddr;
  }
  
  public void printInfo() {
    System.out.println(getZipCode() + " " + getRoadAddr() + " " + getDetailAddr());
  }
  
  
}
