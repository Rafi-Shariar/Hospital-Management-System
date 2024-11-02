package Dashboards.Patient;

import Dashboards.Conn;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UpdatePatientProfile extends JFrame implements ActionListener {

    JTextField password , contactnum, address;
    JRadioButton marride,unmarride;
    ButtonGroup bg1;
    JButton done;
    String ID = "";

    public UpdatePatientProfile(String docid) {
        setLayout(null);
        Font f1 = new Font("Copperplate Gothic Bold" , Font.PLAIN , 18);
        Font f3 = new Font("Dialog" ,Font.PLAIN , 18 );
        ID = docid;

        JLabel intro = new JLabel("Update Info");
        intro.setFont(new Font("Dialog" ,Font.BOLD , 30));
        intro.setBounds(350,50,200,45);
        add(intro);


        JLabel passwardJ  = new JLabel("New Password :");
        passwardJ.setFont(f1);
        passwardJ.setBounds(50,150,200,20);
        add(passwardJ);
        password = new JTextField();
        password.setBounds(230,150,250,25);
        password.setFont(f3);
        add(password);


        JLabel contact  = new JLabel("New Contact :");
        contact.setFont(f1);
        contact.setBounds(70,200,200,20);
        add(contact);
        contactnum = new JTextField();
        contactnum.setBounds(230,200,250,25);
        contactnum.setFont(f3);
        add(contactnum);


        JLabel addJ  = new JLabel("New Address :");
        addJ.setFont(f1);
        addJ.setBounds(60,250,200,20);
        add(addJ);
        address = new JTextField();
        address.setBounds(230,250,600,25);
        address.setFont(f3);
        add(address);




        JLabel marideJ  = new JLabel("Marital Status :");
        marideJ.setFont(f1);
        marideJ.setBounds(50,300,180,20);
        add(marideJ);
        marride = new JRadioButton("Marride");
        marride.setBounds(230,300,140,25);
        marride.setFont(f1);
        marride.setBackground(Color.white);
        add(marride);
        unmarride = new JRadioButton("Unmarride");
        unmarride.setBounds(400,300,180,25);
        unmarride.setFont(f1);
        unmarride.setBackground(Color.white);
        add(unmarride);
        bg1 = new ButtonGroup();
        bg1.add(marride);
        bg1.add(unmarride);

        done = new JButton("Done");
        done.setFont(f1);
        done.setBounds(400,400,100,40);
        done.setBackground(Color.darkGray);
        done.setForeground(Color.white);
        done.addActionListener(this);
        add(done);


        setVisible(true);
        setBounds(450,100,900,600);
        setTitle("Doctor Update Profile");
        getContentPane().setBackground(Color.white);



    }



    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource() == done){

            String newpass =password.getText() , newcontact =contactnum.getText() , newadress =address.getText();
            String newmaritalstatus = "";
            if( marride.isSelected()) newmaritalstatus = "Marride";
            else if (unmarride.isSelected()) {
                newmaritalstatus = "Unmarride";
            }

            try{
                Conn c = new Conn();

                if(newpass.isEmpty()){}
                else {
                    String query = "UPDATE patient_list SET password = '"+newpass+"' WHERE patientID = '"+ID+"';";
                    c.s.executeUpdate(query);

                    String query2 = "UPDATE logindetails SET password = '"+newpass+"' WHERE ID = '"+ID+"';";
                    c.s.executeUpdate(query2);
                }

                if(newcontact.isEmpty()){}
                else{
                    String query = "UPDATE patient_list SET contact_number = '"+newcontact+"' WHERE patientID = '"+ID+"';";
                    c.s.executeUpdate(query);

                }

                if(newmaritalstatus.isEmpty()){}
                else{
                    String query = "UPDATE patient_list SET marital_status = '"+newmaritalstatus+"' WHERE patientID = '"+ID+"';";
                    c.s.executeUpdate(query);

                }

                if(newadress.isEmpty()){}
                else{
                    String query = "UPDATE patient_list SET address = '"+newadress+"' WHERE patientID = '"+ID+"';";
                    c.s.executeUpdate(query);

                }


                JOptionPane.showMessageDialog(null, "Profile Updated Successfully");

            } catch (Exception ex) {
                throw new RuntimeException(ex);
            }




        }

    }
}
