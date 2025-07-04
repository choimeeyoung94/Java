package chap12_Book_Publisher;

// 문제. 생성자 없이 Getter/Setter를 생성하세요.

public class Book {

  private String title;  //--------- 책제목
  private Publisher publisher;  //-- 출판사
  
  public String getTitle() {
    return title;
  }
  public void setTitle(String title) {
    this.title = title;
  }
  public Publisher getPublisher() {
    return publisher;
  }
  public void setPublisher(Publisher publisher) {
    this.publisher = publisher;
  }
  
  
  
}
