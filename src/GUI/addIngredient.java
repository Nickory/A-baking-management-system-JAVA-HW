package GUI;

import BakingInformationSystem.BakingSystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLOutput;
import java.util.function.DoublePredicate;

public class addIngredient extends JPanel {
    JPanel addIngredient =new JPanel();
    public static String name;
    public static String des;
    public static double calories;
    public addIngredient(){
        addIngredient.setBounds(0,50,700,400);
        addIngredient.setVisible(true);

        //Properties owned by BakedGood
        JLabel nameLabel=new JLabel("name");
        JLabel desLabel=new JLabel("description");
        JLabel calLabel=new JLabel("calories");

        JTextField nameText=new JTextField();
        JTextField desText=new JTextField();
        JTextField calText=new JTextField();

        JButton add=new JButton("add");
        add.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println(name+des+calories);
                name=nameText.getText();
                des=desText.getText();
                calories=Double.parseDouble(calText.getText());
                BakingSystem.addIngredient(name,des,calories);
                System.out.println(BakingSystem.listAllRIngredientByName());
                nameText.setText(" ");
                desText.setText(" ");
                calText.setText(" ");
            }
        });

        JPanel addPanel=new JPanel();
        addPanel.setLayout(new GridLayout(3,2));
        addPanel.add(nameLabel);
        addPanel.add(nameText);
        addPanel.add(desLabel);
        addPanel.add(desText);
        addPanel.add(calLabel);
        addPanel.add(calText);



        add(addPanel,BorderLayout.CENTER);
        add(add,BorderLayout.CENTER);


    }
}
