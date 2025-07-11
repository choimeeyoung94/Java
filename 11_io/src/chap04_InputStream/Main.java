package chap04_InputStream;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/*
 * java.io.InputStream
 * 
 * 1. 바이트 기반 입력 스트림의 최상위 추상 클래스이다
 * 2. 파일, 네트워크 등으로부터 바이트 단위로 데이터를 읽어올 수 있다
 * 3. 주요 하위 클래스
 *    1) FileInputStream
 *    2) BufferedInputStream
 *    3) DataInputStream
 * 4. 주요 메소드
 *    1) int read() : 1바이트를 읽어 int 값으로 반환 (읽을 데이터가 없으면 -1(EOF)을 반환)
 *                    (1바이트를 int로 변환하면 0~255 값으로 변환되는데 이렇게 처리하면 -1(EOF)과 반환하는 값의 차이를 만들 수 있다)
 *                    최상위 비트 부호 역할을 하는 비트가 값으로 바뀐다
 *                    1바이트를 byte로 그대로 반환하면 -128 ~ 127 값으로 반환하는데 이러면 -1(EOF)와 반환하는 값의 구분이 어렵다
 *    2) int read(byte[] b) : 전달한 바이트 배열만큼 읽어서 배열에 저장(읽은 데이터는 byte 배열에 저장돼 있다).
 *                            실제로 읽은 바이트 수를 반환한다
 *                            (읽을 데이터가 없으면 -1(EOF)을 반환) 
 *    3) int read(byte[] b, int off, int len) : 전달한 바이트 배열의 일부만 사용해서 저장(인덱스 off 부터 len개만큼)
 *                            실제로 읽은 바이트 수를 반환한다
 *                            (읽을 데이터가 없으면 -1(EOF)을 반환)
 *    4) close() : 입력 스트림을 닫고 자원을 해제
 * 
 * */


public class Main {
  
  public static void bufferedInputStream() {
    File file = new File("C:/Program Files/Java/jdk-17", "README");
    
    try (BufferedInputStream bin = new BufferedInputStream(new FileInputStream(file))) {
      
      // int를 이용해 1바이트 단위로 파일 읽기
      int c;
      
      // 파일에서 읽은 데이터를 저장해 둘 byte[] 배열
      byte[] b = new byte[(int)file.length()];
      int i = 0;
      
//      while (true) {
//        c = bin.read();
//        if (c == -1) 
//          break;
//        b[i++] = (byte)c;
//      }
      
      // 실무
      while ((c = bin.read()) != -1) { // 파일의 끝(EOF == -1)에 도달하지 않았다면 반복한다
        b[i++] = (byte)c;
        
      }
      System.out.println(new String(b));
      
    } catch (Exception e) {
      e.printStackTrace();
    }
    
    
    
    
  }
  
  public static void bufferedInputStream2() {
    
    File file = new File("C:/Program Files/Java/jdk-17", "README");
    
    try (BufferedInputStream bin = new BufferedInputStream(new FileInputStream(file))) {
      
      // byte[] 배열을 이용해 20바이트 단위로 파일 읽기
      byte[] b = new byte[20];
      
      
      // 파일에서 읽은 데이터를 저장해 둘 byte[] 배열
      byte[] bytes = new byte[(int)file.length()];
      int i = 0;
      
      // 파일로부터 실제로 읽은 바이트 수
      int readByte = 0;
      
      while ( (readByte = bin.read(b)) != -1 ) {// 입력 스트림 bin에서 데이터를 읽어서 byte[] b 배열에 b.length 바이트만큼 저장
        // 실제로 읽은 바이트 수를 반환하며, **파일의 끝(EOF)**에 도달하면 -1을 반환
        System.arraycopy(b, 0, bytes, i, readByte);
        i += readByte;// 읽어들인 byte만큼 늘려줘야 한다
      }
      System.out.println(new String(bytes));
      
      
      
    } catch (Exception e) {
      e.printStackTrace();
    }
    
    
    
    
    
  }
  
  public static void systemIn() throws IOException {
    InputStream in = System.in; // 표준 입력 스트림(키보드)을 연결
    
    int c;
    
    while ((c = in.read()) != -1) {
      System.out.print((char)c);
    }
    
  }
  
  public static void dataInputStream() throws IOException {
    
    File file = new File("D:/storage/test.bin");
    
    DataInputStream din = new DataInputStream(new BufferedInputStream(new FileInputStream(file)));
    
    // 저장되어 있는 순서대로 읽는다
    int x = din.readInt(); // writeInt() 생성한 값 읽기
    double y = din.readDouble(); // writeDouble()로 생성한 값 읽기
    String s = din.readUTF(); // writeUTF()로 생성한 값 읽기

    System.out.println(x);
    System.out.println(y);
    System.out.println(s); // 바이트 스트림이지만 한글이 깨지지 않는다
    
    din.close();
  }
  
  
  
  
  public static void main(String[] args) {
    try {
      dataInputStream();
    } catch (IOException e) {
      
      e.printStackTrace();
    }
  }
}
