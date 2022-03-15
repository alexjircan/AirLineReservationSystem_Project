package controllers;

import mysql.DatabaseConnection;
import views.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdminController {
    private AdminView adminView;
    public AdminController(AdminView adminView, LoginView loginView, DatabaseConnection databaseConnection) {
        this.adminView = adminView;

        this.adminView.getCreareZborButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                adminView.setVisible(false);
                CZborView cZborView = new CZborView();
                CZborController cZborController = new CZborController(cZborView, adminView, databaseConnection);
            }
        });

        this.adminView.getStergereZborButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                adminView.setVisible(false);
                SZborView sZborView = new SZborView();
                SZborController sZborController = new SZborController(sZborView, adminView, databaseConnection);
            }
        });

        this.adminView.getVizualizareZborButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                adminView.setVisible(false);
                VZborView vZborView = new VZborView();
                VZborController vZborController = new VZborController(vZborView, adminView, databaseConnection);
            }
        });

        this.adminView.getLogoutButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                adminView.setVisible(false);
                loginView.setVisible(true);
            }
        });
    }
}
