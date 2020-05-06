package ru.progwards.java1.lessons.datetime;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
class Statistica{
    public static void main(String[] args) {
        //Profiler a = new Profiler();
        Profiler.enterSection("S1");
        try{
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Profiler.exitSection("S1");
        /*for(int i=0; i < 5; i++){
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

        Profiler.enterSection("S5");
        try{
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Profiler.exitSection("S5");
        Profiler.enterSection("S6");
        try{
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Profiler.exitSection("S6");
        Profiler.enterSection("S1");
        try{
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Profiler.exitSection("S1");
        Profiler.enterSection("S5");
        try{
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Profiler.exitSection("S5");*/

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
        if(startStop == null){
            startStop = new ArrayList<StatisticInfo>();
        }
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
                boolean find2 = false;
                for(int i = startStop.size() - 1; i>=0; i--) {
                    if (startStop.get(i).getStart().size() > startStop.get(i).getFinish().size()) {
                        //System.out.println(startStop.get(i).getStart().size()+" "+startStop.get(i).getFinish().size());
                        String masterID = startStop.get(i).getSectionID();
                        //System.out.println(masterID);
                        addSI(new StatisticInfo(name, masterID));
                        find2 = true;
                        break;
                    }
                }
                for (int i = 0; i < startStop.size(); i++) {
                    if (startStop.get(i).sectionName == name) {
                        startStop.get(i).addStart(LocalDateTime.now());
                    }
                }
                if(find2 == false){
                    addSI(new StatisticInfo(name));
                    for (int i = 0; i < startStop.size(); i++) {
                        if (startStop.get(i).sectionName == name) {
                            startStop.get(i).addStart(LocalDateTime.now());
                        }
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
                Duration a = Duration.between(startStop.get(i).getStart().get(startStop.get(i).getStart().size()-1),
                        startStop.get(i).getFinish().get(startStop.get(i).getStart().size()-1));
                startStop.get(i).addMilis(a.toMillis());
                //System.out.println(a.toMillis());
            }
        }
    }
    public static List<StatisticInfo> getStatisticInfo(){
        for(StatisticInfo s: Profiler.startStop){
            Long a = s.getMilis().get(0);//Duration.between(s.getStart().get(0),s.getFinish().get(0));
            if(s.getMilis().size()>1) {
                for (int i = 1; i < s.getMilis().size(); i++) {
                    Long b = s.getMilis().get(i);//Duration.between(s.getStart().get(i), s.getFinish().get(i));
                    a += b;
                }
            }
            s.count = s.getStart().size();
            s.fullTime =  a.intValue();
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