package com.thanh.dataprovider;

import org.testng.annotations.DataProvider;

import java.lang.reflect.Method;

public class DataProviderFactory {
    @DataProvider(name = "data_login", parallel = true)
    public Object[][] dataLogin() {
        return new Object[][]{
                {"username1", "password1"}, {"username2", "password2"}
        };
    }

    @DataProvider(name = "data-provider")
    public Object[][] dpMethod(Method m) {
        switch (m.getName()) {
            case "Sum":
                return new Object[][]{{2, 3, 5}, {5, 7, 9}};
            case "Diff":
                return new Object[][]{{2, 3, -1}, {5, 7, -2}};
        }
        return null;
    }
}
