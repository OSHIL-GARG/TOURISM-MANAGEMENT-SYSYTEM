package Travel_management;

import com.mysql.cj.protocol.Resultset;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class ForgetPassword  extends JFrame implements ActionListener {


    JButton search,back;
    JButton retrieve;
    JTextField tfname, tfusername, tfquestion,tfanswer, tfpassword;

    ForgetPassword(){

        setBounds(350,200,850,380);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        try {
            // Load image correctly
            ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/icons/forget_password.jpeg"));
            Image i2 = i1.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT );
            ImageIcon i3 = new ImageIcon(i2);
            // Check if the image is null (not found)
            if (i1.getImage() == null) {
                throw new NullPointerException("Error: Image not found! Check the path.");
            }

            JLabel image = new JLabel(i3);
            image.setBounds(580,70,200,200);

            add(image);

        } catch (NullPointerException e) {
            System.out.println(e.getMessage()); // Print error message to console
            JOptionPane.showMessageDialog(this, "Image not found! Check the file path.", "Error", JOptionPane.ERROR_MESSAGE);
        }



        JPanel p1=new JPanel();
        p1.setBackground(new Color(133,193,233));
        p1.setBounds(30,30,500,280);
        p1.setLayout(null);
        add(p1);

        JLabel lblusername= new JLabel("UserName");
        lblusername.setBounds(40,20,100,25);
        lblusername.setFont(new Font("SAN_SERIF",Font.PLAIN,14));
        p1.add(lblusername);

        tfusername =new JTextField();
        tfusername.setBounds(220,20,150,25);
        tfusername.setBorder(BorderFactory.createEmptyBorder());
        p1.add(tfusername);

        search=new JButton("Search");
        search.setBounds(380,20,100,25);
        search.setBackground(new Color(133,193,233));
        search.setForeground(Color.BLACK);
        search.setFont(new Font("Tahoma",Font.BOLD,14));
        search.addActionListener( this);
        p1.add(search);

        JLabel lblname = new JLabel("Name");
        lblname.setBounds(40,60,100,25);
        lblname.setFont(new Font("SAN_SERIF",Font.PLAIN,14));
        p1.add(lblname);

        tfname =new JTextField();
        tfname.setBounds(220,60,150,25);
        tfname.setBorder(BorderFactory.createEmptyBorder());
        p1.add(tfname);

        JLabel lblquestion = new JLabel("Security Question"   );
        lblquestion.setBounds(40,100,150,25);
        lblquestion.setFont(new Font("SAN_SERIF",Font.PLAIN,14));
        p1.add(lblquestion);

        tfquestion =new JTextField();
        tfquestion.setBounds(220,100,150,25);
        tfquestion.setBorder(BorderFactory.createEmptyBorder());
        p1.add(tfquestion);

        JLabel lblanswer = new JLabel("Answer "   );
        lblanswer.setBounds(40,140,150,25);
        lblanswer.setFont(new Font("SAN_SERIF",Font.PLAIN,14));
        p1.add(lblanswer);

        tfanswer =new JTextField();
        tfanswer.setBounds(220,140,150,25);
        tfanswer.setBorder(BorderFactory.createEmptyBorder());
        p1.add(tfanswer);

        retrieve=new JButton("Retrieve");
        retrieve.setBounds(380,140,100,25);
        retrieve.setBackground(new Color(133,193,233));
        retrieve.setForeground(Color.BLACK);
        retrieve.setFont(new Font("Tahoma",Font.BOLD,14));
        retrieve.addActionListener(this);
        p1.add(retrieve);

        JLabel lblpassword = new JLabel("PassWord");
        lblpassword.setBounds(40,180,150,25);
        lblpassword.setFont(new Font("SAN_SERIF",Font.PLAIN,14));
        p1.add(lblpassword);

        tfpassword =new JTextField();
        tfpassword.setBounds(220,180,150,25);
        tfpassword.setBorder(BorderFactory.createEmptyBorder());
        p1.add(tfpassword);
        setVisible(true);

        back=new JButton("Back");
        back.setBounds(150,230,100,25);
        back.setBackground(new Color(133,193,233));
        back.setForeground(Color.BLACK);
        back.setFont(new Font("Tahoma",Font.BOLD,14));
        back.addActionListener(this);
        p1.add(back);



    }


    public void actionPerformed(ActionEvent ae) {

        if (ae.getSource() == search) {
            try {
                String query = "SELECT * FROM account WHERE username = '" + tfusername.getText() + "'";
                Conn c = new Conn();
                ResultSet rs = c.s.executeQuery(query);

                if (rs.next()) {
                    tfname.setText(rs.getString("name"));
                    tfquestion.setText(rs.getString("security"));
                } else {
                    JOptionPane.showMessageDialog(null, "Username not found!");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

        } else if (ae.getSource() == retrieve) {
            try {
                String query = "SELECT * FROM account WHERE answer = '" + tfanswer.getText() + "' AND username = '" + tfusername.getText() + "'";
                Conn c = new Conn();
                ResultSet rs = c.s.executeQuery(query);

                if (rs.next()) {
                    tfpassword.setText(rs.getString("password"));
                    tfquestion.setText(rs.getString("security"));
                } else {
                    JOptionPane.showMessageDialog(null, "Invalid answer or username!");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

        } else {
            setVisible(false);
            new LogIn();
        }
    }






    public static void main(String[] args) {

        new ForgetPassword();

    }
}
