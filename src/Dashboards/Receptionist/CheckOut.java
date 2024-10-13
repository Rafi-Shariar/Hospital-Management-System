package Dashboards.Receptionist;

import Dashboards.Conn;
import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CheckOut extends JFrame implements ActionListener {

    JLabel namel,agel,dobl,genderl,bloodgroupl,contactl,roomT,roomno,adD ,tbp;
    String name="",age="",dob="",gender="",bloodgroup="",contact="" ,admittedDate = "", selectedRoom = "", selected_roomtype = "", fees ="", releaseDate = "" , Total = ""; ;
    JTextField id;
    JDateChooser dateChooser2;
    JButton ok , sendfile;

    CheckOut(){

        setLayout(null);
        Font f1 = new Font("Dubai Medium" , Font.BOLD,20);
        Font f2 = new Font("Dubai Medium" , Font.PLAIN,20);

        JLabel intro = new JLabel("CheckOut Patient " );
        intro.setBounds(380,10,500,40);
        intro.setFont(new Font("Dubai Medium" , Font.BOLD,30));
        add(intro);



        JLabel patientID = new JLabel("Patient ID : ");
        patientID.setFont(f1);
        patientID.setBounds(20,50,200,25);
        add(patientID);
        id = new JTextField();
        id.setBounds(130,50,100,25);
        id.setFont(f2);
        id.addActionListener(this);
        id.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {}
            @Override
            public void keyPressed(KeyEvent e) {}
            @Override
            public void keyReleased(KeyEvent e) {}
        });
        add(id);

        namel = new JLabel("Name : " + name);
        namel.setBounds(20,100,400,25);
        namel.setFont(f1);
        add(namel);
        agel = new JLabel("Age : " + age);
        agel.setBounds(20,130,400,25);
        agel.setFont(f1);
        add(agel);
        roomT = new JLabel("Room Type : " + selected_roomtype);
        roomT.setBounds(20,160,400,25);
        roomT.setFont(f1);
        add(roomT);



        dobl = new JLabel("DOB : " + dob);
        dobl.setBounds(350,100,400,25);
        dobl.setFont(f1);
        add(dobl);
        genderl = new JLabel("Gender : " + gender);
        genderl.setBounds(350,130,400,25);
        genderl.setFont(f1);
        add(genderl);
        roomno = new JLabel("Room No : " + selectedRoom);
        roomno.setBounds(350,160,400,25);
        roomno.setFont(f1);
        add(roomno);


        bloodgroupl = new JLabel("Blood Group : " + bloodgroup);
        bloodgroupl.setBounds(680,100,400,25);
        bloodgroupl.setFont(f1);
        add(bloodgroupl);
        contactl = new JLabel("Contact : " + contact);
        contactl.setBounds(680,130,400,25);
        contactl.setFont(f1);
        add(contactl);


        adD  = new JLabel("Admiting Date" + admittedDate);
        adD.setFont(f1);
        adD.setBounds(50,250,350,20);
        add(adD);

        JLabel resDate = new JLabel("Release Date : " + releaseDate);
        resDate.setFont(f1);
        resDate.setBounds(450,250,250,20);
        add(resDate);

        dateChooser2 = new JDateChooser();
        dateChooser2.setBounds(600,250,210,30);
        dateChooser2.setFont(f2);
        add(dateChooser2);

        ok = new JButton("Calculate Fees");
        ok.setBounds(370,330,200,50);
        ok.setFont(f2);
        ok.addActionListener(this);
        add(ok);



        tbp = new JLabel("To Be Paid : ");
        tbp.setFont(new Font("Dubai Medium" , Font.BOLD,50));
        tbp.setBounds(200, 430, 600,60);
        tbp.setForeground(Color.RED);
        add(tbp);

        sendfile = new JButton("Send File to Accounts");
        sendfile.setBounds(340,550,300,50);
        sendfile.setFont(f2);
        sendfile.addActionListener(this);
        add(sendfile);




        setVisible(true);
        setBounds(280,30,1000,700);
        setTitle("CheckOut Patient");
        getContentPane().setBackground(Color.white);


    }





    public static void main(String[] args) {
        new CheckOut();
    }
    @Override
    public void actionPerformed(ActionEvent e) {

        Date dobDate = dateChooser2.getDate();
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        String RD = dobDate != null ? sdf.format(dobDate) : ""; // Handle null date selection
        String iid = id.getText();

        if (e.getSource() == id) {

//            System.out.println("ho");

            try {

                Conn c = new Conn();

                String query = "SELECT name, age, date_of_birth, gender, blood_group, contact_number FROM patient_list WHERE patientID = '" + iid + "'";
                ResultSet rs = c.s.executeQuery(query);

                if (rs.next()) {
                    name = rs.getString("name");
                    age = rs.getString("age");
                    dob = rs.getString("date_of_birth");
                    gender = rs.getString("gender");
                    bloodgroup = rs.getString("blood_group");
                    contact = rs.getString("contact_number");

                    namel.setText("Name : " + name);
                    agel.setText("Age : " + age);
                    dobl.setText("DOB : " + dob);
                    genderl.setText("Gender : " + gender);
                    bloodgroupl.setText("Blood Group : " + bloodgroup);
                    contactl.setText("Contact : " + contact);
                } else {
                    JOptionPane.showMessageDialog(null, "Patient not registered");
                }

                rs.close();

                String query2 = "SELECT admitted_date, room_type, room_name , fees FROM admitted_list WHERE patient_id = '" + iid + "'";
                ResultSet rs2 = c.s.executeQuery(query2);

                if (rs2.next()) {

                    admittedDate = rs2.getString("admitted_date");
                    selected_roomtype = rs2.getString("room_type");
                    selectedRoom = rs2.getString("room_name");
                    fees = rs2.getString("fees");

                    roomT.setText("Room Type : " + selected_roomtype);
                    roomno.setText("Room No : " + selectedRoom);
                    adD.setText("Admitted Date : " + admittedDate);



                }
                else {
                    JOptionPane.showMessageDialog(null, "Patient not registered");
                }


                rs2.close();

            } catch (Exception ex) {
                throw new RuntimeException(ex);
            }

            System.out.println("2---> " + admittedDate + " " + iid + " " + name + " " + selected_roomtype + " " + selectedRoom + " " + fees + " " + RD);
        }
        else if (e.getSource() == ok) {

            System.out.println(releaseDate);
            System.out.println("OK");
            System.out.println("3---> " + admittedDate + " " + iid + " " + name + " " + selected_roomtype + " " + selectedRoom + " " + fees + " " + RD);




            try {

                Conn c = new Conn();

                System.out.println(admittedDate + " " + iid + " " + name + " " + selected_roomtype + " " + selectedRoom + " " + fees + " " + RD);

                String query3 = "INSERT INTO released_list VALUES ('"
                        + admittedDate + "', '"
                        + iid + "', '"
                        + name + "', '"
                        + selected_roomtype + "', '"
                        + selectedRoom + "', '"
                        + fees + "', '"
                        + RD + "')";

                c.s.executeUpdate(query3);


                String Query2 = "SELECT "
                        + "DATEDIFF( "
                        + "STR_TO_DATE(released_date, '%d-%m-%Y'), "
                        + "STR_TO_DATE(admitted_date, '%d-%m-%Y') "
                        + ") * CAST(fees AS DECIMAL(10, 2)) AS total_fees "
                        + "FROM released_list "
                        + "WHERE patient_id = '" + iid + "'";

                ResultSet rs = c.s.executeQuery(Query2);

                if (rs.next()) {
                    Total = rs.getString("total_fees");
                    tbp.setText("To Be Paid : " + Total);
                }


                String query4 = "DELETE FROM admitted_list WHERE patient_id = '" + iid + "'";
                c.s.executeUpdate(query4);




            } catch (Exception ex) {
                throw new RuntimeException(ex);
            }







        } else if (e.getSource() == sendfile) {

            JOptionPane.showMessageDialog(null, "File Send to Accounts");

        }
    }

}
