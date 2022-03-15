package models;

public class User {
    private int idUser, tipUser;
    private String nume, prenume ,dataNasterii, username, passsword, dataAngajare;

    public User(int idUser, int tipUser, String nume, String prenume, String dataNasterii, String username, String passsword, String dataAngajare) {
        this.idUser = idUser;
        this.tipUser = tipUser;
        this.nume = nume;
        this.prenume = prenume;
        this.dataNasterii = dataNasterii;
        this.username = username;
        this.passsword = passsword;
        this.dataAngajare = dataAngajare;
    }

    public int getIdUser() {
        return idUser;
    }

    public int getTipUser() {
        return tipUser;
    }

    public String getNume() {
        return nume;
    }

    public String getPrenume() {
        return prenume;
    }

    public String getDataNasterii() {
        return dataNasterii;
    }

    public String getUsername() {
        return username;
    }

    public String getPasssword() {
        return passsword;
    }

    public String getDataAngajare() {
        return dataAngajare;
    }
}
