import controllers.LoginController;
import controllers.NewAccountController;
import controllers.SeatSelectController;
import mysql.DatabaseConnection;
import views.LoginView;
import views.NewAccountView;
import views.PilotView;
import views.SeatSelectView;

import java.sql.Connection;

public class Main {
    public static void main(String[] args) {
        LoginView loginView = new LoginView();
        DatabaseConnection databaseConnection = new DatabaseConnection();

        LoginController loginController = new LoginController(loginView, databaseConnection);
    }
}
