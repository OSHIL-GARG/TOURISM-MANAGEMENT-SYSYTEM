package Travel_management;

import javax.swing.*;
import java.awt.*;

public class BookPackage extends JFrame {
    BookPackage(){

        Choice cpackage;
        JTextField tfpersons;
        setBounds(350,200,1100,500);
        getContentPane().setBackground(Color.white);
        setLayout(null);

        JLabel text=new JLabel("BOOK PACKAGE");
        setBounds(100,10,200,30);
        text.setFont(new Font("Tahoma",Font.BOLD,20));
        add(text);

        JLabel lblusername = new JLabel("UserName");
        lblusername.setBounds(40, 70, 100, 20);
        lblusername.setFont(new Font("SAN_SERIF", Font.PLAIN, 16));
        add(lblusername);
         JLabel labelusername =new JLabel();
        lblusername.setFont(new Font("SAN_SERIF", Font.PLAIN, 16));
        labelusername.setBounds(250,70,200,20);
        add(labelusername);


        JLabel lblpackage = new JLabel("Select Package");
        lblpackage.setBounds(40, 110, 150, 20);
        lblpackage.setFont(new Font("SAN_SERIF", Font.PLAIN, 20));
        add(lblpackage);

        cpackage=new Choice();
        cpackage.add("Gold Package");
        cpackage.add("Silver Package");
        cpackage.add("Bronze Package");
        cpackage.setBounds(250,110,200,20);
        add(cpackage);




        JLabel lblpersons = new JLabel("Total Persons");
        lblpersons.setBounds(40, 150, 150, 25);
        lblpersons.setFont(new Font("SAN_SERIF", Font.PLAIN, 16));
        add(lblpersons);
        tfpersons = new JTextField();
        tfpersons.setBounds(250,150,200,20);
        add(tfpersons);

        JLabel lblid = new JLabel("ID");
        lblid.setBounds(40, 190, 150, 20);
        lblid.setFont(new Font("SAN_SERIF", Font.PLAIN, 16));
        add(lblid);
        JLabel labelid =new JLabel();
        labelid.setBounds(250,190,200,25);
        add(labelid);



        JLabel lblnumber = new JLabel("Number");
        lblnumber.setBounds(40, 230, 150, 25);
        lblnumber.setFont(new Font("SAN_SERIF", Font.PLAIN, 16));
        add(lblnumber);
        JLabel labelnumber =new JLabel();
        labelnumber.setBounds(250,230,150,25);
        add(labelnumber);




        setVisible(true);

    }


    public static void main(String[] args) {
        new BookPackage();
    }
}
