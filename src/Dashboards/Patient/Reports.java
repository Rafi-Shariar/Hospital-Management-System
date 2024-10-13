package Dashboards.Patient;

import Dashboards.Conn;
import Dashboards.DashboardFrame;
import Dashboards.Doctor.DocPatientList;
import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.sql.ResultSet;

public class Reports extends DocPatientList {

    private static String id = "";

    Reports(String PatientID){
        setLayout(null);
        namej.setBounds(0,0,0,0);
        name.setBounds(0,0,0,0);
        search.setBounds(0,0,0,0);
        id = PatientID;

        try{
            Conn c = new Conn();
            String query = "SELECT * From prescriptions Where Patient_ID = '"+PatientID+"'   ";
            ResultSet rs = c.s.executeQuery(query);
            table.setModel(DbUtils.resultSetToTableModel(rs));

        } catch (Exception e) {
            e.printStackTrace();
        }


        setTitle("My Reports");


    }

    public static void main(String[] args) {

        new Reports(id);

    }
}
