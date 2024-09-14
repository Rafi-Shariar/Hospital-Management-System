package Forms;

import Dashboards.AdminDashboard;
import Dashboards.Conn;
import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DoctorRegister extends Register{

    Long doctorID;
    String[] doctorDepartments = {
            "Anesthesiologist",
            "Cardiologist",
            "Dermatologist",
            "Endocrinologist",
            "Gastroenterologist",
            "General Practitioner",
            "Gynecologist",
            "Hematologist",
            "Internal Medicine Specialist",
            "Nephrologist",
            "Neurologist",
            "Oncologist",
            "Orthopedic Surgeon",
            "Otorhinolaryngologist (ENT)",
            "Pediatrician",
            "Pulmonologist",
            "Radiologist",
            "Rheumatologist",
            "Surgeon",
            "Urologist"
    };


    JComboBox depertments;
    JDateChooser dateChooser2;
    JTextField salary;
    JRadioButton fri,sat,sun,mon,tue,wed,thur;
    JButton addDoctor;



    public DoctorRegister(){
        Font f1 = new Font("Copperplate Gothic Bold" , Font.PLAIN , 18);
        Font f3 = new Font("Dialog" ,Font.PLAIN , 18 );

        setTitle("Doctor Registration");
        doctorID = patientID;
        nameJ.setText("Doctor Name: ");
        patiendid.setText("Doctor ID: " + doctorID);

        JLabel depertment = new JLabel("Depertment : ");
        depertment.setFont(f1);
        depertment.setBounds(700,200,300,20);
        add(depertment);
        depertments = new JComboBox<>(doctorDepartments);
        depertments.setBounds(850,195,300,30);
        depertments.setFont(f1);
        depertment.setBackground(Color.white);
        add(depertments);


        JLabel dobJ  = new JLabel("Joining Date :");
        dobJ.setFont(f1);
        dobJ.setBounds(700,395,200,20);
        add(dobJ);
        dateChooser2 = new JDateChooser();
        dateChooser2.setBounds(855,390,200,30);
        dateChooser2.setFont(f3);
        add(dateChooser2);

        JLabel salaryL = new JLabel("Salary : ");
        salaryL.setFont(f1);
        salaryL.setBounds(750,435,270,25);
        add(salaryL);
        salary = new JTextField();
        salary.setFont(f3);
        salary.setBounds(855 , 430 , 150 , 30);
        add(salary);

        register.setBounds(500,620,0,0);
        addressl.setBounds(900,570,0,0);
        contactl.setBounds(900,570,0,0);
        emaill.setBounds(900,570,0,0);


        JLabel available = new JLabel("Available : ");
        available.setFont(f1);
        available.setBounds(215,565,200,25);
        add(available);

        //fri,sat,sun,mon,tue,wed,thur;
        fri = new JRadioButton("Fri");
        fri.setFont(f1);
        fri.setBounds(350,565,70,25);
        fri.setBackground(Color.white);
        add(fri);

        sat = new JRadioButton("Sat");
        sat.setFont(f1);
        sat.setBounds(430,565,70,25);
        sat.setBackground(Color.white);
        add(sat);

        sun = new JRadioButton("Sun");
        sun.setFont(f1);
        sun.setBounds(510,565,70,25);
        sun.setBackground(Color.white);
        add(sun);

        mon = new JRadioButton("Mon");
        mon.setFont(f1);
        mon.setBounds(590,565,70,25);
        mon.setBackground(Color.white);
        add(mon);

        tue = new JRadioButton("tue");
        tue.setFont(f1);
        tue.setBounds(670,565,70,25);
        tue.setBackground(Color.white);
        add(tue);

        wed = new JRadioButton("wed");
        wed.setFont(f1);
        wed.setBounds(750,565,70,25);
        wed.setBackground(Color.white);
        add(wed);


        thur = new JRadioButton("thur");
        thur.setFont(f1);
        thur.setBounds(830,565,100,25);
        thur.setBackground(Color.white);
        add(thur);


        addDoctor = new JButton("Add Doctor");
        addDoctor.setBounds(500,620,150,40);
        addDoctor.setBackground(Color.darkGray);
        addDoctor.setForeground(Color.white);
        addDoctor.setBounds(500,630,250,40);
        addDoctor.setFont(f1);
        addDoctor.addActionListener(this);
        add(addDoctor);

        addDoctor.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String ID = String.valueOf(patientID);
                String Name = name.getText() , NID = dob.getText() , Age = age.getText(), Password = password.getText(), Contact = contactnum.getText();
                String Email = email.getText() , Address = address.getText();
                Date dobDate = dateChooser.getDate();
                SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
                String DOB = sdf.format(dobDate);
                String MaritalStatus="";
                if(marride.isSelected()) MaritalStatus = "Married";
                else if (unmarride.isSelected()) MaritalStatus = "Unmarried";
                String Gender="";
                if(male.isSelected()) Gender = "Male";
                else if (female.isSelected()) Gender = "Female";
                String bloodGroup = (String) bloodgrp.getSelectedItem();
                String Depertment = (String) depertments.getSelectedItem();
                Date joiningDate = dateChooser2.getDate();
                sdf = new SimpleDateFormat("dd-MM-yyyy");
                String JoiningDate = sdf.format(joiningDate);
                String Salary = salary.getText();

                StringBuilder Availability = new StringBuilder();
                if(fri.isSelected()) Availability.append("Fri ");
                if(sat.isSelected()) Availability.append("Sat ");
                if(sun.isSelected()) Availability.append("Sun ");
                if(mon.isSelected()) Availability.append("Mon ");
                if(tue.isSelected()) Availability.append("Tue ");
                if(wed.isSelected()) Availability.append("Wed ");
                if(thur.isSelected()) Availability.append("Thur ");
                String weekdays = Availability.toString();
                System.out.println(weekdays + Depertment +" " + DOB +" " + JoiningDate );
                String Type = "Doctor";




                if (Name.isEmpty() || NID.isEmpty() || Age.isEmpty() || !Age.matches("\\d+") || dobDate == null || Password.isEmpty() || Contact.isEmpty() || !Contact.matches("\\d{10,15}") || Email.isEmpty() || Address.isEmpty()) {
                    JOptionPane.showMessageDialog(null,"Fields Are Empty in the Form !");
                    return;
                } else {

                    try {
                        Conn conn = new Conn();
                        String query = "INSERT INTO doctor_list VALUES ('"
                                + ID + "', '"
                                + Name + "', '"

                                + Depertment + "', '"
                                + JoiningDate + "', '"
                                + weekdays + "', '"
                                + Salary + "', '"

                                + NID + "', '"
                                + Age + "', '"
                                + DOB + "', '"
                                + MaritalStatus + "', '"
                                + Gender + "', '"
                                + bloodGroup + "', '"
                                + Password + "', '"
                                + Contact + "', '"
                                + Email + "', '"
                                + Address + "')";


                        conn.s.executeUpdate(query);

                        String query2 = "INSERT INTO LoginDetails VALUES ('"
                                + ID + "', '"
                                + Name + "', '"
                                + Password + "', '"
                                + Type + "')";

                        conn.s.executeUpdate(query2);


                    }catch (Exception ee){
                        System.out.println("DATA NOT INSERTED IN MYSQL");
                        ee.printStackTrace();

                    }

                    JOptionPane.showMessageDialog(null,"Successfully registered !");
                    setVisible(false);
                    new AdminDashboard().setVisible(true);


                }


            }
        });


    }



    public static void main(String[] args) {
        new DoctorRegister();
    }
}
