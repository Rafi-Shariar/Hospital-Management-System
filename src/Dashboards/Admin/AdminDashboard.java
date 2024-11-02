package Dashboards.Admin;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import Dashboards.AppointmentDashoard;
import Dashboards.Receptionist.SetAppoinment;
import Forms.EmployeeRegister;
import Forms.Register;
import Forms.DoctorRegister;

public class AdminDashboard extends JFrame implements ActionListener {

    JButton adddoctor, addpatient , docotorappointment , doctorlist, patientlist, addemployee, employeelist , admitedPatients;

    public AdminDashboard(){
        setLayout(null);


        JLabel Name = new JLabel("DAFFODIL WELLNESS HOSPITAL");
        Name.setBounds(200,10,700,40);
        Name.setFont(new Font("Eras Bold ITC" , Font.BOLD,30));
        Name.setForeground(Color.blue);
        add(Name);

        JLabel slogan = new JLabel("Caring Beyond Boundaries, Healing with Heart.");
        slogan.setBounds(220,45,700,50);
        slogan.setFont(new Font("Eras Demi ITC" , Font.BOLD,20));
        slogan.setForeground(Color.gray);
        add(slogan);

        Font f1 = new Font("Dubai Medium" , Font.BOLD,25);

        JLabel intro = new JLabel("Wellcome to Admin Dashboard");
        intro.setBounds(300,120,400,40);
        intro.setFont(f1);
        add(intro);

        adddoctor = new JButton("Add Doctor");
        adddoctor.setFont(f1);
        adddoctor.setBounds(200,200,200,50);
        adddoctor.setBackground(Color.darkGray);
        adddoctor.setForeground(Color.white);
        adddoctor.addActionListener(this);
        add(adddoctor);


        addpatient = new JButton("Add Patient");
        addpatient.setFont(f1);
        addpatient.setBounds(500,200,200,50);
        addpatient.setBackground(Color.darkGray);
        addpatient.setForeground(Color.white);
        addpatient.addActionListener(this);
        add(addpatient);

        docotorappointment = new JButton("Appointment");
        docotorappointment.setFont(f1);
        docotorappointment.setBounds(200,275,200,50);
        docotorappointment.setBackground(Color.darkGray);
        docotorappointment.setForeground(Color.white);
        docotorappointment.addActionListener(this);
        add(docotorappointment);

        addemployee = new JButton("Add Employee");
        addemployee.setFont(f1);
        addemployee.setBounds(500,275,200,50);
        addemployee.setBackground(Color.darkGray);
        addemployee.setForeground(Color.white);
        addemployee.addActionListener(this);
        add(addemployee);

        doctorlist = new JButton("Doctor List");
        doctorlist.setFont(f1);
        doctorlist.setBounds(200,350,200,50);
        doctorlist.setBackground(Color.darkGray);
        doctorlist.setForeground(Color.white);
        doctorlist.addActionListener(this);
        add(doctorlist);

        patientlist = new JButton("Patient List");
        patientlist.setFont(f1);
        patientlist.setBounds(500,350,200,50);
        patientlist.setBackground(Color.darkGray);
        patientlist.setForeground(Color.white);
        patientlist.addActionListener(this);
        add(patientlist);

        admitedPatients = new JButton("Admited Patient");
        admitedPatients.setFont(new Font("Dubai Medium" , Font.BOLD,22));
        admitedPatients.setBounds(500,425,200,50);
        admitedPatients.setBackground(Color.darkGray);
        admitedPatients.setForeground(Color.white);
        admitedPatients.addActionListener(this);
        add(admitedPatients);


        employeelist = new JButton("Employee List");
        employeelist.setFont(f1);
        employeelist.setBounds(200,425,200,50);
        employeelist.setBackground(Color.darkGray);
        employeelist.setForeground(Color.white);
        employeelist.addActionListener(this);
        add(employeelist);


        setVisible(true);
        setBounds(380,100,1000,700);
        setTitle("Admin Pannle");
        //setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setBackground(Color.white);

    }


    public static void main(String[] args) {
        new AdminDashboard();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource() == addpatient){
            new Register(true).setVisible(true);

        }
        else if(e.getSource() == adddoctor){

            new DoctorRegister().setVisible(true);

        }
        else if(e.getSource() == addemployee){

            new EmployeeRegister().setVisible(true);
        }
        else if (e.getSource() == doctorlist) {

            new DoctorList().setVisible(true);

        } else if (e.getSource() == patientlist) {

            new PatientList().setVisible(true);
        }
        else if (e.getSource() == employeelist) {

            new EmployeeList().setVisible(true);
        } else if (e.getSource() == admitedPatients) {
            new AdmitedPatientList().setVisible(true);

        } else if (e.getSource()==docotorappointment) {
            new SetAppoinment().setVisible(true);

        }
    }
}
