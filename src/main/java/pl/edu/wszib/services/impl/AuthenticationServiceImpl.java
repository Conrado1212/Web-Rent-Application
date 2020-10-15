package pl.edu.wszib.services.impl;

import org.apache.commons.codec.digest.DigestUtils;
import pl.edu.wszib.dao.IUserAppDao;
import pl.edu.wszib.model.UserApp;
import pl.edu.wszib.services.IAuthenticationService;

public class AuthenticationServiceImpl implements IAuthenticationService {

    IUserAppDao userAppDao;

    public AuthenticationServiceImpl(IUserAppDao userAppDao){
        this.userAppDao = userAppDao;
    }

    @Override
    public boolean authenticateUserApp(UserApp userApp) {
        UserApp userFormDb = this.userAppDao.getUserByLogin(userApp.getLogin());
        //  if(userFromDb != null  &&
        //   userFromDb.getPass().equals(DigestUtils.md5Hex(user.getPass()))){
        //  return true;
        //   }
        // return false;
        return userFormDb != null && userFormDb.getPassword().equals(DigestUtils.md5Hex(userApp.getPassword()));
    }
    public boolean cos(){
        return  true ;
    }

}
