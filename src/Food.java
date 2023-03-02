/**
 * Food class containing constructor and its respective methods
 */
public class Food {
    private String name; //Name of the food
    private int calories; //How many calories are in the food per serving
    private int servings; //How many servings

    private TYPE type; //What type for food

    /**
     * Food constructor when specifying the details of the food, serving is defaulted to 1
     * @param name, name of the food
     * @param calories, how many calories there are in the food
     */
    /*
    public Food(String name, int calories){
        this.name = name;
        this.calories = calories;
        this.serving = 1;
    }
    */

    /**
     * Food constructor specifiying the details of the food, with serving up to the user
     * @param name, name of the food
     * @param calories, how many calores are in the food
     * @param serving, how many servings eaten
     */
    public Food(String name, int calories,int serving) throws IllegalArgumentException{
        if(name ==  null || name.isBlank()){
            throw new IllegalArgumentException("Name cannot be empty or blank!");
        }

        this.name = name;

        if(calories < 0){
            throw new IllegalArgumentException("Calories cannot be negative!");
        }
        this.calories = calories;

        if(serving <= 0){
            throw new IllegalArgumentException("Servings cannot be less than or equal to 0!");
        }
        this.servings = serving;
        this.type = null;





    }

    /**
     * Food constructor specifying the type of food for single servings
     * @param name, name of the food
     * @param calories, how many calores are in the food
     * @param type, type of food
     */
    /*
    public Food(String name, int calories,Type type){
        this.name = name;
        this.calories = calories;
        this.serving = 1;
        this.type = type;
    }
    */

    /**
     * Food constructor specifying the type of food for multiple servings
     * @param name, name of the food
     * @param calories, how many calores are in the food
     * @param serving, how many servings eaten
     * @param type, type of food
     */
    /*
    public Food(String name, int calories,int serving, Type type){
        this.name = name;
        this.calories = calories;
        this.serving = serving;
        this.type = type;
    }
    */

    /**
     * Getter for the food's name
     * @return the name of the food
     */
    public String getName(){
        return this.name;
    }

    /**
     * Getter for the food's calories
     * @return the number of calories for the food
     */
    public int getCalories(){
        return this.calories * this.servings;
    }

    /**
     * Getter for the food's servings
     * @return the number of servings eaten
     */
    public int getServings(){
        return this.servings;
    }

    /**
     * Getter to get type of food
     * @return the type
     */
    public TYPE getType(){
        return this.type;
    }

    /**
     * Setter that changes name for food
     * @param name, new name of the food
     */
    public void setName(String name){
        this.name = name;
    }

    /**
     * Setter that changes calories
     * @param calories, new calorie amount
     */
    public void setCalories(int calories){
        this.calories = calories;
    }

    /**
     * Setter that changes the serving
     * @param serving, new serving amount
     */
    public void setServings(int serving){
        this.servings = serving;
    }

    public void setType(TYPE type){
        this.type = type;
    }
    /**
     * To string method for food
     * @return String iteration for food
     */
    @Override
    public String toString(){
        return  "Food: " + this.name + "\n" +
                "Calories Per Serving: " + this.calories + "\n" +
                "Calories: " +  this.calories * this.servings + "\n" +
                "Servings: " + this.servings  + "\n" +"\n";
    }

    /**
     * Checks to see if two objects are equal
     * @param other, the other object to compare to
     * @return true if it equals, false otherwise
     */
    public boolean equals(Object other){
        if (other instanceof Food){
            Food toCompare = (Food) other;
            if(     toCompare.name.equals(this.name) &&
                    toCompare.servings == this.servings &&
                    toCompare.getCalories() == this.calories &&
                    toCompare.getType() == this.type){
                return true;
            }

        }
        return false;
    }
}
