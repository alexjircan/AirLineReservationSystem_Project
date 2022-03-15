package views;

import javax.swing.*;
import java.awt.*;

public class CRezervareView extends JFrame {
    private JButton nextButton;
    private JButton backButton;
    private JComboBox comboBox;

    public CRezervareView(){
        this.setBounds(100, 100, 946, 499);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.getContentPane().setLayout(null);

        comboBox = new JComboBox();
        comboBox.setBounds(350, 199, 517, 42);
        comboBox.setFont(new Font("Tahoma", Font.PLAIN, 20));
        this.getContentPane().add(comboBox);

        JLabel lblNewLabel = new JLabel("Creare Rezervari");
        lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 32));
        lblNewLabel.setBounds(339, 44, 259, 48);
        this.getContentPane().add(lblNewLabel);

        JLabel lblNewLabel_1 = new JLabel("Alege zborul :");
        lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 22));
        lblNewLabel_1.setBounds(75, 187, 201, 56);
        this.getContentPane().add(lblNewLabel_1);

        nextButton = new JButton("Urmatorul Pas");
        nextButton.setFont(new Font("Tahoma", Font.PLAIN, 22));
        nextButton.setBounds(552, 354, 246, 42);
        this.getContentPane().add(nextButton);

        backButton = new JButton("Inapoi");
        backButton.setFont(new Font("Tahoma", Font.PLAIN, 22));
        backButton.setBounds(152, 354, 246, 42);
        this.getContentPane().add(backButton);

        this.setVisible(true);
    }

    public JButton getNextButton() {
        return nextButton;
    }

    public JButton getBackButton() {
        return backButton;
    }

    public JComboBox getComboBox() {
        return comboBox;
    }
}
