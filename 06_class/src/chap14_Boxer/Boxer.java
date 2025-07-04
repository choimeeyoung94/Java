package chap14_Boxer;

public class Boxer {

  private String name;  //------- 이름
  private int energy;  //-------- 에너지
  private int power;  //--------- 파워
  
  public Boxer(String name, int energy, int power) {
    super();
    this.name = name;
    this.energy = energy;
    this.power = power;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getEnergy() {
    return energy;
  }

  public void setEnergy(int energy) {
    this.energy = energy;
  }

  public int getPower() {
    return power;
  }

  public void setPower(int power) {
    this.power = power;
  }
  
  /**
   * 펀치 메소드입니다. 내가 가진 power만큼 상대 energy가 줄어듭니다.
   * 상대의 energy는 0 아래로 떨어질 수는 없습니다.
   * 상대를 아무리 많이 때려도 내 energy는 줄어들지 않습니다.
   * @param other 상대 복서(Boxer) 객체입니다.
   */
  public void punch(Boxer other) {
   if (other.getEnergy() < 0) {
     System.out.println("상대의 energy는 0 아래로 떨어질 수 없습니다.");
   }
 
   other.setEnergy(other.getEnergy() - this.getPower());
   System.out.println("boxer2: " + this.getName() + " " + this.getEnergy());
   System.out.println("boxer1: " + other.getName() + " " + other.getEnergy());
  }
  
}
