package controllers;

import models.User;
import mysql.DatabaseConnection;
import views.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;

public class UserController {
    private UserView userView;

    public UserController(UserView userView, LoginView loginView, User user, DatabaseConnection databaseConnection) {
        this.userView = userView;

        this.userView.getCreareRezButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                userView.setVisible(false);
                CRezervareView cRezervareView = new CRezervareView();
                CRezervareController cRezervareController = new CRezervareController(cRezervareView, user, databaseConnection, userView);
            }
        });

        this.userView.getVeziRezButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                userView.setVisible(false);
                VRezervareView vRezervareView = new VRezervareView();
                VRezervareController vRezervareController = new VRezervareController(vRezervareView, user, userView, databaseConnection);
            }
        });

        this.userView.getStergeRezButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SRezervareView sRezervareView = new SRezervareView();
                SRezervareController sRezervareController = new SRezervareController(sRezervareView, user, userView, databaseConnection);
                userView.setVisible(false);
            }
        });

        this.userView.getLogoutButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                userView.setVisible(false);
                loginView.setVisible(true);
            }
        });
    }
}
