package Travel_management;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class ViewCustomer extends JFrame implements ActionListener {
    JLabel labelusername,labelid,labelnumber,labelname,labelgender,labelcountry,labeladdress,labelemail,labelphone;
    JButton back;


    ViewCustomer(String username){
        setBounds(450,180,870,625);
        getContentPane().setBackground(Color.white);
        setLayout(null);

        JLabel lblusername = new JLabel("UserName");
        lblusername.setBounds(30, 50, 150, 25);
        lblusername.setFont(new Font("SAN_SERIF", Font.PLAIN, 20));
        add(lblusername);
        labelusername =new JLabel();
        labelusername.setBounds(220,50,150,25);
        add(labelusername);


        JLabel lblid = new JLabel("ID");
        lblid.setBounds(30, 110, 150, 25);
        lblid.setFont(new Font("SAN_SERIF", Font.PLAIN, 20));
        add(lblid);
        labelid =new JLabel();
        labelid.setBounds(220,110,150,25);
        add(labelid);

        JLabel lblnumber = new JLabel("ID Number");
        lblnumber.setBounds(30, 170, 150, 25);
        lblnumber.setFont(new Font("SAN_SERIF", Font.PLAIN, 20));
        add(lblnumber);
        labelnumber = new JLabel();
        labelnumber.setBounds(220,170,150,25);
        add(labelnumber);

        JLabel lblname = new JLabel("Name");
        lblname.setBounds(30, 230, 150, 25);
        lblname.setFont(new Font("SAN_SERIF", Font.PLAIN, 20));
        add(lblname);
        labelname =new JLabel();
        labelname.setBounds(220,230,150,25);
        add(labelname);

        JLabel lblgender = new JLabel("Gender");
        lblgender.setBounds(30, 290, 150, 25);
        lblgender.setFont(new Font("SAN_SERIF", Font.PLAIN, 20));
        add(lblgender);
        labelgender =new JLabel();
        labelgender.setBounds(220,290,150,25);
        add(labelgender);

        JLabel lblcountry = new JLabel("Country");
        lblcountry.setBounds(500, 50, 150, 25);
        lblcountry.setFont(new Font("SAN_SERIF", Font.PLAIN, 20));
        add(lblcountry);
        labelcountry =new JLabel();
        labelcountry.setBounds(690,50,150,25);
        add(labelcountry);

        JLabel lbladdress = new JLabel("Address");
        lbladdress.setBounds(500, 110, 150, 25);
        lbladdress.setFont(new Font("SAN_SERIF", Font.PLAIN, 20));
        add(lbladdress);
        labeladdress =new JLabel();
        labeladdress.setBounds(690,110,150,25);
        add(labeladdress);

        JLabel lblemail = new JLabel("EMail");
        lblemail.setBounds(500, 170, 150, 25);
        lblemail.setFont(new Font("SAN_SERIF", Font.PLAIN, 20));
        add(lblemail);
        labelemail =new JLabel();
        labelemail.setBounds(690,170,150,25);
        add(labelemail);

        JLabel lblphone = new JLabel("Phone");
        lblphone.setBounds(500, 230, 150, 25);
        lblphone.setFont(new Font("SAN_SERIF", Font.PLAIN, 20));
        add(lblphone);
        labelphone=new JLabel();
        labelphone.setBounds(690,230,150,25);
        add(labelphone);

        back=new JButton("BACK");
        back.setBackground(Color.black);
        back.setForeground(Color.white);
        back.setBounds(350,350,100,25);
        back.addActionListener(this);
        add(back);

        try {
            // Load image correctly
            ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/icons/viewall.jpg"));
            Image i2 = i1.getImage().getScaledInstance(600, 200, Image.SCALE_DEFAULT);
            ImageIcon i3 = new ImageIcon(i2);
            // Check if the image is null (not found)
            if (i1.getImage() == null) {
                throw new NullPointerException("Error: Image not found! Check the path.");
            }

            JLabel image = new JLabel(i3);
            image.setBounds(20, 400, 600, 200);

            add(image);

        } catch (NullPointerException e) {
            System.out.println(e.getMessage()); // Print error message to console
            JOptionPane.showMessageDialog(this, "Image not found! Check the file path.", "Error", JOptionPane.ERROR_MESSAGE);
        }
//        image repeat
        try {
            // Load image correctly
            ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/icons/viewall.jpg"));
            Image i2 = i1.getImage().getScaledInstance(600, 200, Image.SCALE_DEFAULT);
            ImageIcon i3 = new ImageIcon(i2);
            // Check if the image is null (not found)
            if (i1.getImage() == null) {
                throw new NullPointerException("Error: Image not found! Check the path.");
            }

            JLabel image = new JLabel(i3);
            image.setBounds(600, 400, 600, 200);

            add(image);

        } catch (NullPointerException e) {
            System.out.println(e.getMessage()); // Print error message to console
            JOptionPane.showMessageDialog(this, "Image not found! Check the file path.", "Error", JOptionPane.ERROR_MESSAGE);
        }


        try{
            Conn conn=new Conn();
            String query="select * from customer where username='"+username+"'";
            ResultSet rs=conn.s.executeQuery(query);
            while (rs.next()){
                labelusername.setText(rs.getString("username"));
                labelid.setText(rs.getString("id"));
                labelnumber.setText(rs.getString("number"));
                labelname.setText(rs.getString("name"));
                labelgender.setText(rs.getString("gender"));
                labelcountry.setText(rs.getString("country"));
                labeladdress.setText(rs.getString("address"));
                labelemail.setText(rs.getString("email"));
                labelphone.setText(rs.getString("phone"));

            }


        }catch (Exception e){
            e.printStackTrace();
        }

        setVisible(true);

    }
    public void actionPerformed(ActionEvent ae){
        setVisible(false);
    }


    public static void main(String[] args) {
        new ViewCustomer("qwerty");
    }
}
