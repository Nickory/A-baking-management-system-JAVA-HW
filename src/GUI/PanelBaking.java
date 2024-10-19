package GUI;

import BakingInformationSystem.BakedGood;
import BakingInformationSystem.BakingSystem;

import javax.swing.*;
import javax.swing.event.AncestorEvent;
import javax.swing.event.AncestorListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.Scanner;

public class PanelBaking extends JPanel {
    JPanel panelBaking=new JPanel();

    public PanelBaking() {
        //basically set
        panelBaking.setBounds(0, 0, 700, 400);
        panelBaking.setVisible(true);



        JPanel bakingShow = new JPanel();
        bakingShow.setLayout(null);

        int size;
        size = BakingSystem.bakedGoodLists.size();

        if(size==0){
            JDialog dialog=new JDialog();
            dialog.setLayout(new FlowLayout(FlowLayout.LEADING));
            dialog.setBounds(200,200,200,150);
            dialog.add(new JLabel("please add a Baked Good"));
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
        if (size / 4 == 0) {
            rows = size / 4;
        } else {
            rows = size / 4 + 1;
        }
        bakingShow.setLayout(new GridLayout(rows, 4,5,5));
        for (int i = 0; i < size; i++) {
            String name=BakingSystem.bakedGoodLists.getDataByIndex(i).getName();
            JButton jButton=new JButton(name);
            int finalI = i;
            jButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    try {
                        DialogBaking bakedDialog=new DialogBaking(BakingSystem.bakedGoodLists.getDataByIndex(finalI));
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                }
                }
            );
            bakingShow.add(jButton);

        }

        JPanel differentTypeSearch=new JPanel();
        JComboBox<String>type=new JComboBox<String>();
        type.addItem(" ");
        type.addItem("name");
        type.addItem("origin");
        type.addItem("description");

        differentTypeSearch.add(type);

        add(differentTypeSearch,BorderLayout.NORTH);
        type.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String typeString=(String)type.getSelectedItem();
                if(typeString=="name"){
                    BakedGood.sortBakedGoodsByName(BakingSystem.bakedGoodLists);
                    PanelBaking panelBaking=new PanelBaking();
                    MainWindow.panelShow.add(panelBaking,"panelBaking");
                    MainWindow.cardLayout.show(MainWindow.panelShow,"panelBaking");

                } else if (typeString=="origin") {

                    BakedGood.sortBakedGoodsByOrigin(BakingSystem.bakedGoodLists);
                    PanelBaking panelBaking=new PanelBaking();
                    MainWindow.panelShow.add(panelBaking,"panelBaking");
                    MainWindow.cardLayout.show(MainWindow.panelShow,"panelBaking");
                }else if (typeString=="description") {
                    BakedGood.sortBakedGoodsByDescription(BakingSystem.bakedGoodLists);
                    PanelBaking panelBaking=new PanelBaking();
                    MainWindow.panelShow.add(panelBaking,"panelBaking");
                    MainWindow.cardLayout.show(MainWindow.panelShow,"panelBaking");
                }
            }
        });



        //Set a new JScrollPane and add the bakingShow to it
        JScrollPane scrollPane = new JScrollPane(bakingShow);
        scrollPane.setPreferredSize(new Dimension(700,350));

        //Add the JScrollPane to the bakingPanel
        add(scrollPane, BorderLayout.CENTER);
    }
}
