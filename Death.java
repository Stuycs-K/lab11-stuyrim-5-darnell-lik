import java.util.*;
public class Death extends Adventurer{
  int graveyard, graveyardMax;

  public Death(String name, int hp){
    super(name,hp);
    graveyardMax = 15;
    graveyard = 3;
  }

  public Death(String name){
    this(name, 30);
  }

  public Death(){
    this("Hades");
  }

  public String getSpecialName(){
    return "graveyard";
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
    int damage = (int) (Math.random() * 5 )+ 6;
    attack(other, damage);//other.applyDamage(damage);
    return this + " attacked "+ other + " and dealt "+ damage + " points of damage";
  }

  public String specialAttack(Adventurer other){
    int souls = (getSpecial() >= 3) ? Math.random() + 1 * (((getSpecial() - getSpecial() % 3) / 3 )+ 1):0;
    restoreSpecial(-souls * 3);
    String temp = attack(other, damage + souls);//other.applyDamage(damage);
    return this + "called" + (souls * 3) + "souls from his graveyard dealing an extra "+ souls +"points of damage" + temp;
  }

/*  public String support(ArrayList<Adventurer> others){
  }
  */

  public String support(){
    int souls = (getSpecial() >= 5) ? Math.random() + 1 * (((getSpecial() - getSpecial() % 5) / 5 )+ 1):0;
    setHP(getHP()+10*souls);
    restoreSpecial(-souls * 5);
    return this+" eats" + souls * 5 + "souls to heal" + 10 * souls +" HP";
  }
}
