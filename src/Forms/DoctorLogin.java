package Forms;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Dashboards.DoctorDashboard;

public class DoctorLogin extends Login {



    public DoctorLogin(){
        setTitle("Doctor Login");
        loginL.setText("Doctor login");
        login.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                setVisible(false);
                new DoctorDashboard().setVisible(true);
            }
        });



    }

    public static void main(String[] args) {
        new DoctorLogin();
    }


}
