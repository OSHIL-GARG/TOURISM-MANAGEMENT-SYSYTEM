package Travel_management;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Dashboard extends JFrame implements ActionListener {
    String username;
    JButton checkpackages,addPersonalDetails, viewPersonalDetails,updatePersonalDetails;
    Dashboard(String username){
//        setBounds(0,0,1600,1000);
        this.username=username;
       setExtendedState(JFrame.MAXIMIZED_BOTH);
       setLayout(null);

       JPanel p1=new JPanel();
       p1.setLayout(null);
       p1.setBackground(new Color(0,0,102));
       p1.setBounds(0,0,1600,65);
       add(p1);

        try {
            // Load image correctly
            ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/icons/dashboard.png"));
            Image i2 = i1.getImage().getScaledInstance(70, 70, Image.SCALE_DEFAULT);
            ImageIcon i3 = new ImageIcon(i2);
            // Check if the image is null (not found)
            if (i1.getImage() == null) {
                throw new NullPointerException("Error: Image not found! Check the path.");
            }

            JLabel image = new JLabel(i3);
            image.setBounds(5, 0, 70, 70);

            p1.add(image);

        } catch (NullPointerException e) {
            System.out.println(e.getMessage()); // Print error message to console
            JOptionPane.showMessageDialog(this, "Image not found! Check the file path.", "Error", JOptionPane.ERROR_MESSAGE);
        }

        JLabel heading= new JLabel("Dashboard");
        heading.setBounds(80,10,300,40);
        heading.setForeground(Color.white);
        heading.setFont(new Font("tahoma", Font.BOLD,30));
        p1.add(heading);

        JPanel p2 =new JPanel();
        p2.setLayout(null);
        p2.setBackground(new Color(0,0,102));
        p2.setBounds(0,65,300,900);
        add(p2);

         addPersonalDetails =new JButton("Add Personal Details");
        addPersonalDetails.setBounds(0,0,300,50);
        addPersonalDetails.setBackground(new Color(0,0,102));
        addPersonalDetails.setForeground(Color.white);
        addPersonalDetails.setFont(new Font("tahoma", Font.PLAIN,20));
        addPersonalDetails.setMargin(new Insets(0,0,0,60));
        addPersonalDetails.addActionListener(this);
        p2.add(addPersonalDetails);

         updatePersonalDetails =new JButton("Update Personal Details");
        updatePersonalDetails.setBounds(0,50,300,50);
        updatePersonalDetails.setBackground(new Color(0,0,102));
        updatePersonalDetails.setForeground(Color.white);
        updatePersonalDetails.setFont(new Font("tahoma", Font.PLAIN,20));
        updatePersonalDetails.setMargin(new Insets(0,0,0,30));
        updatePersonalDetails.addActionListener(this);
        p2.add(updatePersonalDetails);

         viewPersonalDetails =new JButton("View Personal Details");
        viewPersonalDetails.setBounds(0,100,300,50);
        viewPersonalDetails.setBackground(new Color(0,0,102));
        viewPersonalDetails.setForeground(Color.white);
        viewPersonalDetails.setFont(new Font("tahoma", Font.PLAIN,20));
        viewPersonalDetails.setMargin(new Insets(0,0,0,60));
        viewPersonalDetails.addActionListener(this);
        p2.add(viewPersonalDetails);

        JButton deletePersonalDetails =new JButton("Delete Personal Details");
        deletePersonalDetails.setBounds(0,150,300,50);
        deletePersonalDetails.setBackground(new Color(0,0,102));
        deletePersonalDetails.setForeground(Color.white);
        deletePersonalDetails.setFont(new Font("tahoma", Font.PLAIN,20));
        deletePersonalDetails.setMargin(new Insets(0,0,0,50));
        p2.add(deletePersonalDetails);

        checkpackages =new JButton("Check Packages");
        checkpackages.setBounds(0,200,300,50);
        checkpackages.setBackground(new Color(0,0,102));
        checkpackages.setForeground(Color.white);
        checkpackages.setFont(new Font("tahoma", Font.PLAIN,20));
       checkpackages.setMargin(new Insets(0,0,0,110));
        checkpackages.addActionListener(this);
       p2.add(checkpackages);

        JButton bookpackages =new JButton("Book Packages");
        bookpackages.setBounds(0,250,300,50);
        bookpackages.setBackground(new Color(0,0,102));
        bookpackages.setForeground(Color.white);
        bookpackages.setFont(new Font("tahoma", Font.PLAIN,20));
        bookpackages.setMargin(new Insets(0,0,0,120));
        p2.add(bookpackages);

        JButton viewpackages =new JButton("View Packages");
        viewpackages.setBounds(0,300,300,50);
        viewpackages.setBackground(new Color(0,0,102));
        viewpackages.setForeground(Color.white);
        viewpackages.setFont(new Font("tahoma", Font.PLAIN,20));
        viewpackages.setMargin(new Insets(0,0,0,120));
        p2.add(viewpackages);

        JButton viewhotels =new JButton("View Hotels");
        viewhotels.setBounds(0,350,300,50);
        viewhotels.setForeground(Color.white);
        viewhotels.setBackground(new Color(0,0,102));
        viewhotels.setFont(new Font("tahoma", Font.PLAIN,20));
        viewhotels.setMargin(new Insets(0,0,0,130));
        p2.add(viewhotels);

        JButton bookhotel =new JButton("Book Hotel");
        bookhotel.setBounds(0,400,300,50);
        bookhotel.setBackground(new Color(0,0,102));
        bookhotel.setForeground(Color.white);
        bookhotel.setFont(new Font("tahoma", Font.PLAIN,20));
        bookhotel.setMargin(new Insets(0,0,0,140));
        p2.add(bookhotel);

        JButton viewbookhotel =new JButton(" View Booked Hotel");
        viewbookhotel.setBounds(0,450,300,50);
        viewbookhotel.setForeground(Color.white);
        viewbookhotel.setBackground(new Color(0,0,102));
        viewbookhotel.setFont(new Font("tahoma", Font.PLAIN,20));
        viewbookhotel.setMargin(new Insets(0,0,0,70));
        p2.add(viewbookhotel);

        JButton destination =new JButton(" Destination");
        destination.setBounds(0,500,300,50);
        destination.setForeground(Color.white);
        destination.setFont(new Font("tahoma", Font.PLAIN,20));
        destination.setBackground(new Color(0,0,102));
        destination.setMargin(new Insets(0,0,0,125));
        p2.add(destination);

        JButton payments =new JButton(" Payment");
        payments.setBounds(0,550,300,50);
        payments.setBackground(new Color(0,0,102));
        payments.setForeground(Color.white);
        payments.setFont(new Font("tahoma", Font.PLAIN,20));
        payments.setMargin(new Insets(0,0,0,155));
        p2.add(payments);

        JButton about =new JButton(" About");
        about.setBounds(0,600,300,50);
        about.setBackground(new Color(0,0,102));
        about.setForeground(Color.white);
        about.setFont(new Font("tahoma", Font.PLAIN,20));
        about.setMargin(new Insets(0,0,0,175));
        p2.add(about);

        JLabel image = null;

        try {
            java.net.URL imageURL = ClassLoader.getSystemResource("icons/icons/homee.jpg");

            if (imageURL == null) {
                throw new NullPointerException("Error: Image not found! Check the path.");
            }

            ImageIcon i4 = new ImageIcon(imageURL);
            Image i5 = i4.getImage().getScaledInstance(1650, 1000, Image.SCALE_DEFAULT);
            ImageIcon i6 = new ImageIcon(i5);

            image = new JLabel(i6);
            image.setBounds(0, 0, 1650, 1000);

            add(image);

        } catch (NullPointerException e) {
            System.out.println(e.getMessage());
            JOptionPane.showMessageDialog(this, "Image not found! Check the file path.", "Error", JOptionPane.ERROR_MESSAGE);
        }


        if (image != null) {
            JLabel text = new JLabel("Travel And Tourism Management System");
            text.setBounds(400, 70, 1200, 70);
            text.setForeground(Color.black);
            text.setFont(new Font("Raleway", Font.PLAIN, 55));
            image.add(text);
        }

        setVisible(true);

    }
    public void actionPerformed(ActionEvent ae){
        if (ae.getSource()==addPersonalDetails){
            new AddCustomer(username);
        } else if (ae.getSource()==viewPersonalDetails) {
            new ViewCustomer(username);
        }else if (ae.getSource()==updatePersonalDetails){
            new UpdateCustomer(username);
        } else if (ae.getSource()==checkpackages) {
            new CheckPackage();

        }
    }

    public static void main(String[] args) {
        new Dashboard("");

    }
}
