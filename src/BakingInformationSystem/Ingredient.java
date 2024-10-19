package BakingInformationSystem;
import DataStructure.*;
import java.util.Comparator;

public class Ingredient {
    private String name;
    private String description;
    private double calories;

    @Override
    public String toString() {
        return "Ingredient{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", calories=" + calories +
                ",bakedGoodsContainThisIngredient=\n\n" + bakedGoodsContainThisIngredient +
                '}';
    }

    private  List<BakedGood> bakedGoodsContainThisIngredient=new List<>();

    public List<BakedGood> getBakedGoodsContainThisIngredient() {
        return bakedGoodsContainThisIngredient;
    }

    public Ingredient(String name, String description, double calories) {
        this.name = name;
        this.description = description;
        this.calories = calories;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getCalories() {
        return calories;
    }

    public void setCalories(double calories) {
        this.calories = calories;
    }

    public static void sortIngredientsByName(List<Ingredient> ingredients) {
        ingredients.quickSort(new Comparator<Ingredient>() {
            @Override
            public int compare(Ingredient o1, Ingredient o2) {
                return o1.getName().compareTo(o2.getName());
            }
        });
    }

    public static void sortIngredientsByDescription(List<Ingredient> ingredients) {
        ingredients.quickSort(new Comparator<Ingredient>() {
            @Override
            public int compare(Ingredient o1, Ingredient o2) {
                return o1.getDescription().compareTo(o2.getDescription());
            }
        });
    }

    public static void sortIngredientsByCalories(List<Ingredient> ingredients) {
        ingredients.quickSort(new Comparator<Ingredient>() {
            @Override
            public int compare(Ingredient o1, Ingredient o2) {
                return Double.compare(o1.getCalories(),o2.getCalories());
            }
        });
    }
}
