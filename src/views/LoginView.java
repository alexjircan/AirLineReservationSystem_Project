package views;

import javax.swing.*;
import javax.swing.plaf.FontUIResource;
import javax.swing.text.StyleContext;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Locale;

public class LoginView extends JFrame {
    private JTextField textField1;
    private JTextField textField2;
    private JButton creeazaContButton;
    private JButton loginButton;
    private JPanel frontPanel;
    private JPanel titlePanel;
    private JPanel middlePanel;
    private JPanel loginPanel;
    private JPanel creareContPanel;
    private JPasswordField passwordField1;

    public LoginView() {
        this.setBounds(100,100, 500, 500);
        this.setContentPane(this.frontPanel);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //this.pack();
        this.setVisible(true);
    }

    public JButton getLoginButton() {
        return loginButton;
    }

    public JButton getCreeazaContButton() {
        return creeazaContButton;
    }

    public String getTextField1() {
        return textField1.getText();
    }

    public String getPasswordField1() { return String.valueOf(passwordField1.getPassword()); }

    public void showMessage (String message){
        JOptionPane.showMessageDialog(this, message);
        refresh();
    }

    public void refresh(){
        textField1.setText(null);
        textField2.setText(null);
    }
}
