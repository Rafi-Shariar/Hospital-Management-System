package Dashboards;

import javax.swing.*;
import java.awt.*;

public class DashboardFrame extends JFrame {

    JLabel intro;

    public DashboardFrame(){
        setLayout(null);

        JLabel Name = new JLabel("DAFFODIL WELLNESS HOSPITAL");
        Name.setBounds(330,10,700,40);
        Name.setFont(new Font("Eras Bold ITC" , Font.BOLD,30));
        Name.setForeground(Color.blue);
        add(Name);

        JLabel slogan = new JLabel("Caring Beyond Boundaries, Healing with Heart.");
        slogan.setBounds(370,45,700,50);
        slogan.setFont(new Font("Eras Demi ITC" , Font.BOLD,18));
        slogan.setForeground(Color.gray);
        add(slogan);

        Font f1 = new Font("Dubai Medium" , Font.BOLD,30);

        intro = new JLabel("Wellcome to ****");
        intro.setBounds(370,120,500,40);
        intro.setFont(f1);
        add(intro);



        setVisible(true);
        setTitle("Title");
        setBounds(400,100,1200,800);
        setBackground(Color.white);


    }

    public static void main(String[] args) {
        new DashboardFrame();
    }

}
