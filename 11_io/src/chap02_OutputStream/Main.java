package chap02_OutputStream;

import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/*
 * java.io.OutputStream
 * 
 * 1. 바이트 기반 출력 스트림들의 최상위 추상 클래스 (직접 인스턴스를 생성할 수 없다)
 * 2. 데이터를 외부(파일, 네트워크 등)로 바이트 단위로 출력
 * 3. 주요 하위클래스
 *     1) FileOutputStream
 *     2) BufferedOutputStream
 *     3) DataOutputStream
 *     4) PrintStream
 * 4. 주요 메소드
 *     1) write(int b)    : 1바이트를 출력한다 (4바이트 중 하위 1바이트만 사용)
 *     2) write(byte[] b) : 바이트 배열 전체를 출력한다
 *     3) write(byte[] b, int off, int len) : 바이트 배열 일부를 출력 (인덱스 off부터 len개만큼)
 *     4) flush() : 버퍼에 남아있는 데이터를 모두 출력하고 버퍼를 비운다
 *     5) close() : 출력 스트림을 닫고 시스템 자원을 해제한다 (파일이 정상적으로 완료가 안돼기 때문에 close를 해줘야 한다)
 * */


public class Main {
  
  public static void fileCreate() {
   
      // 신규 파일 생성 모드 (항상 새로운 파일을 만든다. 기존 파일이 있다면 덮어쓰기 한다)
      File dir = new File("D:/storage"); // new File("/storage") (루트디렉터리로 D드라이브가 인식된다)
      File file = new File(dir, "test.dat"); // 어느 디렉터리에 저장되는 어느 파일
     
      OutputStream os = null; // try, catch, finally 블록에서 모두 접근 가능한 Scope에서 선언한다
      try {
       os =  new FileOutputStream(file); // 출력 스트림 os 생성 (파일이 데이터를 보낼 수 있는 출력 통로 생성)
       //os.write('A'); // 실제로 데이터를 내보내는 작업 (1바이트만 출력)
       os.write('홍');// 1바이트만 출력
                      // '홍'의 유니코드값은 U+D64D (1101 0110 0100 1101
                      // 유니코드값 중 마지막 1바이트만 출력 (실제 출력은 0100 1101)
                      // 01001101 == 77 이므로 코드값 77인 문자 'M'이 출력된다
       byte[] bytes = "HelloWorld".getBytes(); // 한글자를 8비트로 모아서 저장해준다
       os.write(bytes); // byte[] 배열 전체를 출력
       os.write(bytes,0,5); // 인덱스 0부터 5개만 보낸다
      
      
      } catch (FileNotFoundException e) {
        System.out.println(file.getPath() + "파일을 찾을 수 없습니다."); // 파일 이름과 파일 경로가 다 나온다
      } catch (IOException e) {
        System.out.println("파일 출력에 오류가 발생했습니다.");
      } finally {
        try {
          if (os != null) {
            os.close();
          }
        } catch (IOException e2) {
          System.out.println("출력 스트림 종료 시 오류가 발생했습니다.");
        }
        
      }
   
    
    
    
    
  }
  
  public static void fileAppend() {
    // 파일 추가 모드 (기존 파일의 끝에 데이터를 추가한다. 기존 파일이 없다면 새로 생성한다)
    File file = new File("D:/storage", "test.dat");
    
    OutputStream os = null;
    
    try {
      os = new FileOutputStream(file, true); // true를 추가하면 파일 추가 모드가 된다
      os.write('!');
    } catch(Exception e) {
      e.printStackTrace();
    } finally {
      try {
        if (os != null) {
          os.close();
        }
      } catch (Exception e2) {
        e2.printStackTrace();
      }
    }
    
  }
 
  public static void tryWithResources() {
    // try-with-resources 문법 : try에서 생성한 자원 해제가 자동으로 이루어지는 문법 (close 생략)
    
    File file = new File("D:/storage/test.dat");
    
    // try가 생성한 os는 닫을 필요가 없어서 finally가 필요없다
    try(OutputStream os = new FileOutputStream(file, true)) {
      os.write('?');
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
  
  public static void bufferedOutputStream() {
    
    /*
     * java.io.BufferedOutputStream
     * 
     * 1. java.io.FileOutputStream 클래스의 하위 클래스
     * 2. 출력 스트림 기능에 내부 버퍼(대략 8KB)를 추가하여 출력 효율을 높인 클래스이다
     * 3. 내부 버퍼에 쌓인 출력 데이터는 내부 버퍼가 가득차거나/flush() 호출/close() 호출 시 한번에 출력된다
     * */
    
    File file = new File("D:/storage/test.dat");
    
    // 다른 스트림의 보조적 역할을 하는 보조스트림
    // 속도향상을 위해서 버퍼를 끼운다
    // true를 안넣으면 생성모드
    try(FileOutputStream fos = new FileOutputStream(file); 
        BufferedOutputStream bos = new BufferedOutputStream(fos)) {
      bos.write("Hello World".getBytes());
      
      
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
  
  public static void dataOutputStream() {
    
    /*
     * java.io.DataOutputStream
     * 
     * 1. 기본 타입(Primitive Type) 데이터와 문자열(String)을 이진(binary) 형태로 출력할 수 있도록 해주는
     * 2. 주요 메소드
     *    1) writeInt(int value)
     *    2) writeDouble(double value)
     *    3) writeUTF(String s) : UTF-8 인코딩으로 문자열 출력 (한글도 정상 출력 가능)
     * */
    
    File file = new File("D:/storage/test.bin");
    
    DataOutputStream dos = null;
    
    try {
      dos = new DataOutputStream(new BufferedOutputStream(new FileOutputStream(file)));
      
      // 기본 타입 출력
      dos.writeInt(12345);
      dos.writeDouble(67.89);
      
      // String 출력
      dos.writeUTF("안녕하세요. 난 Tom이라고 해. Nice to meet you!");
      
      dos.close();
    } catch (Exception e) {
      e.printStackTrace();
    } 
    
    
    
    
  }
  
  
  
  
  public static void main(String[] args) {
    
    //fileCreate();
    //fileAppend();
    //tryWithResources();
    //bufferedOutputStream();
    dataOutputStream();
  }
}
