package Travel_management;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class BookPackage extends JFrame  implements ActionListener {
    Choice cpackage;
    JTextField tfpersons;
    String username;
    JButton checkprice,bookpackage,back;
    JLabel labelusername,labelid,labelnumber,labelphone,labelprice,labelpersons;
    BookPackage(String username){

       this.username=username;
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
         labelusername =new JLabel();
        labelusername.setFont(new Font("SAN_SERIF", Font.PLAIN, 16));
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




        labelpersons = new JLabel("Total Persons");
        labelpersons.setBounds(40, 150, 150, 25);
        labelpersons.setFont(new Font("SAN_SERIF", Font.PLAIN, 16));
        add(labelpersons);
        tfpersons = new JTextField();
        tfpersons.setBounds(250,150,200,20);
        add(tfpersons);

        JLabel lblid = new JLabel("ID");
        lblid.setBounds(40, 190, 150, 20);
        lblid.setFont(new Font("SAN_SERIF", Font.PLAIN, 16));
        add(lblid);
         labelid =new JLabel();
        labelid.setBounds(250,190,200,25);
        add(labelid);



        JLabel lblnumber = new JLabel("Number");
        lblnumber.setBounds(40, 230, 150, 25);
        lblnumber.setFont(new Font("SAN_SERIF", Font.PLAIN, 16));
        add(lblnumber);
        labelnumber =new JLabel();
        labelnumber.setBounds(250,230,150,25);
        add(labelnumber);

        JLabel lblphone = new JLabel("Phone");
        lblphone.setBounds(40, 270, 150, 25);
        lblphone.setFont(new Font("SAN_SERIF", Font.PLAIN, 16));
        add(lblphone);
        labelphone =new JLabel();
        labelphone.setBounds(250,270,200,25);
        add(labelphone);

        JLabel lbltotal = new JLabel("Total Price");
        lbltotal.setBounds(40, 310, 150, 25);
        lbltotal.setFont(new Font("SAN_SERIF", Font.PLAIN, 16));
        add(lbltotal);
         labelprice = new JLabel();
        labelprice.setBounds(250,310,200,25);
        add(labelprice);

        try{
            Conn conn=new Conn();
            String query="select * from customer where username='"+username+"'";
            ResultSet rs=conn.s.executeQuery(query);
            while (rs.next()){
                labelusername.setText(rs.getString("username"));
                labelid.setText(rs.getString("id"));
                labelnumber.setText(rs.getString("number"));
                labelphone.setText(rs.getString("phone"));

            }


        }catch (Exception e){
            e.printStackTrace();
        }

        checkprice =new JButton("Check Price");
        checkprice.setBounds(60,380,120,25);
        checkprice.setForeground(Color.white);
        checkprice.setBackground(Color.BLACK);
        checkprice.addActionListener(this);
        add(checkprice);

        bookpackage =new JButton("Book Package");
        bookpackage.setBounds(200,380,120,25);
        bookpackage.setForeground(Color.white);
        bookpackage.setBackground(Color.BLACK);
        bookpackage.addActionListener(this);
        add(bookpackage);

        back =new JButton("Back");
        back.setBounds(340,380,120,25);
        back.setForeground(Color.white);
        back.setBackground(Color.BLACK);
        back.addActionListener(this);
        add(back);

        try {
            // Load image correctly
            ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/icons/bookpackage.jpg"));
            Image i2 = i1.getImage().getScaledInstance(500, 300, Image.SCALE_DEFAULT);
            ImageIcon i3 = new ImageIcon(i2);
            // Check if the image is null (not found)
            if (i1.getImage() == null) {
                throw new NullPointerException("Error: Image not found! Check the path.");
            }

            JLabel image = new JLabel(i3);
            image.setBounds(550, 50, 500, 300);

            add(image);

        } catch (NullPointerException e) {
            System.out.println(e.getMessage()); // Print error message to console
            JOptionPane.showMessageDialog(this, "Image not found! Check the file path.", "Error", JOptionPane.ERROR_MESSAGE);
        }

        setVisible(true);

    }
    public  void actionPerformed(ActionEvent ae){
        if (ae.getSource()==checkprice){

            String pack=cpackage.getSelectedItem();
            int cost=0;
            if (pack.equals("Gold Package")){
                cost+=15000;
            } else if (pack.equals("Silver Package")) {
                cost+=9000;
            }else {
                cost+=5000;
            }

            int persons=Integer.parseInt(tfpersons.getText());
            cost*=persons;
            labelprice.setText("Rs."+cost);

        }else if(ae.getSource()==bookpackage){

            try{
                Conn c=new Conn();
                c.s.executeUpdate("insert into bookpackage values('"+labelusername.getText()+"','"+cpackage.getSelectedItem()+"','"+tfpersons.getText()+"','"+labelid.getText()+"','"+labelnumber.getText()+"','"+labelphone.getText()+"','"+labelprice.getText()+"')");

                JOptionPane.showMessageDialog(null,"Package booked successfully");
                setVisible(false);
            }catch (Exception e){
                e.printStackTrace();
            }
        }else {
            setVisible(false);
        }
    }


    public static void main(String[] args) {
        new BookPackage("qwerty");
    }
}
