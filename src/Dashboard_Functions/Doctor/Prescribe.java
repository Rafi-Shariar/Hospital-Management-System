package Dashboard_Functions.Doctor;

import javax.swing.*;
import java.awt.*;

public class Prescribe extends JFrame {

    public Prescribe() {
        setLayout(null);

        setVisible(true);
        setBounds(380,100,500,700);
        setTitle("Doctor Update Profile");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setBackground(Color.white);


    }
    public static void main(String[] args) {
        new Prescribe();
    }
}
