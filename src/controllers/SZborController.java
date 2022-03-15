package controllers;

import models.User;
import models.Zbor;
import mysql.DatabaseConnection;
import views.AdminView;
import views.SZborView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class SZborController {
    SZborView sZborView;

    public SZborController(SZborView sZborView, AdminView adminView, DatabaseConnection databaseConnection){
        this.sZborView = sZborView;

        DefaultComboBoxModel model = (DefaultComboBoxModel) sZborView.getComboBox().getModel();
        ArrayList<Zbor> list = getZboruriList(databaseConnection);
        Object[] row = new Object[8];

        for(int i = 0; i < list.size();i++){
            row[0] = list.get(i).getDataPlecare();
            row[1] = list.get(i).getAeroportP();
            row[2] = list.get(i).getAeroportS();
            model.addElement(String.valueOf(row[0]) + " " + String.valueOf(row[1])+ " -> " + String.valueOf(row[2]));
        }
        sZborView.getComboBox().setModel(model);

        this.sZborView.getStergeZButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    Zbor zbor = list.get(sZborView.getComboBox().getSelectedIndex());

                    Connection connection = databaseConnection.getConnection();
                    PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM zboruri WHERE id_zbor = ?");
                    preparedStatement.setInt(1,zbor.getIdZbor());

                    preparedStatement.executeUpdate();

                    JOptionPane.showMessageDialog(sZborView, "Zbor sters!");
                    sZborView.setVisible(false);
                    adminView.setVisible(true);
                }catch(Exception ex){
                    ex.printStackTrace();
                }
            }
        });

        this.sZborView.getInapoiZButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sZborView.setVisible(false);
                adminView.setVisible(true);
            }
        });
    }

    public ArrayList<Zbor> getZboruriList(DatabaseConnection databaseConnection){
        ArrayList<Zbor> zboruriList = new ArrayList<>();
        try{
            Connection connection = databaseConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT data_plecare, aeroport_plecare, aeroport_sosire, id_zbor FROM zboruri");

            ResultSet result = preparedStatement.executeQuery();

            Zbor zbor;
            while(result.next()){
                zbor = new Zbor(result.getInt(4),0,0,0,0, result.getString(1), result.getString(2), result.getString(3));
                zboruriList.add(zbor);
            }
        } catch (Exception ex){
            ex.printStackTrace();
        }
        return zboruriList;
    };
}
