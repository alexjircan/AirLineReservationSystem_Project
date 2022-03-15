package views;

import models.Zbor;

import javax.swing.*;
import java.awt.*;

public class SeatSelectView extends JFrame{
    private JFrame frame;
    private JLabel lblNewLabel;
    private int seatNumber;
    private JButton[] seats;
    private JButton inapoiButton;
    public SeatSelectView(Zbor zbor){
        this.seatNumber = zbor.getNrLocuriTotal();

        this.setBounds(100, 100, 450, 300);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.getContentPane().setLayout(new BorderLayout(0, 0));

        JPanel panel_1 = new JPanel();
        this.getContentPane().add(panel_1, BorderLayout.NORTH);

        JLabel lblNewLabel = new JLabel("Selecteaza Locul");
        lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 36));
        panel_1.add(lblNewLabel);

        JPanel panel = new JPanel();
        this.getContentPane().add(panel);

        JPanel panel_4 = new JPanel();
        panel_4.setLayout(new GridLayout(0, 3, 0, 0));

        JPanel panel_2 = new JPanel();
        this.getContentPane().add(panel_2, BorderLayout.WEST);

        JPanel panel_3 = new JPanel();
        this.getContentPane().add(panel_3, BorderLayout.EAST);

        seats = new JButton[seatNumber];
        for(int i=0; i<seatNumber; i++) {
            seats[i] = new JButton("Loc"+(i+1));
            panel_4.add(seats[i]);
        }

        JScrollPane scrollPane = new JScrollPane(panel_4);
        this.getContentPane().add(scrollPane, BorderLayout.CENTER);

        JPanel panel_5 = new JPanel();
        this.getContentPane().add(panel_5, BorderLayout.SOUTH);

        inapoiButton = new JButton("Inapoi");
        inapoiButton.setFont(new Font("Tahoma", Font.PLAIN, 22));
        panel_5.add(inapoiButton, BorderLayout.LINE_START);

        this.setVisible(true);
    }


    public JButton getInapoiButton() {
        return inapoiButton;
    }

    public JButton[] getSeats() {
        return seats;
    }
    public void setSeats(JButton[] seats) {
        this.seats = seats;
    }
    public int getSeatNumber() {
        return seatNumber;
    }
    public void setSeatNumber(int seatNumber) {
        this.seatNumber = seatNumber;
    }

}
