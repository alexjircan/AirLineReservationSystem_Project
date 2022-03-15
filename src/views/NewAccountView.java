package views;

import javax.swing.*;
import java.awt.Font;
import java.io.InputStream;

public class NewAccountView extends JFrame {

    private JFrame frame;
    private JTextField lastNameField;
    private JTextField firstNameField;
    private JTextField bDay;
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JPasswordField passwordRField;
    private JTextField bYear;
    private JTextField bMonth;
    private JTextField hDay;
    private JTextField hMonth;
    private JTextField hYear;
    private JButton SubmitButton;
    private JCheckBox CheckBox1;

    public NewAccountView() {
        this.setBounds(100, 100, 970, 606);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.getContentPane().setLayout(null);

        JLabel NewAccountLabel = new JLabel("Creare Cont");
        NewAccountLabel.setHorizontalAlignment(SwingConstants.CENTER);
        NewAccountLabel.setFont(new Font("Tahoma", Font.PLAIN, 34));
        NewAccountLabel.setBounds(377, 10, 237, 70);
        this.getContentPane().add(NewAccountLabel);

        JLabel newLastNameLabel = new JLabel("Nume : ");
        newLastNameLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        newLastNameLabel.setVerticalAlignment(SwingConstants.TOP);
        newLastNameLabel.setFont(new Font("Tahoma", Font.PLAIN, 26));
        newLastNameLabel.setBounds(288, 110, 180, 28);
        this.getContentPane().add(newLastNameLabel);

        JLabel newFirstNameLabel_1 = new JLabel("Prenume : ");
        newFirstNameLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
        newFirstNameLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 26));
        newFirstNameLabel_1.setBounds(288, 158, 180, 28);
        this.getContentPane().add(newFirstNameLabel_1);

        JLabel newBirthDateLabel = new JLabel("Data nasterii : ");
        newBirthDateLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        newBirthDateLabel.setFont(new Font("Tahoma", Font.PLAIN, 26));
        newBirthDateLabel.setBounds(288, 204, 180, 28);
        this.getContentPane().add(newBirthDateLabel);

        lastNameField = new JTextField();
        lastNameField.setFont(new Font("Tahoma", Font.PLAIN, 26));
        lastNameField.setBounds(519, 110, 180, 28);
        this.getContentPane().add(lastNameField);
        lastNameField.setColumns(10);

        firstNameField = new JTextField();
        firstNameField.setFont(new Font("Tahoma", Font.PLAIN, 26));
        firstNameField.setColumns(10);
        firstNameField.setBounds(519, 158, 180, 28);
        this.getContentPane().add(firstNameField);

        bDay = new JTextField();
        bDay.setFont(new Font("Tahoma", Font.PLAIN, 22));
        bDay.setColumns(10);
        bDay.setBounds(519, 204, 36, 28);
        this.getContentPane().add(bDay);

        JLabel newUsername = new JLabel("Username : ");
        newUsername.setHorizontalAlignment(SwingConstants.RIGHT);
        newUsername.setFont(new Font("Tahoma", Font.PLAIN, 26));
        newUsername.setBounds(288, 256, 180, 28);
        this.getContentPane().add(newUsername);

        JLabel newPassword = new JLabel("Parola : ");
        newPassword.setHorizontalAlignment(SwingConstants.RIGHT);
        newPassword.setFont(new Font("Tahoma", Font.PLAIN, 26));
        newPassword.setBounds(288, 306, 180, 28);
        this.getContentPane().add(newPassword);

        usernameField = new JTextField();
        usernameField.setFont(new Font("Tahoma", Font.PLAIN, 26));
        usernameField.setColumns(10);
        usernameField.setBounds(519, 256, 180, 28);
        this.getContentPane().add(usernameField);

        JLabel repeatPassword = new JLabel("Repeta parola : ");
        repeatPassword.setHorizontalAlignment(SwingConstants.RIGHT);
        repeatPassword.setFont(new Font("Tahoma", Font.PLAIN, 26));
        repeatPassword.setBounds(271, 352, 197, 28);
        this.getContentPane().add(repeatPassword);

        passwordField = new JPasswordField();
        passwordField.setFont(new Font("Tahoma", Font.PLAIN, 26));
        passwordField.setBounds(519, 306, 180, 28);
        this.getContentPane().add(passwordField);

        passwordRField = new JPasswordField();
        passwordRField.setFont(new Font("Tahoma", Font.PLAIN, 26));
        passwordRField.setBounds(519, 350, 180, 30);
        this.getContentPane().add(passwordRField);

        CheckBox1 = new JCheckBox("  Pilot");
        CheckBox1.setFont(new Font("Tahoma", Font.PLAIN, 26));
        CheckBox1.setBounds(459, 399, 180, 28);
        this.getContentPane().add(CheckBox1);

        JLabel hireDate = new JLabel("Data angajarii : ");
        hireDate.setHorizontalAlignment(SwingConstants.RIGHT);
        hireDate.setFont(new Font("Tahoma", Font.PLAIN, 26));
        hireDate.setBounds(271, 443, 197, 28);
        this.getContentPane().add(hireDate);

        SubmitButton = new JButton("Submit");
        SubmitButton.setFont(new Font("Tahoma", Font.PLAIN, 26));
        SubmitButton.setBounds(409, 521, 147, 38);
        this.getContentPane().add(SubmitButton);

        bYear = new JTextField();
        bYear.setFont(new Font("Tahoma", Font.PLAIN, 22));
        bYear.setColumns(10);
        bYear.setBounds(632, 204, 69, 28);
        this.getContentPane().add(bYear);

        bMonth = new JTextField();
        bMonth.setFont(new Font("Tahoma", Font.PLAIN, 22));
        bMonth.setColumns(10);
        bMonth.setBounds(572, 204, 36, 28);
        this.getContentPane().add(bMonth);

        JLabel slash1 = new JLabel("/");
        slash1.setFont(new Font("Tahoma", Font.PLAIN, 26));
        slash1.setBounds(558, 205, 45, 27);
        this.getContentPane().add(slash1);

        JLabel slash2 = new JLabel("/");
        slash2.setFont(new Font("Tahoma", Font.PLAIN, 26));
        slash2.setBounds(615, 204, 45, 27);
        this.getContentPane().add(slash2);

        hDay = new JTextField();
        hDay.setFont(new Font("Tahoma", Font.PLAIN, 22));
        hDay.setColumns(10);
        hDay.setBounds(517, 443, 36, 28);
        this.getContentPane().add(hDay);

        JLabel slash4 = new JLabel("/");
        slash4.setFont(new Font("Tahoma", Font.PLAIN, 26));
        slash4.setBounds(556, 444, 45, 27);
        this.getContentPane().add(slash4);

        hMonth = new JTextField();
        hMonth.setFont(new Font("Tahoma", Font.PLAIN, 22));
        hMonth.setColumns(10);
        hMonth.setBounds(570, 443, 36, 28);
        this.getContentPane().add(hMonth);

        JLabel slash5 = new JLabel("/");
        slash5.setFont(new Font("Tahoma", Font.PLAIN, 26));
        slash5.setBounds(613, 443, 45, 27);
        this.getContentPane().add(slash5);

        hYear = new JTextField();
        hYear.setFont(new Font("Tahoma", Font.PLAIN, 22));
        hYear.setColumns(10);
        hYear.setBounds(630, 443, 69, 28);
        this.getContentPane().add(hYear);

        this.setVisible(true);
    }
    public void showMessage (String message){
        JOptionPane.showMessageDialog(this, message);
        refresh();
    }
    public void refresh(){

    }

    public JButton getSubmitButton() {
        return SubmitButton;
    }

    public String getLastNameField() {
        return lastNameField.getText();
    }

    public String getFirstNameField() {
        return firstNameField.getText();
    }

    public String getUsernameField() {
        return usernameField.getText();
    }

    public String getPasswordField() {
        return String.valueOf(passwordField.getPassword());
    }

    public String getPasswordRField() {
        return String.valueOf(passwordRField.getPassword());
    }

    public String getbDay() {
        return String.valueOf(bDay.getText());
    }

    public String getbYear() {
        return String.valueOf(bYear.getText());
    }

    public String getbMonth() {
        return String.valueOf(bMonth.getText());
    }

    public String gethDay() {
        return String.valueOf(hDay.getText());
    }

    public String gethYear() {
        return String.valueOf(hYear.getText());
    }

    public String gethMonth() {
        return String.valueOf(hMonth.getText());
    }

    public JCheckBox getCheckBox1() {
        return CheckBox1;
    }

}
