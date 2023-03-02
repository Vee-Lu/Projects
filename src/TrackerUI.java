import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.zip.DataFormatException;

public class TrackerUI {
    private int caloricIntake;
    private boolean aboveIntake;
    private CalorieTracker calorieTracker;
    Scanner scanner;

    public TrackerUI(Scanner scanner){
        this.scanner = scanner;
        this.caloricIntake = 0;
        this.aboveIntake = false;
        this.calorieTracker = new CalorieTracker(new ArrayList<Food> ());
    }

    public String showMenu(){
        String menu = "What would you like to do?: \n" +
                      "[B- <Food name>: Food to add to breakfast]\n" +
                      "[L- <Food name>: Food to add to lunch]\n" +
                      "[D- <Food name>: Food to add to dinner]\n" +
                      "[S- <Food name>: Food to add to snack]\n" +
                      "[R- <Food name>: Food to remove from the calorie tracker]\n" +
                      "[E- <Food name>: Food to edit from the food log]\n" +
                      "[P: To print all the foods logged in the tracker\n" +
                      "[P-b: To print all the breakfast foods logged in the tracker\n" +
                      "[P-l: To print all the lunch foods logged in the tracker\n" +
                      "[P-d: To print all the dinner foods logged in the tracker\n" +
                      "[P-s: To print all the snacks foods logged in the tracker\n" +
                      "[Q: To exit out of the application]";
        return menu;
    }

    public void runApplication()  {
        //Set the caloric intake
        this.caloricIntake = setCaloricIntake();

        //Initiate the scanner
        scanner = new Scanner(System.in);

        //Print the menu
        System.out.println(this.showMenu());

        //Prompt user to enter input
        System.out.println("Enter your input: ");

        //Read the input's entire line
        String input = scanner.nextLine();


        //While the input does not equal "Q";
        while(!input.equals("Q")){
            //Remove any whitespace in the input
            input = removeWhiteSpace(input);
            System.out.println("Remove white space: " + input);
            //If the input starts with "B" and is succeeded (index 1) by "-"
          if(input.startsWith("B") && input.charAt(1) == '-'){
              //Get the name of the food starting at the index +1 of "-" to the end of the input's length
              String name = input.substring(input.indexOf("-")+1);
              System.out.println("Food to add: " + name);
              //,input.length()

              try {
                  //Adds a breakfast item to the food log
                  addBreakfast(name);
              }  catch (InputMismatchException i) {
                  System.out.println(i.getMessage());

              } catch (IllegalArgumentException i){
                  System.out.println(i.getMessage());
                  pause();
              }

              //If the input starts with "L" and is succeeded (index 1) by "-"
          } else if(input.startsWith("L") && input.charAt(1) == '-'){
              //Get the name of the food starting at the index +1 of "-" to the end of the input's length
              String name = input.substring(input.indexOf("-")+1);
              System.out.println("Food to add: " + name);
              //,input.length()

                  try {
                      //Adds a lunch item to the food log
                      addLunch(name);
                  }  catch (InputMismatchException e) {
                      System.out.println(e.getMessage());

                  } catch (IllegalArgumentException i){
                      System.out.println(i.getMessage());
                      pause();
                  }


              //If the input starts with "D" and is succeeded (index 1) by "-"
              } else if (input.startsWith("D") && input.charAt(1) == '-'){
              //Get the name of the food starting at the index +1 of "-" to the end of the input's length
              String name = input.substring(input.indexOf("-")+1);
              System.out.println("Food to add: " + name);
              //,input.length()

              try {
                  //Adds a dinner item to the food log
                  addDinner(name);
              }  catch (InputMismatchException e) {
                  System.out.println(e.getMessage());

              } catch (IllegalArgumentException i){
                  System.out.println(i.getMessage());
                  pause();
              }

              //If the input starts with "S" and is succeeded (index 1) by "-"
          } else if(input.startsWith("S") && input.charAt(1) == '-'){
              //Get the name of the food starting at the index +1 of "-" to the end of the input's length
              String name = input.substring(input.indexOf("-")+1);
              System.out.println("Food to add: " + name);
              //, input.length()

              //Add the snack
              try {
                  //Adds a snack item to the food log
                  addSnack(name);
                  //Catch any exceptions that might happen if the input is not an integer
              }  catch (InputMismatchException e) {
                  System.out.println(e.getMessage());
                //Catch any exceptions if the arguments passed is not legal
              } catch (IllegalArgumentException i){
                  System.out.println(i.getMessage());
                  pause();
              }



          } else if(input.startsWith("R") && input.charAt(1) == '-'){
              if(this.calorieTracker.getFoodLog().isEmpty()){
                  System.out.println("Food log is empty!");
              } else{
                  String name = input.substring(input.indexOf("-")+1,input.length());
                  System.out.println("Food to remove: " + name);
              }

              //If the input starts with P and there is no other following characters, print the entire food log
          } else if( input.startsWith("P") && input.length() == 1){
              System.out.println("Log");
              System.out.println(this.calorieTracker.printLog());
              logPause();
          }
          //If the input starts with a "P" and is succeeded by a "b", print only the breakfast log
          else if(input.startsWith("P") && input.charAt(1) == '-' && input.charAt(2) == 'b'){
              System.out.println("Breakfast Log");
              System.out.println(this.calorieTracker.printBreakfast());
              logPause();

              //If the input starts with a "P" and is succeeded by a "l", print only the lunch log
          } else if(input.startsWith("P") && input.charAt(1) == '-' && input.charAt(2) == 'l'){
              System.out.println("Lunch Log");
              System.out.println(this.calorieTracker.printLunch());
              logPause();

              //If the input starts with a "P" and is succeeded by a "d", print only the dinner log
          } else if(input.startsWith("P") && input.charAt(1) == '-' && input.charAt(2) == 'd'){
              System.out.println("Dinner Log");
              System.out.println(this.calorieTracker.printDinner());
              logPause();

              //If the input starts with a "P" and is succeeded by a "s", print only the dinner log
          } else if(input.startsWith("P") && input.charAt(1) == '-' && input.charAt(2) == 's'){
              System.out.println("Snack Log");
              System.out.println(this.calorieTracker.printSnacks());
              logPause();

              //If the input starts with a "P", print the entire food log
          } else {
              System.out.println("Sorry, I do not recognize that. Please enter another input:");
              pause();
          }
            System.out.println(this.showMenu());
            System.out.println("Enter your input: ");
            input = scanner.nextLine();


        }



    }

    public int setCaloricIntake(){
        scanner = new Scanner(System.in);
        //Prompt the user to enter their inpu
        System.out.println("Please set your caloric intake");

        //Default intake is 0
        int intake = 0;
        //boolean valid = false;

        //While the user is trying to put a valid input...
        while(true){
            //If the input is an integer
            if(scanner.hasNextInt()){
                //Parse the input and store it into the intake variable
                intake =  Integer.parseInt(scanner.nextLine());
                    //if intake is < 1200, prompt the user to enter a prompt again since it repeats from the for loop
                if(intake < 1200){
                    System.out.println("Must enter a intake greater than or equal to 1200!");
                    //Else, just break out of the loop
                } else {
                    break;
                }
            //If the input entered is not an integer
            } else if(!scanner.hasNextInt()){
                //Prompt the user to enter their input again
                System.out.println("Must enter a valid input for caloric intake");
                scanner.nextLine();
            }
        }
        //Print the user's caloric intake
        System.out.println("Caloric Intake: " + intake);
        return intake;

    }


    /**
     * Pauses the application before running the next method, so everything doesn't seem to be going at a fast pace
     */
    public void pause (){
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * A pause timer depending on the items logged in the food log so the user can read their logged food info
     */
    public void logPause(){
        long time = 2000;

        for(int i = 0; i < this.calorieTracker.getFoodLog().size(); i++){
            time += 500;
        }

        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Haves the user print the food
     */
    public void editFood() {
        scanner = new Scanner(System.in);
        System.out.println("Please enter the food you want to edit");

        String name = scanner.nextLine();
        name.trim();
        for (int i = 0; i < this.calorieTracker.getFoodLog().size();i++){
            if(name.equals(this.calorieTracker.getFoodLog().get(i).getName())){
                System.out.println("What would you like to edit?");

            }
        }
    }

    public void removeFood(String name){
        System.out.println("What category do you want to remove?");
        System.out.println("B for Breakfast" + "\n"
                         + "L for Lunch" + "\n"
                         + "D for Dinner" + "\n"
                         + "S for Snacks" + "\n");
        scanner = new Scanner(System.in);
        TYPE type = null;
        String input = scanner.nextLine();
        while(true){
            if(input.equals("B")){
                type = TYPE.BREAKFAST;
                break;
            } else if(input.equals("L")){
                type = TYPE.LUNCH;
                break;
            } else if(input.equals("D")){
                type = TYPE.DINNER;
                break;
            } else if(input.equals("S")){
                type = TYPE.SNACK;
                break;
            } else {
                System.out.println("Enter your input again");
                input = scanner.nextLine();
            }
        }

        if(this.calorieTracker.removeFood(name,type) == null){

        }
    }


    /**
     * Adds a breakfast item to the food log
     * @param name, name of the item to add
     */
    public void addBreakfast(String name) {
    int calories = 0;
    int servings = 0;



        try {
            calories = getCalorieInput();
            servings = getServings();
            System.out.println("Cals: " + calories);
            System.out.println("Servings: " + servings);
            System.out.println("Name: " + name);
        } catch(InputMismatchException i){
            System.out.println(i.getMessage());

        }
        calorieTracker.addFood(TYPE.BREAKFAST,name, calories,servings);



    }

    public void addLunch(String name){
        int calories = 0;
        int servings = 0;



        try {
            calories = getCalorieInput();
            servings = getServings();
            System.out.println("Cals: " + calories);
            System.out.println("Servings: " + servings);
            System.out.println("Name: " + name);
        } catch(InputMismatchException i){
            System.out.println(i.getMessage());

        }
        calorieTracker.addFood(TYPE.LUNCH,name, calories,servings);



    }

    public void addDinner(String name){
        int calories = 0;
        int servings = 0;



        try {
            calories = getCalorieInput();
            servings = getServings();
            System.out.println("Cals: " + calories);
            System.out.println("Servings: " + servings);
            System.out.println("Name: " + name);
        } catch(InputMismatchException i){
            System.out.println(i.getMessage());

        }
        calorieTracker.addFood(TYPE.DINNER,name, calories,servings);


    }

    public void addSnack(String name){
        int calories = 0;
        int servings = 0;



        try {
            calories = getCalorieInput();
            servings = getServings();
            System.out.println("Cals: " + calories);
            System.out.println("Servings: " + servings);
            System.out.println("Name: " + name);
        } catch(InputMismatchException i){
            System.out.println(i.getMessage());

        }
        calorieTracker.addFood(TYPE.SNACK,name, calories,servings);



    }

    public int getCalorieInput(){
        //Initate the scanner
        Scanner scanner = new Scanner(System.in);
        //Prompt the user to enter how many calories
        System.out.println("How much calories per serving?");

        //Default calories is 0
        int calories = 0;
        boolean valid = false;

        //While the input is not valid...
        while(!valid){
            //If the current input read is an integer:
            if(scanner.hasNextInt()) {
                //Parse the integer and store it into calories
                calories = Integer.parseInt(scanner.nextLine());
                //Turn valid into true to break the loop
                //valid = true;
                break;
            } else {
                //Else, prompt the user to enter their input again
                System.out.println("Must enter a valid number for calories!");
                scanner.nextLine();
            }



            System.out.println("Method cals: " + calories);
        }

        return calories;

    }

    public int getServings(){
        //Initate the scanner
        Scanner scanner = new Scanner(System.in);
        //Prompt the user to enter how many servings
        System.out.println("How many servings?");

        //Default servings is 0
        int servings = 0;
        boolean valid = false;

        //While the input is not valid...
        while(!valid){
            //If the current input read is an integer:
            if(scanner.hasNextInt()) {
                //Parse the integer and store it into servings
             servings = Integer.parseInt(scanner.nextLine());
                //Turn valid into true to break the loop
                //valid = true;
                break;
            } else {
                //Else, prompt the user to enter their input again
                System.out.println("Must enter a valid number for servings!");
                scanner.nextLine();
            }


            System.out.println("Method servings: " + servings);
        }




        return servings;
    }

    /**
     * Removes any white spaces between words or letters
     * @param input, the user's inputted value to remove all whitespace
     * @return the new input with no whitespace
     */
    private String removeWhiteSpace(String input){
        String result = "";
        int length = 0;
        int index = 0;
        //In the for loop, ending at the word's length, if the character at index i does not equal whitespace, append it
        for(int i = 0; i < input.length();i++){
            if(input.charAt(i)!= ' '){
                length++;
                result += input.charAt(i);
                if(length >= 2 && input.charAt(i)!= '-'){
                    index = i;
                    break;
                }
            }
        }

        for(int i = index+1; i < input.length(); i++){
            result += input.charAt(i);
        }

        //Return the value
        result.trim();
        return result;
    }
}
