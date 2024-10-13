package Dashboards.Admin;

import Dashboards.Conn;
import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class AdmitedPatientList extends JFrame implements ActionListener {

    JTextField name;
    JTable table;
    JScrollPane sp;

    AdmitedPatientList(){
        setLayout(null);
        JLabel intro = new JLabel("Admitted Patient LIST");
        intro.setFont(new Font("Eras Bold ITC" , Font.BOLD,40));
        intro.setBounds(250,10,600,80);
        add(intro);


        table = new JTable();
        table.setFont(new Font("Dialog" ,Font.PLAIN , 12 ));
        sp = new JScrollPane(table);
        sp.setBounds(50, 200, 900, 400);
        table.setBackground(Color.WHITE);
        sp.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        sp.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        add(sp);
        try{
            Conn c = new Conn();
            String query = "SELECT * FROM admitted_list";
            ResultSet rs = c.s.executeQuery(query);
            table.setModel(DbUtils.resultSetToTableModel(rs));

        } catch (Exception e) {
            e.printStackTrace();
        }




        setVisible(true);
        setBounds(250,100,1000,700);
        getContentPane().setBackground(Color.white);
        setTitle("Admitted Patient List");


    }

    public static void main(String[] args) {
        new AdmitedPatientList();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
