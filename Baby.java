import java.util.ArrayList;
public class Baby extends Adventurer{
  int saliva, salivaMax;
  //give it a short name (fewer than 13 characters)
  public String getSpecialName() {
    return "saliva";
  }
  //accessor methods
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
    other.applyDamage(damage);
    return this + " bit " + other + " and dealt " + damage + " damage.";
  }

  public String support(ArrayList<Adventurer> team, ArrayList<Adventurer> enemies){
    String returnString = this + "cries loudly and";
    for(Adventurer teammate : team)
    {
      teammate.boostDamage(1);
      returnString += "boosts " + teammate +"'s damage by 1.5x";
    }
    returnString += "and ";
    for(Adventurer enemy : enemies)
    {
      enemy.applyReducedDamage(1);
      returnString += "reduced " + enemies +"'s damage by 0.5x";
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
    other.applyDamage(damage);
    //Im not sure how to implement possible miss
  }
}
