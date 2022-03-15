package views;

import javax.swing.*;
import java.awt.*;

public class SZborView extends JFrame {
    private JButton stergeZButton;
    private JButton inapoiZButton;
    private JComboBox comboBox;

    public SZborView(){
        this.setBounds(100, 100, 946, 499);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.getContentPane().setLayout(null);

        comboBox = new JComboBox();
        comboBox.setBounds(350, 199, 517, 42);
        comboBox.setFont(new Font("Tahoma", Font.PLAIN, 22));
        this.getContentPane().add(comboBox);

        JLabel lblNewLabel = new JLabel("Sterge Zboruri");
        lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 32));
        lblNewLabel.setBounds(339, 44, 259, 48);
        this.getContentPane().add(lblNewLabel);

        JLabel lblNewLabel_1 = new JLabel("Alege zborul :");
        lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 22));
        lblNewLabel_1.setBounds(75, 187, 201, 56);
        this.getContentPane().add(lblNewLabel_1);

        stergeZButton = new JButton("Sterge zborul");
        stergeZButton.setFont(new Font("Tahoma", Font.PLAIN, 22));
        stergeZButton.setBounds(152, 354, 246, 42);
        this.getContentPane().add(stergeZButton);

        inapoiZButton = new JButton("Inapoi");
        inapoiZButton.setFont(new Font("Tahoma", Font.PLAIN, 22));
        inapoiZButton.setBounds(552, 354, 246, 42);
        this.getContentPane().add(inapoiZButton);

        this.setVisible(true);
    }

    public JButton getInapoiZButton() {
        return inapoiZButton;
    }

    public JButton getStergeZButton() {
        return stergeZButton;
    }

    public JComboBox getComboBox() {
        return comboBox;
    }
}
