import java.util.*;
public class Death extends Adventurer{
  int graveyard, graveyardMax;

  public Death(String name, int hp){
    super(name,hp);
    graveyardMax = 5000;
    graveyard = 105;
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
    int souls = (graveyard >= 3) ? Math.random() + 1 * (((graveyard - graveyard % 3) / 3 )+ 1):0;
    restoreSpecial(-souls * 3);
    String temp = attack(other, damage + souls);//other.applyDamage(damage);
    return this + "called" + (souls * 3) + "souls from his graveyard dealing an extra "+ souls +"points of damage" + temp;
  }

/*  public String support(ArrayList<Adventurer> others){
  }
  */

  public String support(){
    int hp = 8;
    setHP(getHP()+hp);
    if(getSpecial() != 0) restoreSpecial(-1);
    return this+" drinks a coffee and heals " +hp+" HP";
  }
}
