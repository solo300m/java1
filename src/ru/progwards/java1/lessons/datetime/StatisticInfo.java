package ru.progwards.java1.lessons.datetime;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class StatisticInfo {
    public String sectionName;
    public int fullTime;
    public int selfTime;
    public int count;
    private int sectionID;
    private List<LocalDateTime> start;
    private List<LocalDateTime> finish;
    private int masterID;
    private int slaveID;

    public StatisticInfo(String sectionName, int sectionID,
                         int masterID, int slaveID){
        this.sectionName = sectionName;
        this.sectionID = sectionID;
        this.masterID = masterID;
        this.slaveID = slaveID;
        start = new ArrayList<>();
        finish = new ArrayList<>();
    }
    public void addStart(LocalDateTime st1){
        start.add(st1);
    }
    public void addFinish(LocalDateTime fn1){
        finish.add(fn1);
    }

    public List<LocalDateTime> getStart() {
        return start;
    }

    public List<LocalDateTime> getFinish() {
        return finish;
    }

    public int getMasterID() {
        return masterID;
    }

    public int getSectionID() {
        return sectionID;
    }

    public int getSlaveID() {
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
