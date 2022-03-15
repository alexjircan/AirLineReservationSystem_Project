package controllers;

import models.User;
import models.Zbor;
import mysql.DatabaseConnection;
import views.CRezervareView;
import views.SeatSelectView;
import views.UserView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class CRezervareController {
    private CRezervareView cRezervareView;
    public CRezervareController(CRezervareView cRezervareView, User user, DatabaseConnection databaseConnection, UserView userView){
        this.cRezervareView = cRezervareView;

        DefaultComboBoxModel model = (DefaultComboBoxModel) cRezervareView.getComboBox().getModel();
        ArrayList<Zbor> list = getRezervariList(databaseConnection);
        Object[] row = new Object[8];

        for(int i = 0; i < list.size();i++){
            row[0] = list.get(i).getDataPlecare();
            row[1] = list.get(i).getAeroportP();
            row[2] = list.get(i).getAeroportS();
            model.addElement(String.valueOf(row[0]) + " " + String.valueOf(row[1])+ " -> " + String.valueOf(row[2]));
        }
        cRezervareView.getComboBox().setModel(model);

        this.cRezervareView.getNextButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cRezervareView.setVisible(false);
                SeatSelectView seatSelectView = new SeatSelectView( list.get(cRezervareView.getComboBox().getSelectedIndex()) );
                SeatSelectController seatSelectController = new SeatSelectController(
                        seatSelectView,
                        databaseConnection,
                        cRezervareView,
                        userView,
                        list.get(cRezervareView.getComboBox().getSelectedIndex()),
                        user
                );
            }
        });

        this.cRezervareView.getBackButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cRezervareView.setVisible(false);
                userView.setVisible(true);
            }
        });
    }

    public ArrayList<Zbor> getRezervariList(DatabaseConnection databaseConnection){
        ArrayList<Zbor> rezervariList = new ArrayList<>();
        try{
            Connection connection = databaseConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT data_plecare, aeroport_plecare, aeroport_sosire, id_zbor, nr_locuri_total FROM zboruri");

            ResultSet result = preparedStatement.executeQuery();

            Zbor zbor;
            while(result.next()){
                zbor = new Zbor(result.getInt(4),
                        0,
                        0,
                        result.getInt(5),
                        0,
                        result.getString(1),
                        result.getString(2),
                        result.getString(3)
                );
                rezervariList.add(zbor);
            }
        } catch (Exception ex){
            ex.printStackTrace();
        }
        return rezervariList;
    };
}
