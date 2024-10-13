package Forms;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import Dashboards.Conn;
import Dashboards.Doctor.DoctorDashboard;
import Dashboards.Patient.PatientDashboard;

import javax.swing.*;

public class PatientLogin extends Login {

    JButton registerbutton;



    public PatientLogin(){
        setTitle("Patient Login");
        loginL.setText("patient login");
        login.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String ID = getId().getText();
                char[] P = getPass().getPassword();
                String password = new String(P);

                try{

                    Conn c = new Conn();
                    String query = "select * from logindetails WHERE ID = '" + ID + "' AND password = '" +password+"' ";

                    ResultSet rs = c.s.executeQuery(query);

                    if(rs.next()){
                        setVisible(false);
                        new PatientDashboard(ID).setVisible(true);


                    }
                    else JOptionPane.showMessageDialog(null,"Invalid ID or Password");


                }
                catch (Exception ex) {
                    throw new RuntimeException(ex);
                }
            }
        });


        JLabel msg = new JLabel("DON'T HAVE AN ACCOUNT ?");
        msg.setFont(new Font("Dubai Medium" , Font.BOLD,18));
        msg.setBounds(130 , 420 , 350 , 40);
        msg.setForeground(Color.RED);
        add(msg);

        registerbutton = new JButton("Register");
        registerbutton.setBounds(160 , 480 , 150 , 40);
        registerbutton.setFont(new Font("Eras Bold ITC" , Font.BOLD,20));
        registerbutton.setBackground(Color.darkGray);
        registerbutton.setForeground(Color.white);
        add(registerbutton);
        registerbutton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                new Register().setVisible(true);
            }
        });


    }

    public static void main(String[] args) {
        new PatientLogin();
    }


}

