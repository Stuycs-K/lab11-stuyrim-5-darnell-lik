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
    for (int i = 0; i < 80; i++) {
      System.out.print(Text.colorize("+", BORDER_COLOR, BORDER_BACKGROUND));
    }
    for (int i = 1; i < 28; i++) {
      Text.go(i, 1);
      System.out.print(Text.colorize("+", BORDER_COLOR, BORDER_BACKGROUND));
      Text.go(i, 81);
      System.out.print(Text.colorize("+", BORDER_COLOR, BORDER_BACKGROUND));
    }
    Text.go(27, 1);
    for (int i = 0; i < 80; i++) {
      System.out.print(Text.colorize("+", BORDER_COLOR, BORDER_BACKGROUND));
    }
    Text.go(6, 1);
    for (int i = 0; i < 80; i++) {
      System.out.print(Text.colorize("+", BORDER_COLOR, BORDER_BACKGROUND));
    }
    Text.go(22, 1);
    for (int i = 0; i < 80; i++) {
      System.out.print(Text.colorize("+", BORDER_COLOR, BORDER_BACKGROUND));
    }
    for (int i = 2; i < 6; i++) {
      Text.go(i, 27);
      System.out.print(Text.colorize("+", BORDER_COLOR, BORDER_BACKGROUND));
      Text.go(i, 53);
      System.out.print(Text.colorize("+", BORDER_COLOR, BORDER_BACKGROUND));
      Text.go(i + 21, 27);
      System.out.print(Text.colorize("+", BORDER_COLOR, BORDER_BACKGROUND));
      Text.go(i + 21, 53);
      System.out.print(Text.colorize("+", BORDER_COLOR, BORDER_BACKGROUND));
    }
    //DRAW MIDLINE
    for(int i =0; i < 15; i ++){
      Text.go(7 + i,41);
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
      int n = (int)(Math.random() * 3);
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
      int q = 0;
      for(int i = 0; i < party.size(); i ++)
      {
        if(i == 2){
          q = 2;
        }
        TextBox(startRow, 2 + (i * 26), 25 + q, 1, party.get(i).getName());
        TextBox(startRow + 1, 2 + (i * 26), 25 + q, 1, "HP: " + party.get(i).getHP());
        TextBox(startRow + 2, 2 + (i * 26), 25 + q, 1, party.get(i).getSpecialName() + ": " + party.get(i).getSpecial() + "/" + party.get(i).getSpecialMax());
        //TextBox(startRow + 3, 2 + (i * 26), 25 + q, 1, );
        //this last row will show status conditions
      }
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
    drawParty(party, 23);
    //draw enemy party
    drawParty(enemies, 2);
    Text.go(29, 1);
  }

  public static String userInput(Scanner in){
      //Move cursor to prompt location
      Text.go(29, 1);
      //show cursor
      Text.showCursor();
      String input = in.nextLine();
      //clear the text that was written
      Text.go(29,1);
      Text.clearLine();
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
    int PartySize = (int)((Math.random() * 3) + 1);
    if(PartySize == 1){
      enemies.add(new Death("death"));
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
    String preprompt = "Enter command for "+party.get(whichPlayer)+": attack/special/quit:";

    while(! (input.equalsIgnoreCase("q") || input.equalsIgnoreCase("quit"))){
      drawText(preprompt, 28, 1);
      Text.go(29, 1);

      //Read user input
      input = userInput(in);

      //example debug statment
      //TextBox(24,2,1,78,"input: "+input+" partyTurn:"+partyTurn+ " whichPlayer="+whichPlayer+ " whichOpp="+whichOpponent );

      //display event based on last turn's input
      if(partyTurn){

        //Process user input for the last Adventurer:
        String reprompt = "Invalid input, re-enter your action for " + party.get(whichPlayer).toString();
        String[] inputs = input.split(" ");
        try {
          while (true) {
            if (inputs.length == 2 && (input.startsWith("attack ") || input.startsWith("a ") || input.startsWith("special ") || input.startsWith("sp ") || input.startsWith("su ") || input.startsWith("support ")))
            {
              try {
                  int index = Integer.parseInt(inputs[1]);
                  if (index < enemies.size()) {
                      break;
                  }
              } catch (NumberFormatException ex) {}
            }
            drawText(reprompt, 29, 1);
            Text.go(30, 1);
            Text.clearLine();
            input = userInput(in);
            inputs = input.split(" ");
          }
        }catch (Exception e) {}
        int target = Integer.parseInt(inputs[1]);

        target = Integer.parseInt(inputs[1]);

        if(input.startsWith("attack ") || input.startsWith("a ")){
          Text.go(30, 1);
          System.out.print(whichPlayer);
          TextBox(7 + (whichPlayer * 3), 2, 39, 15 - (whichPlayer * 3), party.get(whichPlayer).attack(enemies.get(target)));
        }
        else if(input.startsWith("special ") || input.startsWith("sp ")){
          TextBox(7 + (whichPlayer * 3), 2, 39, 15- (whichPlayer * 3), party.get(whichPlayer).specialAttack(enemies.get(target)));
        }
        else if(input.startsWith("su ") || input.startsWith("support ")){
          //"support 0" or "su 0" or "su 2" etc.
          //assume the value that follows su  is an integer.
          if (target == 0) {
            TextBox(7 + (whichPlayer * 3), 2, 39, 15- (whichPlayer * 3), party.get(whichPlayer).support());
          }
          else {
            TextBox(7 + (whichPlayer * 3), 2, 39, 15- (whichPlayer * 3), party.get(whichPlayer).support(party));
          }
        }
        else {
          drawText("something went wrong", 29, 1);
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
        switch ((int) Math.random() * 4){
          case 0:
            TextBox(7 + (whichOpponent * 4), 42, 39, 15 - (whichOpponent * 4), enemies.get(whichOpponent).attack(party.get((int)(Math.random() * 3))));
            break;
          case 1:
            TextBox(7 + (whichOpponent * 4), 42, 39, 15 - (whichOpponent * 4), enemies.get(whichOpponent).specialAttack(party.get((int)(Math.random() * 3))));
            break;
          case 2:
            TextBox(7 + (whichOpponent * 4), 42, 39, 15 - (whichOpponent * 4), enemies.get(whichOpponent).support(enemies));
            break;
          case 3:
            TextBox(7 + (whichOpponent * 4), 42, 39, 15 - (whichOpponent * 4), enemies.get(whichOpponent).support());
            break;
        }

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
