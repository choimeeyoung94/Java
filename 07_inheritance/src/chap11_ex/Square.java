package chap11_ex;

public class Square extends Rectangle {
	private double side;
	
	public Square() {
		
	}

	// 정사각형의 한 변의 정보 전달
	public Square(double side) {
		this.side = side;
	}
	
	public double getSide() {
		return side;
	}

	public void setSide(double side) {
		this.side = side;
	}

	@Override
	public double getArea() {
		return this.side * this.side;
	}

	@Override
	public double getWidth() {
		// TODO Auto-generated method stub
		return super.getWidth();
	}

	@Override
	public double getHeight() {
		// TODO Auto-generated method stub
		return super.getHeight();
	}
}
