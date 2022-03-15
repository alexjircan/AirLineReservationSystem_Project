package views;

import java.awt.EventQueue;

import javax.swing.*;
import java.awt.Font;

public class SRezervareView extends JFrame{

    private JButton StergeRButton;
    private JButton inapoiRButton;
    private JComboBox comboBox;

    public SRezervareView() {
        this.setBounds(100, 100, 946, 499);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.getContentPane().setLayout(null);

        comboBox = new JComboBox();
        comboBox.setBounds(350, 199, 517, 42);
        this.getContentPane().add(comboBox);

        JLabel lblNewLabel = new JLabel("Sterge Rezervari");
        lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 32));
        lblNewLabel.setBounds(339, 44, 259, 48);
        this.getContentPane().add(lblNewLabel);

        JLabel lblNewLabel_1 = new JLabel("Alege rezervarea :");
        lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 22));
        lblNewLabel_1.setBounds(75, 187, 201, 56);
        this.getContentPane().add(lblNewLabel_1);

        StergeRButton = new JButton("Sterge rezervarea");
        StergeRButton.setFont(new Font("Tahoma", Font.PLAIN, 22));
        StergeRButton.setBounds(152, 354, 246, 42);
        this.getContentPane().add(StergeRButton);

        inapoiRButton = new JButton("Inapoi");
        inapoiRButton.setFont(new Font("Tahoma", Font.PLAIN, 22));
        inapoiRButton.setBounds(552, 354, 246, 42);
        this.getContentPane().add(inapoiRButton);

        this.setVisible(true);
    }

    public JButton getInapoiRButton() {
        return inapoiRButton;
    }

    public JButton getStergeRButton() {
        return StergeRButton;
    }

    public JComboBox getComboBox() {
        return comboBox;
    }

    public void showMessage (String message){
        JOptionPane.showMessageDialog(this, message);
    }
}
