package ex01_ten_quiz;

public class NumberInputException extends Exception {
  private String message;
  
  public NumberInputException(String message) {
    this.message = message;
  }
}
