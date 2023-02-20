package dataConnect;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.ModelSchool.modelS;
import com.ModelSchool.modelT;



public class connectS {
    private static SessionFactory fac;
    private connectS(){
        try{
            fac=new Configuration().configure("hiber.cfg.xml")
        .addAnnotatedClass(modelS.class).addAnnotatedClass(modelT.class).buildSessionFactory();
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    public static SessionFactory getConnection(){
        connectS c=new connectS();
        return(fac);
    }
}
