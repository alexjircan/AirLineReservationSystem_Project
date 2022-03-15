package views;

import mysql.DatabaseConnection;

import java.awt.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class PilotView extends JFrame {

    private JTable table;
    private JLabel titleLabel;
    private JTable zboruriTable;
    private JScrollPane scrollPane;
    private JButton logoutButton;
    private DefaultTableModel dtm;

    public PilotView() {
        this.setBounds(100, 100, 450, 300);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.getContentPane().setLayout(new BorderLayout(20, 20));

        titleLabel = new JLabel("Zboruri");
        titleLabel.setFont(new Font("Tahoma", Font.PLAIN, 36));
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        this.getContentPane().add(titleLabel, BorderLayout.NORTH);

        zboruriTable = new JTable();
        zboruriTable.setRowHeight(50);
        zboruriTable.setFont(new Font("SansSerif", Font.PLAIN, 20));
        zboruriTable.getTableHeader().setFont(new Font("SansSerif", Font.BOLD, 20));

        dtm = new DefaultTableModel(0, 0);
        String header[] = new String[]{"Data Plecare", "Aeroport Plecare", "Aeroport Sosire"};
        dtm.setColumnIdentifiers(header);
        zboruriTable.setModel(dtm);

        JScrollPane scrollPane = new JScrollPane(zboruriTable);
        this.getContentPane().add(scrollPane, BorderLayout.CENTER);

        logoutButton = new JButton("Logout");
        logoutButton.setFont(new Font("Tahoma", Font.PLAIN, 22));
        this.getContentPane().add(logoutButton, BorderLayout.SOUTH);

        this.setVisible(true);
    }

    public JButton getLogoutButton() {
        return logoutButton;
    }

    public DefaultTableModel getDtm() {
        return dtm;
    }

    private void showMessage(String message) {
        JOptionPane.showMessageDialog(this, message);
    }

    public JTable getTable() {
        return table;
    }

}
