package GUI;

import BakingInformationSystem.BakedGood;
import BakingInformationSystem.BakingSystem;
import BakingInformationSystem.Ingredient;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import static GUI.MainWindow.panelShow;

public class DialogIngredient extends JDialog {
    JDialog ingredientDialog=new JDialog();
    String name;
    String description;
    double calories;

    public DialogIngredient(Ingredient ingredient,int x,int y){

        name=ingredient.getName();
        description=ingredient.getDescription();
        calories=ingredient.getCalories();
        System.out.println(name+description+calories);
        ingredientDialog.setBounds(x,y,300,400);




        //Create a new JPanel to store the properties of the item
        JPanel jPanel=new JPanel();
        jPanel.setLayout(new GridLayout(3,2));
        jPanel.setBounds(0,100,210,200);

        JLabel label=new JLabel("name:");
        JLabel label1=new JLabel("description:");
        JLabel label2=new JLabel("calories:");
        JLabel label3=new JLabel(name);
        JLabel label4=new JLabel(description);
        JLabel label5=new JLabel(Double.toString(calories));

        jPanel.add(label);
        jPanel.add(label3);
        jPanel.add(label1);
        jPanel.add(label4);
        jPanel.add(label2);
        jPanel.add(label5);


        JPanel panelButton=new JPanel();
        panelButton.setLayout(new FlowLayout(FlowLayout.CENTER));
        panelButton.setBounds(0,300,300,50);

        JButton ok=new JButton("ok");
        ok.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ingredientDialog.dispose();
            }
        });
        JButton amend=new JButton("amend");
        amend.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ingredientDialog.dispose();
                JDialog jDialog=new JDialog();
                jDialog.setLayout(new FlowLayout(FlowLayout.LEADING));


                JLabel nameLabel=new JLabel("name");
                JLabel descriptionLabel=new JLabel("description");
                JLabel caloriesLabel=new JLabel("calories");

                JTextField nameText=new JTextField();
                nameText.setText(name);
                JTextField desText=new JTextField();
                desText.setText(description);
                JTextField caloriesText=new JTextField();
                caloriesText.setText(Double.toString(calories));



                JPanel addPanel=new JPanel();
                addPanel.setLayout(new GridLayout(3,2));
                addPanel.add(nameLabel);
                addPanel.add(nameText);
                addPanel.add(descriptionLabel);
                addPanel.add(desText);
                addPanel.add(caloriesLabel);
                addPanel.add(caloriesText);

                JButton ok=new JButton("ok");


                jDialog.add(addPanel);
                jDialog.add(ok);
                ok.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        BakingSystem.editIngredient(name,nameText.getText(),desText.getText(),Double.parseDouble(caloriesText.getText()));
                        jDialog.dispose();
                    }
                });

                jDialog.setBounds(200,200,300,200);
                jDialog.setVisible(true);

            }
        });
        JButton show=new JButton("show");
        show.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int size=ingredient.getBakedGoodsContainThisIngredient().size();
                for(int i=0;i<size;i++){
                    try {
                        DialogBaking dialogBaking=new DialogBaking(ingredient.getBakedGoodsContainThisIngredient().getDataByIndex(i),200+i*10,200+i*10);
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                }
            }
        });
        JButton remove=new JButton("remove");
        remove.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                BakingSystem.ingredientList.delete(ingredient);
                addIngredient addIngredient1=new addIngredient();
                panelShow.add(addIngredient1,"addIngredient1");
                MainWindow.cardLayout.show(panelShow,"addIngredient1");
                ingredientDialog.dispose();

            }
        });
        panelButton.add(ok);
        panelButton.add(amend);
        panelButton.add(show);
        panelButton.add(remove);



        ingredientDialog.add(jPanel);
        ingredientDialog.add(panelButton);


        ingredientDialog.setLayout(null);
        ingredientDialog.setVisible(true);
        ingredientDialog.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
    }

    public DialogIngredient(Ingredient ingredient){

        name=ingredient.getName();
        description=ingredient.getDescription();
        calories=ingredient.getCalories();
        System.out.println(name+description+calories);
        ingredientDialog.setBounds(200,200,300,400);




        //Create a new JPanel to store the properties of the item
        JPanel jPanel=new JPanel();
        jPanel.setLayout(new GridLayout(3,2));
        jPanel.setBounds(0,100,210,200);

        JLabel label=new JLabel("name:");
        JLabel label1=new JLabel("description:");
        JLabel label2=new JLabel("calories:");
        JLabel label3=new JLabel(name);
        JLabel label4=new JLabel(description);
        JLabel label5=new JLabel(Double.toString(calories));

        jPanel.add(label);
        jPanel.add(label3);
        jPanel.add(label1);
        jPanel.add(label4);
        jPanel.add(label2);
        jPanel.add(label5);

        JPanel panelButton=new JPanel();
        panelButton.setLayout(new FlowLayout(FlowLayout.CENTER));
        panelButton.setBounds(0,300,300,50);

        JButton ok=new JButton("ok");
        ok.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ingredientDialog.dispose();
            }
        });
        JButton amend=new JButton("amend");
        amend.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ingredientDialog.dispose();
                JDialog jDialog=new JDialog();
                jDialog.setLayout(new FlowLayout(FlowLayout.LEADING));


                JLabel nameLabel=new JLabel("name");
                JLabel descriptionLabel=new JLabel("description");
                JLabel caloriesLabel=new JLabel("calories");

                JTextField nameText=new JTextField();
                nameText.setText(name);
                JTextField desText=new JTextField();
                desText.setText(description);
                JTextField caloriesText=new JTextField();
                caloriesText.setText(Double.toString(calories));



                JPanel addPanel=new JPanel();
                addPanel.setLayout(new GridLayout(3,2));
                addPanel.add(nameLabel);
                addPanel.add(nameText);
                addPanel.add(descriptionLabel);
                addPanel.add(desText);
                addPanel.add(caloriesLabel);
                addPanel.add(caloriesText);

                JButton ok=new JButton("ok");


                jDialog.add(addPanel);
                jDialog.add(ok);
                ok.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        BakingSystem.editIngredient(name,nameText.getText(),desText.getText(),Double.parseDouble(caloriesText.getText()));
                        jDialog.dispose();
                    }
                });

                jDialog.setBounds(200,200,300,200);
                jDialog.setVisible(true);

            }
        });
        JButton show=new JButton("show");
        show.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int size=ingredient.getBakedGoodsContainThisIngredient().size();
                for(int i=0;i<size;i++){
                    try {
                        DialogBaking dialogBaking=new DialogBaking(ingredient.getBakedGoodsContainThisIngredient().getDataByIndex(i));
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                }
            }
        });
        JButton remove=new JButton("remove");
        remove.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                BakingSystem.ingredientList.delete(ingredient);
                addIngredient addIngredient1=new addIngredient();
                panelShow.add(addIngredient1,"addIngredient1");
                MainWindow.cardLayout.show(panelShow,"addIngredient1");
                ingredientDialog.dispose();

            }
        });
        panelButton.add(ok);
        panelButton.add(amend);
        panelButton.add(show);
        panelButton.add(remove);



        ingredientDialog.add(jPanel);
        ingredientDialog.add(panelButton);


        ingredientDialog.setLayout(null);
        ingredientDialog.setVisible(true);
        ingredientDialog.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);


    }
}
