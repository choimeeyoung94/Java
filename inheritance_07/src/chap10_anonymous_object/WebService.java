package chap10_anonymous_object;

public class WebService {
  
  public static void signUp(Button confirmButton) {
    System.out.println("회원 가입을 합니다.");
    confirmButton.onClick();
  }
  
  public static void createPost(Button confirmButton) {
    System.out.println("게시글을 작성합니다.");
    confirmButton.onClick();
  }
}
