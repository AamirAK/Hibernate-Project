package com.ModelSchool;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="result")
public class modelS {
    @Id
    int rollno;
    String name;
    double result;
    public modelS(){
        result=0;
    }
    public int getRollno() {
        return rollno;
    }
    public void setRollno(int rollno) {
        this.rollno = rollno;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public double getResult() {
        return result;
    }
    public void setResult(double result) {
        this.result = result;
    }
    public String toString(){
        return ""+rollno+"  |"+name+" | "+result;
    }
}
