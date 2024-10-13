package Forms;

import javax.swing.*;
import java.awt.*;

public class Login extends JFrame {


    private   JTextField id;
    private JPasswordField pass;
    protected JButton login,doctor;
    protected JLabel loginL;
    protected JLabel patientID;

    public Login(){
        setLayout(null);

        Font f1 = new Font("Copperplate Gothic Bold" , Font.PLAIN , 22);
        Font f3 = new Font("Dialog" ,Font.PLAIN , 18 );

        JLabel Name = new JLabel("DAFFODIL WELLNESS HOSPITAL");
        Name.setBounds(40,10,400,50);
        Name.setFont(new Font("Eras Bold ITC" , Font.BOLD,22));
        Name.setForeground(Color.DARK_GRAY);
        add(Name);

        JLabel slogan = new JLabel("Caring Beyond Boundaries, Healing with Heart.");
        slogan.setBounds(45,50,700,40);
        slogan.setFont(new Font("Eras Demi ITC" , Font.BOLD,16));
        slogan.setForeground(Color.gray);
        add(slogan);

        loginL = new JLabel("Patient Login");
        loginL.setBounds(140,120,200,50);
        loginL.setFont( new Font("Eras Bold ITC" , Font.BOLD,20));
        loginL.setForeground(Color.darkGray);
        add(loginL);


        patientID = new JLabel("USER ID :");
        patientID.setFont(f1);
        patientID.setBounds(30, 200, 140 , 30);
        add(patientID);
        id = new JTextField();
        id.setFont(f3);
        id.setBounds(180,200,250,30);
        add(id);



        JLabel password = new JLabel("Password :");
        password.setFont(f1);
        password.setBounds(25, 250, 200 , 30);
        add(password);
        pass = new JPasswordField();
        pass.setFont(f3);
        pass.setBounds(180,250,250,30);
        add(pass);

        login = new JButton("LOGIN");
        login.setBounds(160 , 350 , 150 , 40);
        login.setFont(new Font("Eras Bold ITC" , Font.BOLD,20));
        login.setBackground(Color.darkGray);
        login.setForeground(Color.white);
        add(login);


        Font f2 = new Font("Copperplate Gothic Light" , Font.CENTER_BASELINE,13);

        JLabel address = new JLabel("Address : Daffodil Smart City (DSC), Birulia, Savar, Dhaka-1216 ");
        address.setBounds(10,640,700,40);
        address.setFont(f2);
        add(address);
        JLabel email = new JLabel("Mail : info@daffodilwhospital.org");
        email.setBounds(110,670,700,40);
        email.setFont(f2);
        add(email);
        JLabel Contact = new JLabel("Tel: +8802224441833");
        Contact.setBounds(160,700,700,40);
        Contact.setFont(f2);
        add(Contact);



        setVisible(true);
        setBounds(620,100,500,800);
        getContentPane().setBackground(Color.white);
        setTitle("Login");
    }

    public void setId(JTextField id) {
        this.id = id;
    }

    public JTextField getId() {
        return id;
    }

    public void setPass(JPasswordField pass) {
        this.pass = pass;
    }

    public JPasswordField getPass() {
        return pass;
    }

    public static void main(String[] args) {
        new Login();
    }

}
