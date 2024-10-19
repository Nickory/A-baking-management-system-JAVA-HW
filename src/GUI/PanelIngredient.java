package GUI;

import BakingInformationSystem.BakedGood;
import BakingInformationSystem.BakingSystem;
import BakingInformationSystem.Ingredient;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.Scanner;

public class PanelIngredient extends JPanel {
    JPanel panelIngredient=new JPanel();
    public PanelIngredient(){
        panelIngredient.setBounds(0,50,700,400);
        panelIngredient.setVisible(true);


        //set IngredientShow's panel
        int size;
        JPanel ingredientShow=new JPanel();
        Scanner sc=new Scanner(System.in);

        size= BakingSystem.ingredientList.size();

        if(size==0){
            JDialog dialog=new JDialog();
            dialog.setLayout(new FlowLayout(FlowLayout.LEADING));
            dialog.setBounds(200,200,200,150);
            dialog.add(new JLabel("please add an ingredient"));
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
        ingredientShow.setLayout(new GridLayout(rows,4,5,5));
        for(int i=0;i<size;i++){
            String name=BakingSystem.ingredientList.getDataByIndex(i).getName();
            JButton jButton=new JButton(name);
            int finalI = i;
            int finalI1 = i;
            int finalI2 = i;
            jButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {

                        DialogIngredient dialogIngredient = new DialogIngredient(BakingSystem.ingredientList.getDataByIndex(finalI1));
                   //}
//                    catch (IOException ex){
//                        throw new RuntimeException(ex);
                    }
            });
            ingredientShow.add(jButton);

        }

        JPanel differentTypeSearch=new JPanel();
        JComboBox<String>type=new JComboBox<String>();
        type.addItem(" ");
        type.addItem("name");
        type.addItem("description");
        type.addItem("calories");

        differentTypeSearch.add(type);

        add(differentTypeSearch,BorderLayout.NORTH);
        type.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String typeString=(String)type.getSelectedItem();
                if(typeString=="name"){
                    Ingredient.sortIngredientsByName(BakingSystem.ingredientList);
                    PanelIngredient panelIngredient=new PanelIngredient();
                    MainWindow.panelShow.add(panelIngredient,"panelIngredient");
                    MainWindow.cardLayout.show(MainWindow.panelShow,"panelIngredient");

                } else if (typeString=="description") {
                    Ingredient.sortIngredientsByDescription(BakingSystem.ingredientList);
                    PanelIngredient panelIngredient=new PanelIngredient();
                    MainWindow.panelShow.add(panelIngredient,"panelIngredient");
                    MainWindow.cardLayout.show(MainWindow.panelShow,"panelIngredient");
                }else if (typeString=="calories") {
                    Ingredient.sortIngredientsByCalories(BakingSystem.ingredientList);
                    PanelIngredient panelIngredient=new PanelIngredient();
                    MainWindow.panelShow.add(panelIngredient,"panelIngredient");
                    MainWindow.cardLayout.show(MainWindow.panelShow,"panelIngredient");
                }
            }
        });


        JScrollPane scrollPane = new JScrollPane(ingredientShow);
        scrollPane.setPreferredSize(new Dimension(700,350));


        add(scrollPane,BorderLayout.CENTER);
    }
}
