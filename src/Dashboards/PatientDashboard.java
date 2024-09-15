package Dashboards;

public class PatientDashboard extends DashboardFrame{

    public PatientDashboard(){
        intro.setText("WellCome To Patient's Dashboard");
        setTitle("Patient Dashboard");

    }

    public static void main(String[] args) {
        new PatientDashboard();
    }
}
