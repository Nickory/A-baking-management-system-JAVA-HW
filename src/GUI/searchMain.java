package GUI;

import BakingInformationSystem.BakingSystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class searchMain extends JPanel {
    private JPanel search=new JPanel();

    private JComboBox<String> comboBox1=new JComboBox<String>();
    private JComboBox<String> comboBox=new JComboBox<String>();
    JTextField searchText=new JTextField(20);
    public searchMain(){

        search.setBounds(0, 0, 700, 400);
        search.setLayout(null);
        search.setVisible(true);

        JPanel control=new JPanel();
        control.setLayout(new FlowLayout(FlowLayout.CENTER));
        control.setBounds(0,100,700,200);



        comboBox.addItem(" ");
        comboBox.addItem("BakedGood");
        comboBox.addItem("Ingredient");
        comboBox.addItem("Recipe");



        comboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                comboBox1.removeAllItems();
                String comboBox1Text=(String) comboBox.getSelectedItem();
                comboBoxChange(comboBox1Text);
            }
        });


        JPanel panelButton=new JPanel();
        panelButton.setBounds(0,200,700,200);
        panelButton.setVisible(true);

        JButton search=new JButton("search!");
        search.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String comboBox1=(String) comboBox.getSelectedItem();
                String comboBox2=comboBoxChange((String) comboBox.getSelectedItem());
                try {
                    searchFunction(comboBox1,comboBox2);
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });

        panelButton.add(search,BorderLayout.CENTER);

        control.add(comboBox);
        control.add(comboBox1);
        control.add(searchText);

        add(control);
        add(panelButton);


    }

    public String comboBoxChange(String comboBox1Text){
        String comboBox=null;

        if(comboBox1Text=="BakedGood"){
            comboBox1.addItem(" ");
            comboBox1.addItem("name");
            comboBox1.addItem("description");
            comboBox1.addItem("origin");
            comboBox=(String) comboBox1.getSelectedItem();
        }

        if(comboBox1Text=="Ingredient"){
            comboBox1.addItem(" ");
            comboBox1.addItem("name");
            comboBox1.addItem("description");
            comboBox1.addItem("calories");
            comboBox=(String) comboBox1.getSelectedItem();
        }


        if(comboBox1Text=="Recipe") {
            comboBox1.addItem(" ");
            comboBox1.addItem("name");
            comboBox1.addItem("calories");
            comboBox=(String) comboBox1.getSelectedItem();
        }
        System.out.println(comboBox);
        return comboBox;
    }

    public void searchFunction(String comboBox1,String comboBox2) throws IOException {
        if(comboBox1=="BakedGood"){
            for(int i=0;i<BakingSystem.searchBakedGood(searchText.getText(),comboBox2).size();i++){
                DialogBaking bakedDialog=new DialogBaking(BakingSystem.searchBakedGood(searchText.getText(),comboBox2).getDataByIndex(i),200+i*10,200+i*10);
            }
        }
        if(comboBox1=="Ingredient"){
            for(int i=0;i<BakingSystem.searchIngredient(searchText.getText(),comboBox2).size();i++){
                DialogIngredient ingredientDialog=new DialogIngredient(BakingSystem.searchIngredient(searchText.getText(),comboBox2).getDataByIndex(i),200+i*10,200+i*10);
            }
        }
        if(comboBox1=="Recipe") {
            for (int i = 0; i < BakingSystem.searchRecipe(searchText.getText(), comboBox2).size(); i++) {
                DialogRecipe dialogRecipe = new DialogRecipe(BakingSystem.searchRecipe(searchText.getText(),comboBox2).getDataByIndex(i),200+i*10,200+i*10);
            }
        }

    }
}
