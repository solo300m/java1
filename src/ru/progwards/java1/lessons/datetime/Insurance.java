package ru.progwards.java1.lessons.datetime;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class Insurance {
    public static enum FormatStyle {SHORT, LONG, FULL}
    private ZonedDateTime start;
    private Duration duration;
    public Insurance(ZonedDateTime start){
        this.start = start;
    }
    public Insurance(String strStart, FormatStyle style){
        switch (style) {
            case SHORT:{
                DateTimeFormatter f_SHORT = DateTimeFormatter.ISO_LOCAL_DATE ;
                this.start = ZonedDateTime.parse(strStart, f_SHORT);
                this.start.withZoneSameInstant(ZoneId.systemDefault());
                break;
            }
            case LONG:{
                DateTimeFormatter f_LONG = DateTimeFormatter.ISO_LOCAL_DATE_TIME;
                this.start = ZonedDateTime.parse(strStart, f_LONG);
                this.start.withZoneSameInstant(ZoneId.systemDefault());
                break;
            }
            case FULL:{
                DateTimeFormatter f_FULL = DateTimeFormatter.ISO_ZONED_DATE_TIME;
                this.start = ZonedDateTime.parse(strStart, f_FULL);
                break;
            }
            default:
                throw new IllegalStateException("Unexpected value: " + style);
        }
    }
    public void setDuration(Duration duration){
        this.duration = duration;
    }
    public void setDuration(ZonedDateTime expiration){
        this.duration = Duration.between(this.start,expiration);
    }
    public void setDuration(int months, int days, int hours){
        ZonedDateTime end = this.start.plusMonths(months).
                plusDays(days).plusHours(hours);
        this.duration = Duration.between(this.start,end);
    }
    public void setDuration(String strDuration, FormatStyle style){
        switch (style){
            case SHORT:{
                long mils = Long.valueOf(strDuration);
                ZonedDateTime end = ZonedDateTime.of(0000,00,
                        00,00,00,(int) mils/1000,00
                        ,ZoneId.systemDefault());
                ZonedDateTime start = ZonedDateTime.of(0000,00,
                        00,00,00,00,
                        00,ZoneId.systemDefault());
                this.duration = Duration.between(start,end);
            }
            case LONG:{
                DateTimeFormatter form = DateTimeFormatter.ISO_LOCAL_DATE_TIME;
                ZonedDateTime loc = LocalDateTime.parse(strDuration,form).
                        atZone(ZoneId.systemDefault());
                ZonedDateTime start = ZonedDateTime.of(0000,00,
                        00,00,00,00,
                        00,ZoneId.systemDefault());
                this.duration = Duration.between(start,loc);
            }
            case FULL:{
                this.duration = Duration.parse(strDuration);
            }
        }
    }
    public boolean checkValid(ZonedDateTime dateTime){
        Duration calc = Duration.between(this.getStart(),dateTime);
        if(this.duration.compareTo(calc) < 0){
            return false;
        }
        else
            return true;
    }
    public String toString(){
        ZonedDateTime now1 = ZonedDateTime.now();
        if(checkValid(now1))
            return "Insurance issued on " + this.getStart() +" is valid";
        else
            return "Insurance issued on " + this.getStart() +" is not valid";
    }

    public ZonedDateTime getStart() {
        return start;
    }

    public void setStart(ZonedDateTime start) {
        this.start = start;
    }
}
