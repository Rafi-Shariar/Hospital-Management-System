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

public class EmployeeRegister extends Register{

    Long employeeID;


    JComboBox depertments;
    JDateChooser dateChooser2;
    JTextField salary;
    JButton addemployee;

    String[] roles = {
            "Anesthesiologist",
            "Accounts",
            "Billing Specialist",
            "Clinical Coordinator",
            "Dietitian",
            "Emergency Medical Technician (EMT)",
            "Health Administrator",
            "IT Support",
            "Janitor",
            "Lab Technician",
            "Maintenance Worker",
            "Management",
            "Medical Assistant",
            "Medical Records Clerk",
            "Occupational Therapist",
            "Paramedic",
            "Patient Care Coordinator",
            "Pharmacist",
            "Physical Therapist",
            "Radiologist",
            "Receptionist",
            "Security Guard",
            "Social Worker",
            "Therapist",
            "Ward Assistant"
    };


    public EmployeeRegister(){
        Font f1 = new Font("Copperplate Gothic Bold" , Font.PLAIN , 18);
        Font f3 = new Font("Dialog" ,Font.PLAIN , 18 );

        setTitle("Employee Registration");
        employeeID = patientID;
        nameJ.setText("Empoyee Name: ");
        patiendid.setText("Employee ID: " + employeeID);

        JLabel depertment = new JLabel("Depertment : ");
        depertment.setFont(f1);
        depertment.setBounds(700,200,300,20);
        add(depertment);
        depertments = new JComboBox<>(roles);
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

        register.setBounds(0,0,0,0);

        addemployee = new JButton("ADD employee");
        addemployee.setFont(f1);
        addemployee.setBounds(500,570,200,40);
        addemployee.setBackground(Color.darkGray);
        addemployee.setForeground(Color.white);
        add(addemployee);

        addemployee.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String ID = String.valueOf(patientID);
                String Name = name.getText(), NID = dob.getText(), Age = age.getText(), Password = password.getText(), Contact = contactnum.getText();
                String Email = email.getText(), Address = address.getText();
                Date dobDate = dateChooser.getDate();
                SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
                String DOB = sdf.format(dobDate);
                String MaritalStatus = "";
                if (marride.isSelected()) MaritalStatus = "Married";
                else if (unmarride.isSelected()) MaritalStatus = "Unmarried";
                String Gender = "";
                if (male.isSelected()) Gender = "Male";
                else if (female.isSelected()) Gender = "Female";
                String bloodGroup = (String) bloodgrp.getSelectedItem();
                String Depertment = (String) depertments.getSelectedItem();
                Date joiningDate = dateChooser2.getDate();
                sdf = new SimpleDateFormat("dd-MM-yyyy");
                String JoiningDate = sdf.format(joiningDate);
                String Salary = salary.getText();
                String Type = "Employee";


                if (Name.isEmpty() || NID.isEmpty() || Age.isEmpty() || !Age.matches("\\d+") || dobDate == null || Password.isEmpty() || Contact.isEmpty() || !Contact.matches("\\d{10,15}") || Email.isEmpty() || Address.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Fields Are Empty in the Form !");
                    return;
                } else {

                    try {
                        Conn conn = new Conn();
                        String query = "INSERT INTO employee_list VALUES ('"
                                + ID + "', '"
                                + Name + "', '"

                                + Depertment + "', '"
                                + JoiningDate + "', '"
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


                    } catch (Exception ee) {
                        System.out.println("DATA NOT INSERTED IN MYSQL");
                        ee.printStackTrace();

                    }


                    JOptionPane.showMessageDialog(null, "Successfully registered !");
                    setVisible(false);
                    new AdminDashboard().setVisible(true);

                }
            }
        });




    }

    public static void main(String[] args) {
        new EmployeeRegister();
    }
}
