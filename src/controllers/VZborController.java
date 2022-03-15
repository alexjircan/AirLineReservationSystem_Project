package controllers;

import models.User;
import mysql.DatabaseConnection;
import views.AdminView;
import views.UserView;
import views.VRezervareView;
import views.VZborView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class VZborController {
    private VZborView vZborView;
    public VZborController(VZborView vZborView, AdminView adminView, DatabaseConnection databaseConnection){
        this.vZborView = vZborView;

        try{
            Connection connection = databaseConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "SELECT data_plecare, aeroport_plecare, aeroport_sosire"+
                            " FROM zboruri"
            );

            ResultSet result = preparedStatement.executeQuery();

            while (result.next()) {
                vZborView.getDtm().addRow(new Object[]{result.getString(1),
                        result.getString(2),
                        result.getString(3)
                });
            }

        }catch (Exception ex){
            ex.printStackTrace();
        }

        this.vZborView.getInapoiButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                vZborView.setVisible(false);
                adminView.setVisible(true);
            }
        });
    }
}
