package GUI;

import BakingInformationSystem.BakedGood;
import BakingInformationSystem.BakingSystem;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;

public class DialogBaking extends JDialog {
    JDialog bakedDialog=new JDialog();
    String name;
    String description;
    String origin;
    String url;

    private static ImageIcon createImageIcon(String path, String description) throws IOException {
        File file = new File(path);
        BufferedImage image = ImageIO.read(file);
        return new ImageIcon(image, description);
    }

    private static ImageIcon scaleImage(ImageIcon icon, int width, int height) {
        Image image = icon.getImage();
        Image scaledImage = image.getScaledInstance(width, height, Image.SCALE_SMOOTH);
        return new ImageIcon(scaledImage);
    }

    public DialogBaking(BakedGood bakedGood,int x,int y) throws IOException {
        if(bakedGood==null){
            return;
        }
        name=bakedGood.getName();
        description=bakedGood.getDescription();
        origin=bakedGood.getOrigin();
        url=bakedGood.getImageUrl();
        System.out.println(name+description+origin+url);
        bakedDialog.setBounds(x,y,500,600);

        String imagePath = url;
        ImageIcon originalIcon = createImageIcon(imagePath, "Original Image");
        ImageIcon scaledIcon = scaleImage(originalIcon, 300, 300);
        //put the picture
        JPanel picturePanel=new JPanel();
        picturePanel.setBounds(100,0,300,300);


        JLabel jLabel=new JLabel();
        jLabel.setIcon(scaledIcon);
        picturePanel.add(jLabel);



        //Create a new JPanel to store the properties of the item
        JPanel jPanel=new JPanel();
        jPanel.setLayout(new GridLayout(3,2));
        jPanel.setBounds(100,300,300,200);

        JLabel label=new JLabel("name:");
        JLabel label1=new JLabel("origin:");
        JLabel label2=new JLabel("description:");
        JLabel label3=new JLabel(name);
        JLabel label4=new JLabel(origin);
        JTextArea jTextArea=new JTextArea(10,10);
        jTextArea.setLineWrap(true);
        jTextArea.setEditable(false);
        jTextArea.setText(description);
        JScrollPane jScrollPane=new JScrollPane(jTextArea);
        jScrollPane.getVerticalScrollBar().setValue(0);

        jPanel.add(label);
        jPanel.add(label3);
        jPanel.add(label1);
        jPanel.add(label4);
        jPanel.add(label2);
        jPanel.add(jScrollPane);

        //JPanel to store the button
        JPanel panelButton=new JPanel();
        panelButton.setLayout(new FlowLayout(FlowLayout.CENTER));
        panelButton.setBounds(0,500,500,50);

        JButton ok=new JButton("ok");
        ok.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                bakedDialog.dispose();
            }
        });
        JButton amend=new JButton("amend");
        amend.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                bakedDialog.dispose();
                JDialog jDialog=new JDialog();
                jDialog.setLayout(new FlowLayout(FlowLayout.LEADING));


                JLabel nameLabel=new JLabel("name");
                JLabel originLabel=new JLabel("place/country of origin");
                JLabel descriptionLabel=new JLabel("description");
                JLabel pictureLabel=new JLabel("URL address");

                JTextField nameText=new JTextField();
                nameText.setText(name);
                JTextField originText=new JTextField();
                originText.setText(origin);
                JTextField desText=new JTextField();
                desText.setText(description);
                JTextField URLText=new JTextField();
                URLText.setText(url);



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

                JButton ok=new JButton("ok");




                jDialog.add(addPanel);
                jDialog.add(ok);
                ok.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        BakingSystem.editBakedGood(name,nameText.getText(),originText.getText(),desText.getText(),URLText.getText());
                        PanelBaking panelBaking=new PanelBaking();
                        MainWindow.panelShow.add(panelBaking,"panelBaking");
                        MainWindow.cardLayout.show(MainWindow.panelShow,"panelBaking");
                        jDialog.dispose();
                    }
                });

                jDialog.setBounds(200,200,1000,200);
                jDialog.setVisible(true);

            }
        });
        JButton remove=new JButton("remove");
        remove.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                BakingSystem.deleteBakedGood(bakedGood.getName());
                PanelBaking panelBaking=new PanelBaking();
                MainWindow.panelShow.add(panelBaking,"panelBaking");
                MainWindow.cardLayout.show(MainWindow.panelShow,"panelBaking");
                bakedDialog.dispose();

            }
        });
        panelButton.add(ok);
        panelButton.add(amend);
        panelButton.add(remove);


        bakedDialog.add(picturePanel);
        bakedDialog.add(jPanel);
        bakedDialog.add(panelButton);


        bakedDialog.setLayout(null);
        bakedDialog.setVisible(true);
        bakedDialog.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

    }

    public DialogBaking(BakedGood bakedGood) throws IOException {
if (bakedGood==null) {
return;
};

        name=bakedGood.getName();
        description=bakedGood.getDescription();
        origin=bakedGood.getOrigin();
        url=bakedGood.getImageUrl();
        System.out.println(name+description+origin+url);
        bakedDialog.setBounds(200,200,500,600);

        String imagePath = url;
        ImageIcon originalIcon = createImageIcon(imagePath, "Original Image");
        ImageIcon scaledIcon = scaleImage(originalIcon, 300, 300);

        JPanel picturePanel=new JPanel();
        picturePanel.setBounds(100,0,300,300);


        JLabel jLabel=new JLabel();
        jLabel.setIcon(scaledIcon);
        picturePanel.add(jLabel);



        //Create a new JPanel to store the properties of the item
        JPanel jPanel=new JPanel();
        jPanel.setLayout(new GridLayout(3,2));
        jPanel.setBounds(100,300,300,200);

        JLabel label=new JLabel("name:");
        JLabel label1=new JLabel("origin:");
        JLabel label2=new JLabel("description:");
        JLabel label3=new JLabel(name);
        JLabel label4=new JLabel(origin);
        JTextArea jTextArea=new JTextArea();
        jTextArea.setLineWrap(true);
        jTextArea.setEditable(false);
        jTextArea.setText(description);
        JScrollPane jScrollPane=new JScrollPane(jTextArea);
        jScrollPane.setVerticalScrollBarPolicy(jScrollPane.VERTICAL_SCROLLBAR_NEVER);
        jScrollPane.getVerticalScrollBar().setValue(0);

        jPanel.add(label);
        jPanel.add(label3);
        jPanel.add(label1);
        jPanel.add(label4);
        jPanel.add(label2);
        jPanel.add(jScrollPane);


        JPanel panelButton=new JPanel();
        panelButton.setLayout(new FlowLayout(FlowLayout.CENTER));
        panelButton.setBounds(0,500,500,50);

        JButton ok=new JButton("ok");
        ok.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                bakedDialog.dispose();
            }
        });
        JButton amend=new JButton("amend");
        amend.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                bakedDialog.dispose();
                JDialog jDialog=new JDialog();
                jDialog.setLayout(new FlowLayout(FlowLayout.LEADING));


                JLabel nameLabel=new JLabel("name");
                JLabel originLabel=new JLabel("place/country of origin");
                JLabel descriptionLabel=new JLabel("description");
                JLabel pictureLabel=new JLabel("URL address");

                JTextField nameText=new JTextField();
                nameText.setText(name);
                JTextField originText=new JTextField();
                originText.setText(origin);
                JTextField desText=new JTextField();
                desText.setText(description);
                JTextField URLText=new JTextField();
                URLText.setText(url);




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

                JButton ok=new JButton("ok");




                jDialog.add(addPanel);
                jDialog.add(ok);
                ok.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        System.out.println(name);
                       BakingSystem.editBakedGood(name,nameText.getText(),originText.getText(),desText.getText(),URLText.getText());
                        System.out.println(nameText.getText());
                        PanelBaking panelBaking=new PanelBaking();
                        MainWindow.panelShow.add(panelBaking,"panelBaking");
                        MainWindow.cardLayout.show(MainWindow.panelShow,"panelBaking");
                       jDialog.dispose();
                    }
                });

                jDialog.setBounds(200,200,1000,200);
                jDialog.setVisible(true);

            }
        });
        JButton remove=new JButton("remove");
        remove.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                BakingSystem.deleteBakedGood(bakedGood.getName());
                PanelBaking panelBaking=new PanelBaking();
                MainWindow.panelShow.add(panelBaking,"panelBaking");
                MainWindow.cardLayout.show(MainWindow.panelShow,"panelBaking");
                bakedDialog.dispose();

            }
        });
        panelButton.add(ok);
        panelButton.add(amend);
        panelButton.add(remove);


        bakedDialog.add(picturePanel);
        bakedDialog.add(jPanel);
        bakedDialog.add(panelButton);


        bakedDialog.setLayout(null);
        bakedDialog.setVisible(true);
        bakedDialog.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);


    }
}
