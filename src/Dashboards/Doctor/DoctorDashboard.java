package Dashboards.Doctor;

import Dashboards.Conn;
import Dashboards.DashboardFrame;
import com.toedter.calendar.JDateChooser;
import net.proteanit.sql.DbUtils;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DoctorDashboard extends DashboardFrame implements ActionListener {

    JButton updateprofile , prescribe, patientlist;
    Timer timer;
    JLabel dateTimeLabel;
    JDateChooser dateChooser;
    String name , depertment,contact,email,available;
    JTable table;
    JScrollPane sp;
    public String docID , docName;


    public DoctorDashboard(String DoctorID){

        intro.setText("WelCome To Doctor's Dashboard");
        setTitle("Doctor Dashboard");


        Font f1 = new Font("Constantia" , Font.BOLD,20);
        Font f2 = new Font("Eras Bold ITC" , Font.PLAIN,20);

        docID = DoctorID;

        try {

            Conn c = new Conn();

            String query = "SELECT name, depertment, contact_number, email, availabily FROM doctor_list WHERE doctorID = '" + DoctorID + "'";
            ResultSet rs = c.s.executeQuery(query);

            if (rs.next()) {

                name = rs.getString("name");
                docName = name;
                depertment = rs.getString("depertment");
                contact = rs.getString("contact_number");
                email = rs.getString("email");
                available = rs.getString("availabily");
            }


        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        JLabel namej = new JLabel("Doctors name : " + name);
        namej.setFont(f1);
        namej.setBounds(10,200, 500,25);
        add(namej);

        JLabel availablej = new JLabel("Available on : " + available);
        availablej.setFont(f1);
        availablej.setBounds(800,200, 400,25);
        add(availablej);

        JLabel depertmentj = new JLabel("Depertment : " + depertment);
        depertmentj.setFont(f1);
        depertmentj.setBounds(10,230, 300,25);
        add(depertmentj);

        dateTimeLabel = new JLabel();
        dateTimeLabel.setFont(f2);
        dateTimeLabel.setBounds(800, 230, 400, 25);
        add(dateTimeLabel);

        timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateDateTime();
            }
        });
        timer.start();

        JLabel contactj = new JLabel("Contact : " + contact);
        contactj.setFont(f1);
        contactj.setBounds(10,260, 300,25);
        add(contactj);

        JLabel emialj = new JLabel("Email : " + email);
        emialj.setFont(f1);
        emialj.setBounds(10,290, 500,25);
        add(emialj);




        updateprofile = new JButton("Update Profile");
        updateprofile.setBounds(10,400,200,40);
        updateprofile.setFont(f2);
        updateprofile.setForeground(Color.white);
        updateprofile.setBackground(Color.darkGray);
        updateprofile.addActionListener(this);
        add(updateprofile);


        prescribe = new JButton("Prescribe");
        prescribe.setBounds(10,460,200,40);
        prescribe.setFont(f2);
        prescribe.setForeground(Color.white);
        prescribe.setBackground(Color.darkGray);
        prescribe.addActionListener(this);
        add(prescribe);



        patientlist = new JButton("Patient List");
        patientlist.setBounds(10,520,200,40);
        patientlist.setFont(f2);
        patientlist.setForeground(Color.white);
        patientlist.setBackground(Color.darkGray);
        patientlist.addActionListener(this);
        add(patientlist);

        JLabel appointmentj = new JLabel("Appointments");
        appointmentj.setFont(new Font("Eras Bold ITC" , Font.BOLD,30));
        appointmentj.setBounds(350,330, 300,25);
        add(appointmentj);


        JLabel datej  = new JLabel("Date :");
        datej.setFont(f2);
        datej.setBounds(800,305,200,20);
        add(datej);
        dateChooser = new JDateChooser();
        dateChooser.setBounds(865,305,200,30);
        dateChooser.setFont(f2);
        dateChooser.addPropertyChangeListener(new PropertyChangeListener() {
            @Override
            public void propertyChange(PropertyChangeEvent evt) {

                if ("date".equals(evt.getPropertyName())) {

                    Date selectedDate = dateChooser.getDate();

                    if (selectedDate != null) {
                        SimpleDateFormat formatDate = new SimpleDateFormat("dd-MM-yyyy");
                        String formattedDate = formatDate.format(selectedDate);
                        try {
                            Conn c = new Conn();
                            String query = "SELECT DateofAppointment, Patient_ID, Patient_Name, AppoinmentID " +
                                    "FROM appointments WHERE Doctor_ID = '" + DoctorID + "' AND DateofAppointment = '" + formattedDate + "'";
                            ResultSet rs = c.s.executeQuery(query);
                            table.setModel(DbUtils.resultSetToTableModel(rs));
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        });
        add(dateChooser);

        table = new JTable();
        table.setFont(new Font("Dialog" ,Font.PLAIN , 15 ));
        sp = new JScrollPane(table);
        sp.setBounds(300, 380, 800, 300);
        table.setBackground(Color.white);
        add(sp);



    }

//    public static void main(String[] args) {
//        new DoctorDashboard("4778657");
//    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource() == updateprofile){

            new UpdateDoctorProfile(docID).setVisible(true);

        } else if ( e.getSource() == prescribe) {
            new Prescribe(docID,docName).setVisible(true);

        } else if (e.getSource() == patientlist) {
            new DocPatientList().setVisible(true);

        }

    }

    private void updateDateTime() {

        SimpleDateFormat sdf = new SimpleDateFormat("dd MMM yyyy     HH : mm : ss");
        String currentTime = sdf.format(new Date());
        dateTimeLabel.setText(currentTime);
    }

}

//4778657