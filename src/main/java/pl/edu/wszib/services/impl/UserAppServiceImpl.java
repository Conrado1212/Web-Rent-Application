package pl.edu.wszib.services.impl;

import org.springframework.beans.factory.annotation.Autowired;

import pl.edu.wszib.dao.IUserAppDao;

import pl.edu.wszib.model.UserApp;
import pl.edu.wszib.services.IUserAppServices;

public class UserAppServiceImpl implements IUserAppServices {
    @Autowired
    IUserAppDao userAppDao;

    public UserAppServiceImpl(IUserAppDao userAppDao){
        this.userAppDao = userAppDao;
    }

    @Override
    public void addUsesApp(UserApp userApp){
        UserApp userAppFromDb = this.userAppDao.getUserApp(userApp.getIdUserApp());
        if(userAppFromDb == null){
            this.userAppDao.addUserApp(userApp);
        }
    }

    @Override
    public UserApp getUserApp(int idUserApp){
        return this.userAppDao.getUserApp(idUserApp);
    }

    @Override
    public void getUpdate(int idUserApp, UserApp userApp){
        UserApp userAppFromDb = this.userAppDao.getUpdate(idUserApp,userApp);
        if(userAppFromDb == null){
            this.userAppDao.getUpdate(idUserApp,userApp);
        }
    }

    @Override
    public void removeUserAppId(int idUserApp){
        UserApp customerFromDb = this.userAppDao.removeUserAppId(idUserApp);
        if(customerFromDb == null){
            this.userAppDao.removeUserAppId(idUserApp);
        }
    }
}
