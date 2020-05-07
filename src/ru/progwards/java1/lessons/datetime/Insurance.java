package ru.progwards.java1.lessons.datetime;

import java.time.*;
import java.time.format.DateTimeFormatter;

class Proverca{
    public static void main(String[] args) {
        /*ZonedDateTime a = ZonedDateTime.now() ;
        Insurance doc = new Insurance(ZonedDateTime.now());*/
        /*String pattern = "yyyy-MM-dd";
        DateTimeFormatter df = DateTimeFormatter.ofPattern(pattern);
        DateTimeFormatter df1 = DateTimeFormatter.ISO_LOCAL_DATE;
        LocalDate ff = LocalDate.parse("2020-05-05",df1);
        System.out.println(ff);*/
        /*DateTimeFormatter f_SHORT = DateTimeFormatter.ISO_LOCAL_DATE;
        LocalDate tmp = LocalDate.parse("2020-05-05",f_SHORT);
        LocalDateTime tmp2 = tmp.atTime(LocalTime.now());
        ZonedDateTime start = tmp2.atZone(ZoneId.systemDefault());
        ZonedDateTime endDefault = start.plusYears(1);
        Duration d = Duration.between(start,endDefault);
        System.out.println(start +"\n"+endDefault);
        System.out.println(d.toDays());*/

        /*DateTimeFormatter f_LONG = DateTimeFormatter.ISO_LOCAL_DATE_TIME;
        LocalDateTime tmp = LocalDateTime.parse("2020-05-05T23:59:59",f_LONG);
        ZonedDateTime start = tmp.atZone(ZoneId.systemDefault());
        ZonedDateTime endDefault = start.plusYears(1);
        Duration d = Duration.between(start,endDefault);*/

        DateTimeFormatter f_FULL = DateTimeFormatter.ISO_ZONED_DATE_TIME;
        ZonedDateTime start = ZonedDateTime.parse("2020-05-05T23:59:59+04:00[Europe/Samara]", f_FULL);
        ZonedDateTime endDefault = start.plusYears(1);
        Duration d = Duration.between(start,endDefault);
        System.out.println(start+"\n"+endDefault);
        System.out.println(d.toDays());
    }
}
public class Insurance {
    public static enum FormatStyle {SHORT, LONG, FULL}
    private ZonedDateTime start;
    private Duration duration;
    public Insurance(){
        this.start = ZonedDateTime.now();
        ZonedDateTime endDefault = this.start.plusYears(1);
        setDuration(endDefault);
    }
    public Insurance(ZonedDateTime start){
        if(start != null) {
            this.start = start;
            ZonedDateTime endDefault = this.start.plusYears(1);
            setDuration(endDefault);
        }
        else {
            this.start = ZonedDateTime.now();
            ZonedDateTime endDefault = this.start.plusYears(1);
            setDuration(endDefault);
        }
    }
    public Insurance(String strStart, FormatStyle style){
        if(!strStart.isEmpty() && style != null) {
            switch (style) {
                case SHORT: {
                    DateTimeFormatter f_SHORT = DateTimeFormatter.ISO_LOCAL_DATE;
                    LocalDate tmp = LocalDate.parse(strStart,f_SHORT);
                    LocalDateTime tmp2 = tmp.atTime(LocalTime.now());
                    this.start = tmp2.atZone(ZoneId.systemDefault());
                    ZonedDateTime endDefault = this.start.plusYears(1);
                    Duration d = Duration.between(start,endDefault);
                    setDuration(d);
                    break;
                }
                case LONG: {
                    DateTimeFormatter f_LONG = DateTimeFormatter.ISO_LOCAL_DATE_TIME;
                    LocalDateTime tmp = LocalDateTime.parse(strStart,f_LONG);
                    this.start = tmp.atZone(ZoneId.systemDefault());
                    ZonedDateTime endDefault = this.start.plusYears(1);
                    Duration d = Duration.between(start,endDefault);
                    setDuration(d);
                    break;
                }
                case FULL: {
                    DateTimeFormatter f_FULL = DateTimeFormatter.ISO_ZONED_DATE_TIME;
                    this.start = ZonedDateTime.parse(strStart, f_FULL);
                    ZonedDateTime endDefault = this.start.plusYears(1);
                    Duration d = Duration.between(start,endDefault);
                    setDuration(d);
                    break;
                }
                default:{
                    this.start = ZonedDateTime.now();
                    ZonedDateTime endDefault = this.start.plusYears(1);
                    setDuration(endDefault);
                }
            }
        }
        else{
            this.start = ZonedDateTime.now();
            ZonedDateTime endDefault = this.start.plusYears(1);
            setDuration(endDefault);
        }
    }
    public void setDuration(Duration duration){
        this.duration = duration;
    }
    public void setDuration(ZonedDateTime expiration){
        this.duration = Duration.between(this.start,expiration);
    }
    public void setDuration(int months, int days, int hours){
        ZonedDateTime end = this.start.withMonth(months).
                withDayOfMonth(days).withHour(hours);
        this.duration = Duration.between(this.start,end);
        //System.out.println(end);
    }
    public void setDuration(String strDuration, FormatStyle style){
        switch (style){
            case SHORT:{
                long mils = Long.valueOf(strDuration);
                ZonedDateTime end = start.plusSeconds(mils/1000);
                this.duration = Duration.between(start,end);
                break;
            }
            case LONG:{
                DateTimeFormatter form = DateTimeFormatter.ISO_LOCAL_DATE_TIME;//2020-05-04T13:19:53.255727600+04:00[Asia/Dubai] test
                ZonedDateTime loc = LocalDateTime.parse(strDuration,form).
                        atZone(ZoneId.systemDefault());
                this.duration = Duration.between(start,loc);
                //System.out.println(duration);
                break;
            }
            case FULL:{
                this.duration = Duration.parse(strDuration);//PT737H21M38.0061589S
                break;
            }
        }
    }
    public boolean checkValid(ZonedDateTime dateTime){
        Duration calc = Duration.between(this.getStart(),dateTime);
        if(this.duration.toMillis() < calc.toMillis()){
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