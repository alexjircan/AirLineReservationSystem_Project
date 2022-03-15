package views;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextPane;
import java.awt.Font;
import javax.swing.JButton;

public class UserView extends JFrame{

    private JButton CreareRezButton;
    private JButton StergeRezButton;
    private JButton VeziRezButton;
    private JButton logoutButton;

    public UserView() {
        this.setBounds(100, 100, 991, 596);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.getContentPane().setLayout(null);

        JLabel lblNewLabel = new JLabel("User");
        lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 32));
        lblNewLabel.setBounds(442, 26, 81, 46);
        this.getContentPane().add(lblNewLabel);

        CreareRezButton = new JButton("Creare Rezervare");
        CreareRezButton.setFont(new Font("Tahoma", Font.PLAIN, 22));
        CreareRezButton.setBounds(370, 134, 222, 46);
        this.getContentPane().add(CreareRezButton);

        VeziRezButton = new JButton("Vezi Rezervari");
        VeziRezButton.setFont(new Font("Tahoma", Font.PLAIN, 22));
        VeziRezButton.setBounds(370, 243, 222, 46);
        this.getContentPane().add(VeziRezButton);

        StergeRezButton = new JButton("Sterge Rezervare");
        StergeRezButton.setFont(new Font("Tahoma", Font.PLAIN, 22));
        StergeRezButton.setBounds(370, 346, 222, 46);
        this.getContentPane().add(StergeRezButton);

        logoutButton = new JButton("Logout");
        logoutButton.setFont(new Font("Tahoma", Font.PLAIN, 22));
        logoutButton.setBounds(370, 446, 222, 46);
        this.getContentPane().add(logoutButton);

        this.setVisible(true);
    }

    public JButton getCreareRezButton() {
        return CreareRezButton;
    }

    public JButton getStergeRezButton() {
        return StergeRezButton;
    }

    public JButton getVeziRezButton() {
        return VeziRezButton;
    }

    public JButton getLogoutButton() {
        return logoutButton;
    }
}
