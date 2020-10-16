package pl.edu.wszib.dao.impl;

import pl.edu.wszib.dao.IUserAppDao;
import pl.edu.wszib.model.UserApp;

import java.util.List;

public class UserAppDAOImplStub implements IUserAppDao {
    @Override
    public void addUserApp(UserApp userApp) {

    }

    @Override
    public UserApp getUserApp(int idUserApp) {
        return null;
    }

    @Override
    public UserApp getUpdate(int idUserApp, UserApp userApp) {
        return null;
    }

    @Override
    public void updateUserApp(int idUserApp, UserApp userApp) {

    }

    @Override
    public UserApp removeUserAppId(int idUserApp) {
        return null;
    }

    @Override
    public List<UserApp> getAllUserApp() {
        return null;
    }

    @Override
    public UserApp getUserByLogin(String login) {
        return null;
    }
}
