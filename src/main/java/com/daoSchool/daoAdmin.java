package com.daoSchool;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.ModelSchool.modelS;
import com.ModelSchool.modelT;

import dataConnect.connectS;

public class daoAdmin {
    SessionFactory fac;
    Session ses;
    Transaction tx;
    public daoAdmin(){
        fac=connectS.getConnection();
    }

    public void insertUser(modelS m){
        ses=fac.openSession();
        tx=ses.beginTransaction();
        modelS ms=new modelS();
        ms=ses.get(modelS.class,m.getRollno());
        if(ms!=null && ms.getName().equals(m.getName())){
            System.out.println("Student already added");
        }else {
            ses.save(m);
            tx.commit();
        }
        
    }

    public void insertQues(modelT t){
        ses=fac.openSession();
        tx=ses.beginTransaction();
        modelT ts=new modelT();
        ts=ses.get(modelT.class,t.getQno());
        if(ts!=null){
            System.out.println("Question number already present");
        }else{
            ses.save(t);
            tx.commit();
        }
    }

    public void deleteQues(int qn){
        ses=fac.openSession();
        tx=ses.beginTransaction();
        modelT ts=new modelT();
        ts=ses.get(modelT.class,qn);
        if(ts!=null){
            ses.delete(ts);
            tx.commit();
        }else{
            System.out.println("Question does not exist");
        }
    }

    public List<modelS> viewResult(){
        ses=fac.openSession();
        //tx=ses.beginTransaction();
        Query q=ses.createQuery("from modelS");
        List <modelS> l=q.list();
        return l;
    }

    public void updateMarks(int rn,double marks){
        ses=fac.openSession();
        tx=ses.beginTransaction();
        Query q=ses.createQuery("update modelS set result=:r where rollno=:p");
        q.setParameter("r",marks);
        q.setParameter("p",rn);
        q.executeUpdate();
        tx.commit();
    }
}
