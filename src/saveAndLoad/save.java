package saveAndLoad;
import BakingInformationSystem.*;
import DataStructure.*;

import java.io.FileWriter;
import java.io.IOException;
public class save {
    public static void saveSystemData() {
        String projectDir = System.getProperty("user.dir");
        String fileName = projectDir + "/out"+"/data.dat";
        try (FileWriter writer = new FileWriter(fileName)) {

            List<BakedGood> bakedGoods = BakingSystem.bakedGoodLists;
            for (int i = 0; i < bakedGoods.size(); i++) {
                BakedGood bakedGood = bakedGoods.getDataByIndex(i);
                writer.write("BAKEDGOOD," + bakedGood.getName() + "," + bakedGood.getOrigin() + "," +
                        bakedGood.getDescription() + "," + bakedGood.getImageUrl() + "\n");
            }


            List<Ingredient> ingredients = BakingSystem.ingredientList;
            for (int i = 0; i < ingredients.size(); i++) {
                Ingredient ingredient = ingredients.getDataByIndex(i);
                writer.write("INGREDIENT," + ingredient.getName() + "," + ingredient.getDescription() + "," +
                        ingredient.getCalories() + "\n");
            }

            List<Recipe> recipes = BakingSystem.recipeList;
            for (int i = 0; i < recipes.size(); i++) {
                Recipe recipe = recipes.getDataByIndex(i);
                writer.write("RECIPE," + recipe.getBakedGood().getName() + "," +
                        recipe.getTotalCalories() + "\n");


                List<Ingredient> ingredientsInRecipe = recipe.getIngredients();
                List<Double> quantities = recipe.getQualities();
                for (int j = 0; j < ingredientsInRecipe.size(); j++) {
                    Ingredient ingredientInRecipe = ingredientsInRecipe.getDataByIndex(j);
                    double quantity = quantities.getDataByIndex(j);

                    writer.write(ingredientInRecipe.getName() + "," + quantity + "\n");
                }

                writer.write("\n");
            }

            System.out.println("System data saved successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}