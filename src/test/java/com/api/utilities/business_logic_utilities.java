package com.api.utilities;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import java.util.Collection;
import java.util.List;

public class business_logic_utilities {

    public static double compute_completion_percentage(Response response){
        JsonPath jsonPath =  response.jsonPath();
        int total_task = jsonPath.getList("").size();
        System.out.println(total_task);
        int completed_task = jsonPath.getList("findAll{it.completed == true }.id").size();
        System.out.println(completed_task);
        double completionPercentage = ((double) completed_task / total_task) * 100;
        System.out.println("Completion Percentage: " + completionPercentage + "%");
        return completionPercentage;
    }

    public static Collection<Integer> fanCode_users(Response response){
        JsonPath jsonPath = response.jsonPath();
        // Extract the users who meet the criteria
        List<Integer> fanCode_users = jsonPath.getList(
                "findAll { it.address.geo.lat.toFloat() >= "+constants.lat_min+" &&" +
                "it.address.geo.lat.toFloat() <= "+ constants.lat_max+" &&" +
                "it.address.geo.lng.toFloat() >= "+ constants.lng_min+" &&" +
                "it.address.geo.lat.toFloat() <= "+ constants.lng_max+
                " }.id");
        return fanCode_users;
    }
}
