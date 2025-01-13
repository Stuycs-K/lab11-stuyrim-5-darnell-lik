import java.util.*;
public class MiddleAgedMan extends Adventurer{
  int caffeine, caffeineMax;

  /*the other constructors ultimately call the constructor
  *with all parameters.*/
  public MiddleAgedMan(String name, int hp){
    super(name,hp);
    caffeineMax = 5;
    caffeine = 5;
    preferredLanguage = language;
  }

  public MiddleAgedMan(String name){
    this(name, 30);
  }

  public MiddleAgedMan(){
    this("Default");
  }

  /*The next 8 methods are all required because they are abstract:*/
  public String getSpecialName(){
    return "Hot Coffee";
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
    other.applyDamage(damage);
    return this + " attacked "+ other + " and dealt "+ damage + " points of damage";
  }

  public String specialAttack(Adventurer other){
    if(getSpecial() != 0){
      restoreSpecial(-1);
      int damage = 4;
      other.applyDamage(damage);
      return this + " spilled coffee on "+other+ " dealing "+ damage +" points of damage and skipping their next turn!";
    }else{
      return "Not enough coffee to spill. Instead " + attack(other);
    }

  }

  public String support(Adventurer other){
    String result = this + "works overtime to help his team dealing 6 damage to himself but makes each teamates take 50% less damage";
    for(other : others)
    {
      other.applyReducedDamage();
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
