package Dashboards.Patient;

import Dashboards.AppointmentDashoard;
import Dashboards.Conn;
import Dashboards.DashboardFrame;
import Dashboards.Receptionist.SetAppoinment;
import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class PatientDashboard extends DashboardFrame implements ActionListener {

    JLabel patientName, patientID, bloodGroup, contact;
    JButton makeAppointment , reports , payments;
    JTable table;
    JScrollPane sp;
    String pn,pID,bg,con;
    public String getpID;

    public PatientDashboard( String PatientID){
        intro.setText("WellCome To Patient's Dashboard");
        setTitle("Patient Dashboard");
        getpID = PatientID;

        Font f1 = new Font("Constantia" , Font.BOLD,20);
        Font f2 = new Font("Eras Bold ITC" , Font.PLAIN,20);

        try {

            Conn c = new Conn();

            String query = "SELECT patientID ,name, blood_group, contact_number FROM patient_list WHERE patientID = '" + PatientID + "'";
            ResultSet rs = c.s.executeQuery(query);

            if (rs.next()) {


                pn = rs.getString("name");
                pID = rs.getString("patientID");
                con = rs.getString("contact_number");
                bg = rs.getString("blood_group");
            }


        } catch (Exception e) {
            throw new RuntimeException(e);
        }




        patientID = new JLabel("Patient ID : " + pID);
        patientID.setFont(f2);
        patientID.setBounds(50,230,500,25);
        add(patientID);


        patientName = new JLabel("Patient Name : " + pn);
        patientName.setFont(f2);
        patientName.setBounds(50,270,500,25);
        add(patientName);



        bloodGroup = new JLabel("Blood Group : " + bg);
        bloodGroup.setFont(f2);
        bloodGroup.setBounds(550,230,500,25);
        add(bloodGroup);


        contact = new JLabel("Contact : " + con);
        contact.setFont(f2);
        contact.setBounds(550,270,500,25);
        add(contact);


        makeAppointment = new JButton("Make Appointments");
        makeAppointment.setBackground(Color.darkGray);
        makeAppointment.setForeground(Color.white);
        makeAppointment.setFont(f1);
        makeAppointment.addActionListener(this);
        makeAppointment.setBounds(50,350 , 250,50);
        add(makeAppointment);



        reports = new JButton("Reports");
        reports.setBackground(Color.darkGray);
        reports.setForeground(Color.white);
        reports.setFont(f1);
        reports.addActionListener(this);
        reports.setBounds(50,450 , 250,50);
        add(reports);

        payments = new JButton("Update Profile");
        payments.setBackground(Color.darkGray);
        payments.setForeground(Color.white);
        payments.setFont(f1);
        payments.addActionListener(this);
        payments.setBounds(50,550 , 250,50);
        add(payments);


        JLabel intro =  new JLabel("My Appointments");
        intro.setBounds(400,350,300,35);
        intro.setFont(new Font("Eras Bold ITC" , Font.BOLD,30));
        add(intro);


        table = new JTable();
        sp = new JScrollPane(table);
        sp.setBounds(400, 400, 700, 300);
        table.setBackground(Color.white);
        add(sp);
        try{
            Conn c = new Conn();
            String query = "SELECT AppoinmentID, Doctor_Name, Depertment, DateofAppointment FROM appointments WHERE Patient_ID = '" + PatientID + "';";
            ResultSet rs = c.s.executeQuery(query);
            table.setModel(DbUtils.resultSetToTableModel(rs));

        } catch (Exception e) {
            e.printStackTrace();
        }



    }

//    public static void main(String[] args) {
//        new PatientDashboard("7429178");
//    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource() == makeAppointment){
            new AppointmentDashoard().setVisible(true);
        } else if ( e.getSource() == reports) {
            new Reports(getpID).setVisible(true);

        } else if (e.getSource() == payments) {
            new UpdatePatientProfile(getpID).setVisible(true);

        }


    }
}
