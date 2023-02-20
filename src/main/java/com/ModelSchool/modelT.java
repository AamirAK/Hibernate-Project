package com.ModelSchool;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

interface adminLogin {
    String password="admin@123"; 
    Boolean loginsuccess(String s);
}

@Entity
@Table(name="questions")
public class modelT implements adminLogin{
    @Id
    int qno;
    @Column(name="question")
    String ques;
    double marks;
    public int getQno() {
        return qno;
    }
    public void setQno(int qno) {
        this.qno = qno;
    }
    public String getQues() {
        return ques;
    }
    public void setQues(String ques) {
        this.ques = ques;
    }
    public double getMarks() {
        return marks;
    }
    public void setMarks(double marks) {
        this.marks = marks;
    }
    public String toString(){
        return ""+qno+". "+ques+"   "+marks+" marks";
    }

    public Boolean loginsuccess(String s) {
        // TODO Auto-generated method stub
        boolean b=false;
        if(s.equals(adminLogin.password)){
            b=true;
        }
        return b;
    }
}
