package ru.progwards.java1.lessons.datetime;

import java.time.*;
import java.time.format.DateTimeFormatter;

class Proverca{
    public static void main(String[] args) {

        Insurance doc = new Insurance("2020-05-18T18:50:38", Insurance.FormatStyle.LONG);
        doc.setDuration(0,2,0);

        System.out.println(doc);

    }
}
public class Insurance {
    public static enum FormatStyle {SHORT, LONG, FULL}
    private ZonedDateTime start;
    //public ZonedDateTime validDateTime;
    private Duration duration;

    public Insurance(ZonedDateTime start){
        if(start != null) {
            this.start = start;
            ZonedDateTime endDefault = this.start.plusYears(100); //ZonedDateTime.now();//
            setDuration(endDefault);
        }
        else {
            this.start = ZonedDateTime.now();
            ZonedDateTime endDefault = this.start.plusYears(100);//ZonedDateTime.now();//this.start.plusYears(1);
            setDuration(endDefault);
        }
    }
    public Insurance(String strStart, FormatStyle style){
        if(!strStart.isEmpty() && style != null) {
            switch (style) {
                case SHORT: {
                    String[] proverca = strStart.split("[-,T,:]");
                    if(Integer.parseInt(proverca[1])==0 || Integer.parseInt(proverca[2])==0){
                        this.start = ZonedDateTime.now();
                        ZonedDateTime endDefault = this.start.plusYears(100);
                        Duration d = Duration.between(start,endDefault);
                        setDuration(d);
                    }
                    else {
                        DateTimeFormatter f_SHORT = DateTimeFormatter.ISO_LOCAL_DATE;
                        LocalDate tmp = LocalDate.parse(strStart, f_SHORT);
                        LocalDateTime tmp2 = tmp.atTime(00, 00, 00);
                        this.start = tmp2.atZone(ZoneId.systemDefault());
                        ZonedDateTime endDefault = this.start.plusYears(100);//ZonedDateTime.now();//this.start.plusYears(1);
                        Duration d = Duration.between(start, endDefault);
                        setDuration(d);
                    }
                    break;
                }
                case LONG: {
                    String[] proverca = strStart.split("[-,T,:]");
                    if(Integer.parseInt(proverca[1])==0 || Integer.parseInt(proverca[2])==0){
                        this.start = ZonedDateTime.now();
                        ZonedDateTime endDefault = this.start.plusYears(100);
                        Duration d = Duration.between(start,endDefault);
                        setDuration(d);
                    }
                    else {
                        DateTimeFormatter f_LONG = DateTimeFormatter.ISO_LOCAL_DATE_TIME;
                        LocalDateTime tmp = LocalDateTime.parse(strStart, f_LONG);
                        this.start = tmp.atZone(ZoneId.systemDefault());
                        ZonedDateTime endDefault = this.start.plusYears(100);//ZonedDateTime.now();//this.start.plusYears(1);
                        Duration d = Duration.between(start, endDefault);
                        setDuration(d);
                    }
                    break;
                }
                case FULL: {
                    String[] proverca = strStart.split("[-,T,:]");
                    if(Integer.parseInt(proverca[1])==0 || Integer.parseInt(proverca[2])==0){
                        this.start = ZonedDateTime.now();
                        ZonedDateTime endDefault = this.start.plusYears(100);
                        Duration d = Duration.between(start,endDefault);
                        setDuration(d);
                    }
                    else {
                        DateTimeFormatter f_FULL = DateTimeFormatter.ISO_ZONED_DATE_TIME;
                        this.start = ZonedDateTime.parse(strStart, f_FULL);
                        ZonedDateTime endDefault = this.start.plusYears(100);//ZonedDateTime.now();//this.start.plusYears(1);
                        Duration d = Duration.between(start, endDefault);
                        setDuration(d);
                    }
                    break;
                }
                default:{
                    this.start = ZonedDateTime.now();
                    ZonedDateTime endDefault = this.start.plusYears(100);//ZonedDateTime.now();//this.start.plusYears(1);
                    setDuration(endDefault);
                }
            }
        }
        else{
            this.start = ZonedDateTime.now();
            ZonedDateTime endDefault = this.start.plusYears(100);//ZonedDateTime.now();//this.start.plusYears(1);
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
        ZonedDateTime end = ZonedDateTime.now();
        if(months <= 0 || months > 12){
            end = this.start.plusDays(days).plusHours(hours);
        }
        else if((months >= 1 || months <=12)) {
            end = this.start.plusMonths(months).plusDays(days).plusHours(hours);
        }
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
                String[] proverka = strDuration.split("[-,T,:]");
                //DateTimeFormatter form = DateTimeFormatter.ISO_LOCAL_DATE_TIME;//2020-05-04T13:19:53.255727600+04:00[Asia/Dubai] test
                // LocalDateTime end = LocalDateTime.parse(strDuration, form);
                LocalDateTime start11 = LocalDateTime.now()/*.minusYears(end.getYear()).minusMonths(end.getMonth().getValue()).minusDays(end.getDayOfMonth())*/;
                LocalDateTime tmp = start11.minusYears(Integer.parseInt(proverka[0])).
                        minusMonths(Integer.parseInt(proverka[1])).
                        minusDays(Integer.parseInt(proverka[2])).
                        minusHours(Integer.parseInt(proverka[3])).
                        minusMinutes(Integer.parseInt(proverka[4])).
                        minusSeconds(Integer.parseInt(proverka[5]));
                Duration loc = Duration.between(tmp, start11);
                this.duration = loc;
                //System.out.println(loc);
                break;
            }
            case FULL:{
                this.duration = Duration.parse(strDuration);//PT737H21M38.0061589S
                break;
            }
        }
    }
    public boolean checkValid(ZonedDateTime dateTime){
        if(start.compareTo(ZonedDateTime.now())>0){
            return false;
        }
        else {
            Duration calc = Duration.between(this.getStart(), dateTime);
            //System.out.println(calc.toMillis()+" "+duration.toMillis());
            if (duration.toMillis() < calc.toMillis()) {
                return false;
            } else
                return true;
        }
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