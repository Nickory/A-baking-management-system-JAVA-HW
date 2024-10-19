package GUI;

import BakingInformationSystem.BakingSystem;
import BakingInformationSystem.Ingredient;
import BakingInformationSystem.Recipe;
import DataStructure.List;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLOutput;

import static GUI.MainWindow.panelShow;

public class DialogRecipe extends JDialog {
    JDialog recipeDialog=new JDialog();
    List<Ingredient> ingredientList = new List<Ingredient>();
    List<Double> quantityList = new List<Double>();
    String name;

    public DialogRecipe(Recipe recipe,int x,int y){
        name=recipe.getBakedGood().getName();

        recipeDialog.setBounds(x,y,300,400);


        JPanel jPanel=new JPanel();
        jPanel.setBounds(0,100,200,50);
        jPanel.setLayout(new FlowLayout(FlowLayout.LEFT));

        JLabel jLabel=new JLabel("bakedGood:"+name+"    ");
        JLabel jLabel1=new JLabel("calories:"+Double.toString(recipe.getTotalCalories()));

        jPanel.add(jLabel);
        jPanel.add(jLabel1);

        JPanel jPanel1=new JPanel();
        jPanel1.setLayout(new FlowLayout(FlowLayout.LEADING));
        jPanel1.setVisible(true);
        jPanel1.setBounds(0,150,200,100);
        for(int i=0;i<recipe.getIngredients().size();i++){
            System.out.println(i);
            System.out.println(recipe.getIngredients().getDataByIndex(i).getName());
            JLabel jLabel2=new JLabel(recipe.getIngredients().getDataByIndex(i).getName()+":  "+recipe.getQualities().getDataByIndex(i));
            jPanel1.add(jLabel2);
        }



        JPanel jPanel2=new JPanel();
        jPanel2.setLayout(new FlowLayout(FlowLayout.CENTER));
        jPanel2.setBounds(0,300,300,50);
        JButton ok=new JButton("ok");
        ok.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                recipeDialog.dispose();
            }
        });
        JButton amend=new JButton("amend");
        amend.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                recipeDialog.dispose();
                JDialog jDialog=new JDialog();
                jDialog.setLayout(new FlowLayout(FlowLayout.LEADING));


                JLabel nameLabel = new JLabel("name");
                JLabel desLabel = new JLabel("ingredient");
                JLabel quantity = new JLabel("quantities");

                String bakeName = recipe.getBakedGood().getName();
                JLabel name=new JLabel(bakeName);


                String ingredient=null;
                System.out.println(BakingSystem.ingredientList.toString());
                JComboBox<String> comboBox1 = new JComboBox<String>();
                for (int i = 0; i < BakingSystem.ingredientList.size(); i++) {
                    ingredient = BakingSystem.ingredientList.getDataByIndex(i).getName();
                    comboBox1.addItem(ingredient);
                }
                JTextField quantityText = new JTextField();

                JTextArea textArea = new JTextArea(5,20);
                JButton add = new JButton("add");
                //add.setBounds(320,50,60,25);
                add.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        ingredientList.addFirst(BakingSystem.getIngredientByName((String)comboBox1.getSelectedItem()));
                        double d= Double.parseDouble(quantityText.getText()); //Forcibly convert the character entered into quantityText to Double
                        quantityList.addFirst(d);//Add the quantity to the quantityList
                        textArea.append("ingredient :" + comboBox1.getSelectedItem() + "      quantity:" + quantityText.getText()+"\n");//Display the content added to the text field on the right
                        quantityText.setText(" ");

                    }
                });

                JButton complete=new JButton("complete");

                complete.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        BakingSystem.editRecipe(bakeName,ingredientList,quantityList);
                        textArea.setText(" ");
                        jDialog.dispose();
                    }
                });

                JPanel addPanel = new JPanel();

                addPanel.setLayout(new GridLayout(3, 2));
                addPanel.add(nameLabel);
                addPanel.add(name);
                addPanel.add(desLabel);
                addPanel.add(comboBox1);
                addPanel.add(quantity);
                addPanel.add(quantityText);
                JPanel a=new JPanel();
                a.add(addPanel);
                a.add(add);


                jDialog.add(a);
                jDialog.add(textArea);
                jDialog.add(complete);
                jDialog.setBounds(200,200,400,300);
                jDialog.setVisible(true);


            }});

        JButton remove=new JButton("remove");
        remove.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                BakingSystem.recipeList.delete(recipe);
                PanelRecipes panelRecipes=new PanelRecipes();
                panelShow.add(panelRecipes,"panelRecipes");
                MainWindow.cardLayout.last(panelShow);
                recipeDialog.dispose();

            }
        });
        jPanel2.add(ok);
        jPanel2.add(amend);
        jPanel2.add(remove);



        recipeDialog.add(jPanel);
        recipeDialog.add(jPanel1);
        recipeDialog.add(jPanel2);

        recipeDialog.setLayout(null);
        recipeDialog.setVisible(true);
        recipeDialog.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
    }

    public DialogRecipe(Recipe recipe){
        name=recipe.getBakedGood().getName();

        recipeDialog.setBounds(200,200,300,400);


        JPanel jPanel=new JPanel();
        jPanel.setBounds(0,100,200,50);
        jPanel.setLayout(new FlowLayout(FlowLayout.LEFT));

        JLabel jLabel=new JLabel("bakedGood:"+name+"    ");
        JLabel jLabel1=new JLabel("calories:"+Double.toString(recipe.getTotalCalories()));

        jPanel.add(jLabel);
        jPanel.add(jLabel1);

        JPanel jPanel1=new JPanel();
        jPanel1.setLayout(new FlowLayout(FlowLayout.LEADING));
        jPanel1.setVisible(true);
        jPanel1.setBounds(0,150,200,100);
        for(int i=0;i<recipe.getIngredients().size();i++){
            System.out.println(i);
            System.out.println(recipe.getIngredients().getDataByIndex(i).getName());
            JLabel jLabel2=new JLabel(recipe.getIngredients().getDataByIndex(i).getName()+":  "+recipe.getQualities().getDataByIndex(i));
            jPanel1.add(jLabel2);
        }



        JPanel jPanel2=new JPanel();
        jPanel2.setLayout(new FlowLayout(FlowLayout.CENTER));
        jPanel2.setBounds(0,300,300,50);
        JButton ok=new JButton("ok");
        ok.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                recipeDialog.dispose();
            }
        });
        JButton amend=new JButton("amend");
        amend.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                recipeDialog.dispose();
                JDialog jDialog=new JDialog();
                jDialog.setLayout(new FlowLayout(FlowLayout.LEADING));


                JLabel nameLabel = new JLabel("name");
                JLabel desLabel = new JLabel("ingredient");
                JLabel quantity = new JLabel("quantities");

                String bakeName = recipe.getBakedGood().getName();
                JLabel name=new JLabel(bakeName);


                    String ingredient=null;
                    System.out.println(BakingSystem.ingredientList.toString());
                    JComboBox<String> comboBox1 = new JComboBox<String>();
                    for (int i = 0; i < BakingSystem.ingredientList.size(); i++) {
                        ingredient = BakingSystem.ingredientList.getDataByIndex(i).getName();
                        comboBox1.addItem(ingredient);
                    }
                JTextField quantityText = new JTextField();

                JTextArea textArea = new JTextArea(5,20);
                JButton add = new JButton("add");

                add.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        ingredientList.addFirst(BakingSystem.getIngredientByName((String)comboBox1.getSelectedItem()));
                        double d= Double.parseDouble(quantityText.getText());
                        quantityList.addFirst(d);
                        textArea.append("ingredient :" + comboBox1.getSelectedItem() + "      quantity:" + quantityText.getText()+"\n");
                        quantityText.setText(" ");

                    }
                });

                JButton complete=new JButton("complete");

                complete.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        BakingSystem.editRecipe(bakeName,ingredientList,quantityList);
                        textArea.setText(" ");
                        jDialog.dispose();
                    }
                });

                JPanel addPanel = new JPanel();

                addPanel.setLayout(new GridLayout(3, 2));
                addPanel.add(nameLabel);
                addPanel.add(name);
                addPanel.add(desLabel);
                addPanel.add(comboBox1);
                addPanel.add(quantity);
                addPanel.add(quantityText);
                JPanel a=new JPanel();
                a.add(addPanel);
                a.add(add);


                jDialog.add(a);
                jDialog.add(textArea);
                jDialog.add(complete);
                jDialog.setBounds(200,200,400,300);
                jDialog.setVisible(true);


        }});

        JButton remove=new JButton("remove");
        remove.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                BakingSystem.recipeList.delete(recipe);
                PanelRecipes panelRecipes=new PanelRecipes();
                panelShow.add(panelRecipes,"panelRecipes");
                MainWindow.cardLayout.last(panelShow);
                recipeDialog.dispose();

            }
        });
        jPanel2.add(ok);
        jPanel2.add(amend);
        jPanel2.add(remove);



        recipeDialog.add(jPanel);
        recipeDialog.add(jPanel1);
        recipeDialog.add(jPanel2);

        recipeDialog.setLayout(null);
        recipeDialog.setVisible(true);
        recipeDialog.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
    }
}
