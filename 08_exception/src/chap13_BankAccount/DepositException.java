package chap13_BankAccount;

/*
 * Exception  ✅ Checked Exception (예외 처리 필수)
   RuntimeException  ✅ Unchecked Exception (예외 처리 선택)
 * */


public class DepositException extends Exception {

  private static final long serialVersionUID = 6617348274559101411L;
  
  public DepositException(String message) {
    super(message);
  }
  
}
