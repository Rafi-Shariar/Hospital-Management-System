package Dashboards.Receptionist;

import Dashboards.AppointmentDashoard;
import Forms.Register;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SetAppoinment extends AppointmentDashoard {

    JButton addpatient;

    public SetAppoinment(){
        setTitle("Receptionist - Set Appoinment");
        addpatient = new JButton("ADD New");
        addpatient.setFont(new Font("Dubai Medium" , Font.BOLD,20));
        addpatient.setBounds(740,40,150, 40);
        addpatient.setBackground(Color.green);
        addpatient.setForeground(Color.WHITE);
        addpatient.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Register().setVisible(true);
            }
        });
        add(addpatient);



    }

    public static void main(String[] args) {
        new SetAppoinment();
    }

}
