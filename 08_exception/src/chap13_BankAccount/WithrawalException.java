package chap13_BankAccount;

/*
 * Exception  ✅ Checked Exception (예외 처리 필수)
   RuntimeException  ✅ Unchecked Exception (예외 처리 선택)
 * */

public class WithrawalException extends Exception {

  private static final long serialVersionUID = -365711173065328341L;
  
  public WithrawalException(String message) {
    super(message);
  }
}
