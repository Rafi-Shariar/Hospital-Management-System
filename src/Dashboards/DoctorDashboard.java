package Dashboards;

import Dashboard_Functions.Doctor.PatientList;
import Dashboard_Functions.Doctor.Prescribe;
import Dashboard_Functions.Doctor.UpdateDoctorProfile;
import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DoctorDashboard extends DashboardFrame implements ActionListener {

    JButton updateprofile , prescribe, patientlist;
    Timer timer;
    JLabel dateTimeLabel;
    JDateChooser dateChooser;


    public DoctorDashboard(){

        intro.setText("WelCome To Doctor's Dashboard");
        setTitle("Doctor Dashboard");


        Font f1 = new Font("Constantia" , Font.PLAIN,20);
        Font f2 = new Font("Eras Bold ITC" , Font.PLAIN,20);

        JLabel namej = new JLabel("Doctors name");
        namej.setFont(f1);
        namej.setBounds(10,200, 300,25);
        add(namej);

        JLabel availablej = new JLabel("Available on : ");
        availablej.setFont(f1);
        availablej.setBounds(700,200, 300,25);
        add(availablej);

        JLabel depertmentj = new JLabel("Depertment");
        depertmentj.setFont(f1);
        depertmentj.setBounds(10,230, 300,25);
        add(depertmentj);

        dateTimeLabel = new JLabel();
        dateTimeLabel.setFont(f1);
        dateTimeLabel.setBounds(800, 230, 400, 25);
        add(dateTimeLabel);

        timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateDateTime();
            }
        });
        timer.start();

        JLabel contactj = new JLabel("Contact");
        contactj.setFont(f1);
        contactj.setBounds(10,260, 300,25);
        add(contactj);

        JLabel emialj = new JLabel("Email");
        emialj.setFont(f1);
        emialj.setBounds(10,290, 300,25);
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
        appointmentj.setBounds(300,300, 300,25);
        add(appointmentj);


        JLabel datej  = new JLabel("Date :");
        datej.setFont(f2);
        datej.setBounds(800,305,200,20);
        add(datej);
        dateChooser = new JDateChooser();
        dateChooser.setBounds(865,305,200,30);
        dateChooser.setFont(f2);
        add(dateChooser);



    }

    public static void main(String[] args) {
        new DoctorDashboard();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource() == updateprofile){

            new UpdateDoctorProfile().setVisible(true);

        } else if ( e.getSource() == prescribe) {
            new Prescribe().setVisible(true);

        } else if (e.getSource() == patientlist) {
            new PatientList().setVisible(true);

        }

    }

    private void updateDateTime() {

        SimpleDateFormat sdf = new SimpleDateFormat("dd MMM yyyy     HH : mm : ss");
        String currentTime = sdf.format(new Date());
        dateTimeLabel.setText(currentTime);
    }
}
