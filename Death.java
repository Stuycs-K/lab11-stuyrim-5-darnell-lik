import java.util.ArrayList;
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
    return graveyard;
  }

  public void setSpecial(int n){
    graveyard = n;
  }

  public int getSpecialMax(){
    return graveyardMax;
  }

  public String attack(Adventurer other){
    int damage = (int) (Math.random() * 5 )+ 6;
    attack(other, damage);//other.applyDamage(damage);
    return this + " attacked "+ other + " and dealt "+ damage + " points of damage";
  }

  public String specialAttack(Adventurer other){
    if(getSpecial() >= 3)
    {
      int souls = ((int) Math.random() + 1) * (((getSpecial() - getSpecial() % 3) / 3 )+ 1);
      restoreSpecial(-souls * 3);
      int damage = (int) (Math.random() * 5 )+ 6;
      attack(other, damage + souls);//other.applyDamage(damage);
      return this + "attacked" + other +  " and summoned " + souls + "souls from his graveyard dealing an extra " + (souls * 3) + "points of damage on top of" + damage;
    }
    else{
      return "Not enough Souls. Instead " + attack(other);
    }
  }

/*  public String support(ArrayList<Adventurer> others){
  }
  */

  public String support(){
    if(getSpecial() >= 3)
    {
      int souls = (getSpecial() >= 5) ? ((int)Math.random() + 1) * (((getSpecial() - getSpecial() % 5) / 5 )+ 1):0;
      setHP(getHP()+10*souls);
      restoreSpecial(-souls * 5);
      return this+" eats" + souls * 5 + "souls to heal" + 10 * souls +" HP";
    }
    else{
      setHP(getHP() + 5);
      restoreSpecial(-graveyard);
      return "Not enough souls in graveyard, all are sacrificed and 5 HP is gained";
    }
  }

  public String support(ArrayList<Adventurer> team){
    return "THIS SHOULD NOT HAPPEN - DEATH HAS NO TEAM TO SUPPORT";
  }
}
