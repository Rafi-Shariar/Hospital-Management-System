package Forms;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Dashboards.PatientDashboard;

public class PatientLogin extends Login {



    public PatientLogin(){
        setTitle("Patient Login");
        loginL.setText("patient login");
        login.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                setVisible(false);
                new PatientDashboard().setVisible(true);
            }
        });



    }

    public static void main(String[] args) {
        new PatientLogin();
    }


}

