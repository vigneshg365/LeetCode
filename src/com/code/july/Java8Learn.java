package com.code.july;


import java.util.ArrayList;
import java.util.List;

final public class Java8Learn {

    public static void main(String[] args) {

       new Java8Learn().runClass();

    }

     protected void runClass() {

        List<? extends Animal> animalList = new ArrayList<>();
        //animalList.add(new Dog(1,"jimmy"));

    }




    private class Animal{
        public Animal() {
        }
    }

    private class Dog extends Animal{
        private long dId;
        private String collarName;

        public Dog(long dId, String collarName) {
            super();
            this.dId = dId;
            this.collarName = collarName;
        }

        public long getdId() {
            return dId;
        }

        public void setdId(long dId) {
            this.dId = dId;
        }

        public String getCollarName() {
            return collarName;
        }

        public void setCollarName(String collarName) {
            this.collarName = collarName;
        }
    }

    private class Cat extends Animal{
        private long collarId;
        private String cName;

        public Cat(long collarId, String cName) {
            super();
            this.collarId = collarId;
            this.cName = cName;
        }

        public long getCollarId() {
            return collarId;
        }

        public void setCollarId(long collarId) {
            this.collarId = collarId;
        }

        public String getcName() {
            return cName;
        }

        public void setcName(String cName) {
            this.cName = cName;
        }
    }
}
