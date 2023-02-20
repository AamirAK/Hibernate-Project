package com.serviceSchool;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.ModelSchool.modelS;
import com.ModelSchool.modelT;
import com.daoSchool.daoS;

public class serviceS {
    private Scanner sc;
    private Scanner ss;
    static int rn;
    static String n;
    daoS sDao;
    public serviceS(){
        sc=new Scanner(System.in);
        ss=new Scanner(System.in);
        sDao=new daoS();
    }
    public boolean validateS(){
        System.out.println("Enter rollno");
        rn=sc.nextInt();
        System.out.println("ENter name");
        n=ss.nextLine();
        boolean f=sDao.validateS(rn, n);
        return f;
    }

    public void viewQues(){
        System.out.println("----------Questions---------");
        List<modelT> l=new ArrayList<modelT>();
        l=sDao.showQues();
        for(modelT i:l){
            System.out.println(i.toString());
        }
    }

    public void viewMarks(){
        List<modelS> ms=new ArrayList<modelS>();
        ms=sDao.showMarks(rn);
        for(modelS i:ms){
            System.out.println(i.toString());
        }
    }

}
