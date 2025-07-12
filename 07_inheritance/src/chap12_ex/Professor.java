package chap12_ex;

public class Professor extends Person {
	private String major;
	
	public Professor() {}

	public Professor(String name, int age, String tel, String major) {
		super(name, age, tel);
		this.major = major;
	}
	
	public String getMajor() {
		return major;
	}

	public void setMajor(String major) {
		this.major = major;
	}

	@Override
	public String toString() {
		return super.toString();
	}
}
