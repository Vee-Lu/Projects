import java.util.ArrayList;


public class CalorieTracker {
    private ArrayList<Food> foodLog;

    /**
     * Constructor for the calorie tracker
     */
    public CalorieTracker(ArrayList<Food> foodLog) throws IllegalArgumentException{
        this.foodLog = foodLog;
    }

    /**
     * Adds food to the food log
     * @param type, the type of food
     * @param name, name of the food
     * @param calories, amount of calories per serving
     * @param servings, how many servings were eaten
     */
    public void addFood(TYPE type, String name, int calories, int servings){
        Food toAdd = new Food(name,calories,servings);
        toAdd.setType(type);
        this.foodLog.add(toAdd);
    }

    /**
     * Prints all the food eaten
     * @return every food of the food log
     */
    public String printLog(){
        String returnValue = "";
        returnValue +=  printBreakfast()   + printLunch()  + printDinner() + printSnacks();
        returnValue += "\n" + "Total Calories: " + getCalories() + "\n";

        return returnValue;

    }

    public ArrayList<Food> getFoodLog() {
        return this.foodLog;
    }

    /**
     * Prints all foods from the breakfast logs
     * @return all foods eaten during breakfast
     */
    public String printBreakfast(){
        String returnValue ="Breakfast: " + "\n";
        for(Food food: foodLog){
            if(food.getType() == TYPE.BREAKFAST){
                returnValue += food.toString();
            }
        }
        returnValue += "Breakfast Calories: " + getBreakfastCalories();
        return returnValue+  "\n" + "\n" ;
    }

    /**
     * Prints all foods from the lunch logs
     * @return all foods eaten during lunch
     */
    public String printLunch(){
        String returnValue = "Lunch: " + "\n";
        for(Food food: foodLog){
            if(food.getType() == TYPE.LUNCH){
                returnValue += food.toString();
            }
        }
        returnValue += "Lunch Calories: " + getLunchCalories();
        return returnValue + "\n" + "\n" ;
    }

    /**
     * Prints all foods from the dinner logs
     * @return all foods eaten during dinner
     */
    public String printDinner(){
        String returnValue = "Dinner: " + "\n";
        for(Food food: foodLog){
            if(food.getType() == TYPE.DINNER){
                returnValue += food.toString();
            }
        }
        returnValue += "Dinner Calories: " + getDinnerCalories() ;
        return returnValue + "\n" + "\n" ;
    }

    /**
     * Prints all foods from the snack logs
     * @return all foods eaten during snack time
     */
    public String printSnacks(){
        String returnValue ="Snacks: " + "\n";
        for(Food food: foodLog){
            if(food.getType() == TYPE.SNACK){
                returnValue += food.toString() ;
            }
        }
        returnValue += "Snack Calories: " + getSnackCalories() ;
        return returnValue + "\n" ;
    }

    /**
     * Gets the total calories from the breakfast, lunch, dinner, and snack logs
     * @return total calories eaten throughout the day
     */
    public int getCalories(){
        int calories = 0;
        calories += getBreakfastCalories() + getLunchCalories() + getDinnerCalories() + getSnackCalories();
        return calories;
    }

    /**
     * Gets the total calories from the breakfast log
     * @return total breakfast calories eaten
     */
    public int getBreakfastCalories(){
        int calories = 0;
        for(Food foods: foodLog){
            if(foods.getType() == TYPE.BREAKFAST){
                calories += foods.getCalories();
            }
        }
        return calories;
    }

    /**
     * Gets the total calories from the lunch log
     * @return total lunch calories eaten
     */
    public int getLunchCalories(){
        int calories = 0;
        for(Food foods: foodLog){
            if(foods.getType() == TYPE.LUNCH){
                calories += foods.getCalories();
            }
        }
        return calories;
    }

    /**
     * Gets the total calories from the dinner log
     * @return total dinner calories eaten
     */
    public int getDinnerCalories(){
        int calories = 0;
        for(Food foods: foodLog){
            if(foods.getType() == TYPE.DINNER){
                calories += foods.getCalories();
            }
        }
        return calories;
    }

    /**
     * Gets the total calories from the snack log
     * @return total snack calories eaten
     */
    public int getSnackCalories(){
        int calories = 0;
        for(Food foods: foodLog){
            if(foods.getType() == TYPE.SNACK){
                calories += foods.getCalories();
            }
        }
        return calories;
    }

    /**
     *
     * @param toRemove
     * @param type
     * @return
     */
    public Food removeFood(String toRemove, TYPE type){
        for(int i = 0; i < foodLog.size(); i++){
            if(foodLog.get(i).getName().equals(toRemove) && foodLog.get(i).getType() == type){
                return foodLog.get(i);
            }
        }
        return null;

    }
}
