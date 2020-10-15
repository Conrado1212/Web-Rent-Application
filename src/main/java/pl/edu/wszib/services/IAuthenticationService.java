package pl.edu.wszib.services;

import pl.edu.wszib.model.UserApp;

public interface IAuthenticationService {
    boolean authenticateUserApp(UserApp userApp);
}
