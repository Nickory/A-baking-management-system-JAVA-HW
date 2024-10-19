package GUI;

import BakingInformationSystem.BakingSystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class addBakedGood extends JPanel {
    JPanel addBakedGood =new JPanel();
    public static String name;
    public static String origin;
    public static String description;
    public static String URL;
    public addBakedGood(){
        addBakedGood.setBounds(0,50,700,400);
        addBakedGood.setVisible(true);

        //BakedGood所拥有的属性
         JLabel nameLabel=new JLabel("name");
         JLabel originLabel=new JLabel("place/country of origin");
         JLabel descriptionLabel=new JLabel("description");
         JLabel pictureLabel=new JLabel("URL address");

         JTextField nameText=new JTextField();
         JTextField originText=new JTextField();
         JTextField desText=new JTextField();
         JTextField URLText=new JTextField();

         JButton browseButton=new JButton("browse picture");
         browseButton.addActionListener(new ActionListener() {
             @Override
             public void actionPerformed(ActionEvent e) {
                 JFileChooser jFileChooser=new JFileChooser();
                 int result=jFileChooser.showOpenDialog(new JFileChooser());
                 if(result==JFileChooser.APPROVE_OPTION){
                     File selectedFile=jFileChooser.getSelectedFile();
                     URLText.setText(selectedFile.getAbsolutePath());
                 }
             }
         });



        JPanel addPanel=new JPanel();
        addPanel.setLayout(new GridLayout(4,2));
        addPanel.add(nameLabel);
        addPanel.add(nameText);
        addPanel.add(originLabel);
        addPanel.add(originText);
        addPanel.add(descriptionLabel);
        addPanel.add(desText);
        addPanel.add(pictureLabel);
        addPanel.add(URLText);






        JButton add=new JButton("add");
        add.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                name=nameText.getText();

                origin=originText.getText();
                description=desText.getText();
                URL=URLText.getText();
                BakingSystem.addBakedGood(name,origin,description,URL);
                System.out.println(BakingSystem.listAllBakedGoodsByName());
                nameText.setText(" ");
                originText.setText(" ");
                desText.setText(" ");
                URLText.setText(" ");


            }
        });

        add(browseButton,BorderLayout.CENTER);
       add(addPanel,BorderLayout.CENTER);
       add(add,BorderLayout.CENTER);





    }
}
