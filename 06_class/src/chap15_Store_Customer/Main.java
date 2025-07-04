package chap15_Store_Customer;

public class Main {

  public static void main(String[] args) {
    
    //----- 한 명의 고객을 생성합니다.
    Customer customer = new Customer(0, 100.0);
    
    //----- 상품을 판매할 두 개의 상점을 생성합니다.
    Store store = new Store(10, 1.9, 100.0);
    //----- 첫 번째 상점에서 상품을 구매합니다. 
    Store store2 = new Store(10, 2.9, 100.0);
    //----- 두 번째 상점에서 상품을 구매합니다.
    customer.purchase(store, 5, 10.0);
    
    customer.purchase(store2, 5, 15.0);
    
    //----- 모든 상점의 정보와 고객의 정보를 출력합니다.
    System.out.println("[상점1]");
    System.out.println("상품개수: " + store.getCount() + ",자본금: " + store.getMoney());
    System.out.println("[상점2]");
    System.out.println("상품개수: " + store2.getCount() + ",자본금: " + store2.getMoney());
    System.out.println("[고객]");
    System.out.println("구매상품개수: " + customer.getCount() + " 남은돈: " + customer.getMoney());
  }

}
