import java.util.ArrayList;
public class Grandma extends Adventurer{
  int cookies, cookieMax;

  //constructors

  public Grandma(String name, int hp){
    super(name,hp);
    cookieMax = 4;
    cookies = 0;
  }

  public Grandma(String name){
    this(name,15);
  }

  public Grandma(){
    this("Heather");
  }

  //accessor methods
  public String getSpecialName() {
    return "cookies";
  }
  public int getSpecial() {
    return cookies;
  }
  public int getSpecialMax() {
    return cookieMax;
  }
  public void setSpecial(int n) {
    cookies = n;
  }


  //actions

  //Deals 8 damage
  public String attack(Adventurer other) {
    int damage = 8;
    other.applyDamage(damage);
    return this + " hit " + other + " with their rolling pin and dealt " + damage + " damage.";
  }

  //tells last words
  public String support(ArrayList<Adventurer> others) {
    int chance = (int)(Math.random() * 4);
    if (chance == 0) {
      for (int i = 0; i < others.size(); i++) {
        
      }
    }
    else {

    }
  }

  //heal or buff self
  public abstract String support();

  //hurt or hinder the target adventurer, consume some special resource
  public abstract String specialAttack(Adventurer other);
}
