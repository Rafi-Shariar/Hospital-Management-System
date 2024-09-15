package Dashboards;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class AppointmentDashoard extends JFrame implements ActionListener {

    JTextField id;
    JButton idsearch;
    JLabel namel,agel,dobl,genderl,bloodgroupl,contactl;
    String name,age,dob,gender,bloodgroup,contact;

    AppointmentDashoard(){
        setLayout(null);
        Font f1 = new Font("Dubai Medium" , Font.BOLD,20);
        Font f2 = new Font("Dubai Medium" , Font.PLAIN,20);


        JLabel intro = new JLabel("Appointment");
        intro.setBounds(450,10,500,40);
        intro.setFont(new Font("Dubai Medium" , Font.BOLD,30));
        add(intro);



        JLabel patientID = new JLabel("Patient ID : ");
        patientID.setFont(f1);
        patientID.setBounds(20,50,200,25);
        add(patientID);
        id = new JTextField();
        id.setBounds(130,50,100,25);
        id.setFont(f2);
        id.addActionListener(this);
        id.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {}
            @Override
            public void keyPressed(KeyEvent e) {}
            @Override
            public void keyReleased(KeyEvent e) {}
        });
        add(id);

        namel = new JLabel("Name : " + name);
        namel.setBounds(20,100,400,25);
        namel.setFont(f1);
        add(namel);
        agel = new JLabel("Age : " + age);
        agel.setBounds(20,130,400,25);
        agel.setFont(f1);
        add(agel);


        dobl = new JLabel("DOB : " + dob);
        dobl.setBounds(450,100,400,25);
        dobl.setFont(f1);
        add(dobl);
        genderl = new JLabel("Gender : " + gender);
        genderl.setBounds(450,130,400,25);
        genderl.setFont(f1);
        add(genderl);


        bloodgroupl = new JLabel("Blood Group : " + bloodgroup);
        bloodgroupl.setBounds(850,100,400,25);
        bloodgroupl.setFont(f1);
        add(bloodgroupl);
        contactl = new JLabel("Contact : " + contact);
        contactl.setBounds(850,130,400,25);
        contactl.setFont(f1);
        add(contactl);




















        setVisible(true);
        setBounds(280,30,1200,800);
        setTitle("Appointment");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setBackground(Color.white);

    }

    public static void main(String[] args) {
        new AppointmentDashoard();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource() == id){

            try {

                String iid = id.getText();
                Conn c = new Conn();

                String query = "SELECT name, age, date_of_birth, gender, blood_group, contact_number FROM patient_list WHERE patientID = '" + iid + "'";




            }
            catch (Exception ex) {
                throw new RuntimeException(ex);
            }

        }

    }
}



























