package com.daoSchool;

import java.util.List;



import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.ModelSchool.modelS;
import com.ModelSchool.modelT;

import dataConnect.connectS;

public class daoS {
    SessionFactory fac;
    Session ses;
    Transaction tx;
    public daoS(){
        fac=connectS.getConnection();
    }

    public boolean validateS(int rn,String nm){
        boolean f=false;
        try{
            ses=fac.openSession();
            modelS ms=new modelS();
            ms=ses.get(modelS.class,rn);
            if(ms!=null && ms.getName().equals(nm)){
                f=true;
            }
            // Query q=ses.createQuery("from student");
            // List <modelS> m=q.list();
            // for(modelS i:m){
            //     if(i.getRollno()==rn && i.getName().equals(nm)){
            //         f=true;
            //     }
            // }
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
        return f;
    }

    public List<modelT> showQues(){
        ses=fac.openSession();
        Query q=ses.createQuery("from modelT");
        List <modelT> ls=q.list();
        return ls;
    }

    public List<modelS> showMarks(int rn){
        ses=fac.openSession();
        Query q=ses.createQuery("from modelS where rollno=:r");
        q.setParameter("r",rn);
        List<modelS> lm=q.list();
        return lm;
    }
}
