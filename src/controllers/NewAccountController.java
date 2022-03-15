package controllers;

import mysql.DatabaseConnection;
import views.LoginView;
import views.NewAccountView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.Array;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class NewAccountController {
    private NewAccountView newAccountView;
    public NewAccountController(NewAccountView newAccountView, LoginView loginView,  DatabaseConnection databaseConnection){
        this.newAccountView = newAccountView;
        final int[] pilot = {1};
        this.newAccountView.getSubmitButton().addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String nume = newAccountView.getLastNameField();
                    String prenume = newAccountView.getFirstNameField();
                    String username = newAccountView.getUsernameField();
                    String password = newAccountView.getPasswordField();
                    String rPassword = newAccountView.getPasswordRField();
                    String bDay = newAccountView.getbDay();
                    String bMonth = newAccountView.getbMonth();
                    String bYear = newAccountView.getbYear();
                    String hDay = newAccountView.gethDay();
                    String hMonth = newAccountView.gethMonth();
                    String hYear = newAccountView.gethYear();

                    Connection connection = databaseConnection.getConnection();
                    PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO users (nume, prenume, data_nasterii, username, password, tipuser, data_angajare) VALUES (?,?,?,?,?,?,?)");

                    if(password.equals(rPassword)){
                        preparedStatement.setString(1, nume);
                        preparedStatement.setString(2, prenume);
                        preparedStatement.setString(3, bYear+'-'+bMonth+'-'+bDay);
                        preparedStatement.setString(4, username);
                        preparedStatement.setString(5, password);
                        preparedStatement.setInt(6, pilot[0]);
                        if(pilot[0] == 2){
                            preparedStatement.setString(7, hYear+'-'+hMonth+'-'+hDay);
                        }
                        else {
                            preparedStatement.setString(7, null);
                        }

                        preparedStatement.executeUpdate();
                        connection.close();
                        newAccountView.showMessage("Cont nou creat");
                        loginView.setVisible(true);
                        newAccountView.dispose();
                    }
                    else{
                        newAccountView.showMessage("Password incorect");
                    }
                } catch (Exception ex) {
                    newAccountView.showMessage("Bad input!");
                    ex.printStackTrace();
                }
            }
        });

        this.newAccountView.getCheckBox1().addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == 1) {
                    pilot[0] = 2;
                }
                else{
                    pilot[0] = 1;
                }
            }
        });
    }
}
