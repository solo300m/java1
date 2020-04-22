package ru.progwards.java1.lessons.queues;

public class AnalisSpeed {
        private String nameMetod;
        public long speed;
        public AnalisSpeed(String name){
            this.nameMetod = name;
            this.speed = 0L;
        }

        public String getNameMetod() {
            return nameMetod;
        }

        public long getSpeed() {
            return speed;
        }

        public void setSpeed(long speed) {
            this.speed = speed;
        }

        @Override
        public String toString() {
            return  "nameMetod= " + nameMetod + ", speed= " + speed;
        }
}


