import javax.swing.*;
import java.awt.*;

public class Dashboard extends JFrame {

    JButton loginButton, singupButton;


    Dashboard(){
        setLayout(null);

        ImageIcon background = new ImageIcon(this.getClass().getResource("/Images/Background.jpg"));
        JLabel backgrdL = new JLabel(background);
        backgrdL.setBounds(0,0,1300,250);
        add(backgrdL);


         JLabel Name = new JLabel("DAFFODIL WELLNESS HOSPITAL");
         Name.setBounds(30,70,700,70);
         Name.setFont(new Font("Eras Bold ITC" , Font.BOLD,40));
         Name.setForeground(Color.blue);
         backgrdL.add(Name);

         JLabel slogan = new JLabel("Caring Beyond Boundaries, Healing with Heart.");
         slogan.setBounds(30,120,700,70);
         slogan.setFont(new Font("Eras Demi ITC" , Font.BOLD,25));
         slogan.setForeground(Color.gray);
         backgrdL.add(slogan);



        Font f1 = new Font("Dubai Medium" , Font.BOLD,17);

        loginButton = new JButton("Login");
        loginButton.setBounds(1050,300,150,40);
        loginButton.setFont(f1);
        loginButton.setBackground(Color.lightGray);
        loginButton.setForeground(Color.darkGray);
        add(loginButton);

        singupButton = new JButton("Register");
        singupButton.setBounds(1050,370,150,40);
        singupButton.setFont(f1);
        singupButton.setBackground(Color.lightGray);
        singupButton.setForeground(Color.darkGray);
        add(singupButton);


        JLabel searchL = new JLabel("Search Doctor ");
        searchL.setBounds(300,300,150,40);
        searchL.setFont(new Font("Dubai Medium" , Font.BOLD,20));
        add(searchL);

        JTextField searchTF = new JTextField();
        searchTF.setBounds(450,300,400,45);
        searchTF.setFont(new Font("Bahnschrift", Font.CENTER_BASELINE,20));
        add(searchTF);

        Font f2 = new Font("Copperplate Gothic Light" , Font.CENTER_BASELINE,13);

        JLabel address = new JLabel("Address : Daffodil Smart City (DSC), Birulia, Savar, Dhaka-1216 ");
        address.setBounds(445,640,700,40);
        address.setFont(f2);
        add(address);
        JLabel email = new JLabel("Mail : info@daffodilwhospital.org");
        email.setBounds(530,670,700,40);
        email.setFont(f2);
        add(email);
        JLabel Contact = new JLabel("Tel: +8802224441833");
        Contact.setBounds(570,700,700,40);
        Contact.setFont(f2);
        add(Contact);

        JLabel text_ourdoc = new JLabel("OUR DOCTORS");
        text_ourdoc.setFont(new Font("Eras Bold ITC" , Font.BOLD,30));
        text_ourdoc.setBounds(550,370,400,40);
        text_ourdoc.setForeground(Color.orange);
        add(text_ourdoc);


        ImageIcon i1 = new ImageIcon(this.getClass().getResource("/Images/Logo.png"));
        Image i2 = i1.getImage().getScaledInstance(150,150,Image.SCALE_SMOOTH);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel i4 = new JLabel(i3);
        i4.setBounds(250,450,150,150);
        add(i4);

        ImageIcon i5 = new ImageIcon(this.getClass().getResource("/Images/Logo.png"));
        Image i6 = i5.getImage().getScaledInstance(150,150,Image.SCALE_SMOOTH);
        ImageIcon i7 = new ImageIcon(i6);
        JLabel i8 = new JLabel(i7);
        i8.setBounds(450,450,150,150);
        add(i8);

        ImageIcon i9 = new ImageIcon(this.getClass().getResource("/Images/Logo.png"));
        Image i10 = i9.getImage().getScaledInstance(150,150,Image.SCALE_SMOOTH);
        ImageIcon i11 = new ImageIcon(i10);
        JLabel i12 = new JLabel(i11);
        i12.setBounds(650,450,150,150);
        add(i12);

        ImageIcon i13 = new ImageIcon(this.getClass().getResource("/Images/Logo.png"));
        Image i14 = i13.getImage().getScaledInstance(150,150,Image.SCALE_SMOOTH);
        ImageIcon i15 = new ImageIcon(i14);
        JLabel i16 = new JLabel(i15);
        i16.setBounds(850,450,150,150);
        add(i16);


        setVisible(true);
        setBounds(280,30,1300,800);
        setTitle("Daffodil wellness hospital");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setBackground(Color.white);

    }

    public static void main(String[] args) {
        new Dashboard();
    }
}
