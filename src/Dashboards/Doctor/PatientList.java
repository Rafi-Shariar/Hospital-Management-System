package Dashboards.Doctor;

import javax.swing.*;
import java.awt.*;

public class PatientList extends JFrame {

    public PatientList() {
        setLayout(null);

        setVisible(true);
        setBounds(380,100,500,700);
        setTitle("Doctor Update Profile");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setBackground(Color.white);


    }
    public static void main(String[] args) {
        new PatientList();
    }
}
