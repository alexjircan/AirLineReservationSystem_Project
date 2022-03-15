package controllers;

import models.User;
import models.Zbor;
import mysql.DatabaseConnection;
import views.AdminView;
import views.CZborView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class CZborController {
    private CZborView cZborView;
    public CZborController(CZborView cZborView, AdminView adminView, DatabaseConnection databaseConnection){
        this.cZborView = cZborView;

        DefaultComboBoxModel model = (DefaultComboBoxModel) cZborView.getPilotComboBox().getModel();
        ArrayList<User> list = getRezervariList(databaseConnection);
        Object[] row = new Object[8];

        for(int i = 0; i < list.size();i++){
            row[0] = list.get(i).getNume();
            row[1] = list.get(i).getPrenume();
            model.addElement(String.valueOf(row[0]) + " " + String.valueOf(row[1]));
        }
        cZborView.getPilotComboBox().setModel(model);

        this.cZborView.getSubmitButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    User user = list.get( cZborView.getPilotComboBox().getSelectedIndex() );

                    int id_pilot = user.getIdUser();
                    String bDay = cZborView.getbDay();
                    String bMonth = cZborView.getbMonth();
                    String bYear = cZborView.getbYear();
                    String pret = cZborView.getPretField();
                    String aeroportPlecare = cZborView.getAeroportPlecare();
                    String aeroportSosire = cZborView.getAeroportSosire();
                    String locuriTotal = cZborView.getNrlocuriField();

                    Connection connection = databaseConnection.getConnection();
                    PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO zboruri VALUES (NULL,?,?,?,?,?,?,?)");
                    preparedStatement.setInt(1, id_pilot );
                    preparedStatement.setString(2, bYear+'-'+bMonth+'-'+bDay);
                    preparedStatement.setInt(3, Integer.parseInt(pret));
                    preparedStatement.setString(4, aeroportPlecare);
                    preparedStatement.setString(5, aeroportSosire);
                    preparedStatement.setInt(6, Integer.parseInt(locuriTotal));
                    preparedStatement.setInt(7, Integer.parseInt(locuriTotal));

                    preparedStatement.executeUpdate();
                    JOptionPane.showMessageDialog(cZborView, "Zbor creat!");
                    cZborView.setVisible(false);
                    adminView.setVisible(true);

                }catch(Exception ex){
                    JOptionPane.showMessageDialog(cZborView, "Date gresite!");
                    ex.printStackTrace();
                }
            }
        });

        this.cZborView.getBackButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cZborView.setVisible(false);
                adminView.setVisible(true);
            }
        });
    }

    public ArrayList<User> getRezervariList(DatabaseConnection databaseConnection){
        ArrayList<User> rezervariList = new ArrayList<>();
        try{
            Connection connection = databaseConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT id_user, nume, prenume FROM users WHERE tipuser = 2");

            ResultSet result = preparedStatement.executeQuery();

            User user;
            while(result.next()){
                user = new User(result.getInt(1), 0, result.getString(2), result.getString(3), "", "","","");
                rezervariList.add(user);
            }
        } catch (Exception ex){
            ex.printStackTrace();
        }
        return rezervariList;
    };
}
