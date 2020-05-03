package ru.progwards.java1.lessons.datetime;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;

class Prog{
    public static void main(String[] args) {
        SessionManager session = new SessionManager(10);
        session.add(new UserSession("Sergey"));
        session.add(new UserSession("Olga"));
        try {
            Thread.sleep(11000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        session.add(new UserSession("Nikita"));
        session.add(new UserSession("Anton"));
        for(int i = 0; i < session.getSessions().size(); i++)
            System.out.println(session.getSessions().get(i).toString());

        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(session.get(1761283695));
        try {
            Thread.sleep(11000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(session.get(1749940626));
        session.deleteExpired();
        for(int i = 0; i < session.getSessions().size(); i++)
            System.out.println(session.getSessions().get(i).toString());
        for(int i = 0; i < session.getSessions().size(); i++)
            System.out.println(session.getSessions().get(i).toString());
    }
}

public class SessionManager {
    private ArrayList<UserSession>sessions;
    private int sessionValid;

    public SessionManager(int sessionValid){
        this.sessions = new ArrayList<>();
        this.sessionValid = sessionValid;
    }

    public void add(UserSession userSession){
        this.sessions.add(userSession);
    }

    public UserSession find(String userName){
        for(int i = 0; i < this.sessions.size(); i++) {
            if(this.sessions.get(i).getUserName().equals(userName)) {
                LocalDateTime t_Session = this.sessions.get(i).getLastAccess();
                LocalDateTime t_Now = LocalDateTime.now();
                Duration t_Different = Duration.between(t_Session,t_Now);
                if(t_Different.toSeconds() <= this.sessionValid) {
                    this.sessions.get(i).updateLastAccess();
                    return this.sessions.get(i);
                }
                else
                    this.sessions.remove(i);
                    return null;
            }
        }
        return null;
    }

    public UserSession get(int sessionHandle){
        for(int i = 0; i < this.sessions.size(); i++) {
            if(this.sessions.get(i).getSessionHandle() == sessionHandle) {
                LocalDateTime t_Session = this.sessions.get(i).getLastAccess();
                LocalDateTime t_Now = LocalDateTime.now();
                Duration t_Different = Duration.between(t_Session,t_Now);
                if(t_Different.toSeconds() <= this.sessionValid) {
                    this.sessions.get(i).updateLastAccess();
                    return this.sessions.get(i);
                }
                else
                    this.sessions.remove(i);
                    return null;
            }
        }
        return null;
    }

    public void delete(int sessionHandle){
        for(int i = 0; i < this.sessions.size(); i++){
            if(this.sessions.get(i).getSessionHandle() == sessionHandle){
                this.sessions.remove(i);
            }
        }
    }

    public void deleteExpired(){
        for(int i = 0; i < this.sessions.size(); i++){
            LocalDateTime t_Session = this.sessions.get(i).getLastAccess();
            LocalDateTime t_Now = LocalDateTime.now();
            Duration t_Different = Duration.between(t_Session,t_Now);
            //System.out.println(t_Different.toSeconds()+" "+sessions.get(i).getUserName());
            if(t_Different.toSeconds() > this.sessionValid){
                this.sessions.remove(i);
            }
        }

    }

    public ArrayList<UserSession> getSessions() {
        return sessions;
    }
}
