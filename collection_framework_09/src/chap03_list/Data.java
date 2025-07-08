package chap03_list;
/*
 * Comparable 인터페이스
 * 
 * 1. functional interface이다 (추상 메소드가 1개이다)
 * 2. 정렬이 필요한 객체들은 Comparable 인터페이스의 구현클래스 객체여야 한다
 * 3. 추상 메소드
 *    1) int compareTo(T t);
 *    2) 결과가 음수이면 현재 객체를 t 앞에 두고, 양수이면 현재 객체를 뒤에 둔다
 *    
 * 
 * */
public class Data implements Comparable<Data>{

  private int item;
  
  public Data(int item) {
    this.item = item;
  }
    
  @Override
  public int compareTo(Data o) {
    
    return this.item-o.item; // 현재객체의 item이 크면 양수 반환하므로 현재 객체를 Data o 뒤에 둔다 
                         // 현재객체의 item이 작으면 음수를 반환하므로, 현재 객체를 Data o 앞에 둔다
  }
  
  @Override
  public String toString() {
    return item + "";
  }
  
}
