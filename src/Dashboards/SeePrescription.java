package Dashboards;

import Dashboards.Doctor.DocPatientList;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class SeePrescription extends JFrame {

    public SeePrescription(String date, String patientName, String patientID, String doctorName, String doctorID, String description, String medicines, String test, String notes) {

        setLayout(null);

        Font f1 = new Font("Dubai Medium", Font.BOLD, 20);
        Font f2 = new Font("Dubai Medium", Font.PLAIN, 20);
        Font f3 = new Font("Century", Font.PLAIN, 14);

        String age = "", gender = "", contact = "";

        try {
            Conn c = new Conn();
            String query = "SELECT name, age, gender, contact_number FROM patient_list WHERE patientID = '" + patientID + "'";
            ResultSet rs = c.s.executeQuery(query);

            if (rs.next()) {
                age = rs.getString("age");
                gender = rs.getString("gender");
                contact = rs.getString("contact_number");
            } else {
                JOptionPane.showMessageDialog(null, "Patient not registered");
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        // Heading
        JLabel intro = new JLabel("Prescription");
        intro.setBounds(380, 10, 500, 40);
        intro.setFont(new Font("Dubai Medium", Font.BOLD, 30));
        add(intro);

        // Patient details
        JLabel patientid = new JLabel("Patient ID: " + patientID);
        patientid.setFont(f1);
        patientid.setBounds(20, 50, 200, 25);
        add(patientid);

        JLabel dateL = new JLabel("Date: " + date);
        dateL.setBounds(680, 50, 200, 25);
        dateL.setFont(f1);
        add(dateL);

        JLabel namel = new JLabel("Name: " + patientName);
        namel.setBounds(20, 100, 400, 25);
        namel.setFont(f1);
        add(namel);

        JLabel agel = new JLabel("Age: " + age);
        agel.setBounds(20, 130, 400, 25);
        agel.setFont(f1);
        add(agel);

        JLabel contactl = new JLabel("Contact: " + contact);
        contactl.setBounds(350, 100, 400, 25);
        contactl.setFont(f1);
        add(contactl);

        JLabel genderl = new JLabel("Gender: " + gender);
        genderl.setBounds(350, 130, 400, 25);
        genderl.setFont(f1);
        add(genderl);

        JLabel doctornamel = new JLabel("Doctor Name: " + doctorName);
        doctornamel.setBounds(680, 100, 400, 25);
        doctornamel.setFont(f1);
        add(doctornamel);

        JLabel doctoridl = new JLabel("Doctor ID: " + doctorID);
        doctoridl.setBounds(680, 130, 400, 25);
        doctoridl.setFont(f1);
        add(doctoridl);

        // Prescription details
        JLabel descriptionJ = new JLabel("Description");
        descriptionJ.setFont(f1);
        descriptionJ.setForeground(Color.blue);
        descriptionJ.setBounds(20, 180, 200, 30);
        add(descriptionJ);

        JTextArea descriptionArea = new JTextArea();
        descriptionArea.setBounds(20, 210, 450, 250);
        descriptionArea.setText(description);
        descriptionArea.setFont(f3);
        descriptionArea.setLineWrap(true);
        descriptionArea.setWrapStyleWord(true);
        descriptionArea.setBackground(Color.lightGray);
        descriptionArea.setEditable(false);
        add(descriptionArea);

        JLabel medJ = new JLabel("Medicines");
        medJ.setFont(f1);
        medJ.setForeground(Color.blue);
        medJ.setBounds(530, 180, 200, 30);
        add(medJ);

        JTextArea medicine = new JTextArea();
        medicine.setText(medicines);
        medicine.setBounds(530, 210, 400, 250);
        medicine.setFont(f3);
        medicine.setBackground(Color.lightGray);
        medicine.setLineWrap(true);
        medicine.setWrapStyleWord(true);
        medicine.setEditable(false);
        add(medicine);

        JLabel testJ = new JLabel("Tests");
        testJ.setFont(f1);
        testJ.setForeground(Color.blue);
        testJ.setBounds(20, 480, 200, 30);
        add(testJ);

        JTextArea tests = new JTextArea();
        tests.setText(test);
        tests.setBounds(20, 510, 450, 200);
        tests.setFont(f3);
        tests.setLineWrap(true);
        tests.setWrapStyleWord(true);
        tests.setBackground(Color.lightGray);
        tests.setEditable(false);
        add(tests);

        JLabel notesJ = new JLabel("Notes");
        notesJ.setFont(f1);
        notesJ.setForeground(Color.blue);
        notesJ.setBounds(530, 480, 200, 30);
        add(notesJ);

        JTextArea notesArea = new JTextArea();
        notesArea.setBounds(530, 510, 400, 150);
        notesArea.setText(notes);
        notesArea.setFont(f3);
        notesArea.setLineWrap(true);
        notesArea.setWrapStyleWord(true);
        notesArea.setBackground(Color.lightGray);
        notesArea.setEditable(false);
        add(notesArea);

        JButton ok = new JButton("OK");
        ok.setFont(f2);
        ok.setBackground(Color.darkGray);
        ok.setForeground(Color.white);
        ok.setBounds(750, 690, 80, 50);
        ok.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);

            }
        });
        add(ok);

        setVisible(true);
        setBounds(280, 30, 1000, 800);
        setTitle("Prescription");
        getContentPane().setBackground(Color.white);
    }

}
