package Travel_management;

import com.mysql.cj.protocol.Resultset;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.concurrent.ConcurrentHashMap;

public class LogIn extends JFrame implements ActionListener {

    JButton login,signup,forgetpassword;
    JTextField tfpassword,tfusername;
    LogIn() {
        setSize(900, 400);
        setLocation(350, 200);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);
        JPanel p1 = new JPanel();
        p1.setBackground(new Color(131, 193, 233));

        p1.setBounds(0, 0, 400, 400);
        p1.setLayout(null);
        add(p1);
        JPanel p2 = new JPanel();
        p2.setLayout(null);
        p2.setBounds(400, 30, 450, 300);
        add(p2);


        JLabel lblusername = new JLabel("UserName");
        lblusername.setBounds(60, 20, 100, 25);
        lblusername.setFont(new Font("SAN_SERIF", Font.PLAIN, 20));
        p2.add(lblusername);

       tfusername = new JTextField();
        tfusername.setBounds(60, 60, 300, 30);
        tfusername.setBorder(BorderFactory.createEmptyBorder());
        p2.add(tfusername);

        JLabel lblpassword = new JLabel("PassWord");
        lblpassword.setBounds(60, 110, 100, 25);
        lblpassword.setFont(new Font("SAN_SERIF", Font.PLAIN, 20));
        p2.add(lblpassword);

         tfpassword = new JTextField();
        tfpassword.setBounds(60, 150, 300, 30);
        tfpassword.setBorder(BorderFactory.createEmptyBorder());
        p2.add(tfpassword);

        login = new JButton("LogIn");
        login.setBounds(60, 200, 130, 30);
        login.setBackground(new Color(133, 193, 233));
        login.setForeground(Color.BLACK);
        login.setBorder(new LineBorder(new Color(133, 193, 233)));
        login.addActionListener(this);
        p2.add(login);


        signup = new JButton("SignUp");
        signup.setBounds(230, 200, 130, 30);
        signup.setBackground(new Color(133, 193, 233));
        signup.setForeground(Color.BLACK);
        signup.setBorder(new LineBorder(new Color(133, 193, 233)));
        signup.addActionListener(this);
        p2.add(signup);

        forgetpassword = new JButton("Forget Password?");
        forgetpassword.setBounds(130, 250, 130, 30);
        forgetpassword.setBackground(new Color(133, 193, 233));
        forgetpassword.setForeground(Color.BLACK);
        forgetpassword.setBorder(new LineBorder(new Color(133, 193, 233)));
        forgetpassword.addActionListener(this);
        p2.add(forgetpassword);

//        JLabel text=new JLabel("Troble in LogIn....");
//        text.setBounds(300,250,150,20);
//        text.setForeground(Color.RED);
//        p2.add(text);


        try {
            // Load image correctly
            ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/icons/login.jpg"));
            Image i2 = i1.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
            ImageIcon i3 = new ImageIcon(i2);
            // Check if the image is null (not found)
            if (i1.getImage() == null) {
                throw new NullPointerException("Error: Image not found! Check the path.");
            }

            JLabel image = new JLabel(i3);
            image.setBounds(100, 120, 200, 200);

            p1.add(image);

        } catch (NullPointerException e) {
            System.out.println(e.getMessage()); // Print error message to console
            JOptionPane.showMessageDialog(this, "Image not found! Check the file path.", "Error", JOptionPane.ERROR_MESSAGE);
        }
        setVisible(true);
    }





    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() ==login){
            try {
                String username=tfusername.getText();
                String pass=tfpassword.getText();
                String query = "SELECT * FROM account WHERE username = '" + username + "' AND password = '" + pass + "'";
                Conn c=new Conn();
                ResultSet rs=c.s.executeQuery(query);
                if (rs.next()){
                    setVisible(false);
                    new Loading(username);

                }else {
                    JOptionPane.showMessageDialog(null,"Incorrect Username and Password");
                }
            }catch (Exception e){
                e.printStackTrace();
            }

        } else if (ae.getSource()==signup) {
            setVisible(false);
            new SignUp();

        }else {
            setVisible(false);
            new ForgetPassword();
        }

    }
    public static void main(String[] args) {
        new LogIn();
    }
}