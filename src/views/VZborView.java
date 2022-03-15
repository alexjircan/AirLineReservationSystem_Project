package views;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class VZborView extends JFrame {
    private JLabel titleLabel;
    private JTable zboruriTable;
    private DefaultTableModel dtm;
    private JButton inapoiButton;

    public VZborView(){
        this.setBounds(100, 100, 1044, 593);
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

        inapoiButton = new JButton("Inapoi");
        inapoiButton.setFont(new Font("Tahoma", Font.PLAIN, 22));
        inapoiButton.setBounds(419, 457, 194, 47);
        this.getContentPane().add(inapoiButton, BorderLayout.SOUTH);

        this.setVisible(true);
    }

    public JButton getInapoiButton() {
        return inapoiButton;
    }

    public DefaultTableModel getDtm() {
        return dtm;
    }
}
