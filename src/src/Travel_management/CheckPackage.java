package Travel_management;

import javax.swing.*;
import java.awt.*;

public class CheckPackage extends JFrame {

CheckPackage(){
    setBounds(450,200,900,600);

    JTabbedPane tab=new JTabbedPane();

    JPanel p1=new JPanel();
    p1.setLayout(null);
    p1.setBackground(Color.white);

    JLabel l1=new JLabel("GOLD PACKAGE");
    l1.setBounds(50,5,300,30);
    l1.setForeground(Color.yellow);
    l1.setFont(new Font("Tahoma",Font.BOLD,30));
    p1.add(l1);

    JLabel l2 =new JLabel("6 DAYS & 7 NIGHTS");
    l2.setBounds(30,60,300,30);
    l2.setForeground(Color.black);
    l2.setFont(new Font("Tahoma",Font.BOLD,20));
    p1.add(l2);

    JLabel l3 =new JLabel("AIRPORT ASSISTANCE");
    l3.setBounds(30,110,300,30);
    l3.setForeground(Color.black);
    l3.setFont(new Font("Tahoma",Font.BOLD,20));
    p1.add(l3);

    JLabel l4 =new JLabel("HALF DAY CITY TOUR");
    l4.setBounds(30,160,300,30);
    l4.setForeground(Color.black);
    l4.setFont(new Font("Tahoma",Font.BOLD,20));
    p1.add(l4);

    JLabel l5 =new JLabel("DAILY BUFFET");
    l5.setBounds(30,210,300,30);
    l5.setForeground(Color.black);
    l5.setFont(new Font("Tahoma",Font.BOLD,20));
    p1.add(l5);

    JLabel l6 =new JLabel("FULL DAY 3 ISLAND CRUISE");
    l6.setBounds(30,260,300,30);
    l6.setForeground(Color.black);
    l6.setFont(new Font("Tahoma",Font.BOLD,20));
    p1.add(l6);

    JLabel l7 =new JLabel("ENGLISH SPEAKING GUIDE");
    l7.setBounds(30,310,300,30);
    l7.setForeground(Color.black);
    l7.setFont(new Font("Tahoma",Font.BOLD,20));
    p1.add(l7);

    JLabel l8 =new JLabel("BOOK NOW");
    l8.setBounds(60,380,300,30);
    l8.setForeground(Color.RED);
    l8.setFont(new Font("Tahoma",Font.BOLD,25));
    p1.add(l8);

    JLabel l9 =new JLabel("SUMMER SPECIAL");
    l9.setBounds(20,430,300,30);
    l9.setForeground(Color.magenta);
    l9.setFont(new Font("Tahoma",Font.BOLD,25));
    p1.add(l9);

    JLabel l10 =new JLabel("Rs. 12000 ");
    l10.setBounds(500,430,300,30);
    l10.setForeground(Color.red);
    l10.setFont(new Font("Tahoma",Font.BOLD,40));
    p1.add(l10);

    try {
        // Load image correctly
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/icons/package1.jpg"));
        Image i2 = i1.getImage().getScaledInstance(500, 300, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        // Check if the image is null (not found)
        if (i1.getImage() == null) {
            throw new NullPointerException("Error: Image not found! Check the path.");
        }

        JLabel image = new JLabel(i3);
        image.setBounds(350, 50, 500, 300);

        add(image);

    } catch (NullPointerException e) {
        System.out.println(e.getMessage()); // Print error message to console
        JOptionPane.showMessageDialog(this, "Image not found! Check the file path.", "Error", JOptionPane.ERROR_MESSAGE);
    }

    tab.addTab("Package 1",null,p1);

    add(tab);









    setVisible(true);
}




    public static void main(String[] args) {
        new CheckPackage();
    }
}
