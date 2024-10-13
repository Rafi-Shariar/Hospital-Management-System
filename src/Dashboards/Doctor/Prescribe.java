package Dashboards.Doctor;

import Dashboards.Conn;
import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class Prescribe extends JFrame implements ActionListener {

    JTextField id;

    JLabel namel,agel,doctoridl,genderl,doctornamel,contactl;
    String name="",age="",gender="",contact="";
    public JTextArea description , medicine , tests , notes;
    JButton ok;
    public JDateChooser dateChooser;
    String docname , docid;



    public Prescribe(String DoctorID , String DoctorName) {
        setLayout(null);

        setLayout(null);
        Font f1 = new Font("Dubai Medium" , Font.BOLD,20);
        Font f2 = new Font("Dubai Medium" , Font.PLAIN,20);
        Font f3 = new Font("Century" , Font.PLAIN,14);

        docname = DoctorName;
        docid = DoctorID;




        JLabel intro = new JLabel("Prescription " );
        intro.setBounds(380,10,500,40);
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

        JLabel date = new JLabel("Date : ");
        date.setBounds(680,50,100,25);
        date.setFont(f1);
        add(date);
        dateChooser = new JDateChooser();
        dateChooser.setBounds(750,50,150,25);
        dateChooser.setFont(f1);
        add(dateChooser);

        namel = new JLabel("Name : " + name);
        namel.setBounds(20,100,400,25);
        namel.setFont(f1);
        add(namel);
        agel = new JLabel("Age : " + age);
        agel.setBounds(20,130,400,25);
        agel.setFont(f1);
        add(agel);


        contactl = new JLabel("Contact : " + contact);
        contactl.setBounds(350,100,400,25);
        contactl.setFont(f1);
        add(contactl);
        genderl = new JLabel("Gender : " + gender);
        genderl.setBounds(350,130,400,25);
        genderl.setFont(f1);
        add(genderl);


        doctornamel = new JLabel("Doctor Name : " + DoctorName);
        doctornamel.setBounds(680,100,400,25);
        doctornamel.setFont(f1);
        add(doctornamel);
        doctoridl = new JLabel("Doctor ID : " + DoctorID);
        doctoridl.setBounds(680,130,400,25);
        doctoridl.setFont(f1);
        add(doctoridl);

        JLabel descriptionJ = new JLabel("Description");
        descriptionJ.setFont(f1);
        descriptionJ.setForeground(Color.blue);
        descriptionJ.setBounds(20,180,200,30);
        add(descriptionJ);
        description = new JTextArea();
        description.setBounds(20,210,450,250);
        description.setFont(f3);
        description.setLineWrap(true);
        description.setWrapStyleWord(true);
        description.setBackground(Color.lightGray);
        add(description);


        JLabel medJ = new JLabel("Medicines");
        medJ.setFont(f1);
        medJ.setForeground(Color.blue);
        medJ.setBounds(530,180,200,30);
        add(medJ);
        medicine = new JTextArea();
        medicine.setBounds(530,210,400,250);
        medicine.setFont(f3);
        medicine.setBackground(Color.lightGray);
        medicine.setLineWrap(true);
        medicine.setWrapStyleWord(true);
        add(medicine);

        JLabel testJ = new JLabel("Tests");
        testJ.setFont(f1);
        testJ.setForeground(Color.blue);
        testJ.setBounds(20,480,200,30);
        add(testJ);
        tests = new JTextArea();
        tests.setBounds(20,510,450,200);
        tests.setFont(f3);
        tests.setLineWrap(true);
        tests.setWrapStyleWord(true);
        tests.setBackground(Color.lightGray);
        add(tests);


        JLabel notesj = new JLabel("Notes");
        notesj.setFont(f1);
        notesj.setForeground(Color.blue);
        notesj.setBounds(530,480,200,30);
        add(notesj);
        notes = new JTextArea();
        notes.setBounds(530,510,400,150);
        notes.setFont(f3);
        notes.setLineWrap(true);
        notes.setWrapStyleWord(true);
        notes.setBackground(Color.lightGray);
        add(notes);

        JLabel confirm = new JLabel("Confirm Prescription ?");
        confirm.setFont(f1);
        confirm.setBounds(530,690,200,30);
        add(confirm);

        ok = new JButton("OK");
        ok.setFont(f2);
        ok.setBackground(Color.darkGray);
        ok.setForeground(Color.white);
        ok.addActionListener(this);
        ok.setBounds(750 , 690 , 80 , 50);
        add(ok);




        setVisible(true);
        setBounds(280,30,1000,800);
        setTitle("Prescription");
        getContentPane().setBackground(Color.white);

    }




    public static void main(String[] args) {
        new Prescribe("123" , "Main func");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == id){

            System.out.println("ho");

            try {

                String iid = id.getText();
                Conn c = new Conn();

                String query = "SELECT name, age, gender, contact_number FROM patient_list WHERE patientID = '" + iid + "'";
                ResultSet rs = c.s.executeQuery(query);

                if(rs.next()){

                    name = rs.getString("name");
                    age = rs.getString("age");
                    gender = rs.getString("gender");
                    contact = rs.getString("contact_number");

                    namel.setText("Name : " + name);
                    agel.setText("Age : " + age);
                    genderl.setText("Gender : " + gender);
                    contactl.setText("Contact : " + contact);
                }
                else{
                    JOptionPane.showMessageDialog(null, "Patient not registered");
                }



            }
            catch (Exception ex) {
                throw new RuntimeException(ex);
            }

        }

        if(e.getSource() == ok){


            Date dobDate = dateChooser.getDate();
            SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
            String Date = sdf.format(dobDate);

            String PatientID = id.getText();
            String PatientName = name;
            String DoctorName = docname;
            String DoctorID = docid;
            String Description = description.getText();
            String Medicines = medicine.getText();
            String Tests = tests.getText();
            String Notes = notes.getText();



            try{

                Conn conn = new Conn();
                String query = "INSERT INTO prescriptions VALUES ('"
                        + Date + "', '"
                        + PatientName + "', '"
                        + PatientID + "', '"
                        + DoctorName + "', '"
                        + DoctorID + "', '"
                        + Description + "', '"
                        + Medicines + "', '"
                        + Tests + "', '"
                        + Notes + "')";


                conn.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null,"Done");

            } catch (Exception ex) {

                JOptionPane.showMessageDialog(null,"Date not selected");

            }



        }

    }
}
