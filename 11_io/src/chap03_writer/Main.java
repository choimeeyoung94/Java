package chap03_writer;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

/*
 * java.io.Writer
 * 
 * 1. 문자(Character) 기반 출력 스트림의 최상위 추상 클래스 (직접 인스턴스를 생성할 수 없다)
 * 2. 문자 데이터를 파일, 네트워크 등으로 출력할때 사용
 * 3. 주요 하위클래스
 *    1) FileWriter
 *    2) BufferedWriter
 *    3) PrintWriter
 * 4. 주요 메소드
 *    1) write(int c) : 문자 1개를 출력
 *    2) write(char[] cbuf) : 문자 배열 전체를 출력
 *    3) write(String str) : 문자열 전체를 출력
 *    4) write(String str, int off, int len) : 문자열 일부만 출력 (인덱스 off 부터 len개만큼)
 *    5) flush()
 *    6) close()
 *    
 * 
 * 
 * 
 * */



public class Main {
  
  public static void fileWriter() {
    
    File file = new File("D:/storage/test.txt");
    
    try(FileWriter out = new FileWriter(file)) {
      out.write('안');
      out.write("녕하세요 반갑습니다".toCharArray()); // char[] 출력
      out.write(" 어디에서 오셨을까요?");// String 출력
      out.write("Hello World", 0, 5);
      
      
    } catch(Exception e) {// FileNotFoundException, IOException
      e.printStackTrace();
    }
    
    
  }
  
  public static void bufferedWriter() {
    
    /*
     * java.io.BufferedWriter
     * 
     * 1. 내부 버퍼를 이용해서 한 번에 출력하는 보조 스트림 클래스 (기본 8192자)
     * 2. newLine() 메소드를 지원함
     * 
     * */
    
    File file = new File("D:/storage/test.txt");
    
    // true를 붙이면 추가모드
    try(BufferedWriter out = new BufferedWriter(new FileWriter(file, true))) {
      out.write("나라입니다.");
      out.newLine(); // \n 사용해도 동일하다 성능 향상을 위해서는 BufferedWriter가 좋다
      out.write("알겠습니까?");
    } catch (Exception e) {
      e.printStackTrace();
    }
    
  }
  
  
  
  public static void main(String[] args) {
   //fileWriter();
   bufferedWriter();
  }
}
