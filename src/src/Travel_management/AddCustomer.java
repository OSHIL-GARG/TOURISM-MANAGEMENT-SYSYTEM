package Travel_management;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class AddCustomer extends JFrame implements ActionListener {

    JLabel labelusername,labelname;
    JComboBox comboid;
    JTextField tfnumber,tfadress, tfcountry,tfemail,tfphone;
    JRadioButton rmale, rfemale,rother;
    JButton add,back;
    String username;
    AddCustomer(String username){
        this.username=username;
        setBounds(450,200,850,550);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);



        JLabel lblusername = new JLabel("UserName");
        lblusername.setBounds(30, 50, 150, 25);
        lblusername.setFont(new Font("SAN_SERIF", Font.PLAIN, 20));
        add(lblusername);
        labelusername =new JLabel();
        labelusername.setBounds(220,50,150,25);
        add(labelusername);


        JLabel lblid = new JLabel("ID");
        lblid.setBounds(30, 90, 150, 25);
        lblid.setFont(new Font("SAN_SERIF", Font.PLAIN, 20));
        add(lblid);
        comboid =new JComboBox(new String[]{"Passport", "Aadhar card","Pan card","Ration card"});
        comboid.setBounds(220,90,150,25);
        comboid.setBackground(Color.white);
        add(comboid);


        JLabel lblnumber = new JLabel("ID Number");
        lblnumber.setBounds(30, 130, 150, 25);
        lblnumber.setFont(new Font("SAN_SERIF", Font.PLAIN, 20));
        add(lblnumber);
        tfnumber=new JTextField();
        tfnumber.setBounds(220,130,150,25);
        add(tfnumber);

        JLabel lblname = new JLabel("Name");
        lblname.setBounds(30, 170, 150, 25);
        lblname.setFont(new Font("SAN_SERIF", Font.PLAIN, 20));
        add(lblname);
        labelname =new JLabel();
        labelname.setBounds(220,170,150,25);
        add(labelname);

        JLabel lblgender = new JLabel("Gender");
        lblgender.setBounds(30, 210, 150, 25);
        lblgender.setFont(new Font("SAN_SERIF", Font.PLAIN, 20));
        add(lblgender);

        rmale=new JRadioButton("Male");
        rmale.setBounds(220,210,70,25);
        rmale.setBackground(Color.white);
        add(rmale);

        rfemale=new JRadioButton("Female");
        rfemale.setBounds(300,210,70,25);
        rfemale.setBackground(Color.white);
        add(rfemale);

        rother=new JRadioButton("Other");
        rother.setBounds(380,210,70,25);
        rother.setBackground(Color.white);
        add(rother);

        ButtonGroup bg=new ButtonGroup();
        bg.add(rmale);
        bg.add(rfemale);
        bg.add(rother);

        JLabel lblcountry = new JLabel("Country");
        lblcountry.setBounds(30, 250, 150, 25);
        lblcountry.setFont(new Font("SAN_SERIF", Font.PLAIN, 20));
        add(lblcountry);
        tfcountry=new JTextField();
        tfcountry.setBounds(220,250,150,25);
        add(tfcountry);

        JLabel lbladdress = new JLabel("Address");
        lbladdress.setBounds(30, 290, 150, 25);
        lbladdress.setFont(new Font("SAN_SERIF", Font.PLAIN, 20));
        add(lbladdress);
        tfadress=new JTextField();
        tfadress.setBounds(220,290,150,25);
        add(tfadress);

        JLabel lblemail = new JLabel("EMail");
        lblemail.setBounds(30, 330, 150, 25);
        lblemail.setFont(new Font("SAN_SERIF", Font.PLAIN, 20));
        add(lblemail);
        tfemail=new JTextField();
        tfemail.setBounds(220,330,150,25);
        add(tfemail);

        JLabel lblphone = new JLabel("Phone");
        lblphone.setBounds(30, 370, 150, 25);
        lblphone.setFont(new Font("SAN_SERIF", Font.PLAIN, 20));
        add(lblphone);
        tfphone=new JTextField();
        tfphone.setBounds(220,370,150,25);
        add(tfphone);

        add=new JButton("ADD");
        add.setBackground(Color.black);
        add.setForeground(Color.white);
        add.setBounds(70,430,100,25);
        add.addActionListener(this);
        add(add);

        back=new JButton("BACK");
        back.setBackground(Color.black);
        back.setForeground(Color.white);
        back.setBounds(70,470,100,25);
        back.addActionListener(this);
        add(back);

        try {
            // Load image correctly
            ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/icons/newcustomer.jpg"));
            Image i2 = i1.getImage().getScaledInstance(400, 500, Image.SCALE_DEFAULT);
            ImageIcon i3 = new ImageIcon(i2);
            // Check if the image is null (not found)
            if (i1.getImage() == null) {
                throw new NullPointerException("Error: Image not found! Check the path.");
            }

            JLabel image = new JLabel(i3);
            image.setBounds(400, 40, 450, 420);

            add(image);

        } catch (NullPointerException e) {
            System.out.println(e.getMessage()); // Print error message to console
            JOptionPane.showMessageDialog(this, "Image not found! Check the file path.", "Error", JOptionPane.ERROR_MESSAGE);
        }




        try {
            Conn c=new Conn();
            ResultSet rs=c.s.executeQuery("select * from account where username='qwerty'");
            while (rs.next()){
                labelusername.setText(rs.getString("username"));
                labelname.setText(rs.getString("name"));
            }

        }catch (Exception e){
            e.printStackTrace();
        }



        setVisible(true);

    }

    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==add){
            String username=labelusername.getText();
            String id=(String) comboid.getSelectedItem();
            String number= tfnumber.getText();
            String name=labelname.getText();
            String gender=null;

            if (rmale.isSelected()){
                gender="Male";

            } else if (rfemale.isSelected()) {
                gender="Female";
            }else {
                gender="Other";
            }
            String country=tfcountry.getText();
            String address=tfadress.getText();
            String email=tfemail.getText();
            String phone=tfphone.getText();

            try {

                Conn c=new Conn();
                String query="insert into customer values ('"+username+"','"+id+"','"+number+"','"+name+"','"+gender+"','"+country+"','"+address+"','"+email+"','"+phone+"')";
                c.s.executeUpdate(query);

                JOptionPane.showMessageDialog(null,"Customer Details Added Successfully");
                setVisible(false);


            }catch (Exception e){
                e.printStackTrace();
                JOptionPane.showMessageDialog(null, "Error while adding customer details");
            }

        }else {
            setVisible(false);
        }
    }


    public static void main(String[] args) {
        new AddCustomer("");

    }
}
