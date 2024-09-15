package Forms;

import Dashboards.AdminDashboard;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ReceptionistLogin extends Login implements ActionListener {
    public ReceptionistLogin(){
        setTitle("Receptionist Login");
        loginL.setText("Receptionist Login");
        loginL.setBounds(140,120,250,50);
        login.addActionListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource() == login){

            String userid = id.getText();
            char[] p = pass.getPassword();
            String password = new String(p);

            if(userid.equals("12345") && password.equals("12345")){
                setVisible(false);

            }
            else {
                JOptionPane.showMessageDialog(null,"Wrong User Name or Password !");
                id.setText("");
                pass.setText("");
            }



        }

    }

    public static void main(String[] args) {
        new ReceptionistLogin();
    }


}
