import java.util.Random;
import java.util.ArrayList;
public abstract class Adventurer{
  private String name;
  private int HP, maxHP, resistance, dodge, dmgBoost, AttackMiss;
  private double odds;

  //Abstract methods are meant to be implemented in child classes.
  /*
  all adventurers must have a custom special
  consumable resource (mana/rage/money/witts etc)
  */

  //give it a short name (fewer than 13 characters)
  public abstract String getSpecialName();
  //accessor methods
  public abstract int getSpecial();
  public abstract int getSpecialMax();
  public abstract void setSpecial(int n);

  //concrete method written using abstract methods.
  //refill special resource by amount, but only up to at most getSpecialMax()
  public int restoreSpecial(int n){
    if( n > getSpecialMax() - getSpecial()){
      n = getSpecialMax() - getSpecial();
    }
    setSpecial(getSpecial()+n);
    return n;
  }

  /*
  all adventurers must have a way to attack enemies and
  support their allys
  */
  //hurt or hinder the target adventurer
  public abstract String attack(Adventurer other);

  /*This is an example of an improvement that you can make to allow
   * for more flexible targetting.
   */
  //heal or buff the party
  public abstract String support(ArrayList<Adventurer> others);

  //heal or buff the target adventurer
  //public abstract String support(Adventurer other);

  //heal or buff self
  public abstract String support();

  //hurt or hinder the target adventurer, consume some special resource
  public abstract String specialAttack(Adventurer other);

  /*
  standard methods
  */
  public void applyReducedDamage(int rounds){
    this.resistance = rounds;
  }
  public void dodge(int rounds, double chance){
    dodge = rounds;
    odds = chance;
  }
  public void applyDodge(Adventurer other, int rounds, double chance){
    other.dodge(rounds, chance);
  }
  public void boostDamage(int rounds){
    dmgBoost = rounds;
  }
  public int getdmgBoost() {
    return dmgBoost;
  }
  public void AttackMiss(int rounds){
    AttackMiss = rounds;
  }
  public int applyDamage(int amount){
    if(dodge != 0) {
      dodge--;
      if (!(Math.random() < odds)) {
        return 0;
      }
    }
    if(resistance != 0) {
      this.HP -= (int)(amount * 0.5);
      if(this.HP < 0){this.HP = 0;}
      resistance--;
      return (int)(amount * 0.5);
    }
    this.HP -= amount;
    if(this.HP < 0){this.HP = 0;}
    return amount;
  }

  public int attack(Adventurer other, int amount){
    int damage = 0;
    if( (AttackMiss == 0)){
      damage = other.applyDamage(amount);
    }
    else if (!(Math.random() < 0.75)){
      damage = other.applyDamage(amount);
    }
    return damage;
  }

  //You did it wrong if this happens.
  public Adventurer(){
    this("Lester-the-noArg-constructor-string");
  }

  public Adventurer(String name){
    this(name, 10);
  }

  public Adventurer(String name, int hp){
    this.name = name;
    this.HP = hp;
    this.maxHP = hp;
    this.dmgBoost = 0;
    this.dodge = 0;
    this.resistance = 0;
    this.odds = 0.0;
  }

  //toString method
  public String toString(){
    return this.getName();
  }

  //Get Methods
  public String getName(){
    return name;
  }

  public int getHP(){
    return HP;
  }

  public int getmaxHP(){
    return maxHP;
  }
  public void setmaxHP(int newMax){
    maxHP = newMax;
  }

  //Set Methods
  public void setHP(int health){
    this.HP = health;
  }

  public void setName(String s){
    this.name = s;
  }
}
