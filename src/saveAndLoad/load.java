package saveAndLoad;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import BakingInformationSystem.*;
import DataStructure.*;
import GUI.MainWindow;

public class load {
        public static void loadSystemData() {
            String projectDir = System.getProperty("user.dir");
            String fileName = projectDir + "/out"+"/data.dat";
            try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    String[] tokens = line.split(",");
                    String type = tokens[0];

                    switch (type) {
                        case "BAKEDGOOD" -> {
                            String name = tokens[1];
                            String origin = tokens[2];
                            String description = tokens[3];
                            String imageUrl = tokens[4];
                            BakingSystem.addBakedGood(name, origin, description, imageUrl);
                        }
                        case "INGREDIENT" -> {
                            String ingredientName = tokens[1];
                            String ingredientDescription = tokens[2];
                            double calories = Double.parseDouble(tokens[3]);
                            BakingSystem.addIngredient(ingredientName, ingredientDescription, calories);
                        }

                        case "RECIPE" -> {
                            String recipeName = tokens[1];
                            BakedGood bakedGood = BakingSystem.getBakedGoodByName(recipeName);
                            if (bakedGood != null) {
                                List<Ingredient> ingredients = new List<>();
                                List<Double> quantities = new List<>();

                                while ((line = reader.readLine()) != null && !line.isEmpty()) {
                                    String[] ingredientTokens = line.split(",");
                                    String ingredientNameInRecipe = ingredientTokens[0];
                                    double quantity = Double.parseDouble(ingredientTokens[1]);

                                    Ingredient ingredientInRecipe = BakingSystem.getIngredientByName(ingredientNameInRecipe);
                                    if (ingredientInRecipe != null) {
                                        ingredients.addLast(ingredientInRecipe);
                                        quantities.addLast(quantity);
                                    }
                                }

                                BakingSystem.addRecipe(bakedGood, ingredients, quantities);
                            }
                        }
                        default ->
                                System.err.println("Unknown type: " + type);
                    }
                }

                System.out.println("System data loaded successfully.");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


