package views;

import javax.swing.*;
import java.awt.*;

public class AdminView extends JFrame {
    private JButton creareZborButton;
    private JButton stergereZborButton;
    private JButton vizualizareZborButton;
    private JButton logoutButton;

    public AdminView(){
        this.setBounds(100, 100, 991, 600);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.getContentPane().setLayout(null);

        JLabel lblNewLabel = new JLabel("Admin");
        lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 32));
        lblNewLabel.setBounds(442, 26, 90, 46);
        this.getContentPane().add(lblNewLabel);

        creareZborButton = new JButton("Creare Zbor");
        creareZborButton.setFont(new Font("Tahoma", Font.PLAIN, 22));
        creareZborButton.setBounds(370, 134, 222, 46);
        this.getContentPane().add(creareZborButton);

        stergereZborButton = new JButton("Stergere Zbor");
        stergereZborButton.setFont(new Font("Tahoma", Font.PLAIN, 22));
        stergereZborButton.setBounds(370, 243, 222, 46);
        this.getContentPane().add(stergereZborButton);

        vizualizareZborButton = new JButton("Vizualizare Zboruri");
        vizualizareZborButton.setFont(new Font("Tahoma", Font.PLAIN, 22));
        vizualizareZborButton.setBounds(370, 346, 222, 46);
        this.getContentPane().add(vizualizareZborButton);

        logoutButton = new JButton("Logout");
        logoutButton.setFont(new Font("Tahoma", Font.PLAIN, 22));
        logoutButton.setBounds(370, 446, 222, 46);
        this.getContentPane().add(logoutButton);

        this.setVisible(true);
    }

    public JButton getCreareZborButton() {
        return creareZborButton;
    }

    public JButton getStergereZborButton() {
        return stergereZborButton;
    }

    public JButton getVizualizareZborButton() {
        return vizualizareZborButton;
    }

    public JButton getLogoutButton() {
        return logoutButton;
    }
}
