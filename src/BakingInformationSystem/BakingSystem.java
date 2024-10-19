package BakingInformationSystem;

import DataStructure.*;

import java.util.Comparator;
import java.util.Objects;

public class BakingSystem {
    public static HashTable<String, BakedGood> bakedGoodsTable = new HashTable<>();
    public static HashTable<String, Ingredient> ingredientsTable = new HashTable<>();
    public static HashTable<String, Recipe> recipesTable = new HashTable<>();

    public static List<BakedGood> bakedGoodLists = new List<>();
    public static List<Ingredient> ingredientList = new List<>();
    public static List<Recipe> recipeList = new List<>();

    public static void addBakedGood(String name, String origin, String description, String imageUrl) {
        BakedGood bakedGood = new BakedGood(name, origin, description, imageUrl);
        bakedGoodsTable.put(bakedGood.getName(), bakedGood);
        bakedGoodLists.addLast(bakedGood);
    }

    public static void addIngredient(String name, String description, double calories) {
        Ingredient ingredient = new Ingredient(name, description, calories);
        ingredientsTable.put(ingredient.getName(), ingredient);
        ingredientList.addLast(ingredient);
    }

    public static void addRecipe(BakedGood bakedGood, List<Ingredient> ingredients, List<Double> qualities) {
        Recipe recipe = new Recipe(bakedGood, ingredients, qualities);
        recipesTable.put(bakedGood.getName(), recipe);
        recipeList.addLast(recipe);
    }

    //edit a bakedGood which has been put into the hashTable
    public static void editBakedGood(String preName, String newName, String origin, String description, String imageUrl) {
        System.out.println(bakedGoodsTable.get(preName));
        bakedGoodsTable.get(preName).setName(newName);
        bakedGoodsTable.get(preName).setOrigin(origin);
        bakedGoodsTable.get(preName).setDescription(description);
        bakedGoodsTable.get(preName).setImageUrl(imageUrl);
        bakedGoodsTable.put(newName, bakedGoodsTable.get(preName));
    }

    //edit an ingredient which has been put into the hashTable
    public static void editIngredient(String preName, String newName, String description, double calories) {
        ingredientsTable.get(preName).setName(newName);
        ingredientsTable.get(preName).setDescription(description);
        ingredientsTable.get(preName).setCalories(calories);
        ingredientsTable.put(newName, ingredientsTable.get(preName));

    }

    //edit a recipe which has been put into the hashTable
    public static void editRecipe(String name, List<Ingredient> ingredients, List<Double> qualities) {
        recipesTable.get(name).setIngredients(ingredients);
        recipesTable.get(name).setQualities(qualities);
    }

    public static BakedGood getBakedGoodByName(String name) {
        return bakedGoodsTable.get(name);
    }

    public static Ingredient getIngredientByName(String name) {
        return ingredientsTable.get(name);
    }

    public static Recipe getRecipeByName(String name) {
        return recipesTable.get(name);
    }


    //delete methods
    public static void deleteBakedGood(String name) {
        bakedGoodLists.delete(BakingSystem.getBakedGoodByName(name));
        bakedGoodsTable.remove(name);
    }

    public static void deleteIngredient(String name) {
        ingredientList.delete(BakingSystem.getIngredientByName(name));
        ingredientsTable.remove(name);
    }

    public static void deleteRecipe(String name) {
        recipeList.delete(BakingSystem.getRecipeByName(name));
        recipesTable.remove(name);
    }

    public static String listAllBakedGoodsByName() {
        BakedGood.sortBakedGoodsByName(bakedGoodLists);
        StringBuilder content = new StringBuilder();
        for (int i = 0; i < bakedGoodLists.size(); i++) {
            content.append(bakedGoodLists.getDataByIndex(i).toString());
            content.append("\n");
        }
        return content.toString();
    }

    public static String listAllRecipesByName() {
        Recipe.sortRecipesByName(recipeList);
        StringBuilder content = new StringBuilder();
        for (int i = 0; i < recipeList.size(); i++) {
            content.append(recipeList.getDataByIndex(i).toString());
            content.append("\n");
        }
        return content.toString();
    }

    public static String listAllRecipesByCalories() {
        Recipe.sortRecipesByTotalCalories(recipeList);
        StringBuilder content = new StringBuilder();
        for (int i = 0; i < recipeList.size(); i++) {
            content.append(recipeList.getDataByIndex(i).toString());
            content.append("\n");
        }
        return content.toString();
    }

    public static String listAllRIngredientByName() {
        Ingredient.sortIngredientsByName(ingredientList);
        StringBuilder content = new StringBuilder();
        for (int i = 0; i < ingredientList.size(); i++) {
            content.append(ingredientList.getDataByIndex(i).toString());
            content.append("\n");
        }
        return content.toString();
    }

    public static String listAllIngredientByCalories() {
        Ingredient.sortIngredientsByCalories(ingredientList);
        StringBuilder content = new StringBuilder();
        for (int i = 0; i < ingredientList.size(); i++) {
            content.append(ingredientList.getDataByIndex(i).toString());
            content.append("\n");
        }
        return content.toString();
    }

    public static String listBakedGoodsContainThisIngredient(Ingredient ingredient) {
        BakedGood.sortBakedGoodsByName(ingredient.getBakedGoodsContainThisIngredient());
        return ingredient.getBakedGoodsContainThisIngredient().toString();
    }

    //method to search bakedGood ,you can choose to search by name/description/origin ,be care that if you search by name,make sure the name is exact.
    //If you search by name, a list with only one element will be returned.

    public static List<BakedGood> searchBakedGood(String content, String parameter) {
        switch (parameter) {
            case "name" -> {
                List<BakedGood> list = new List<>();
                list.addLast(bakedGoodsTable.get(content));
                return list;
            }
            case "description" -> {
                List<BakedGood> list = new List<>();
                for (int i = 0; i < bakedGoodLists.size(); i++) {
                    if (computeSimilarity(bakedGoodLists.getDataByIndex(i).getDescription(), content) >= 0.6) {
                        list.addLast(bakedGoodLists.getDataByIndex(i));
                    }
                }
                list.quickSort((o1, o2) -> (Double.compare(((computeSimilarity(o2.getDescription(), content))), computeSimilarity(o1.getDescription(), content))));
                return list;
            }
            case "origin" -> {
                List<BakedGood> list = new List<>();
                for (int i = 0; i < bakedGoodLists.size(); i++) {
                    if (Objects.equals(bakedGoodLists.getDataByIndex(i).getOrigin(), content)) {
                        list.addLast(bakedGoodLists.getDataByIndex(i));
                    }
                }
                return list;
            }
        }
        return new List<>();
    }

    public static List<Ingredient> searchIngredient(String content, String parameter) {
        switch (parameter) {
            case "name" -> {
                List<Ingredient> list = new List<>();
                list.addLast(ingredientsTable.get(content));
                return list;
            }
            case "description" -> {
                List<Ingredient> list = new List<>();
                for (int i = 0; i < ingredientList.size(); i++) {
                    if (computeSimilarity(ingredientList.getDataByIndex(i).getDescription(), content) >= 0.6) {
                        list.addLast(ingredientList.getDataByIndex(i));
                    }
                }
                list.quickSort((o1, o2) -> (Double.compare(((computeSimilarity(o2.getDescription(), content))), computeSimilarity(o1.getDescription(), content))));
                return list;
            }
            case "calories" -> {
                List<Ingredient> list = new List<>();
                for (int i = 0; i < ingredientList.size(); i++) {
                    if ((abs((ingredientList.getDataByIndex(i).getCalories() - Double.parseDouble(content)) / Double.parseDouble(content))) < 0.1) {
                        list.addLast(ingredientList.getDataByIndex(i));
                    }
                }
                list.quickSort(new Comparator<Ingredient>() {
                    @Override
                    public int compare(Ingredient o1, Ingredient o2) {
                        return Double.compare((abs((o1.getCalories() - Double.parseDouble(content)) / Double.parseDouble(content))), (abs((o2.getCalories() - Double.parseDouble(content)) / Double.parseDouble(content))));
                    }
                });
                return list;
            }
        }
        return new List<>();
    }

    public static List<Recipe> searchRecipe(String content, String parameter) {
        switch (parameter) {
            case "name" -> {
                List<Recipe> list = new List<>();
                list.addLast(recipesTable.get(content));
                return list;
            }

            case "calories" -> {
                List<Recipe> list = new List<>();
                for (int i = 0; i < recipeList.size(); i++) {
                    if ((abs((recipeList.getDataByIndex(i).getTotalCalories() - Double.parseDouble(content)) / Double.parseDouble(content))) < 0.3) {
                        list.addLast(recipeList.getDataByIndex(i));
                    }
                }
                list.quickSort(new Comparator<Recipe>() {
                    @Override
                    public int compare(Recipe o1, Recipe o2) {
                        return Double.compare((abs((o1.getTotalCalories() - Double.parseDouble(content)) / Double.parseDouble(content))), (abs((o2.getTotalCalories() - Double.parseDouble(content)) / Double.parseDouble(content))));
                    }
                });
                return list;
            }
        }
        return new List<>();
    }

    public static double abs(double number) {
        if (number > 0) {
            return number;
        } else return -number;
    }

    public static double computeSimilarity(String content1, String content2) {
        String[] words1 = content1.split("\\s");
        String[] words2 = content2.split("\\s");


        int commonWords = CommonWords(words1, words2);

        int totalWords = (words1.length + words2.length) / 2;

        // Compute similarity
        return (double) commonWords / totalWords;
    }

    private static int CommonWords(String[] words1, String[] words2) {
        int i = 0;
        // Check for common terms using nested loops
        for (String word1 : words1) {
            for (String word2 : words2) {
                if (word1.equals(word2)) {
                    i++;
                    break; // Once you find a common word, you don't need to keep checking that word
                }
            }
        }
        return i;
    }

    public static void clear() {
        BakingSystem.bakedGoodLists.clear();
        BakingSystem.ingredientList.clear();
        BakingSystem.recipeList.clear();
        BakingSystem.bakedGoodsTable.clear();
        BakingSystem.ingredientsTable.clear();
        BakingSystem.recipeList.clear();
    }
}
