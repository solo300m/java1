package ru.progwards.java1.lessons.datetime;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class StatisticInfo {
    public String sectionName;
    public int fullTime;
    public int selfTime;
    public int count;
    private String sectionID;
    private List<LocalDateTime> start;
    private List<LocalDateTime> finish;
    private List<Long> milis;
    private String masterID;
    private String slaveID;

    public StatisticInfo(String sectionName){
        this.sectionName = sectionName;
        this.sectionID = sectionName;
        this.masterID = "";
        this.slaveID = "";
        start = new ArrayList<>();
        finish = new ArrayList<>();
        milis = new ArrayList<>();
    }
    public StatisticInfo(String sectionName,String masterID){
        this.sectionName = sectionName;
        this.sectionID = sectionName;
        this.masterID = masterID;
        this.slaveID = "";
        start = new ArrayList<>();
        finish = new ArrayList<>();
        milis = new ArrayList<>();
    }
    public void addStart(LocalDateTime st1){
        start.add(st1);
    }
    public void addFinish(LocalDateTime fn1){
        finish.add(fn1);
    }
    public void addMilis(Long durMil){
        milis.add(durMil);
    }

    public List<LocalDateTime> getStart() {
        return start;
    }

    public List<LocalDateTime> getFinish() {
        return finish;
    }

    public List<Long> getMilis() {
        return milis;
    }

    public String getMasterID() {
        return masterID;
    }

    public String getSectionID() {
        return sectionID;
    }

    public String getSlaveID() {
        return slaveID;
    }

    @Override
    public String toString() {
        return  sectionName +
                ", sectionID=" + sectionID +
                ", start=" + start +
                ", finish=" + finish +
                ", masterID=" + masterID +
                ", slaveID=" + slaveID;
    }
}