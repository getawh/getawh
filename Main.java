package com.ghab.banking;
import java.util.*;

class away {

    Scanner input=new Scanner(System.in);

    private double balance[]=new double[1000];
    private int accountNumber[]=new int[1000];
    private String accountName[]=new String[1000];
    private long phoneNumber[]=new long[1000];
    private String job[]=new String[1000];
    private String sex[]=new String[1000];
    private int age[]=new int[1000];

    void createAccount(int i){
        Random rand=new Random();
        int acc=rand.nextInt(1000);
        acc+=100000;
        accountNumber[i]=acc;


        System.out.println("ENTER YOUR  NAME : ");
        accountName[i]=input.next();

        System.out.println("ENTER YOUR PHONE NUMBER : ");
        phoneNumber[i]=input.nextLong();
        while(phoneNumber[i]<900000000 || phoneNumber[i]>999999999){
            System.out.println("PLEASE ENTER VALID PHONE NUMBER!");
            phoneNumber[i]=input.nextInt();
        }

        System.out.println("ENTER YOUR SEX(1-for male   2-for female) : ");
        int temp=input.nextInt();
        while(temp != 1 && temp !=2){
            System.out.println("PLEASE ENTER VALID CHOICE!");
            temp=input.nextInt();
        }
        if (temp==1){
            sex[i]="male";
        }
        else{
            sex[i]="female";
        }

        System.out.println("ENTER YOUR AGE : ");
        age[i]=input.nextInt();

        System.out.println("ENTER YOUR JOB : ");
        job[i]=input.next();

        System.out.println("ENTER AMOUNT OF MONEY YOU WANT TO START WITH : ");
        balance[i]=input.nextDouble();


        System.out.println("CONGRATULATIONS "+accountName[i]+" YOU HAVE SUCCESSFULLY CREATED NEW ACCOUNT\n");
        System.out.println("CHECK YOUR DETAILS :\nACCOUNT NUMBER : "+accountNumber[i]+"\nNAME: "+accountName[i]+"\nPHONE NUMBER : 0"+phoneNumber[i]+
                "\nSEX : "+sex[i]+"\nAGE : "+age[i]+"\nJOB : "+job[i]+"\nCURRENT BALANCE : "+balance[i]);
        System.out.println("======PLEASE NOTE YOUR ACCOUNT NUMBER!! YOU WILL NOT SHOWN THE NUMBER AGAIN!!======\n");
    }
    void withdrawMoney(){
        System.out.println("ENTER YOUR ACCOUNT NUMBER : ");
        int temp=input.nextInt();
        boolean flag=false;
        int index=0;
        int subtraction=0;
        for (int element : accountNumber) {
            if (element == temp) {
                flag=true;
            }
        }
        if(flag==false){
            System.out.println("THERE IS NO ACCOUNT WITH THIS ACCOUNT NUMBER !\n\n");
        }
        else{
            for(int i=0;i<1000;i++){
                if(accountNumber[i]==temp){
                    index=i;
                    break;
                }
            }
            System.out.println("HELLO WELCOME BACK "+accountName[index]+" HOW MUCH BIRR DO YOU WANT TO WITHDRAW : ");
            subtraction=input.nextInt();
            while (subtraction != 0) {
                if ((balance[index] - subtraction) < 0) {
                    System.out.println("YOU DON'T HAVE ENOUGH AMOUNT OF MONEY TO DO THIS TASK! \n" +
                            "PLEASE ENTER LOWER VALUE! OR PRESS 0 TO EXIT TO MAIN MENU...");
                    subtraction = input.nextInt();
                } else {
                    balance[index] = balance[index] - subtraction;
                    System.out.println("YOU HAVE SUCCESSFULLY DEBITED "+subtraction+" BIRR FROM YOUR ACCOUNT! \n\n");
                    break;
                }
            }
        }
    }
    void depositMoney(){
        System.out.println("ENTER YOUR ACCOUNT NUMBER : ");
        int temp=input.nextInt();
        boolean flag=false;
        int index=0;
        int addition=0;
        for (int element : accountNumber) {
            if (element == temp) {
                flag=true;

            }
        }
        if(flag==false){
            System.out.println("THERE IS NO ACCOUNT WITH THIS ACCOUNT NUMBER !");
        }
        else{
            for(int i=0;i<1000;i++){
                if(accountNumber[i]==temp){
                    index=i;
                    break;
                }
            }
            System.out.println("HELLO WELCOME BACK "+accountName[index]+" HOW MANY BIRR DO YOU WANT TO DEPOSIT : ");
            addition=input.nextInt();
            balance[index]=balance[index]+addition;

            System.out.println("YOU HAVE SUCCESSFULLY CREDITED "+addition+" BIRR TO YOUR ACCOUNT! \n\n");
        }
    }
    void viewBalance() {
        System.out.println("ENTER YOUR ACCOUNT NUMBER : ");
        int temp = input.nextInt();
        boolean flag = false;
        int index = 0;
        for (int element : accountNumber) {
            if (element == temp) {
                flag = true;

            }
        }
        if (flag == false) {
            System.out.println("THERE IS NO ACCOUNT WITH THIS ACCOUNT NUMBER !");
        }
        else {
            for (int i = 0; i < 1000; i++) {
                if (accountNumber[i] == temp) {
                    index = i;
                    break;
                }
            }
            System.out.println("YOUR BALANCE IS : " + balance[index]+"\n\n");
        }
    }
    int checkMember(int temp){
        boolean flag = false;
        int index = 0;
        for (int element : accountNumber) {
            if (element == temp) {
                flag = true;
            }
        }

            while (flag == false) {

                    System.out.println("THERE IS NO ACCOUNT WITH THIS ACCOUNT NUMBER !");
                    temp = input.nextInt();
                    for (int element : accountNumber) {
                        if (element == temp) {
                            flag = true;
                        }
                    }
            }
            for (int i = 0; i < 1000; i++) {
                if (accountNumber[i] == temp) {
                    index = i;
                    break;
                }
            }
    return index;
    }


    void transferMoney(){
        int amount=0;
        System.out.println("ENTER YOUR ACCOUNT NUMBER : ");
        int temp = input.nextInt();
        int index = checkMember(temp);

        System.out.println("ENTER THE ACCOUNT YOU WANT TO TRANSFER TO : ");
        int transferTo = input.nextInt();
        int indexTo = checkMember(transferTo);

        System.out.println("ENTER THE AMOUNT OF MONEY YOU WANT TO TRANSFER : ");
        amount =input.nextInt();
        while (amount != 0) {
            if ((balance[index] - amount) < 0) {
                System.out.println("YOU DON'T HAVE ENOUGH AMOUNT OF MONEY TO DO THIS TASK! \n" +
                        "PLEASE ENTER LOWER VALUE! OR PRESS 0 TO EXIT TO MAIN MENU...");
                amount = input.nextInt();
            } else {
                balance[index] = balance[index] - amount;
                balance[indexTo]=balance[indexTo] + amount;
                System.out.println("YOU HAVE SUCCESSFULLY TRANSFERRED "+amount+" BIRR FROM YOUR ACCOUNT TO "+ accountName[indexTo]+" ! \n\n");
                break;
            }
        }
    }
}

public class Main {
    public static void main(String[] args) {
        // write your code here
        Scanner input = new Scanner(System.in);
        away access = new away();
        int x, counter = 0;
        boolean condition = true;
        System.out.println("WELCOME TO ASTU BANK!!\n");
        while (condition) {
            System.out.println("ENTER  :  \n1. TO CREATE ACCOUNT\t2. TO DEPOSIT MONEY \t3. TO VIEW BALANCE\n" +
                    "4.TO WITHDRAW MONEY \t 5. TO TRANSFER MONEY\t6. TO EXIT ");
            x = input.nextInt();
            switch (x) {
                case 1:
                    if (counter>0){
                        for (int i=0;i<50;i++){
                            System.out.println(" ");
                        }
                    }
                    access.createAccount(counter);
                    counter++;
                    break;
                case 2:
                        for (int i=0;i<50;i++){
                            System.out.println(" ");
                        }
                    access.depositMoney();
                    break;
                case 3:
                    for (int i=0;i<50;i++){
                        System.out.println(" ");
                    }
                    access.viewBalance();
                    break;
                case 4:
                    for (int i=0;i<50;i++){
                        System.out.println(" ");
                    }
                    access.withdrawMoney();
                    break;
                case 5:
                    for (int i=0;i<50;i++){
                        System.out.println(" ");
                    }
                    access.transferMoney();
                    break;
                case 6:
                    condition = false;
                    break;
                default:
                    System.out.println("PLEASE ENTER VALID KEY!!!");
            }
        }
    }
}
