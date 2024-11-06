package com.tutorial;

import org.testng.annotations.Test;

import java.util.Date;

public class DataStampAndOthers {
    @Test
    public static void generateTimeStamp(){
        Date date = new Date();
        String exactTime = date.toString().substring(8).replace(":","_").replace(" ","_");
        System.out.println(exactTime);
    }
}
