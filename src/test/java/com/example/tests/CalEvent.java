package com.example.tests;

import com.google.api.client.util.DateTime;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Locale;

public class CalEvent {
    public String courseName;
    public String classN;
    public String sectionNumber;
    public String location;
    public String meetingDates;
    public String DateTime;
    public String allText;
    public DateTime startDateTime;
    public DateTime endDateTime;
    public String[] recurrence;


    public CalEvent(String courseName, String classN, String sectionNumber,
                    String location, String meetingDates, String DateTime, String allText) {
        this.courseName = courseName;
        this.classN = classN;
        this.sectionNumber = sectionNumber;
        this.location = location;
        this.meetingDates = meetingDates;
        this.DateTime = DateTime;
        this.allText = allText;
    }

    public void parse() {
        String beginDate = meetingDates.substring(0, 10);
        String endDate = meetingDates.substring(13);
        int firstSpace = DateTime.indexOf(" ");
        int secondSpace = DateTime.indexOf(" ", firstSpace + 1);
        int thirdSpace = DateTime.indexOf(" ", secondSpace + 1);
        String beginTime = DateTime.substring(firstSpace + 1, secondSpace);
        String endTime = DateTime.substring(thirdSpace + 1);
        String begin = beginDate + beginTime;
        String end = beginDate + endTime;
        String days = DateTime.substring(0, firstSpace).toUpperCase();
        int dLength = days.length();
        String oldFormat = "MM/dd/yyyyhh:mma";
        String newFormat = "yyyy-MM-dd'T'HH:mm:ssXXX";
        String rec = "RRULE:FREQ=WEEKLY;UNTIL=";
        String rFormat = "MM/dd/yyyy";
        String rNewFormat = "yyyyMMdd";
        SimpleDateFormat r = new SimpleDateFormat(rFormat, Locale.getDefault());
        SimpleDateFormat sdf = new SimpleDateFormat(oldFormat, Locale.getDefault());
        SimpleDateFormat sdz = new SimpleDateFormat(oldFormat, Locale.getDefault());
        Date eDate;
        Date bDate;
        Date rDate;
        try {
            bDate = sdf.parse(begin);
            sdf.applyPattern(newFormat);
            startDateTime = new DateTime(sdf.format(bDate));
            System.out.println(sdf.format(bDate));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        try {
            eDate = sdz.parse(end);
            sdz.applyPattern(newFormat);
            System.out.println(sdz.format(eDate));
            endDateTime = new DateTime(sdz.format(eDate));
        } catch (ParseException x) {
            x.printStackTrace();
        }
        try {
            rDate = r.parse(endDate);
            r.applyPattern(rNewFormat);
            rec = rec + r.format(rDate) + "T170000Z;WKST=SU;BYDAY=";
        } catch (ParseException x) {
            x.printStackTrace();
        }
        for (int i = dLength - 2; i > 0;i -= 2) {
            days = days.substring(0, i) + "," + days.substring(i);
        }
        rec = rec + days;
        recurrence = new String[] {rec};
        System.out.println(rec);
    }

}
