package ru.progwards.java1.lessons.datetime;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
class Statistica{
    public static void main(String[] args) {
        Profiler a = new Profiler();
        Profiler.enterSection("S1");
        try{
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        for(int i=0; i < 2; i++){
            Profiler.enterSection("S2");
            try{
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Profiler.enterSection("S3");
            try{
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Profiler.exitSection("S3");
            Profiler.exitSection("S2");
        }
        Profiler.enterSection("S4");
        try{
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Profiler.exitSection("S4");
        Profiler.exitSection("S1");

        for(StatisticInfo s: Profiler.getStatisticInfo()){
            System.out.println(s.sectionName+" "+s.fullTime+" "+s.selfTime+" "+s.count);
        }
    }
}

public class Profiler {
    public static List<StatisticInfo> startStop;
    public Profiler(){
        startStop = new ArrayList<StatisticInfo>();
    }
    public static void addSI(StatisticInfo o1){
        startStop.add(o1);
    }
    public static void enterSection(String name){
        if(startStop.size()!=0) {
            boolean find = false;
            for (int i = 0; i < startStop.size(); i++) {
                if (startStop.get(i).sectionName == name) {
                    find = true;
                }
            }
            if (find == true) {
                for (int i = 0; i < startStop.size(); i++) {
                    if (startStop.get(i).sectionName == name) {
                        startStop.get(i).addStart(LocalDateTime.now());
                    }
                }
            }
            else {
                for(int i = startStop.size() - 1; i>=0; i--) {
                    if (startStop.get(i).getStart().size() > startStop.get(i).getFinish().size()) {
                        System.out.println(startStop.get(i).getStart().size()+" "+startStop.get(i).getFinish().size());
                        String masterID = startStop.get(i).getSectionID();
                        System.out.println(masterID);
                        addSI(new StatisticInfo(name, masterID));
                        break;
                    }
                }
                for (int i = 0; i < startStop.size(); i++) {
                    if (startStop.get(i).sectionName == name) {
                        startStop.get(i).addStart(LocalDateTime.now());
                    }
                }
            }
        }
        else{
            addSI(new StatisticInfo(name));
            for (int i = 0; i < startStop.size(); i++) {
                if (startStop.get(i).sectionName == name) {
                    startStop.get(i).addStart(LocalDateTime.now());
                }
            }
        }
    }
    public static void exitSection(String name){
        for(int i = 0; i < startStop.size(); i++){
            if(startStop.get(i).sectionName == name){
                startStop.get(i).addFinish(LocalDateTime.now());
            }
        }
    }
    public static List<StatisticInfo> getStatisticInfo(){
        for(StatisticInfo s: Profiler.startStop){
            Duration a = Duration.between(s.getStart().get(0),s.getFinish().get(0));
            if(s.getStart().size()>1) {
                for (int i = 1; i < s.getStart().size(); i++) {
                    Duration b = Duration.between(s.getStart().get(i), s.getFinish().get(i));
                    a.plus(b);
                }
            }
            s.count = s.getStart().size();
            s.fullTime = (int) a.toMillis();
        }
        for(int i = 0; i < startStop.size(); i++){
            int sTime = startStop.get(i).fullTime;
            String id = startStop.get(i).getSectionID();
            for(int j = 0; j < startStop.size(); j++){
                if(startStop.get(j).getMasterID().equals(id)){
                    sTime -= startStop.get(j).fullTime;
                }
            }
            startStop.get(i).selfTime = sTime;
        }
        return startStop;
    }



}
