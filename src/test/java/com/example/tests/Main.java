package com.example.tests;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws Exception {
        TestClass2 t = new TestClass2();
        t.setUp();
        String pr = "";
        int[] classes = {35432, 35439, 35478, 35915, 35897, 37205, 38343, 39838};
        String[] results = new String[classes.length];
        for (int i = 0; i < classes.length; i++) {
            t.testUntitledTestCase(classes[i]);
            //results[i] = t.courseName;
            pr += "\nCourse Name: " + t.courseName;
            pr += "\nCourse Number: " + t.classN;
            pr += "\nSection Number: " + t.sectionNumber;
            pr += "\nLocation: " + t.location;
            pr += "\nMeeting Dates: " + t.meetingDates;
            pr += "\nDate and Time: " + t.DateTime;
            pr += "\n\n";
        }
        t.tearDown();
        System.out.println(pr);
        //System.out.println(Arrays.toString(results));
    }
}

