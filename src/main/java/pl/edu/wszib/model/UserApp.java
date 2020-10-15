package pl.edu.wszib.model;


import javax.persistence.*;

@Entity
@Table(name="userapp")
public class UserApp {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idUserApp;
    private String login;
    private String password;

    public UserApp(int idUserApp, String login, String password) {
        this.idUserApp = idUserApp;
        this.login = login;
        this.password = password;
    }

    public UserApp(){

    }

    public int getIdUserApp() {
        return idUserApp;
    }

    public void setIdUserApp(int idUserApp) {
        this.idUserApp = idUserApp;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "UserApp{" +
                "idUserApp=" + idUserApp +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
