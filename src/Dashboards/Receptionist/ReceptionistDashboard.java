package Dashboards.Receptionist;

import Dashboards.Admin.DoctorList;
import Dashboards.AppointmentDashoard;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ReceptionistDashboard extends JFrame implements ActionListener{

    Timer timer;
    JLabel dateTimeLabel;
    JButton makeAppointmentButton , checkDoctor , admitpatient , checkoutpatient;

    public ReceptionistDashboard(){
        setLayout(null);

        JLabel Name = new JLabel("DAFFODIL WELLNESS HOSPITAL");
        Name.setBounds(15,10,700,40);
        Name.setFont(new Font("Eras Bold ITC" , Font.BOLD,26));
        Name.setForeground(Color.blue);
        add(Name);


        Font f1 = new Font("Dubai Medium" , Font.BOLD,25);

        JLabel intro = new JLabel("Welcome to Receptionist's Dashboard");
        intro.setBounds(30,60,500,40);
        intro.setFont(f1);
        add(intro);

        dateTimeLabel = new JLabel();
        dateTimeLabel.setFont(f1);
        dateTimeLabel.setBounds(80, 150, 400, 25);
        add(dateTimeLabel);

        timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateDateTime();
            }
        });
        timer.start();


        makeAppointmentButton = new JButton("Make Appointment");
        makeAppointmentButton.setBounds(100,250,250,50);
        makeAppointmentButton.setFont(f1);
        makeAppointmentButton.setBackground(Color.lightGray);
        makeAppointmentButton.setForeground(Color.darkGray);
        makeAppointmentButton.addActionListener(this);
        add(makeAppointmentButton);


        checkDoctor = new JButton("Check Doctor");
        checkDoctor.setBounds(100,350,250,50);
        checkDoctor.setFont(f1);
        checkDoctor.setBackground(Color.lightGray);
        checkDoctor.setForeground(Color.darkGray);
        checkDoctor.addActionListener(this);
        add(checkDoctor);

        admitpatient = new JButton("Admit");
        admitpatient.setBounds(100,450,250,50);
        admitpatient.setFont(f1);
        admitpatient.setBackground(Color.lightGray);
        admitpatient.setForeground(Color.darkGray);
        admitpatient.addActionListener(this);
        add(admitpatient);

        checkoutpatient = new JButton("Check Out");
        checkoutpatient.setBounds(100,550,250,50);
        checkoutpatient.setFont(f1);
        checkoutpatient.setBackground(Color.lightGray);
        checkoutpatient.setForeground(Color.darkGray);
        checkoutpatient.addActionListener(this);
        add(checkoutpatient);









        setVisible(true);
        setBounds(380,100,500,900);
        setTitle("Receptionist Pannle");
        getContentPane().setBackground(Color.white);

    }

    private void updateDateTime() {

        SimpleDateFormat sdf = new SimpleDateFormat("dd MMM yyyy     HH : mm : ss");
        String currentTime = sdf.format(new Date());
        dateTimeLabel.setText(currentTime);
    }

    public static void main(String[] args) {
        new ReceptionistDashboard();

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if( e.getSource() == makeAppointmentButton){
            new SetAppoinment().setVisible(true);
        }
        else if (e.getSource() == checkDoctor) {
            new CheckDoctors().setVisible(true);

        } else if (e.getSource() == admitpatient) {
            new Admit().setVisible(true);

        } else if (e.getSource() == checkoutpatient) {
            new CheckOut().setVisible(true);


        }

    }
}































