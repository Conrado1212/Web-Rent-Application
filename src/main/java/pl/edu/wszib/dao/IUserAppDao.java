package pl.edu.wszib.dao;

import pl.edu.wszib.model.UserApp;

public interface IUserAppDao {
    void addUserApp(UserApp userApp);


    UserApp getUserApp(int idUserApp);

    UserApp getUpdate(int idUserApp, UserApp userApp);

    void updateUserApp(int idUserApp, UserApp userApp);

    UserApp removeUserAppId(int idUserApp);

    java.util.List<UserApp> getAllUserApp();

    UserApp getUserByLogin(String login);
}
