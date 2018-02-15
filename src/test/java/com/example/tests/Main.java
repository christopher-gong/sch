package com.example.tests;

import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    private static CalEvent[] events;

    public static void setup(int[] classNbrs) throws Exception {
        InfoPuller t = new InfoPuller();
        events = new CalEvent[classNbrs.length];
        t.setUp();
        for (int i = 0; i < classNbrs.length; i++) {
            t.populate(classNbrs[i]);
            events[i] = new CalEvent(t.courseName, t.classN, t.sectionNumber, t.location, t.meetingDates, t.DateTime, t.allText);
            events[i].parse();
        }
        t.tearDown();
    }

    public static int[] inputClasses() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please copy your classes from SchedulePlaner!");
        System.out.print("Classes: ");
        String classInput = scanner.nextLine();
        System.out.println(classInput);
        classInput = classInput + ", helps end properly";
        int numberOfClasses = StringUtils.countMatches(classInput, ",");
        int[] classes = new int[numberOfClasses];
        for (int i = 0; i < numberOfClasses; i++) {
            classes[i] = Integer.parseInt(classInput.substring(classInput.indexOf(",") - 5, classInput.indexOf(",")));
            classInput = classInput.substring(classInput.indexOf(",") + 1);
        }
        return classes;
    }

    public static void printer() throws Exception {
        InfoPuller t = new InfoPuller();
        t.setUp();
        String pr = "";
        int[] classes = {35432, 35439, 35478, 35915, 35897, 37205, 38343, 39838};
        String[] results = new String[classes.length];
        for (int i = 0; i < classes.length; i++) {
            t.populate(classes[i]);
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
    }

    public static void main(String[] args) throws Exception {
        int[] classes = inputClasses();
        //printer();
        //CalEvent c = new CalEvent("CS61B", "35432", "001-LEC", "Wheeler 150", "01/16/2018 - 05/04/2018", "MoWeFr 3:00PM - 3:59PM", "");
        //c.parse();
        //System.out.println(Arrays.toString(results));
        //int[] classes = {35432, 35439, 35478, 35915, 35897, 37205, 38343, 39838};
        //int[] classes = {35432, 35915, 39838};
        setup(classes);
        for (CalEvent e: events) {
            ClassAdder.addClass(e.calName, e.location, e.desc, e.startDateTime, e.endDateTime, e.recurrence, e.shortCourseName);
        }
    }
}

