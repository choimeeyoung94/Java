package chap12_Book_Publisher;

// 문제. 생성자 없이 Getter/Setter를 생성하세요.

public class Contact {

  private String tel;  //----- 전화번호
  private String fax;  //----- 팩스번호
  public String getTel() {
    return tel;
  }
  public void setTel(String tel) {
    this.tel = tel;
  }
  public String getFax() {
    return fax;
  }
  public void setFax(String fax) {
    this.fax = fax;
  }
  

  
}
