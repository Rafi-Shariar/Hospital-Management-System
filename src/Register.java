import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class Register extends JFrame implements ActionListener {

    JButton register;
    JTextField name , age , dob , nationality , contactnum, email, address ;
    Long patientID;
    JRadioButton male,female , marride , unmarride;
    ButtonGroup bg1 , bg2;
    JComboBox bloodgrp;
    String[] bldgrps = { "A+", "A-", "B+", "B-", "AB+", "AB-", "O+", "O-" };
    JDateChooser dateChooser;
    Register(){
        setLayout(null);

        JLabel Name = new JLabel("DAFFODIL WELLNESS HOSPITAL");
        Name.setBounds(50,10,700,50);
        Name.setFont(new Font("Eras Bold ITC" , Font.BOLD,40));
        Name.setForeground(Color.DARK_GRAY);
        add(Name);

        JLabel slogan = new JLabel("Caring Beyond Boundaries, Healing with Heart.");
        slogan.setBounds(90,50,700,40);
        slogan.setFont(new Font("Eras Demi ITC" , Font.BOLD,20));
        slogan.setForeground(Color.gray);
        add(slogan);

        ImageIcon i1 = new ImageIcon(this.getClass().getResource("/Images/PatientLogo.png"));
        Image i2 = i1.getImage().getScaledInstance(120,120,Image.SCALE_SMOOTH);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel i4 = new JLabel(i3);
        i4.setBounds(1000,5,120,120);
        add(i4);

        Font f1 = new Font("Copperplate Gothic Bold" , Font.PLAIN , 18);
        Font f3 = new Font("Dialog" ,Font.PLAIN , 18 );

        Random ran = new Random();
        patientID = Math.abs( (ran.nextLong()%10000000L) + 10000L);
        JLabel patiendid = new JLabel("Patient ID : " + patientID);
        patiendid.setFont(f1);
        patiendid.setBounds(450,150,300,20);
        add(patiendid);


        JLabel nameJ = new JLabel("Patient Name :");
        nameJ.setFont(f1);
        nameJ.setBounds(185,200,300,20);
        add(nameJ);
        name = new JTextField();
        name.setBounds(340,195,270,25);
        name.setFont(f3);
        add(name);

        JLabel nidJ  = new JLabel("NID/B.C Number :");
        nidJ.setFont(f1);
        nidJ.setBounds(150,240,320,20);
        add(nidJ);
        dob = new JTextField();
        dob.setBounds(340,235,270,25);
        dob.setFont(f3);
        add(dob);

        JLabel Age  = new JLabel("Age :");
        Age.setFont(f1);
        Age.setBounds(280,280,100,20);
        add(Age);
        age = new JTextField();
        age.setBounds(340,275,270,25);
        age.setFont(f3);
        add(age);

        JLabel dobJ  = new JLabel("Date Of Birth :");
        dobJ.setFont(f1);
        dobJ.setBounds(700,280,200,20);
        add(dobJ);
        dateChooser = new JDateChooser();
        dateChooser.setBounds(855,275,200,30);
        dateChooser.setFont(f3);
        add(dateChooser);

        JLabel marideJ  = new JLabel("Marital Status :");
        marideJ.setFont(f1);
        marideJ.setBounds(165,320,180,20);
        add(marideJ);
        marride = new JRadioButton("Marride");
        marride.setBounds(340,320,140,25);
        marride.setFont(f1);
        marride.setBackground(Color.white);
        add(marride);
        unmarride = new JRadioButton("Unmarride");
        unmarride.setBounds(480,320,180,25);
        unmarride.setFont(f1);
        unmarride.setBackground(Color.white);
        add(unmarride);
        bg1 = new ButtonGroup();
        bg1.add(marride);
        bg1.add(unmarride);

        JLabel genderJ  = new JLabel("Gender :");
        genderJ.setFont(f1);
        genderJ.setBounds(700,320,200,20);
        add(genderJ);
        male = new JRadioButton("Male");
        male.setBounds(800,320,100,25);
        male.setFont(f1);
        male.setBackground(Color.white);
        add(male);
        female = new JRadioButton("Female");
        female.setBounds(910,320,180,25);
        female.setFont(f1);
        female.setBackground(Color.white);
        add(female);
        bg2 = new ButtonGroup();
        bg2.add(male);
        bg2.add(female);

        JLabel bloodgrpJ  = new JLabel("Blood Group :");
        bloodgrpJ.setFont(f1);
        bloodgrpJ.setBounds(185,360,200,20);
        add(bloodgrpJ);
        bloodgrp = new JComboBox(bldgrps);
        bloodgrp.setFont(f3);
        bloodgrp.setBounds(355,355,200,30);
        bloodgrp.setBackground(Color.white);
        add(bloodgrp);


        JLabel nationalJ  = new JLabel("Nationality :");
        nationalJ.setFont(f1);
        nationalJ.setBounds(200,400,200,20);
        add(nationalJ);
        nationality = new JTextField();
        nationality.setBounds(340,395,270,25);
        nationality.setFont(f3);
        add(nationality);

        JLabel contact  = new JLabel("Contact :");
        contact.setFont(f1);
        contact.setBounds(230,440,200,20);
        add(contact);
        contactnum = new JTextField();
        contactnum.setBounds(340,435,270,25);
        contactnum.setFont(f3);
        add(contactnum);


        JLabel emailJ  = new JLabel("Email :");
        emailJ.setFont(f1);
        emailJ.setBounds(260,480,200,20);
        add(emailJ);
        email = new JTextField();
        email.setBounds(340,475,270,25);
        email.setFont(f3);
        add(email);


        JLabel addJ  = new JLabel("Address :");
        addJ.setFont(f1);
        addJ.setBounds(230,520,200,20);
        add(addJ);
        address = new JTextField();
        address.setBounds(340,515,600,25);
        address.setFont(f3);
        add(address);


        Font f2 = new Font("Copperplate Gothic Light" , Font.CENTER_BASELINE,13);

        JLabel address = new JLabel("Address : Daffodil Smart City (DSC), Birulia, Savar, Dhaka-1216 ");
        address.setBounds(350,640,700,40);
        address.setFont(f2);
        add(address);
        JLabel email = new JLabel("Mail : info@daffodilwhospital.org");
        email.setBounds(450,670,700,40);
        email.setFont(f2);
        add(email);
        JLabel Contact = new JLabel("Tel: +8802224441833");
        Contact.setBounds(480,700,700,40);
        Contact.setFont(f2);
        add(Contact);


        register = new JButton("Register");
        register.setBackground(Color.darkGray);
        register.setForeground(Color.white);
        register.setBounds(500,570,150,40);
        register.setFont(f1);
        register.addActionListener(this);

        add(register);


        setVisible(true);
        setBounds(400,100,1200,800);
        getContentPane().setBackground(Color.white);
        setTitle("Registration");

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        JOptionPane.showMessageDialog(null,"Successfully registered !");

        if( e.getSource() == register){
            setVisible(false);
            new Login().setVisible(true);
        }


    }



    public static void main(String[] args) {
        new Register();
    }


}
/*
Name
male/female
NID
age
DOB
Gender
Marital Status
Blood Group
Nationality
Phone number
Email
Adress
Emergency contact
*/
