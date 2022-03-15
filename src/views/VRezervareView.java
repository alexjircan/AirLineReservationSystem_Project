package views;

import mysql.DatabaseConnection;

import java.awt.*;
import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.table.DefaultTableModel;

public class VRezervareView extends JFrame {
    private JButton InapoiButton;
    private JTable zboruriTable;
    private JLabel titleLabel;
    private DefaultTableModel dtm;

    public VRezervareView() {
        this.setBounds(100, 100, 1044, 593);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.getContentPane().setLayout(new BorderLayout(20, 20));

        titleLabel = new JLabel("Rezervari");
        titleLabel.setFont(new Font("Tahoma", Font.PLAIN, 36));
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        this.getContentPane().add(titleLabel, BorderLayout.NORTH);

        zboruriTable = new JTable();
        zboruriTable.setRowHeight(50);
        zboruriTable.setFont(new Font("SansSerif", Font.PLAIN, 20));
        zboruriTable.getTableHeader().setFont(new Font("SansSerif", Font.BOLD, 20));

        dtm = new DefaultTableModel(0, 0);
        String header[] = new String[]{"Data Plecare", "Aeroport Plecare", "Aeroport Sosire", "Loc"};
        dtm.setColumnIdentifiers(header);
        zboruriTable.setModel(dtm);

        JScrollPane scrollPane = new JScrollPane(zboruriTable);
        this.getContentPane().add(scrollPane, BorderLayout.CENTER);

        InapoiButton = new JButton("Inapoi");
        InapoiButton.setFont(new Font("Tahoma", Font.PLAIN, 22));
        InapoiButton.setBounds(419, 457, 194, 47);
        this.getContentPane().add(InapoiButton, BorderLayout.SOUTH);

        this.setVisible(true);
    }

    public DefaultTableModel getDtm() {
        return dtm;
    }

    private void showMessage(String message) {
        JOptionPane.showMessageDialog(this, message);
    }

    public JButton getInapoiButton() {
        return InapoiButton;
    }
}


