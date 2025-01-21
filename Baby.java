import java.util.ArrayList;
public class Baby extends Adventurer{
  int saliva, salivaMax;

  //constructors
  public Baby(String name, int hp){
    super(name,hp);
    salivaMax = 6;
    saliva = 6;
  }

  public Baby(String name){
    this(name,18);
  }

  public Baby(){
    this("Daniel");
  }

  //accessor methods
  public String getSpecialName() {
    return "saliva";
  }
  public int getSpecial() {
    return saliva;
  }
  public int getSpecialMax() {
    return salivaMax;
  }
  public void setSpecial(int n) {
    saliva = n;
  }

  public String attack(Adventurer other){
    int damage = 6;
    attack(other, damage);//other.applyDamage(damage);
    return this + " bit " + other + " and dealt " + damage + " damage.";
  }

  public String support(ArrayList<Adventurer> team){
    String returnString = this + " cries loudly and";
    for(Adventurer teammate : team)
    {
      teammate.boostDamage(1);
      returnString += " boosts " + teammate +"'s damage by 1.5x";
    }
    return returnString;
  }

  //heal or buff the target adventurer
  //public abstract String support(Adventurer other);

  //heal or buff self
  public String support(){
    dodge(1, 0.80);
    return "The baby crawls and has an 80% chance to dodge";
  }

  public String specialAttack(Adventurer other){
    saliva --;
    int damage = 4;
    attack(other, damage);
    other.AttackMiss(2);
    //Im not sure how to implement possible miss
    return "";
  }
}
