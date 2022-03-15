package views;

import javax.swing.*;
import java.awt.*;

public class CZborView extends JFrame {
    private JComboBox pilotComboBox;
    private JTextField pretField;
    private JTextField bDay;
    private JTextField aeroportPlecare;
    private JTextField aeroportSosire;
    private JTextField nrlocuriField;
    private JButton SubmitButton;
    private JTextField bYear;
    private JTextField bMonth;
    private JButton backButton;

    public CZborView(){
        this.setBounds(100, 100, 970, 606);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.getContentPane().setLayout(null);

        JLabel NewAccountLabel = new JLabel("Creare Zbor");
        NewAccountLabel.setHorizontalAlignment(SwingConstants.CENTER);
        NewAccountLabel.setFont(new Font("Tahoma", Font.PLAIN, 34));
        NewAccountLabel.setBounds(377, 10, 237, 70);
        this.getContentPane().add(NewAccountLabel);

        JLabel newLastNameLabel = new JLabel("Pilot : ");
        newLastNameLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        newLastNameLabel.setVerticalAlignment(SwingConstants.TOP);
        newLastNameLabel.setFont(new Font("Tahoma", Font.PLAIN, 26));
        newLastNameLabel.setBounds(288, 110, 180, 28);
        this.getContentPane().add(newLastNameLabel);

        pilotComboBox = new JComboBox();
        pilotComboBox.setBounds(519, 110, 180, 28);
        this.getContentPane().add(pilotComboBox);

        JLabel newFirstNameLabel_1 = new JLabel("Data plecare : ");
        newFirstNameLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
        newFirstNameLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 26));
        newFirstNameLabel_1.setBounds(288, 158, 180, 28);
        this.getContentPane().add(newFirstNameLabel_1);

        JLabel slash1 = new JLabel("/");
        slash1.setFont(new Font("Tahoma", Font.PLAIN, 26));
        slash1.setBounds(558, 158, 45, 27);
        this.getContentPane().add(slash1);

        JLabel slash2 = new JLabel("/");
        slash2.setFont(new Font("Tahoma", Font.PLAIN, 26));
        slash2.setBounds(615, 158, 45, 27);
        this.getContentPane().add(slash2);

        bDay = new JTextField();
        bDay.setFont(new Font("Tahoma", Font.PLAIN, 22));
        bDay.setColumns(10);
        bDay.setBounds(519, 158, 36, 28); // 204
        this.getContentPane().add(bDay);

        bMonth = new JTextField();
        bMonth.setFont(new Font("Tahoma", Font.PLAIN, 22));
        bMonth.setColumns(10);
        bMonth.setBounds(572, 158, 36, 28);
        this.getContentPane().add(bMonth);

        bYear = new JTextField();
        bYear.setFont(new Font("Tahoma", Font.PLAIN, 22));
        bYear.setColumns(10);
        bYear.setBounds(632, 158, 69, 28);
        this.getContentPane().add(bYear);

        JLabel newBirthDateLabel = new JLabel("Pret bilet : ");
        newBirthDateLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        newBirthDateLabel.setFont(new Font("Tahoma", Font.PLAIN, 26));
        newBirthDateLabel.setBounds(288, 204, 180, 28);
        this.getContentPane().add(newBirthDateLabel);

        pretField = new JTextField();
        pretField.setFont(new Font("Tahoma", Font.PLAIN, 26));
        pretField.setColumns(10);
        pretField.setBounds(519, 204, 180, 28);
        this.getContentPane().add(pretField);

        JLabel newUsername = new JLabel("Aeroport Plecare : ");
        newUsername.setHorizontalAlignment(SwingConstants.RIGHT);
        newUsername.setFont(new Font("Tahoma", Font.PLAIN, 26));
        newUsername.setBounds(248, 256, 220, 28);
        this.getContentPane().add(newUsername);

        JLabel newPassword = new JLabel("Aeroport Sosire : ");
        newPassword.setHorizontalAlignment(SwingConstants.RIGHT);
        newPassword.setFont(new Font("Tahoma", Font.PLAIN, 26));
        newPassword.setBounds(248, 306, 220, 28);
        this.getContentPane().add(newPassword);

        aeroportPlecare = new JTextField();
        aeroportPlecare.setFont(new Font("Tahoma", Font.PLAIN, 26));
        aeroportPlecare.setColumns(10);
        aeroportPlecare.setBounds(519, 256, 180, 28);
        this.getContentPane().add(aeroportPlecare);

        JLabel repeatPassword = new JLabel("Numar locuri : ");
        repeatPassword.setHorizontalAlignment(SwingConstants.RIGHT);
        repeatPassword.setFont(new Font("Tahoma", Font.PLAIN, 26));
        repeatPassword.setBounds(271, 352, 197, 28);
        this.getContentPane().add(repeatPassword);

        aeroportSosire = new JTextField();
        aeroportSosire.setFont(new Font("Tahoma", Font.PLAIN, 26));
        aeroportSosire.setBounds(519, 306, 180, 28);
        this.getContentPane().add(aeroportSosire);

        nrlocuriField = new JTextField();
        nrlocuriField.setFont(new Font("Tahoma", Font.PLAIN, 26));
        nrlocuriField.setBounds(519, 350, 180, 30);
        this.getContentPane().add(nrlocuriField);

        SubmitButton = new JButton("Submit");
        SubmitButton.setFont(new Font("Tahoma", Font.PLAIN, 26));
        SubmitButton.setBounds(609, 450, 147, 38);
        this.getContentPane().add(SubmitButton);

        backButton = new JButton("Inapoi");
        backButton.setFont(new Font("Tahoma", Font.PLAIN, 26));
        backButton.setBounds(209, 450, 147, 38);
        this.getContentPane().add(backButton);

        this.setVisible(true);
    }

    public JComboBox getPilotComboBox() {
        return pilotComboBox;
    }

    public String getPretField() {
        return pretField.getText();
    }

    public String getAeroportPlecare() {
        return aeroportPlecare.getText();
    }

    public String getAeroportSosire() {
        return aeroportSosire.getText();
    }

    public String getbDay() {
        return bDay.getText();
    }

    public String getbMonth() {
        return bMonth.getText();
    }

    public String getbYear() {
        return bYear.getText();
    }

    public String getNrlocuriField() {
        return nrlocuriField.getText();
    }

    public JButton getSubmitButton() {
        return SubmitButton;
    }

    public JButton getBackButton() {
        return backButton;
    }
}
