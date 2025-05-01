package Travel_management;

import javax.swing.*;
import java.awt.*;

public class CheckPackage extends JFrame {

CheckPackage(){
    setBounds(450,200,900,600);

    String[] package1={"Gold Package","6 DAYS & 7 NIGHTS ","AIRPORT ASSISTANCE","FULL DAY CITY TOUR","DAILY BUFFET","FULL DAY 3 ISLAND CRUISE","ENGLISH SPEAKING GUIDE","BOOK NOW","SUMMER SPECIAL","Rs.15000 ","package1.jpg"};
    String[] package2={"Silver Package","5 DAYS & 6 NIGHTS","TAXI FREE","HALF DAY CITY TOUR","DAILY BUFFET","1 DAY ISLAND CRUISE","RIVER RAFTING"," BOOK NOW","SUMMER SPECIAL","Rs.9000","package2.jpg"};
    String[] package3={"Bronze Package","3 DAYS & 4 NIGHTS","TAXI FREE","5 HOURS CITY TOUR","DAILY BUFFET","1/2 DAY ISLAND CRUISE","GAMES"," BOOK NOW","SUMMER SPECIAL","Rs.5000","package3.jpg"};
    JTabbedPane tab=new JTabbedPane();

    JPanel p1=createPackage(package1);
    tab.addTab("Package 1",null,p1);

    JPanel p2 =createPackage(package2);
    tab.addTab("Package 2",null, p2);
    JPanel p3 =createPackage(package3);
    tab.addTab("Package 3",null, p3);


    add(tab);

    setVisible(true);
}
 public JPanel createPackage(String[] pack){
     JPanel p1=new JPanel();
     p1.setLayout(null);
     p1.setBackground(Color.white);

     JLabel l1=new JLabel(pack[0]);
     l1.setBounds(50,5,300,30);
     l1.setForeground(Color.yellow);
     l1.setFont(new Font("Tahoma",Font.BOLD,30));
     p1.add(l1);

     JLabel l2 =new JLabel(pack[1]);
     l2.setBounds(30,60,300,30);
     l2.setForeground(Color.black);
     l2.setFont(new Font("Tahoma",Font.BOLD,20));
     p1.add(l2);

     JLabel l3 =new JLabel(pack[2]);
     l3.setBounds(30,110,300,30);
     l3.setForeground(Color.black);
     l3.setFont(new Font("Tahoma",Font.BOLD,20));
     p1.add(l3);

     JLabel l4 =new JLabel(pack[3]);
     l4.setBounds(30,160,300,30);
     l4.setForeground(Color.black);
     l4.setFont(new Font("Tahoma",Font.BOLD,20));
     p1.add(l4);

     JLabel l5 =new JLabel(pack[4]);
     l5.setBounds(30,210,300,30);
     l5.setForeground(Color.black);
     l5.setFont(new Font("Tahoma",Font.BOLD,20));
     p1.add(l5);

     JLabel l6 =new JLabel(pack[5]);
     l6.setBounds(30,260,300,30);
     l6.setForeground(Color.black);
     l6.setFont(new Font("Tahoma",Font.BOLD,20));
     p1.add(l6);

     JLabel l7 =new JLabel(pack[6]);
     l7.setBounds(30,310,300,30);
     l7.setForeground(Color.black);
     l7.setFont(new Font("Tahoma",Font.BOLD,20));
     p1.add(l7);

     JLabel l8 =new JLabel(pack[7]);
     l8.setBounds(60,380,300,30);
     l8.setForeground(Color.RED);
     l8.setFont(new Font("Tahoma",Font.BOLD,25));
     p1.add(l8);

     JLabel l9 =new JLabel(pack[8]);
     l9.setBounds(20,430,300,30);
     l9.setForeground(Color.magenta);
     l9.setFont(new Font("Tahoma",Font.BOLD,25));
     p1.add(l9);

     JLabel l10 =new JLabel(pack[9]);
     l10.setBounds(500,430,300,30);
     l10.setForeground(Color.red);
     l10.setFont(new Font("Tahoma",Font.BOLD,40));
     p1.add(l10);

     try {
         // Load image correctly
         ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/icons/"+pack[10]));
         Image i2 = i1.getImage().getScaledInstance(500, 300, Image.SCALE_DEFAULT);
         ImageIcon i3 = new ImageIcon(i2);
         // Check if the image is null (not found)
         if (i1.getImage() == null) {
             throw new NullPointerException("Error: Image not found! Check the path.");
         }

         JLabel image = new JLabel(i3);
         image.setBounds(350, 50, 500, 300);

         p1.add(image);

     } catch (NullPointerException e) {
         System.out.println(e.getMessage()); // Print error message to console
         JOptionPane.showMessageDialog(this, "Image not found! Check the file path.", "Error", JOptionPane.ERROR_MESSAGE);
     }
     return p1;
 }



    public static void main(String[] args) {
        new CheckPackage();
    }
}
