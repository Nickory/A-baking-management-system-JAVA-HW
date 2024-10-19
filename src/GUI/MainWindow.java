package GUI;

import BakingInformationSystem.BakedGood;
import BakingInformationSystem.BakingSystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.io.IOException;

import  saveAndLoad.*;

public class MainWindow extends JFrame {
    JFrame frameMain= new JFrame("Baking Information System");
    JPanel panelButton=new JPanel();
    public static JPanel panelShow=new JPanel();
    public static CardLayout cardLayout=new CardLayout();
    public MainWindow() {

        frameMain.setBounds(200, 200, 700, 500);

        //Set layout
        panelShow.setBounds(0, 50, 700, 400);

        panelShow.setLayout(cardLayout);


        panelButton.setBounds(0, 0, 700, 50);
        panelButton.setVisible(true);
        panelButton.setLayout(new FlowLayout(FlowLayout.LEFT));

        //Add the control to the panelButton

        //The first button displays panelBaking
        JButton buttonBaking = new JButton("Baking");
        buttonBaking.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PanelBaking panelBaking = new PanelBaking();
                panelShow.add(panelBaking, "panelBaking");
                cardLayout.show(panelShow, "panelBaking");
            }
        });

        //The second button displays the panelIngredient

        JButton buttonIngredient = new JButton("Ingredient");
        buttonIngredient.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PanelIngredient panelIngredient = new PanelIngredient();
                panelShow.add(panelIngredient, "panelIngredient");
                cardLayout.show(panelShow, "panelIngredient");
            }
        });
        //The third button displays panelRecipes
        JButton buttonRecipes = new JButton("Recipes");
        buttonRecipes.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PanelRecipes panelRecipes = new PanelRecipes();
                panelShow.add(panelRecipes, "panelRecipes");
                cardLayout.last(panelShow);
            }
        });

        panelButton.add(buttonBaking);
        panelButton.add(buttonIngredient);
        panelButton.add(buttonRecipes);


        //The fourth button implements the addBakedGood method
        JButton addBakedGood = new JButton("add BakedGood");
        addBakedGood.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addBakedGood addBakedGood1 = new addBakedGood();
                panelShow.add(addBakedGood1, "addBakedGood1");
                cardLayout.show(panelShow, "addBakedGood1");
            }
        });

        //The fifth button implements the addIngredient method
        JButton addIngredient = new JButton("add Ingredient");
        addIngredient.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addIngredient addIngredient1 = new addIngredient();
                panelShow.add(addIngredient1, "addIngredient1");
                cardLayout.show(panelShow, "addIngredient1");
            }
        });

        //The sixth method implements the addRecipes method
        JButton addRecipes = new JButton("add Recipes");
        addRecipes.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addRecipe addRecipe1 = new addRecipe();
                panelShow.add(addRecipe1, "addRecipe1");
                cardLayout.show(panelShow, "addRecipe1");
            }
        });

        //The seventh button implements the save method
        JButton save = new JButton("save");
        save.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                saveAndLoad.save.saveSystemData();
            }
        });

        //The eighth button implements the load function
        JButton load = new JButton("load");
        load.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                saveAndLoad.load.loadSystemData();
            }
        });

        JButton clear = new JButton("designer/clear");
        clear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                BakingSystem.clear();
            }
        });

        JButton designer=new JButton("clear");
        clear.addActionListener(new ActionListener() {
            @Override

            public void actionPerformed(ActionEvent e) {
                String projectDir = System.getProperty("user.dir");
                BakedGood JerryHuang =new BakedGood("JerryHuang","Japan","Colonel from Japan",projectDir+"/JerryHuang.jpg");
                try {
                    DialogBaking jerry=new DialogBaking(JerryHuang);
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });

        //The ninth button implements the search function
        JButton search=new JButton("search");
        search.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                searchMain search1=new searchMain();
                panelShow.add(search1,"search1");
                cardLayout.show(panelShow,"search1");
            }
        });
        //Set the control panel for the add method, save method, and load method
        JPanel panelControl=new JPanel();
        panelControl.setBounds(0,450,700,50);
        panelControl.setLayout(new FlowLayout(FlowLayout.LEFT));


        panelControl.add(addBakedGood);
        panelControl.add(addIngredient);
        panelControl.add(addRecipes);
        panelControl.add(save);
        panelControl.add(load);
        
        panelControl.add(clear);

        panelButton.add(search);






      frameMain.add(panelButton,BorderLayout.NORTH);
      frameMain.setVisible(true);
      frameMain.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
      frameMain.add(panelShow,BorderLayout.CENTER);
      frameMain.add(panelControl,BorderLayout.SOUTH);
  }


}
