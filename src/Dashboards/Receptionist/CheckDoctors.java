package Dashboards.Receptionist;

import Dashboards.Admin.AdminDashboard;
import Dashboards.Conn;
import net.proteanit.sql.DbUtils;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class CheckDoctors extends JFrame implements ActionListener{

    JButton back,search;
    JTextField name;
    JTable table;
    JScrollPane sp;

    public CheckDoctors(){
        setLayout(null);

        JLabel intro = new JLabel("Available Doctors");
        intro.setFont(new Font("Eras Bold ITC" , Font.BOLD,50));
        intro.setBounds(300,10,500,80);
        add(intro);

        table = new JTable();
        table.setFont(new Font("Dialog" ,Font.PLAIN , 12 ));
        sp = new JScrollPane(table);
        sp.setBounds(50, 200, 900, 400);
        table.setBackground(Color.WHITE);
        add(sp);
        try{
            Conn c = new Conn();
            String query = "SELECT doctorID, name, depertment, availabily, contact_number, email FROM doctor_list";
            ResultSet rs = c.s.executeQuery(query);
            table.setModel(DbUtils.resultSetToTableModel(rs));

        } catch (Exception e) {
            e.printStackTrace();
        }


        JLabel namej = new JLabel("Doctor ID : ");
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



        setVisible(true);
        setBounds(550,100,1000,700);
        getContentPane().setBackground(Color.white);
        setTitle("Receptionist - Doctor List");


    }

    public static void main(String[] args) {
        new CheckDoctors();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource() == back){
            setVisible(false);
            new AdminDashboard().setVisible(true);
        }
        else if (e.getSource() == search) {

            try {
                String ID = name.getText();
                String query = "SELECT doctorID, name, depertment, availabily, contact_number, email "
                        + "FROM doctor_list WHERE doctorID = '" + ID + "'";

                Conn c = new Conn();
                ResultSet rs = c.s.executeQuery(query);
                table.setModel(DbUtils.resultSetToTableModel(rs));
            }
            catch (Exception ex) {
                throw new RuntimeException(ex);
            }





        }

    }
}