package Dashboards.Doctor;


import Dashboards.Admin.AdminDashboard;
import Dashboards.Conn;

import Dashboards.SeePrescription;
import net.proteanit.sql.DbUtils;
import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class DocPatientList extends JFrame implements ActionListener{

    public JButton seehistory,search;
    public JTextField name;
    public JTable table;
    JScrollPane sp;
    String date,patientName,PatientID,DoctorName,DoctorID,Description,Medicines,Tests,Notes;
    public JLabel namej;

    public DocPatientList(){
        setLayout(null);

        JLabel intro = new JLabel("Patient History");
        intro.setFont(new Font("Eras Bold ITC" , Font.BOLD,50));
        intro.setBounds(300,10,500,80);
        add(intro);

        table = new JTable();
        table.setFont(new Font("Dialog" ,Font.PLAIN , 12 ));
        sp = new JScrollPane(table);
        sp.setBounds(50, 200, 900, 350);
        table.setBackground(Color.WHITE);
        table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent event) {
                if (!event.getValueIsAdjusting()) {
                    int selectedRow = table.getSelectedRow();
                    if (selectedRow != -1) {

                        date = table.getValueAt(selectedRow,0).toString();
                        patientName = table.getValueAt(selectedRow,1).toString();
                        PatientID = table.getValueAt(selectedRow,2).toString();
                        DoctorName = table.getValueAt(selectedRow,3).toString();
                        DoctorID = table.getValueAt(selectedRow,4).toString();
                        Description = table.getValueAt(selectedRow,5).toString();
                        Medicines = table.getValueAt(selectedRow,6).toString();
                        Tests = table.getValueAt(selectedRow,7).toString();
                        Notes = table.getValueAt(selectedRow,8).toString();


                    }
                }
            }
        });
        add(sp);
        try{
            Conn c = new Conn();
            String query = "SELECT * From prescriptions";
            ResultSet rs = c.s.executeQuery(query);
            table.setModel(DbUtils.resultSetToTableModel(rs));

        } catch (Exception e) {
            e.printStackTrace();
        }


        namej = new JLabel("Patient ID : ");
        namej.setBounds(130,130,200,30);
        namej.setFont(new Font("Dialog" ,Font.BOLD , 20 ));
        add(namej);

        name = new JTextField();
        name.setBounds(250,130,200,30);
        name.setFont(new Font("Dialog" ,Font.PLAIN , 20 ));
        add(name);

        search = new JButton("Search");
        search.setBounds(470,130,100,30);
        search.setBackground(Color.darkGray);
        search.setForeground(Color.white);
        search.setFont(new Font("Dialog" ,Font.PLAIN , 17 ));
        search.addActionListener(this);
        add(search);

        seehistory = new JButton("See Prescription");
        seehistory.setBounds(430,600,200,30);
        seehistory.setBackground(Color.darkGray);
        seehistory.setForeground(Color.white);
        seehistory.setFont(new Font("Dialog" ,Font.PLAIN , 17 ));
        seehistory.addActionListener(this);
        add(seehistory);




        setVisible(true);
        setBounds(550,100,1000,700);
        getContentPane().setBackground(Color.white);
        setTitle("Doctor List");


    }

    public static void main(String[] args) {
        new DocPatientList();
    }

    @Override
    public void actionPerformed(ActionEvent e) {


         if (e.getSource() == search) {

            try {
                String ID = name.getText();
                String query = "SELECT * FROM prescriptions WHERE Patient_ID = '" + ID + "'";


                Conn c = new Conn();
                ResultSet rs = c.s.executeQuery(query);
                table.setModel(DbUtils.resultSetToTableModel(rs));
            }
            catch (Exception ex) {
                throw new RuntimeException(ex);
            }

        }
         else if ( e.getSource() == seehistory) {
              new SeePrescription( date ,  patientName,  PatientID,  DoctorName,  DoctorID, Description,  Medicines, Tests, Notes).setVisible(true);
             System.out.println(Medicines);
         }

    }
}
