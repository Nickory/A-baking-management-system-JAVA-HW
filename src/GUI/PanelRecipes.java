package GUI;

import BakingInformationSystem.BakedGood;
import BakingInformationSystem.BakingSystem;
import BakingInformationSystem.Ingredient;
import BakingInformationSystem.Recipe;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;

public class PanelRecipes extends JPanel {
    JPanel panelRecipes=new JPanel();
    public PanelRecipes(){
        panelRecipes.setBounds(0,50,700,400);
        panelRecipes.setVisible(true);


        int size;
        JPanel recipesShow=new JPanel();
        Scanner sc=new Scanner(System.in);

        size= BakingSystem.recipeList.size();


        if(size==0){
            JDialog dialog=new JDialog();
            dialog.setLayout(new FlowLayout(FlowLayout.LEADING));
            dialog.setBounds(200,200,200,150);
            dialog.add(new JLabel("please add a recipe"));
            dialog.setVisible(true);
            JButton ok=new JButton("ok");
            ok.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    dialog.dispose();
                }
            });

        }
        int rows;
        if(size/4==0){
            rows=size/4;
        }else{
            rows=size/4+1;
        }
        recipesShow.setLayout(new GridLayout(rows,4,5,5));
        for(int i=0;i<size;i++){
            System.out.println(BakingSystem.recipeList.toString());
            String name=BakingSystem.recipeList.getDataByIndex(i).getBakedGood().getName();
            JButton jButton=new JButton(name);
            int finalI = i;
            jButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    DialogRecipe dialogRecipe=new DialogRecipe(BakingSystem.recipeList.getDataByIndex(finalI));
                }
            });
            recipesShow.add(jButton);
        }

        JPanel differentTypeSearch=new JPanel();
        JComboBox<String>type=new JComboBox<String>();
        type.addItem(" ");
        type.addItem("name");
        type.addItem("Total calories");

        differentTypeSearch.add(type);

        add(differentTypeSearch,BorderLayout.NORTH);
        type.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String typeString=(String)type.getSelectedItem();
                if(typeString=="name"){
                    Recipe.sortRecipesByName(BakingSystem.recipeList);
                    PanelRecipes panelRecipes=new PanelRecipes();
                    MainWindow.panelShow.add(panelRecipes,"panelRecipes");
                    MainWindow.cardLayout.show(MainWindow.panelShow,"panelRecipes");

                } else if (typeString=="calories") {
                    Recipe.sortRecipesByTotalCalories(BakingSystem.recipeList);
                    PanelRecipes panelRecipes=new PanelRecipes();
                    MainWindow.panelShow.add(panelRecipes,"panelRecipes");
                    MainWindow.cardLayout.show(MainWindow.panelShow,"panelRecipes");
                }
            }
        });


        JScrollPane scrollPane=new JScrollPane(recipesShow);
        scrollPane.setPreferredSize(new Dimension(700,350));


        add(scrollPane,BorderLayout.CENTER);
    }
}
