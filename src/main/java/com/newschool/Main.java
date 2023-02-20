package com.newschool;

import java.util.Scanner;

import com.serviceSchool.serviceAdmin;
import com.serviceSchool.serviceS;

/**
 * Hello world!
 *
 */
public class Main 
{
    public static void main( String[] args )
    {
        //System.out.println( "Hello World!" );
        Scanner sc=new Scanner(System.in);
        serviceS s=new serviceS();
        serviceAdmin sa=new serviceAdmin();
        while(true){
            System.out.println("1...Student Login");
            System.out.println("2...Admin Login");
            System.out.println("3...Exit");
            int op=sc.nextInt();
            if(op==1){
                if(s.validateS()==true){
                    System.out.println("You Have Logged In Successfully\n");
                    while(true){
                        System.out.println("1...Start Exam");
                        System.out.println("2...View Result");
                        System.out.println("3...Logout");
                        int op1=sc.nextInt();
                        if(op1==1){
                            s.viewQues();
                        }else if(op1==2){
                            s.viewMarks();
                        }else if(op1==3){
                            break;
                        }
                    }
                    
                }else{
                    System.out.println("Wrong Credentials");
                }
            }else if(op==2){
                if(sa.login()==true){
                    System.out.println("----Login Successful----\n");
                    while(true){
                        System.out.println("1...Add user");
                        System.out.println("2...Add Questions");
                        System.out.println("3...Remove Question");
                        System.out.println("4...Update marks");
                        System.out.println("5...view Result");
                        System.out.println("6...Logout");
                        int op2=sc.nextInt();
                        if(op2==1){
                            sa.addUser();
                        }else if(op2==2){
                            sa.addQues();
                        }else if(op2==3){
                            sa.removeQues();
                        }else if(op2==4){
                            sa.addMarks();
                        }
                        else if(op2==5){
                            sa.showResult();
                        }else{
                            break;
                        }
                    }
                }else {
                    System.out.println("Student not found");
                }
            }else if(op==3){
                break;
            }
        }
    }
}