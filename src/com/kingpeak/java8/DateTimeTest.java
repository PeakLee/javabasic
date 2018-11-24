package com.kingpeak.java8;

import java.time.*;

/**
 * 时间日期API:  localDate, LocalTime, LocalDateTime, ZoneId, ZonedDateTime.
 * url: http://www.runoob.com/java/java8-datetime-api.html
 * @date 20181124
 */
public class DateTimeTest {

    public static void main(String[] args) {

        //##1  test local datetime apis.
        LocalDateTime currentTime = LocalDateTime.now();
        System.out.println("current time: " + currentTime);

        Month month = currentTime.getMonth();
        int day = currentTime.getDayOfMonth();
        int seconds = currentTime.getSecond();
        System.out.println("Month: " + month + ", day: " + day + ", second: " + seconds);

        LocalDateTime date2 = currentTime.withDayOfMonth(10).withYear(2012);
        System.out.println("date2:  " + date2);

        LocalDate date3 = LocalDate.of(2014, Month.DECEMBER, 12);
        System.out.println("date3: " + date3);

        LocalTime date4 = LocalTime.of(22, 15);
        System.out.println("date4: " + date4);

        LocalTime date5 = LocalTime.parse("20:12:23");
        System.out.println("date5: " + date5);

        // ##2  test time zone apis.
        ZoneId currentZone = ZoneId.systemDefault();
        System.out.println("current zone: " + currentZone);

        ZoneId id = ZoneId.of("Europe/Paris");
        System.out.println("zoneId: " + id);

        ZonedDateTime date6 = ZonedDateTime.parse("2015-12-03T10:15:30+05:30[Asia/Shanghai]");
        System.out.println("date6: " + date6);

        System.exit(0);
    }

}
