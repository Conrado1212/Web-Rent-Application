package pl.edu.wszib.service.impl;


import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import pl.edu.wszib.configuration.AppConfigurationTest;
import pl.edu.wszib.dao.IUserAppDao;
import pl.edu.wszib.model.UserApp;
import pl.edu.wszib.services.IAuthenticationService;

import static org.hamcrest.Matchers.notNullValue;
import static org.hamcrest.text.IsEmptyString.emptyString;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {AppConfigurationTest.class})
@WebMvcTest //imitacja http
public class AuthenticationServiceImplTest {

    @Autowired
    IAuthenticationService authenticationService;

    @MockBean
    IUserAppDao userAppDao;

    @Autowired

    private MockMvc mockMvc;


    @Test
    public void authenticateUserTest() {
        UserApp userApp = new UserApp();
        userApp.setLogin("mateusz");
        userApp.setPassword("sdsghkh");

        Mockito.when(this.userAppDao.getUserByLogin(any()))
                .thenReturn(new UserApp(1,"mateusz",
                        "sdsghkh"));

        boolean result = this.authenticationService.authenticateUserApp(userApp);

        Assert.assertTrue(result);

        IUserAppDao mojeDAO = Mockito.mock(IUserAppDao.class);
    }


    @Test
    public void authenticateUserTest2() {
        UserApp userApp = new UserApp();
        userApp.setLogin("mateusz");
        userApp.setPassword("mateusz");

        Mockito.when(this.userAppDao.getUserByLogin("janusz"))
                .thenReturn(new UserApp(1,"mateusz",
                        "sdsghkh"));

        boolean result = this.authenticationService.authenticateUserApp(userApp);

        Assert.assertTrue(result);

        verify(this.userAppDao, times(1)).getUserByLogin("mateusz");
        verify(this.userAppDao, times(0)).getUserByLogin("mateusz8");
    }

    @Test
    public void callLoginPage()throws Exception{
        String expectedErrorMessage = "";
        String expectedVievName = "loginAndRegistry";

        this.mockMvc.perform(get("/loginAndRegistry"))
                .andExpect(status().isOk())
                .andExpect(view().name(expectedVievName))
                .andExpect(model().attribute("errorMessage",emptyString()))
                .andExpect(model().attribute("userModel",notNullValue(null)));


    }



}
