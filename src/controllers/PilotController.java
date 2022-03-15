package controllers;

import models.User;
import models.Zbor;
import mysql.DatabaseConnection;
import views.LoginView;
import views.PilotView;

import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class PilotController {
    private PilotView pilotView;

    public PilotController(PilotView pilotView, LoginView loginView, DatabaseConnection databaseConnection, User user){
        this.pilotView = pilotView;
        try{
            Connection connection = databaseConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "SELECT data_plecare, aeroport_plecare, aeroport_sosire "+
                            "FROM zboruri "+
                            "WHERE id_pilot="+
                            user.getIdUser()
            );

            ResultSet result = preparedStatement.executeQuery();

            while (result.next()) {
                pilotView.getDtm().addRow(new Object[]{result.getString(1),
                        result.getString(2),
                        result.getString(3)
                });
            }

        }catch (Exception ex){
            ex.printStackTrace();
        }

        this.pilotView.getLogoutButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pilotView.setVisible(false);
                loginView.setVisible(true);
            }
        });
    }
}
