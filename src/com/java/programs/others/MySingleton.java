package com.java.programs.others;

/**
 * Created by sheik on 10/22/2017.
 */
public class MySingleton {

    private static MySingleton singleton;

    static {
        singleton = new MySingleton();
    }

    private MySingleton(){

    }

    public static MySingleton getInstance(){
        return singleton;
    }

}
