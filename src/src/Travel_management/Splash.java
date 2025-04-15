package Travel_management;

import javax.swing.*;
import java.awt.*;

public  class Splash extends JFrame implements Runnable{

   Thread thread;

    Splash() {

//    setSize(1200,600);
//    setLocation(200,100);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Ensure closing works properly
        setResizable(false);

//    ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("icons/splash.jpg"));

        try {
            // Load image correctly
            ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/icons/splash.jpg"));
            Image i2 = i1.getImage().getScaledInstance(1200, 600, Image.SCALE_DEFAULT);
            ImageIcon i3 = new ImageIcon(i2);
            // Check if the image is null (not found)
            if (i1.getImage() == null) {
                throw new NullPointerException("Error: Image not found! Check the path.");
            }

            JLabel image = new JLabel(i3);
            add(image);

        } catch (NullPointerException e) {
            System.out.println(e.getMessage()); // Print error message to console
            JOptionPane.showMessageDialog(this, "Image not found! Check the file path.", "Error", JOptionPane.ERROR_MESSAGE);
        }

        setVisible(true);
        thread=new Thread(this);
        thread.start();

    }
public void run() {
    try {
        Thread.sleep(7000);
//    new login();
        setVisible(false);
    } catch (Exception e) {
    }
}
    public static void main(String[] args) {
        Splash frame = new Splash();
        int x = 1;

        for (int i = 1; i <= 500; x += 7, i += 6) {
            frame.setLocation(750-(x+i)/2, 400-(i/2));
            frame.setSize(x + i, i);
            try {
                Thread.sleep(10);
            } catch (Exception e) {

            }
        }

    }
}
