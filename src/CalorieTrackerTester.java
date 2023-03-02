import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.zip.DataFormatException;

public class CalorieTrackerTester {
    public static void main(String[] args) {
    System.out.println(testFood());
    testFoodToString();
    System.out.println(testGetters());
    System.out.println(testSetters());
    System.out.println(testEquals());
    System.out.println(testCalorieTrackerConstructor());
    System.out.println(testAddFood());
    testPrint();
    Scanner scanner = new Scanner(System.in);
    TrackerUI ui = new TrackerUI(scanner);
    ui.runApplication();

    }

    /**
     * Tests to see if the food objects works as expected
     * @return true if it does, false otherwise
     */
    public static boolean testFood(){
        //Name is null
        try {
            Food apple = new Food(null, 10,1);
        } catch(IllegalArgumentException i) {
            System.out.println(i.getMessage());
        } catch (Exception e) {
            return false;
        }

        //Name is blank
        try {
            Food apple = new Food("", 10,1);
        } catch(IllegalArgumentException i) {
            System.out.println(i.getMessage());
        } catch (Exception e) {
            return false;
        }

        //Calories are less than 0
        try {
            Food apple = new Food("Apple", -10,1);
        } catch(IllegalArgumentException i) {
            System.out.println(i.getMessage());
        } catch (Exception e) {
            return false;
        }

        //Servings are less than or equal to 0
        try {
            Food apple = new Food("Apple", 100,0);
        } catch(IllegalArgumentException i) {
            System.out.println(i.getMessage());
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    /**
     * Tests to see if the toString works
     */
    public static void testFoodToString(){
        {
            Food apple = new Food("Apple", 90, 1);
            System.out.println(apple.toString());
        }

        {
            Food apple = new Food("Apple", 100, 3);
            System.out.println(apple.toString());
        }
    }

    /**
     * Tests to see if the getters work as intended
     * @return true if it does, false otherwise
     */
    public static boolean testGetters(){
        {
            Food apple = new Food("Apple", 90,4);
            if(!apple.getName().equals("Apple")){

                return false;
            }

            if(apple.getCalories() != 90){
                return false;
            }

            if(apple.getServings() != 4){
                return false;
            }
        }
        return true;
    }

    /**
     * Test to see if the mutators works as intended
     * @return true if it does, false otherwise
     */
    public static boolean testSetters(){
        {
            Food apple = new Food("Apple", 90,4);
            apple.setName("Banana");
            if(!apple.getName().equals("Banana")){
                return false;
            }

            apple.setCalories(120);
            if(apple.getCalories() != 120){
                return false;
            }

            apple.setServings(3);
            if(apple.getServings() != 3){
                return false;
            }

            apple.setType(TYPE.SNACK);
            if(apple.getType() != TYPE.SNACK){
                return false;
            }

        }
        return true;
    }

    /**
     *Tests to see if the equals method works as intended
     * @return true if it does, false otherwise
     */
    public static boolean testEquals(){
        {
            Food apple = new Food("Apple", 90,4);
            if(!apple.equals(new Food(apple.getName(),apple.getCalories(), apple.getServings()))){
                System.out.println("Error");
                System.out.println(apple.toString());
                System.out.println(apple.getName());
                System.out.println(apple.getCalories());
                System.out.println(apple.getServings());

                return false;
            }
        }

        {
            Food apple = new Food("Apple", 90,4);
            Food apple2 = new Food("Apple", 90,4);
            apple.setType(TYPE.SNACK);
            if(apple.equals(apple2)){

                return false;
            }
        }
        return true;
    }

    public static boolean testCalorieTrackerConstructor(){

        {
            try {
                ArrayList<Food> foodLog = new ArrayList<Food>();
                CalorieTracker tracker = new CalorieTracker(foodLog);
            } catch (IllegalArgumentException i) {
                System.out.println(i.getMessage());
            } catch (Exception e){

                return false;
            }

        }


        {
            try {
                ArrayList<Food> foodLog = new ArrayList<Food>();
                CalorieTracker tracker = new CalorieTracker(foodLog);
            } catch (IllegalArgumentException i) {
                System.out.println(i.getMessage());
            } catch (Exception e){
                return false;
            }

        }

             return true;
    }

    public static boolean testAddFood(){
        {
            ArrayList<Food> foodLog = new ArrayList<Food>();
            CalorieTracker tracker = new CalorieTracker(foodLog);
            tracker.addFood(TYPE.LUNCH,"Scrambled Eggs",220,2);
            Food toCompare = new Food("Scrambled Eggs",220,2);
            toCompare.setType(TYPE.LUNCH);
            if(!foodLog.get(0).equals(toCompare)){

                return false;
            }
        }

        return true;
    }

    public static void testPrint(){
        //Checks if it will print breakfast
        {
            ArrayList<Food> foodLog = new ArrayList<Food>();
            CalorieTracker tracker = new CalorieTracker( foodLog);
            tracker.addFood(TYPE.BREAKFAST, "Scrambled Eggs", 220, 2);
            tracker.addFood(TYPE.BREAKFAST, "Sausage", 100, 1);
            tracker.addFood(TYPE.BREAKFAST, "Turkey Bacon", 80, 4);
            System.out.println(tracker.printBreakfast());
        }

        //Checks if it will print lunch
        {
            ArrayList<Food> foodLog = new ArrayList<Food>();
            CalorieTracker tracker = new CalorieTracker( foodLog);
            tracker.addFood(TYPE.LUNCH, "Scrambled Eggs", 220, 2);
            tracker.addFood(TYPE.LUNCH, "Sausage", 100, 1);
            tracker.addFood(TYPE.LUNCH, "Turkey Bacon", 80, 4);
            System.out.println(tracker.printLunch());
        }

        //Checks if it will print dinner
        {
            ArrayList<Food> foodLog = new ArrayList<Food>();
            CalorieTracker tracker = new CalorieTracker( foodLog);
            tracker.addFood(TYPE.DINNER, "Scrambled Eggs", 220, 2);
            tracker.addFood(TYPE.DINNER, "Sausage", 100, 1);
            tracker.addFood(TYPE.DINNER, "Turkey Bacon", 80, 4);
            System.out.println(tracker.printDinner());
        }

        //Checks if it will print snacks
        {
            ArrayList<Food> foodLog = new ArrayList<Food>();
            CalorieTracker tracker = new CalorieTracker(foodLog);
            tracker.addFood(TYPE.SNACK, "Scrambled Eggs", 220, 2);
            tracker.addFood(TYPE.SNACK, "Sausage", 100, 1);
            tracker.addFood(TYPE.SNACK, "Turkey Bacon", 80, 4);
            System.out.println(tracker.printSnacks());
        }

        //Checks if it will print breakfast scattered in the array
        {
            ArrayList<Food> foodLog = new ArrayList<Food>();
            CalorieTracker tracker = new CalorieTracker( foodLog);
            tracker.addFood(TYPE.BREAKFAST, "Scrambled Eggs", 220, 1);
            tracker.addFood(TYPE.LUNCH, "Club Sandwich", 400, 1);
            tracker.addFood(TYPE.SNACK, "Oreos", 40, 10);
            tracker.addFood(TYPE.DINNER, "Roast Beef", 400, 2);
            tracker.addFood(TYPE.DINNER, "Mashed Potatoes", 330, 1);
            tracker.addFood(TYPE.BREAKFAST, "Sausage", 100, 4);
            tracker.addFood(TYPE.LUNCH, "Potato Chips", 90, 3);
            tracker.addFood(TYPE.BREAKFAST, "Turkey Bacon", 80, 6);
            tracker.addFood(TYPE.SNACK, "Twix", 130, 1);
            tracker.addFood(TYPE.SNACK, "Gummy Worms", 60, 8);
            tracker.addFood(TYPE.DINNER, "Tomato Soup", 230, 1);
            tracker.addFood(TYPE.LUNCH, "Water", 0, 2);
            tracker.addFood(TYPE.BREAKFAST, "Cereal", 90, 6);
            System.out.println(tracker.printLog());
        }
    }
}
