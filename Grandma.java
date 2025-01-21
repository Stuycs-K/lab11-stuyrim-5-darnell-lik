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
    int damage;
    if (this.getdmgBoost() != 0) {
      damage = attack(other, (int)(8 * 1.5));
    }
    else {
      damage = attack(other, 8);
    }
    return this + " hit " + other + " with their rolling pin and dealt " + damage + " damage.";
  }

  //tells last words
  public String support(ArrayList<Adventurer> allies) {
    int chance = (int)(Math.random() * 4);
    if (chance == 0) {
      setHP(0);
      for (int i = 0; i < allies.size(); i++) {
        //give allies resistance and dmgBoost
      }
    }
    else {
      //give allies dmgBoost
    }
    //placeholder
    return "";
  }

  //bake cookies to heal 4 and gain 1 sp
  public String support() {
    int hp = 4;
    setHP(getHP()+hp);
    return this + " baked cookies to restore " + hp + " hp and stored " + restoreSpecial(1) + "cookie(s) in reserve.";
  }

  //consume all cookies to deal sp * 4 damage
  public String specialAttack(Adventurer other) {
    int damage = getSpecial() * 4;
    attack(other, damage);//other.applyDamage(damage);
    setSpecial(0);
    return this + " went into a frenzy after consuming their cookies in reserve to deal " + damage + " damage!";
  }
}
