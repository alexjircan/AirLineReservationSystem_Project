package controllers;

import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;
import models.User;
import models.Zbor;
import mysql.DatabaseConnection;
import views.CRezervareView;
import views.SeatSelectView;
import views.UserView;

import javax.crypto.CipherInputStream;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class SeatSelectController {
    private SeatSelectView view;
    public SeatSelectController(SeatSelectView view, DatabaseConnection databaseConnection, CRezervareView cRezervareView, UserView userView, Zbor zbor, User user){
        this.view = view;

        for(int i=0; i<this.view.getSeatNumber(); i++) {
            int finalI = i+1;
            this.view.getSeats()[i].setBackground(new Color(30, 255, 42));
            this.view.getSeats()[i].addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    try {
                        Connection connection = databaseConnection.getConnection();
                        PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO rezervari VALUES ( NULL, ?, ?, ? )");
                        preparedStatement.setInt(1, user.getIdUser());
                        preparedStatement.setInt(2, zbor.getIdZbor());
                        preparedStatement.setInt(3, finalI);

                        preparedStatement.executeUpdate();

                        view.setVisible(false);
                        userView.setVisible(true);
                        JOptionPane.showMessageDialog(userView, "Locul " +
                                finalI +
                                " din zborul " +
                                zbor.getDataPlecare() +
                                " " +
                                zbor.getAeroportP() +
                                "->" +
                                zbor.getAeroportS() +
                                " a fost rezervat!");
                    }catch(MySQLIntegrityConstraintViolationException ex){
                        JOptionPane.showMessageDialog(userView, "Ati selectat un zbor deja rezervat!");
                    } catch (Exception ex){
                        ex.printStackTrace();
                        JOptionPane.showMessageDialog(userView, "Zborul nu a putut fi rezervat!");
                    }
                }
            });
        }

        try{
            Connection connection = databaseConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT nr_loc FROM rezervari WHERE id_zbor = ?");
            preparedStatement.setInt(1, zbor.getIdZbor());

            ResultSet result = preparedStatement.executeQuery();

            while(result.next()){
                this.view.getSeats()[result.getInt(1)-1 ].setEnabled(false);
                this.view.getSeats()[result.getInt(1)-1 ].setBackground(new Color(255, 50, 50));
            }
        }catch (Exception ex){
            ex.printStackTrace();
        }

        this.view.getInapoiButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                view.setVisible(false);
                cRezervareView.setVisible(true);
            }
        });
    }
}
