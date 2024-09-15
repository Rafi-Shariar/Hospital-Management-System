package Dashboard_Functions.Doctor;

import javax.swing.*;
import java.awt.*;

public class UpdateDoctorProfile extends JFrame {

    public UpdateDoctorProfile() {
        setLayout(null);

        setVisible(true);
        setBounds(380,100,500,700);
        setTitle("Doctor Update Profile");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setBackground(Color.white);


    }
    public static void main(String[] args) {
        new UpdateDoctorProfile();
    }
}
