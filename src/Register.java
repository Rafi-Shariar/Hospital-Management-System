import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class Register extends JFrame {

    JButton doctor,patient;
    JTextField name , nid , age , dob , gender , marital , bloodgroup, nationality , contactnum, email, address, emergencyContact;
    Long patientID;
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

        Random ran = new Random();
        patientID = Math.abs( (ran.nextLong()%10000000L) + 10000L);
        JLabel patiendid = new JLabel("Patient ID : " + patientID);
        patiendid.setFont(f1);
        patiendid.setBounds(450,150,300,20);
        add(patiendid);


        JLabel nameJ = new JLabel("Patient Name :");
        nameJ.setFont(f1);
        nameJ.setBounds(220,200,300,20);
        add(nameJ);

        JLabel nidJ  = new JLabel("NID/Birth Certificate Number :");
        nidJ.setFont(f1);
        nidJ.setBounds(50,240,320,20);
        add(nidJ);

        JLabel Age  = new JLabel("Age :");
        Age.setFont(f1);
        Age.setBounds(300,280,100,20);
        add(Age);

        JLabel dobJ  = new JLabel("Date Of Birth :");
        dobJ.setFont(f1);
        dobJ.setBounds(700,280,200,20);
        add(dobJ);

        JLabel marideJ  = new JLabel("Marital Status :");
        marideJ.setFont(f1);
        marideJ.setBounds(200,320,200,20);
        add(marideJ);

        JLabel genderJ  = new JLabel("Gender :");
        genderJ.setFont(f1);
        genderJ.setBounds(700,320,200,20);
        add(genderJ);

        JLabel bloodgrpJ  = new JLabel("Blood Group :");
        bloodgrpJ.setFont(f1);
        bloodgrpJ.setBounds(200,360,200,20);
        add(bloodgrpJ);

        JLabel nationalJ  = new JLabel("Nationality :");
        nationalJ.setFont(f1);
        nationalJ.setBounds(200,400,200,20);
        add(nationalJ);

        JLabel contact  = new JLabel("Contact :");
        contact.setFont(f1);
        contact.setBounds(200,440,200,20);
        add(contact);

        JLabel emercontact  = new JLabel("Emergency Contact :");
        emercontact.setFont(f1);
        emercontact.setBounds(700,440,300,20);
        add(emercontact);


        JLabel emailJ  = new JLabel("Email :");
        emailJ.setFont(f1);
        emailJ.setBounds(200,480,200,20);
        add(emailJ);


        JLabel addJ  = new JLabel("Address :");
        addJ.setFont(f1);
        addJ.setBounds(200,520,200,20);
        add(addJ);


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




































        setVisible(true);
        setBounds(400,100,1200,800);
        getContentPane().setBackground(Color.white);
        setTitle("Registration");



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
