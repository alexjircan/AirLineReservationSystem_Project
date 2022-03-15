package controllers;

import models.User;
import mysql.DatabaseConnection;
import views.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class LoginController {
    private LoginView loginView;
    public LoginController(LoginView loginView, DatabaseConnection databaseConnection){
        this.loginView = loginView;

        this.loginView.getLoginButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String username = loginView.getTextField1();
                    String password = loginView.getPasswordField1();

                    Connection connection = databaseConnection.getConnection();
                    PreparedStatement preparedStatement = connection.prepareStatement("SELECT username, password, tipuser, id_user,nume,prenume,data_nasterii,data_angajare FROM users WHERE username = ?");
                    preparedStatement.setString(1, username);

                    ResultSet result = preparedStatement.executeQuery();
                    if(result.next()) {
                        User user = new User(result.getInt(4),result.getInt(3),result.getString(5),result.getString(6),result.getString(7),result.getString(1),result.getString(2),result.getString(8));
                        if(password.equals(result.getObject(2))){
                            if(result.getInt(3) == 2){
                                PilotView pilotView = new PilotView();
                                PilotController pilotController = new PilotController(pilotView, loginView, databaseConnection, user);
                            }
                            else if( result.getInt(3) == 3 ){
                                AdminView adminView = new AdminView();
                                AdminController adminController = new AdminController(adminView, loginView, databaseConnection);
                            }
                            else{
                                UserView userView = new UserView();
                                UserController userController = new UserController (userView, loginView, user, databaseConnection);
                            }
                            loginView.setVisible(false);
                        }
                        else {
                            loginView.showMessage("Parola incorecta!");
                        }
                    }
                    else{

                        loginView.showMessage("Bad input!");
                    }

                } catch (Exception ex) {
                    //ex.printStackTrace();
                    loginView.showMessage("Bad inputds!");

                }
            }
        });

        this.loginView.getCreeazaContButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                loginView.setVisible(false);
                NewAccountView newAccountView = new NewAccountView();
                NewAccountController newAccountController = new NewAccountController(newAccountView, loginView, databaseConnection);
            }
        });


    }
}
