package Forms;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import Dashboards.Conn;
import Dashboards.Doctor.DoctorDashboard;

import javax.swing.*;

public class DoctorLogin extends Login {



    public DoctorLogin(){
        setTitle("Doctor Login");
        loginL.setText("Doctor login");

        login.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String ID = getId().getText();
                char[] P = getPass().getPassword();
                String password = new String(P);

                try{

                    Conn c = new Conn();
                    String query = "select * from logindetails WHERE ID = '" + ID + "' AND password = '" +password+"' ";

                    ResultSet rs = c.s.executeQuery(query);

                    if(rs.next()){
                        setVisible(false);
                        new DoctorDashboard(ID).setVisible(true);


                    }
                    else JOptionPane.showMessageDialog(null,"Invalid ID or Password");


                }
                catch (Exception ex) {
                    throw new RuntimeException(ex);
                }
            }
        });



    }

    public static void main(String[] args) {
        new DoctorLogin();
    }


}
