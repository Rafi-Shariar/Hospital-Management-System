package Forms;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Dashboards.Admin.AdminDashboard;

import javax.swing.*;

public class AdminLogin extends Login implements ActionListener {

    public AdminLogin(){
        setTitle("Admin Login");
        loginL.setText("Admin login");
        login.addActionListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource() == login){

            String userid = getId().getText();
            char[] p = getPass().getPassword();
            String password = new String(p);

            if(userid.equals("12345") && password.equals("12345")){
                setVisible(false);
                new AdminDashboard();
            }
            else {
                JOptionPane.showMessageDialog(null,"Wrong User Name or Password !");
                getId().setText("");
                getPass().setText("");
            }



        }

    }

    public static void main(String[] args) {
        new AdminLogin();
    }


}
