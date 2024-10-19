package BakingInformationSystem;
import DataStructure.*;
import java.util.Comparator;

public class Recipe {
    private BakedGood bakedGood;
    private List<Ingredient> ingredients;
    private List<Double> qualities;

    @Override
    public String toString() {
        StringBuilder content= new StringBuilder("Recipe{" +
                "bakedGood=" + bakedGood.getName() +" calories="+this.getTotalCalories()+
                "}\n");

        for (int i=0;i<ingredients.size();i++){
            content.append(ingredients.getDataByIndex(i).getName()).append(" ").append(qualities.getDataByIndex(i));
            content.append("\n");
        }

        return content.toString();
    }

    public double getTotalCalories() {
        int totalCalories = 0;
        for (int i = 0; i < ingredients.size(); i++) {
            totalCalories += ingredients.getDataByIndex(i).getCalories() * qualities.getDataByIndex(i);
        }
        return totalCalories;
    }

    public List<Double> getQualities() {
        return qualities;
    }

    public void setQualities(List<Double> qualities) {
        this.qualities = qualities;
    }

    public BakedGood getBakedGood() {
        return bakedGood;
    }

    public void setBakedGood(BakedGood bakedGood) {
        this.bakedGood = bakedGood;
    }

    public List<Ingredient> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }

    public Recipe(BakedGood bakedGood, List<Ingredient> ingredients, List<Double> qualities) {
        this.bakedGood = bakedGood;
        this.ingredients = ingredients;
        this.qualities = qualities;

        for (int i = 0; i < ingredients.size(); i++) {
            ingredients.getDataByIndex(i).getBakedGoodsContainThisIngredient().addLast(bakedGood);
        }
    }

    public static void sortRecipesByName(List<Recipe> recipes) {
        recipes.quickSort(new Comparator<Recipe>() {
            @Override
            public int compare(Recipe o1, Recipe o2) {
                return o1.getBakedGood().getName().compareTo(o2.getBakedGood().getName());
            }
        });
    }

    //sort by the sequence of totalCalories of the recipe
    public static void sortRecipesByTotalCalories(List<Recipe> recipes) {
        recipes.quickSort(new Comparator<Recipe>() {
            @Override
            public int compare(Recipe o1, Recipe o2) {
                return Double.compare(o1.getTotalCalories(), o2.getTotalCalories());
            }
        });
    }
}
