package chap12_Book_Publisher;

// 문제. Book 객체를 만들고 Setter를 호출하여 적절한 정보를 저장하세요.
//       정보 저장 뒤 Getter를 호출하여 해당 정보를 확인하세요.

public class Main {

  public static void main(String[] args) {
    Book book = new Book();
    
    Publisher publisher = new Publisher();
    
    Contact contact = new Contact();
    contact.setTel("010-1111-2222");
    contact.setFax("070-3333-4444");
    
    publisher.setName("한빛출판사");
    publisher.setLocation("서울특별시 중원구 회원로1가");
    publisher.setContact(contact);
    
    book.setTitle("자바뽀개기");
    book.setPublisher(publisher);
    
    System.out.println(book.getTitle() + " " + publisher.getName() + " " + publisher.getLocation() + " " + publisher.getContact().getFax() + " " + publisher.getContact().getTel());
    
  }

}
