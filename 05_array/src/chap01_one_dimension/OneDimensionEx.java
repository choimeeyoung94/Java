package chap01_one_dimension;

import java.util.Arrays;

public class OneDimensionEx {

  public static void main(String[] args) {
    
    // 배열 선언
    String[] blackPink; // 스택 영역에 참조 변수 blackPink가 생성된다
    
    
    // 배열 생성
    blackPink = new String[4]; // 힙 영역에 String 저장이 가능한 연속된 4개 메모리 공간이 생긴다
                               //  그 중 첫번째 공간의 참조값을 참조 변수 blackPink에 저장한다
                               // 힙 영역에 생성된 4개 메모리 공간은 늘이거나 줄일 수 없다
                              
    // 배열 요소 사용 (배열명 뒤에 대괄호를 붙이고 인덱스를 작성)
    blackPink[0] = "로제";
    blackPink[1] = "지수";
    blackPink[2] = "제니";
    blackPink[3] = "리사";
    
   System.out.println(Arrays.toString(blackPink));
   
   
   //------ 배열 초기화 (배열 선언 + 배열 생성 + 배열 요소에 값 저장)-----//
   
   // 배열 초기화 1 (배열 선언시에만 초기화 가능하다)
   String[] frontEnd = {"HTML", "CSS", "JavaScript", "React"};
   System.out.println(Arrays.toString(frontEnd));
   
   // 배열 초기화 2 (배열 선언과 초기화를 두개의 코드로 분리할 수 있다)
   String[] backEnd;
   backEnd = new String[] { "Java", "JSP/Servlet", "SPRING", "MySQL" };
   System.out.println(Arrays.toString(backEnd));
   
   
    

  }

}
