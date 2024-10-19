package GUI;

import BakingInformationSystem.BakedGood;
import BakingInformationSystem.BakingSystem;
import BakingInformationSystem.Ingredient;
import DataStructure.List;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.function.DoublePredicate;

public class addRecipe extends JPanel {
    JPanel addRecipes = new JPanel();

    public static String name;
    List<Ingredient> ingredientList = new List<Ingredient>();
    List<Double> quantityList = new List<Double>();

    public addRecipe() {
        setBounds(0, 50, 700, 400);
        setVisible(true);
        setLayout(null);

        //bake，ingredient and quantity‘s label
        JLabel nameLabel = new JLabel("name");
        JLabel desLabel = new JLabel("ingredient");
        JLabel quantity = new JLabel("quantities");

        //name，ingredient and input of quantity
        String bakeName = null;
        System.out.println(BakingSystem.bakedGoodLists.toString());
        JComboBox<String> comboBox = new JComboBox<String>();
        for (int i = 0; i < BakingSystem.bakedGoodLists.size(); i++) {
            bakeName = BakingSystem.bakedGoodLists.getDataByIndex(i).getName();
            comboBox.addItem(bakeName);
        }

        String ingredient=null;
        System.out.println(BakingSystem.ingredientList.toString());
        JComboBox<String> comboBox1 = new JComboBox<String>();
        for (int i = 0; i < BakingSystem.ingredientList.size(); i++) {
            ingredient = BakingSystem.ingredientList.getDataByIndex(i).getName();
            comboBox1.addItem(ingredient);
        }

        JTextField quantityText = new JTextField();

        JTextArea textArea = new JTextArea(5,20);
        textArea.setBounds(150,150,400,150);


        JButton add = new JButton("add");

        //add.setBounds(320,50,60,25);
        add.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ingredientList.addFirst(BakingSystem.getIngredientByName((String)comboBox1.getSelectedItem()));
                double d= Double.parseDouble(quantityText.getText()); //Forcibly convert the character entered into quantityText to Double
                quantityList.addFirst(d);//Add the quantity to the quantityList
                textArea.append("ingredient :" + comboBox1.getSelectedItem() + "      quantity:" + quantityText.getText()+"\n");//Display the content added to the text field on the right
                quantityText.setText(" ");//Empty quantityText

            }
        });


        JButton complete=new JButton("complete");
        complete.setBounds(350,350,120,25);

        complete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                BakingSystem.addRecipe(BakingSystem.getBakedGoodByName((String)comboBox.getSelectedItem()),ingredientList,quantityList);
                textArea.setText(" ");
            }
        });

        JPanel addPanel = new JPanel();
        addPanel.setBounds(100,0,200,100);

        addPanel.setLayout(new GridLayout(3, 2));
        addPanel.add(nameLabel);
        addPanel.add(comboBox);
        addPanel.add(desLabel);
        addPanel.add(comboBox1);
        addPanel.add(quantity);
        addPanel.add(quantityText);
        JPanel a=new JPanel();
        a.setBounds(0,0,700,150);
        a.setLayout(new FlowLayout(FlowLayout.CENTER));
        a.add(addPanel);
        a.add(add);


        add(a);
        add(textArea);
        add(complete);
    }
}
