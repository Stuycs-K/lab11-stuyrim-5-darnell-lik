import java.util.*;
public class MiddleAgedMan extends Adventurer{
  int caffeine, caffeineMax;

  /*the other constructors ultimately call the constructor
  *with all parameters.*/
  public MiddleAgedMan(String name, int hp){
    super(name,hp);
    caffeineMax = 5;
    caffeine = 5;
  }

  public MiddleAgedMan(String name){
    this(name, 25);
  }

  public MiddleAgedMan(){
    this("Jim");
  }

  /*The next 8 methods are all required because they are abstract:*/
  public String getSpecialName(){
    return "caffeine";
  }

  public int getSpecial(){
    return caffeine;
  }

  public void setSpecial(int n){
    caffeine = n;
  }

  public int getSpecialMax(){
    return caffeineMax;
  }

  public String attack(Adventurer other){
    int damage = 4;
    if (this.getdmgBoost() != 0) {
      damage = attack(other, (int)(4 * 1.5));
    }
    else {
      damage = attack(other, 4);
    }
    return this + " attacked "+ other + " and dealt "+ damage + " points of damage";
  }

  public String specialAttack(Adventurer other){
    if(getSpecial() != 0){
      restoreSpecial(-1);
      int damage = 8;
      if (this.getdmgBoost() != 0) {
        damage = attack(other, (int)(8 * 1.5));
      }
      else {
        damage = attack(other, 8);
      }
      return this + " spilled coffee on " + other + ", dealing " + damage + " points of damage!";
    }else{
      return "Not enough coffee to spill. Instead " + attack(other);
    }

  }

  public String support(ArrayList<Adventurer> others){
    String result = this + "works overtime to help his team dealing 6 damage to himself but makes each teammate take 50% less damage";
    for(int i = 0; i < others.size(); i++){
      others.get(i).applyReducedDamage(1);
    }
    return result;
  }

  public String support(){
    int hp = 8;
    setHP(getHP()+hp);
    if(getSpecial() != 0) restoreSpecial(-1);
    return this+" drinks a coffee and heals " +hp+" HP";
  }
}
