package com.api.utilities.DataProviders;

import com.api.serviceBuilder.users;
import com.api.tests.BaseTest;
import com.api.utilities.business_logic_utilities;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;

import java.util.Collection;

public class FanCodeUsersDataProvider extends BaseTest {

    public static Object[][] provideFanCodeUsers(Collection<Integer> fanCodeUsers) {
        if (fanCodeUsers != null) {
            Object[][] data = new Object[fanCodeUsers.size()][];
            int index = 0;
            for (Integer user : fanCodeUsers) {
                data[index] = new Object[] { user };
                index++;
            }
            return data;
        } else {
            return new Object[0][];
        }
    }
}

