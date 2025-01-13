public Class Baby {
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
  public abstract void setSpecial(int n) {
    saliva = n;
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
}
