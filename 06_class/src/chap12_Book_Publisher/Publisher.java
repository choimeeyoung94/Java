package chap12_Book_Publisher;

// 문제. 생성자 없이 Getter/Setter를 생성하세요.

public class Publisher {

  private String name;  //------ 출판사이름
  private String location;  //-- 출판사위치
  private Contact contact;  //-- 출판사연락처
  
  public String getName() {
    return name;
  }
  public void setName(String name) {
    this.name = name;
  }
  public String getLocation() {
    return location;
  }
  public void setLocation(String location) {
    this.location = location;
  }
  public Contact getContact() {
    return contact;
  }
  public void setContact(Contact contact) {
    this.contact = contact;
  }
  
  
  
  
}
