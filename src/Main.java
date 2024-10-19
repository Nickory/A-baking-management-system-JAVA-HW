import DataStructure.*;
import BakingInformationSystem.*;
import saveAndLoad.*;
import java.util.Random;
import GUI.*;

public class Main {
    public static void main(String[] args) {
        String projectDir = System.getProperty("user.dir");

        BakingSystem.addBakedGood("Fisherman's toast","Mond",
                "Toast covered in Onions. It's a popular staple among fishermen." +
                        " They stuff their bags with this toast. And squat by the river all day.",projectDir+"/toast.jpg");


        BakingSystem.addBakedGood("Chinese sweetmeats","Liyue","A seasoned and roasted meat dish." +
                " Although the raw materials are mainly from animal offal and scraps, " +
                "after some seasoning and processing, it completely covers the original meat taste. " +
                "Many people eat a lifetime to realize that the name of the original dish is not abusive.",projectDir+"/Chinese sweetmeats.png");


        BakingSystem.addBakedGood("Shrimp balls with golden shreds","Liyue","Fried shrimp dish. At first, the fragrant, " +
                " crispy potatoes reveal the sweetness of shrimp meat. " +
                "With the small and cute shape, " +
                "it makes the index finger move.",projectDir+"/Shrimp balls with golden shreds.png");


        BakingSystem.addBakedGood("Manor baked muffins","Mond","Round scones. From an afternoon snack on the estate," +
                "it evolved into a regular staple, " +
                "embellished with the finest raspberries." ,projectDir+"/Manor baked muffins.png");


        BakingSystem.addBakedGood("Mond potato cake","Mond","Potato fritters. A few pinecones provide a varied taste." +
                " Can be eaten with jam, popular with all ages." ,projectDir+"/Mond potato cake.png");


        BakingSystem.addBakedGood("Baked mushroom pizza","Mond","A pancake covered in mushrooms and cheese." +
                " When hot, the cheese can be pulled out of thin silk," +
                "and it is very enjoyable to bite down." ,projectDir+"/Baked mushroom pizza.png");


        BakingSystem.addBakedGood("Mora meat","Snezhnaya","A cake wrapped in a large piece of meat." +
                "Divide the pancake into two pieces and insert the rich meat filling." +
                "It not only removes the cloying taste of the meat," +
                "but also sets off the sweetness of the cake. In order to achieve wealth and happiness," +
                "it is usually printed with the pattern of [Mora].",projectDir+"/Mora meat.png");


        BakingSystem.addBakedGood("Matsutake with butter","Mond","Fried matsutake slices. " +
                "Thinly sliced matsutake is crispy on the outside" +
                "and tender on the inside, which is easy to grab. " ,projectDir+"/Matsutake with butter.png");


        BakingSystem.addBakedGood("Thick cloud muffins","Mond","Thick muffins, the Order's afternoon tea dessert," +
                "bring a sense of happiness like falling into a soft cloud." ,projectDir+"/Thick cloud muffins.png");


        new MainWindow();


    }
}