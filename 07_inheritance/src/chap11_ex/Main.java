package chap11_ex;

public class Main {
	public static void main(String[] args) {
		
		 //----- 직사각형을 1개 생성합니다.
	    Rectangle rectangle = new Rectangle(4.5, 5.0);
		
	    //----- 직사각형의 너비, 높이, 넓이를 출력합니다.
	    System.out.println("직사각형의 너비: " + rectangle.getWidth() + "직사각형의 높이: " + rectangle.getHeight() + "넓이: " + rectangle.getArea());
	    
	    //----- 정사각형을 1개 생성합니다.
		Square square = new Square(3);
		square.setWidth(3.0);
		square.setHeight(3.0);
	    
	    //----- 정사각형의 너비, 높이, 넓이를 출력합니다.
		System.out.println("정사각형의 너비: " + square.getWidth() + "높이: " + square.getHeight() + "넓이: " + square.getArea());
		
		
		
		
		
	}

}
