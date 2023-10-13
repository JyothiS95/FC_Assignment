package com.api.tests;

import com.api.serviceBuilder.tasks;
import com.api.serviceBuilder.users;
import com.api.utilities.DataProviders.FanCodeUsersDataProvider;
import com.api.utilities.business_logic_utilities;
import io.qameta.allure.Allure;
import io.qameta.allure.Description;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Collection;

public class task_completed_tests extends BaseTest {
    private Collection<Integer> fanCodeUsers;
    @BeforeTest
    public void getFanCodeCityUsers() {
        Response response = users.get_users_details();
        Assert.assertEquals(response.statusCode(), 200);
        fanCodeUsers = business_logic_utilities.fanCode_users(response);
    }

   @DataProvider(name = "fanCodeUsersProvider")
   public Object[][] provideFanCodeUsers() {
       return FanCodeUsersDataProvider.provideFanCodeUsers(fanCodeUsers);
   }

   @Description("Scenario : All the users of City `FanCode` should have more than half of their todos task completed.")
   @Test(dataProvider = "fanCodeUsersProvider")
    public void verify_50perent_completion_percentage(int user) {
        Response response = tasks.get_todos_details(user);
        Assert.assertEquals(response.statusCode(), 200);
        System.out.println("fancode_ user:" +user);
        Assert.assertTrue(business_logic_utilities.compute_completion_percentage(response) > 50.0, "Completion percentage is less than 50%.");
        Allure.addAttachment("Fancode users", String.valueOf(user));
        Allure.addAttachment("Response", "application/json",response.asString());
    }

}