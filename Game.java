import java.util.*;
public class Game{
  private static final int WIDTH = 80;
  private static final int HEIGHT = 30;
  private static final int BORDER_COLOR = Text.BLACK;
  private static final int BORDER_BACKGROUND = Text.WHITE + Text.BACKGROUND;

  public static void main(String[] args) {
    run();
  }

  //Display the borders of your screen that will not change.
  //Do not write over the blank areas where text will appear or parties will appear.
  public static void drawBackground(){
    //this needs to be 02500 but it doesnt work for some reason
    //String dash = "\u0250";
    Text.go(1, 1);
    for (int i = 0; i < 79; i++) {
      System.out.print(Text.colorize("+", BORDER_COLOR, BORDER_BACKGROUND));
    }
    for (int i = 1; i < 30; i++) {
      Text.go(i, 1);
      System.out.print(Text.colorize("+", BORDER_COLOR, BORDER_BACKGROUND));
      Text.go(i, 81);
      System.out.print(Text.colorize("+", BORDER_COLOR, BORDER_BACKGROUND));
    }
    Text.go(29, 1);
    for (int i = 0; i < 80; i++) {
      System.out.print(Text.colorize("+", BORDER_COLOR, BORDER_BACKGROUND));
    }
    Text.go(6, 1);
    for (int i = 0; i < 80; i++) {
      System.out.print(Text.colorize("+", BORDER_COLOR, BORDER_BACKGROUND));
    }
    Text.go(24, 1);
    for (int i = 0; i < 80; i++) {
      System.out.print(Text.colorize("+", BORDER_COLOR, BORDER_BACKGROUND));
    }
    for (int i = 2; i < 6; i++) {
      Text.go(i, 27);
      System.out.print(Text.colorize("+", BORDER_COLOR, BORDER_BACKGROUND));
      Text.go(i, 53);
      System.out.print(Text.colorize("+", BORDER_COLOR, BORDER_BACKGROUND));
      Text.go(i + 23, 27);
      System.out.print(Text.colorize("+", BORDER_COLOR, BORDER_BACKGROUND));
      Text.go(i + 23, 53);
      System.out.print(Text.colorize("+", BORDER_COLOR, BORDER_BACKGROUND));
    }
  }

  //Display a line of text starting at
  //(columns and rows start at 1 (not zero) in the terminal)
  //use this method in your other text drawing methods to make things simpler.
  public static void drawText(String s,int startRow, int startCol){
    Text.go(startRow, startCol);
    System.out.print(s);
  }

  /*Use this method to place text on the screen at a particular location.
  *When the length of the text exceeds width, continue on the next line
  *for up to height lines.
  *All remaining locations in the text box should be written with spaces to
  *clear previously written text.
  *@param row the row to start the top left corner of the text box.
  *@param col the column to start the top left corner of the text box.
  *@param width the number of characters per row
  *@param height the number of rows
  */
  public static void TextBox(int row, int col, int width, int height, String text){
    //separates the text into individual words
    String[] words = text.split(" ");
    //dashes are here for testing, replace with spaces for final
    String empty = " --------------------------------------------------------".substring(0, width);
    // tested this for loop, it works properly
    for (int i = 0; i < height; i++) {
      drawText(empty, row + i, col);
    }
    String line = "";
    String testLine = "";
    for (int i = 0; i < words.length; i++) {
      if (testLine.equals("")) {
        testLine = words[i];
      }
      else {
        testLine = line + " " + words[i];
      }
      if (testLine.length() <= width) {
        if (line.equals("")) {
          line = words[i];
        }
        else {
          line = line + " " + words[i];
        }
        if (i == words.length - 1) {
          drawText(line, row, col);
        }
      }
      else {
        drawText(line, row, col);
        row++;
        line = "";
        testLine = "";
        i--;
      }
    }
  }




    //return a random adventurer (choose between all available subclasses)
    //feel free to overload this method to allow specific names/stats.
    public static Adventurer createRandomAdventurer(){
      int n = (int)(Math.random() * 4);
      if (n == 0) {
        return new Grandma("grandma");
        //these return statements are placeholders until the other classes are made
      }
      else if (n == 1) {
        return new MiddleAgedMan("middle aged man");
      }
      else {
        return new Baby("baby");
      }
    }

    /*Display a List of 2-4 adventurers on the rows row through row+3 (4 rows max)
    *Should include Name HP and Special on 3 separate lines.
    *Note there is one blank row reserved for your use if you choose.
    *Format:
    *Bob          Amy        Jun
    *HP: 10       HP: 15     HP:19
    *Caffeine: 20 Mana: 10   Snark: 1
    * ***THIS ROW INTENTIONALLY LEFT BLANK***
    */
    public static void drawParty(ArrayList<Adventurer> party,int startRow){
      TextBox(startRow, 2, 25, 1, party.get(0).getName());
      TextBox(startRow + 1, 2, 25, 1, "HP: " + party.get(0).getHP());
      TextBox(startRow + 2, 2, 25, 1, party.get(0).getSpecialName() + ": " + party.get(0).getSpecial() + "/" + party.get(0).getSpecialMax());

      TextBox(startRow, 28, 25, 1, party.get(1).getName());
      TextBox(startRow + 1, 28, 25, 1, "HP: " + party.get(1).getHP());
      TextBox(startRow + 2, 28, 25, 1, party.get(1).getSpecialName() + ": " + party.get(1).getSpecial() + "/" + party.get(1).getSpecialMax());

      TextBox(startRow, 54, 26, 1, party.get(2).getName());
      TextBox(startRow + 1, 54, 26, 1, "HP: " + party.get(2).getHP());
      TextBox(startRow + 2, 54, 26, 1, party.get(2).getSpecialName() + ": " + party.get(2).getSpecial() + "/" + party.get(2).getSpecialMax());
    }


  //Use this to create a colorized number string based on the % compared to the max value.
  public static String colorByPercent(int hp, int maxHP){
    String output = String.format("%2s", hp+"")+"/"+String.format("%2s", maxHP+"");
    //COLORIZE THE OUTPUT IF HIGH/LOW:
    // under 25% : red
    // under 75% : yellow
    // otherwise : white
    if (hp < maxHP / 4.0) {
      output = "\u001b[" + Text.RED + "m"+ output +"\u001b[0m";
    }
    else if (hp < maxHP * 3 / 4.0) {
      output = "\u001b[" + Text.YELLOW + "m"+ output +"\u001b[0m";
    }
    return output;
  }





  //Display the party and enemies
  //Do not write over the blank areas where text will appear.
  //Place the cursor at the place where the user will by typing their input at the end of this method.
  public static void drawScreen(ArrayList<Adventurer> party, ArrayList<Adventurer> enemies){

    //draw player party
    drawParty(party, 2);
    //draw enemy party
    drawParty(enemies, 25);
    Text.go(30, 1);
  }

  public static String userInput(Scanner in){
      //Move cursor to prompt location

      //show cursor

      String input = in.nextLine();

      //clear the text that was written

      return input;
  }

  public static void quit(){
    Text.reset();
    Text.showCursor();
    Text.go(32,1);
  }

  public static void run(){
    //Clear and initialize
    Text.hideCursor();
    Text.clear();


    //Things to attack:
    //Make an ArrayList of Adventurers and add 1-3 enemies to it.
    //If only 1 enemy is added it should be the boss class.
    //start with 1 boss and modify the code to allow 2-3 adventurers later.
    ArrayList<Adventurer>enemies = new ArrayList<Adventurer>();
    int PartySize = (Math.random() * 3) + 1;
    if(PartySize == 1){
      enemies.add(Death());
    }
    else{
      while( PartySize > 0){
        PartySize --;
        enemies.add(createRandomAdventurer());
      }
    }
    //Adventurers you control:
    //Make an ArrayList of Adventurers and add 2-4 Adventurers to it.
    ArrayList<Adventurer> party = new ArrayList<>();
    for(int i = 0; i < 3; i++){
      party.add(createRandomAdventurer());
    }

    boolean partyTurn = true;
    int whichPlayer = 0;
    int whichOpponent = 0;
    int turn = 0;
    String input = "";//blank to get into the main loop.
    Scanner in = new Scanner(System.in);
    //Draw the window border
    drawBackground();

    //You can add parameters to draw screen!
    drawScreen(party, enemies);
    //initial state.

    //Main loop

    //display this prompt at the start of the game.
    String preprompt = "Enter command for "+party.get(whichPlayer)+": attack/special/quit";

    while(! (input.equalsIgnoreCase("q") || input.equalsIgnoreCase("quit"))){
      //Read user input
      input = userInput(in);

      //example debug statment
      TextBox(24,2,1,78,"input: "+input+" partyTurn:"+partyTurn+ " whichPlayer="+whichPlayer+ " whichOpp="+whichOpponent );

      //display event based on last turn's input
      if(partyTurn){

        //Process user input for the last Adventurer:
        if(input.equals("attack") || input.equals("a")){
          /*>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>*/
          //YOUR CODE HERE
          /*<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<*/
        }
        else if(input.equals("special") || input.equals("sp")){
          /*>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>*/
          //YOUR CODE HERE
          /*<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<*/
        }
        else if(input.startsWith("su ") || input.startsWith("support ")){
          //"support 0" or "su 0" or "su 2" etc.
          //assume the value that follows su  is an integer.
          /*>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>*/
          //YOUR CODE HERE
          /*<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<*/
        }

        //You should decide when you want to re-ask for user input
        //If no errors:
        whichPlayer++;


        if(whichPlayer < party.size()){
          //This is a player turn.
          //Decide where to draw the following prompt:
          String prompt = "Enter command for "+party.get(whichPlayer)+": attack/special/quit";


        }else{
          //This is after the player's turn, and allows the user to see the enemy turn
          //Decide where to draw the following prompt:
          String prompt = "press enter to see monster's turn";

          partyTurn = false;
          whichOpponent = 0;
        }
        //done with one party member
      }else{
        //not the party turn!


        //enemy attacks a randomly chosen person with a randomly chosen attack.z`
        //Enemy action choices go here!
        /*>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>*/
        //YOUR CODE HERE
        /*<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<*/


        //Decide where to draw the following prompt:
        String prompt = "press enter to see next turn";

        whichOpponent++;

      }//end of one enemy.

      //modify this if statement.
      if(!partyTurn && whichOpponent >= enemies.size()){
        //THIS BLOCK IS TO END THE ENEMY TURN
        //It only triggers after the last enemy goes.
        whichPlayer = 0;
        turn++;
        partyTurn=true;
        //display this prompt before player's turn
        String prompt = "Enter command for "+party.get(whichPlayer)+": attack/special/quit";
      }

      //display the updated screen after input has been processed.
      drawScreen(party, enemies);


    }//end of main game loop


    //After quit reset things:
    quit();
  }
}
