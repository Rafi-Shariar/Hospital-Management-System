package Dashboards;

import com.toedter.calendar.JDateChooser;
import net.proteanit.sql.DbUtils;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class AppointmentDashoard extends JFrame implements ActionListener {

    JTextField id , doctorName;
    JButton confirmbutton;
    JLabel namel,agel,dobl,genderl,bloodgroupl,contactl;
    public JLabel intro;
    String name="",age="",dob="",gender="",bloodgroup="",contact="";
    JTable table;
    JScrollPane sp;
    String[] doctorDepartments = {
            "Select",
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
    public JLabel docSelectedname , docdep ,docselectedID;
    String selectedDepartment,selectedName , selectedID;
    Long appoinmentID;


    public AppointmentDashoard(){
        setLayout(null);
        Font f1 = new Font("Dubai Medium" , Font.BOLD,20);
        Font f2 = new Font("Dubai Medium" , Font.PLAIN,20);


        Random ran = new Random();
        appoinmentID = Math.abs( (ran.nextLong()%10000000L) + 10000L);


        intro = new JLabel("Appointment " );
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

        namel = new JLabel("Name : " + name);
        namel.setBounds(20,100,400,25);
        namel.setFont(f1);
        add(namel);
        agel = new JLabel("Age : " + age);
        agel.setBounds(20,130,400,25);
        agel.setFont(f1);
        add(agel);


        dobl = new JLabel("DOB : " + dob);
        dobl.setBounds(350,100,400,25);
        dobl.setFont(f1);
        add(dobl);
        genderl = new JLabel("Gender : " + gender);
        genderl.setBounds(350,130,400,25);
        genderl.setFont(f1);
        add(genderl);


        bloodgroupl = new JLabel("Blood Group : " + bloodgroup);
        bloodgroupl.setBounds(680,100,400,25);
        bloodgroupl.setFont(f1);
        add(bloodgroupl);
        contactl = new JLabel("Contact : " + contact);
        contactl.setBounds(680,130,400,25);
        contactl.setFont(f1);
        add(contactl);


        JLabel dobJ  = new JLabel("Appoinment Date");
        dobJ.setFont(f1);
        dobJ.setBounds(50,200,250,20);
        add(dobJ);
        dateChooser2 = new JDateChooser();
        dateChooser2.setBounds(50,230,210,30);
        dateChooser2.setFont(f2);
        add(dateChooser2);


        JLabel depertment = new JLabel("Search By Depertments");
        depertment.setFont(f1);
        depertment.setBounds(350,200,250,20);
        add(depertment);
        depertments = new JComboBox<>(doctorDepartments);
        depertments.setBounds(350,230,250,30);
        depertments.setFont(f2);
        depertments.setBackground(Color.white);
        depertments.addActionListener(this);
        add(depertments);


        JLabel docname = new JLabel("Search By Doctor Name");
        docname.setFont(f1);
        docname.setBounds(650,200,350,30);
        add(docname);
        doctorName = new JTextField("");
        doctorName.setFont(f2);
        doctorName.setBounds(650,230,250,30);
        doctorName.addActionListener(this);
        add(doctorName);


        JLabel selected = new JLabel("<html><u>Selected Doctor</u></html>");
        selected.setFont(f1);
        selected.setBounds(100,550,300,30);
        add(selected);



        docselectedID = new JLabel("ID : ");
        docselectedID.setFont(f1);
        docselectedID.setBounds(70,600,300,30);
        add(docselectedID);

        docSelectedname = new JLabel("Name : ");
        docSelectedname.setFont(f1);
        docSelectedname.setBounds(300,600,300,30);
        add(docSelectedname);

        docdep = new JLabel("Depertment : ");
        docdep.setFont(f1);
        docdep.setBounds(630,600,300,30);
        add(docdep);



        table = new JTable();
        table.setFont(new Font("Dialog" ,Font.PLAIN , 15 ));
        sp = new JScrollPane(table);
        sp.setBounds(130, 320, 700, 200);
        table.setBackground(Color.white);
        table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent event) {
                if (!event.getValueIsAdjusting()) {
                    int selectedRow = table.getSelectedRow();
                    if (selectedRow != -1) {

                        selectedID = table.getValueAt(selectedRow, 0).toString();
                        selectedName = table.getValueAt(selectedRow, 1).toString();
                        selectedDepartment = table.getValueAt(selectedRow, 2).toString();

                        docSelectedname.setText("Name : " + selectedName);
                        docdep.setText("Department : " + selectedDepartment);
                        docselectedID.setText("ID : " + selectedID);

                    }
                }
            }
        });
        add(sp);


        confirmbutton = new JButton("Confirm");
        confirmbutton.setBounds(350, 650, 150,50 );
        confirmbutton.setFont(f1);
        confirmbutton.addActionListener(this);
        confirmbutton.setBackground(Color.lightGray);
        add(confirmbutton);




        setVisible(true);
        setBounds(280,30,1000,800);
        setTitle("Appointment");
        //setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setBackground(Color.white);

    }

    public static void main(String[] args) {
        new AppointmentDashoard();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource() == id){

            System.out.println("ho");

            try {

                String iid = id.getText();
                Conn c = new Conn();

                String query = "SELECT name, age, date_of_birth, gender, blood_group, contact_number FROM patient_list WHERE patientID = '" + iid + "'";
                ResultSet rs = c.s.executeQuery(query);

                if(rs.next()){

                    name = rs.getString("name");
                    age = rs.getString("age");
                    dob = rs.getString("date_of_birth");
                    gender = rs.getString("gender");
                    bloodgroup = rs.getString("blood_group");
                    contact = rs.getString("contact_number");

                    namel.setText("Name : " + name);
                    agel.setText("Age : " + age);
                    dobl.setText("DOB : " + dob);
                    genderl.setText("Gender : " + gender);
                    bloodgroupl.setText("Blood Group : " + bloodgroup);
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
        else if (e.getSource() == depertments) {

            try{
                String Depertment = (String) depertments.getSelectedItem();
                Conn c = new Conn();
                String query = "SELECT doctorID , name, depertment, availabily FROM doctor_list WHERE depertment = '" + Depertment + "' ";
                ResultSet rs = c.s.executeQuery(query);
                table.setModel(DbUtils.resultSetToTableModel(rs));

            } catch (Exception ex) {
                throw new RuntimeException(ex);
            }

        }
        else if (e.getSource() == doctorName) {

            try{
                String Name = doctorName.getText();
                Conn c = new Conn();
                String query = "SELECT doctorID ,name, depertment, availabily FROM doctor_list WHERE name = '" + Name + "' ";
                ResultSet rs = c.s.executeQuery(query);
                table.setModel(DbUtils.resultSetToTableModel(rs));

            } catch (Exception ex) {
                throw new RuntimeException(ex);
            }



        }
        else if (e.getSource() == confirmbutton) {

            String AppointmentID = String.valueOf(appoinmentID);
            String PatientName = name;
            String PatientID = id.getText();
            String DoctorName = selectedName;
            String DoctorID = selectedID;
            String DocDepertment = selectedDepartment;
            Date date = dateChooser2.getDate();
            SimpleDateFormat formatdate = new SimpleDateFormat("dd-MM-yyyy");
            String formattedDate = formatdate.format(date);

            if(PatientID.isEmpty()){
                JOptionPane.showMessageDialog(null,"Patient Not Set");
                return;
            }


            try{
                Conn conn = new Conn();
                String query = "INSERT INTO Appointments VALUES ('"
                        + AppointmentID + "', '"
                        + PatientName + "', '"
                        + PatientID + "', '"
                        + DoctorName + "', '"
                        + DoctorID + "', '"
                        + DocDepertment + "', '"
                        + formattedDate + "')";


                conn.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null,"Appoinment Set Succesfully");
//                new AppointmentDashoard().setVisible(true);

            }
            catch (Exception ex) {
                throw new RuntimeException(ex);
            }



        }

    }
}



























