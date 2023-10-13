package com.api.endpoints;

public class Routes {
    public static String base_url = "http://jsonplaceholder.typicode.com";
    //making static so that we can use in directly with the class name without using any object
    // user model
    public static String todos_url = base_url +"/todos";
    public static String post_url = base_url +"/posts";
    public static String comment_url = base_url +"/comments";
    public static String albums_url = base_url +"/albums";
    public static String photos_url = base_url +"/photos";
    public static String get_users_url = base_url + "/users";
}
