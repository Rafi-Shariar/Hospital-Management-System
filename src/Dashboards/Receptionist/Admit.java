package Dashboards.Receptionist;

import Dashboards.Conn;
import com.toedter.calendar.JDateChooser;
import net.proteanit.sql.DbUtils;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Admit extends JFrame implements ActionListener {

    JLabel namel,agel,dobl,genderl,bloodgroupl,contactl;
    String name="",age="",dob="",gender="",bloodgroup="",contact="" , selectedRoom = "", selected_roomtype = "", fees ="";
    JTextField id;
    JDateChooser dateChooser2;
    JTable table;
    JScrollPane sp;
    JButton admitbutton;

    JComboBox roomType;
    String[] roomTypelist = {
            "Select",
            "General Ward",
            "Burn Unit",
            "CCU",
            "ICU",
            "Maternity Ward",
            "NICU",
            "Private Room",
            "Deluxe/VIP Room"

    };


    Admit(){
        setLayout(null);
        Font f1 = new Font("Dubai Medium" , Font.BOLD,20);
        Font f2 = new Font("Dubai Medium" , Font.PLAIN,20);

        JLabel intro = new JLabel("Admit Patient " );
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


        dobl = new JLabel("DOB : " + dob);
        dobl.setBounds(350,100,400,25);
        dobl.setFont(f1);
        add(dobl);
        genderl = new JLabel("Gender : " + gender);
        genderl.setBounds(350,130,400,25);
        genderl.setFont(f1);
        add(genderl);


        bloodgroupl = new JLabel("Blood Group : " + bloodgroup);
        bloodgroupl.setBounds(680,100,400,25);
        bloodgroupl.setFont(f1);
        add(bloodgroupl);
        contactl = new JLabel("Contact : " + contact);
        contactl.setBounds(680,130,400,25);
        contactl.setFont(f1);
        add(contactl);


        JLabel dobJ  = new JLabel("Admiting Date");
        dobJ.setFont(f1);
        dobJ.setBounds(50,200,250,20);
        add(dobJ);
        dateChooser2 = new JDateChooser();
        dateChooser2.setBounds(50,230,210,30);
        dateChooser2.setFont(f2);
        add(dateChooser2);



        JLabel depertment = new JLabel("Room Type :");
        depertment.setFont(f1);
        depertment.setBounds(350,200,250,20);
        add(depertment);
        roomType = new JComboBox<>(roomTypelist);
        roomType.setBounds(350,230,250,30);
        roomType.setFont(f2);
        roomType.setBackground(Color.white);
        roomType.addActionListener(this);
        add(roomType);


        table = new JTable();
        sp = new JScrollPane(table);
        sp.setBounds(100, 300, 800, 300);
        table.setBackground(Color.white);
        table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent event) {
                if (!event.getValueIsAdjusting()) {
                    int selectedRow = table.getSelectedRow();
                    if (selectedRow != -1) {
                        selectedRoom = table.getValueAt(selectedRow, 1).toString();
                        selected_roomtype = table.getValueAt(selectedRow, 0).toString();
                        fees = table.getValueAt(selectedRow, 2).toString();
                    }
                }
            }
        });
        add(sp);


        admitbutton = new JButton("Admit");
        admitbutton.setBounds(370,630,200,40);
        admitbutton.setFont(f2);
        admitbutton.setBackground(Color.darkGray);
        admitbutton.setForeground(Color.white);
        admitbutton.addActionListener(this);
        add(admitbutton);










        setVisible(true);
        setBounds(280,30,1000,800);
        setTitle("Admit Patient");
        getContentPane().setBackground(Color.white);

    }

    public static void main(String[] args) {
        new Admit();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource() == id){

            System.out.println("ho");

            try {

                String iid = id.getText();
                Conn c = new Conn();

                String query = "SELECT name, age, date_of_birth, gender, blood_group, contact_number FROM patient_list WHERE patientID = '" + iid + "'";
                ResultSet rs = c.s.executeQuery(query);

                if(rs.next()){

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
                }
                else{
                    JOptionPane.showMessageDialog(null, "Patient not registered");
                }



            }
            catch (Exception ex) {
                throw new RuntimeException(ex);
            }

        }
        else if (e.getSource() == roomType) {

            try{
                String room = (String) roomType.getSelectedItem();
                Conn c = new Conn();
                String query = "SELECT Room_Type , Room_No, Rate, Status FROM room_list WHERE Status = '" + "Available" + "' AND Room_Type = '" + room+ "'";
                ResultSet rs = c.s.executeQuery(query);
                table.setModel(DbUtils.resultSetToTableModel(rs));

            } catch (Exception ex) {
                throw new RuntimeException(ex);
            }

        } else if (e.getSource() == admitbutton) {

            String iid = id.getText();
            Date date = dateChooser2.getDate();
            SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
            String DOB = sdf.format(date);




            try{
                Conn c = new Conn();
                String query = "INSERT INTO Admitted_List VALUES ('"
                        + DOB + "', '"
                        + iid + "', '"
                        + name + "', '"
                        + selected_roomtype + "', '"
                        + selectedRoom + "', '"
                        + fees + "')";

                c.s.executeUpdate(query);


                String query2 = "UPDATE room_list SET Status = 'Occupied' WHERE Room_No = '"+selectedRoom +"'";
                c.s.executeUpdate(query2);

                JOptionPane.showMessageDialog(null, "Successfully Admitted !");
                setVisible(false);






            } catch (Exception ex) {
                throw new RuntimeException(ex);
            }





        }

    }
}
