package Forms;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ForgotPass extends JFrame implements ActionListener {

    JTextField ID , NID, newpass;

    ForgotPass(){
        setLayout(null);
        Font f1 = new Font("Copperplate Gothic Bold" , Font.PLAIN , 18);
        Font f3 = new Font("Dialog" ,Font.PLAIN , 18 );


        JLabel intro = new JLabel("RESET YOUR PASSWORD");
        intro.setFont(new Font("Dialog" ,Font.BOLD, 30 ));
        intro.setBounds(130,20,500,40);
        intro.setForeground(Color.green);
        add(intro);


        JLabel passwardJ  = new JLabel("User ID :");
        passwardJ.setFont(f1);
        passwardJ.setBounds(180,150,200,20);
        add(passwardJ);
        ID = new JTextField();
        ID.setBounds(300,150,200,25);
        ID.setFont(f3);
        add(ID);


        JLabel NIDlable  = new JLabel("NID Number :");
        NIDlable.setFont(f1);
        NIDlable.setBounds(130,200,200,20);
        add(NIDlable);
        NID = new JTextField();
        NID.setBounds(300,200,200,25);
        add(NID);


        JLabel newpasslable  = new JLabel("New Password :");
        newpasslable.setFont(f1);
        newpasslable.setBounds(100,250,200,20);
        add(newpasslable);
        newpass = new JTextField();
        newpass.setBounds(300,250,200,25);
        newpass.setFont(f3);
        add(newpass);


        JButton apply = new JButton("Reset Password");
        apply.setBounds(220,350,250,40);
        apply.setFont(f1);
        apply.setBackground(Color.DARK_GRAY);
        apply.setForeground(Color.white);
        apply.addActionListener(this);
        add(apply);






        setVisible(true);
        setBounds(450,100,700,600);
        setTitle("Forgot Password");
        getContentPane().setBackground(Color.white);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    public static void main(String[] args) {
        new ForgotPass();
    }
}
