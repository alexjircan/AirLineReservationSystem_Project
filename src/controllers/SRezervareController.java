package controllers;

import models.User;
import models.Zbor;
import mysql.DatabaseConnection;
import views.SRezervareView;
import views.UserView;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.xml.crypto.Data;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class SRezervareController {
    private SRezervareView sRezervareView;
    public SRezervareController(SRezervareView sRezervareView, User user, UserView userView, DatabaseConnection databaseConnection){
        this.sRezervareView = sRezervareView;
        DefaultComboBoxModel model = (DefaultComboBoxModel) sRezervareView.getComboBox().getModel();
        ArrayList<Zbor> list = getRezervariList(user, databaseConnection);
        Object[] row = new Object[8];

        for(int i = 0; i < list.size();i++){
            row[0] = list.get(i).getDataPlecare();
            row[1] = list.get(i).getAeroportP();
            row[2] = list.get(i).getAeroportS();
            model.addElement(String.valueOf(row[0]) + " " + String.valueOf(row[1])+ " -> " + String.valueOf(row[2]));
        }
        sRezervareView.getComboBox().setModel(model);

        this.sRezervareView.getStergeRButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    Zbor zbor = list.get(sRezervareView.getComboBox().getSelectedIndex());

                    Connection connection = databaseConnection.getConnection();
                    PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM rezervari WHERE id_zbor = ? AND id_user = ?");
                    preparedStatement.setInt(1,zbor.getIdZbor());
                    preparedStatement.setInt(2,user.getIdUser());

                    preparedStatement.executeUpdate();

                    sRezervareView.showMessage("Rezervare stearsa");
                    sRezervareView.setVisible(false);
                    userView.setVisible(true);
                }catch(Exception ex){
                    ex.printStackTrace();
                }
            }
        });

        this.sRezervareView.getInapoiRButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sRezervareView.setVisible(false);
                userView.setVisible(true);
            }
        });
    }
    public ArrayList<Zbor> getRezervariList(User user, DatabaseConnection databaseConnection){
        ArrayList<Zbor> rezervariList = new ArrayList<>();
        try{
            Connection connection = databaseConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT data_plecare, aeroport_plecare, aeroport_sosire, id_zbor FROM zboruri WHERE id_zbor IN (SELECT id_zbor FROM rezervari WHERE id_user = ?)");
            preparedStatement.setInt(1, user.getIdUser());

            ResultSet result = preparedStatement.executeQuery();

            Zbor zbor;
            while(result.next()){
                zbor = new Zbor(result.getInt(4),0,0,0,0, result.getString(1), result.getString(2), result.getString(3));
                rezervariList.add(zbor);
            }
        } catch (Exception ex){
            ex.printStackTrace();
        }
        return rezervariList;
    };
}
