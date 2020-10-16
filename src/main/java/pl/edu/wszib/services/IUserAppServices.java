package pl.edu.wszib.services;

import pl.edu.wszib.model.UserApp;

public interface IUserAppServices {
    void addUsesApp(UserApp userApp);

    UserApp getUserApp(int idUserApp);

    void getUpdate(int idUserApp, UserApp userApp);

    void removeUserAppId(int idUserApp);
}
