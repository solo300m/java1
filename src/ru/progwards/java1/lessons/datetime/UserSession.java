package ru.progwards.java1.lessons.datetime;

import java.time.LocalDateTime;
import java.util.Random;

public class UserSession {
    private int sessionHandle;
    private String userName;
    private LocalDateTime lastAccess;
    static private Random rand = new Random(1);

    public UserSession(String userName){
        this.userName = userName;
        this.sessionHandle = rand.nextInt();
        this.lastAccess = LocalDateTime.now();
    }
    public void updateLastAccess(){
        this.lastAccess = LocalDateTime.now();
    }

    public int getSessionHandle() {
        return sessionHandle;
    }

    public void setSessionHandle(int sessionHandle) {
        this.sessionHandle = sessionHandle;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public LocalDateTime getLastAccess() {
        return lastAccess;
    }

    public void setLastAccess(LocalDateTime lastAccess) {
        this.lastAccess = lastAccess;
    }

    @Override
    public String toString() {
        return "UserSession{" +
                "sessionHandle=" + sessionHandle +
                ", userName='" + userName + '\'' +
                ", lastAccess=" + lastAccess +
                '}';
    }
}