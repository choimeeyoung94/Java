package chap13_BankAccount;

public class Main {

  public static void main(String[] args) {

    BankAccount myAcc = new BankAccount("010-1111-1111", 500_000);  //----- 내 계좌 (자바에서는 숫자 3자리마다 밑줄을 넣을 수 있습니다.)
    BankAccount momAcc = new BankAccount("010-9999-9999", 1_000_000);  //-- 엄마 계좌
    
    //momAcc.transfer(myAcc, -100_000);  //----- 마이너스 이체는 실패해야 합니다. (확인 후 주석 처리)
    //momAcc.transfer(myAcc, 10_000_000);  //--- 천만원 이체는 실패해야 합니다. (확인 후 주석 처리)
    momAcc.transfer(myAcc, 100_000);  //------ 백만원 이체는 성공해야 합니다.
    
    myAcc.inquiry();  //----- 이체결과확인
    momAcc.inquiry();

  }

}
