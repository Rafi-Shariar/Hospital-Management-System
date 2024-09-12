import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Dashboards.AdminDashboard;

public class AdminLogin extends Login implements ActionListener {

    public AdminLogin(){
        setTitle("Admin Login");
        loginL.setText("Admin login");
        login.addActionListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource() == login){

            setVisible(false);
            new AdminDashboard();

        }

    }

    public static void main(String[] args) {
        new AdminLogin();
    }


}
