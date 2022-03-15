package controllers;

import models.User;
import models.Zbor;
import mysql.DatabaseConnection;
import views.UserView;
import views.VRezervareView;

import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class VRezervareController {
    private VRezervareView vRezervareView;
    public VRezervareController(VRezervareView vRezervareView, User user, UserView userView, DatabaseConnection databaseConnection){
        this.vRezervareView = vRezervareView;

        try{
            Connection connection = databaseConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "SELECT data_plecare, aeroport_plecare, aeroport_sosire, nr_loc "+
                    "FROM rezervari a JOIN zboruri b ON( a.id_zbor = b.id_zbor  )"+
                    "WHERE id_user="+
                    user.getIdUser()
            );

            ResultSet result = preparedStatement.executeQuery();

            while (result.next()) {
                vRezervareView.getDtm().addRow(new Object[]{result.getString(1),
                        result.getString(2),
                        result.getString(3),
                        result.getString(4)
                });
            }

        }catch (Exception ex){
            ex.printStackTrace();
        }

        this.vRezervareView.getInapoiButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                vRezervareView.setVisible(false);
                userView.setVisible(true);
            }
        });
    }
}
