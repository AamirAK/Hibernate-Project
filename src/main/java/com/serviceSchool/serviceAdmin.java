package com.serviceSchool;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.ModelSchool.modelS;
import com.ModelSchool.modelT;
import com.daoSchool.daoAdmin;

public class serviceAdmin {
    private Scanner sc;
    private Scanner ss;
    daoAdmin aDao;
    public serviceAdmin(){
        sc=new Scanner(System.in);
        ss=new Scanner(System.in);
        aDao=new daoAdmin();
    }
    public boolean login(){
        System.out.println("Enter Password");
        String p=ss.nextLine();
        modelT m=new modelT();
        boolean f=m.loginsuccess(p);
        return f;
    }
    public void addUser(){
        System.out.println("Enter Roll No");
        int r=sc.nextInt();
        System.out.println("Enter name");
        String nm=ss.nextLine();
        modelS s=new modelS();
        s.setRollno(r);
        s.setName(nm);
        aDao.insertUser(s);
    }
    public void addQues(){
        System.out.println("Enter question number");
        int qn=sc.nextInt();
        System.out.println("Enter Question");;
        String q=ss.nextLine();
        System.out.println("Enter marks");
        double m=sc.nextDouble();
        modelT t=new modelT();
        t.setQno(qn);
        t.setQues(q);
        t.setMarks(m);
        aDao.insertQues(t);
    }

    public void removeQues(){
        System.out.println("Enter question Number");
        int qn=sc.nextInt();
        aDao.deleteQues(qn);
    }

    public void showResult(){
        System.out.println("RollNo"+" "+"Name"+" "+"Marks");
        List<modelS> ls=new ArrayList<modelS>();
        ls=aDao.viewResult();
        for(modelS i:ls){
            System.out.println(i.toString());
        }
    }

    public void addMarks(){
        System.out.println("Enter Roll no");
        int r=sc.nextInt();
        System.out.println("Enter marks");
        double m=sc.nextDouble();
        aDao.updateMarks(r, m);
    }
}
