import java.io.*;
import java.util.*;

class Food implements Serializable
{
int itemno;
int quantity;
float price;
Food(int itemno,int quantity)
{
this.itemno=itemno;
this.quantity=quantity;
switch(itemno)
{
case 1:price=quantity*220;
break;
case 2:price=quantity*259;
break;
case 3:price=quantity*125;
break;
case 4:price=quantity*150;
break;
}
}
}

class Service_Apartment implements Serializable
{
String name;
double contact;
String gender;
ArrayList<Food> food =new ArrayList<>();
Service_Apartment()
{
this.name="";
}
Service_Apartment(String name,double contact,String gender)
{
this.name=name;
this.contact=contact;
this.gender=gender;

}
}
class Atlantis extends Service_Apartment implements Serializable
{
String name2;
double contact2;
String gender2;
Atlantis()
{
this.name="";
this.name2="";
}
Atlantis(String name,double contact,String gender,String name2,double contact2,String
gender2)
{
this.name=name;
this.contact=contact;
this.gender=gender;
this.name2=name2;
this.contact2=contact2;
this.gender2=gender2;
}
}
class NotAvailable extends Exception
{
// @Override
public String toString()
{
return "Not Available !";
}
}
class Database implements Serializable
{
Atlantis firstclass_Atlantis[]=new Atlantis[10];
Atlantis businessclass_Atlantis[]=new Atlantis[20];
Service_Apartment firstclass_Service_Apartment[]=new Service_Apartment[10];
Service_Apartment businessclass_Service_Apartment[]=new Service_Apartment[20];
}
class Atlantis1
{
static Database database_obj=new Database();
static Scanner sc = new Scanner(System.in);
static void CustomerDetails(int i,int rn)
{

 String name, gender;
double contact;
String name2 = null;
double contact2 = 0;
String gender2="";
System.out.print("\nEnter customer name: ");
name = sc.next();
System.out.print("Enter contact number: ");
contact=sc.nextDouble();
System.out.print("Enter gender: ");
gender = sc.next();
if(i<3)
{
System.out.print("Enter second customer name: ");
name2 = sc.next();
System.out.print("Enter contact number: ");
contact2=sc.nextDouble();
System.out.print("Enter gender: ");
gender2 = sc.next();
}
switch (i) {
case 1:database_obj.firstclass_Atlantis[rn]=new
Atlantis(name,contact,gender,name2,contact2,gender2);
break;
case 2:database_obj.businessclass_Atlantis[rn]=new
Atlantis(name,contact,gender,name2,contact2,gender2);
break;
case 3:database_obj.firstclass_Service_Apartment[rn]=new
Service_Apartment(name,contact,gender);
break;
case 4:database_obj.businessclass_Service_Apartment[rn]=new
Service_Apartment(name,contact,gender);
break;
default:System.out.println("Wrong option");
break;
}
}

static void RoomPreferance(int i)
{
int j;
int rn;
System.out.println("\nChoose room number from : ");
switch (i) {
case 1:
for(j=0;j<database_obj.firstclass_Atlantis.length;j++)
{
if(database_obj.firstclass_Atlantis[j]==null)

{
System.out.print(j+1+",");
}
}
System.out.print("\nEnter room number: ");
try{
rn=sc.nextInt();
rn--;
if(database_obj.firstclass_Atlantis[rn]!=null)
throw new NotAvailable();
CustomerDetails(i,rn);
}
catch(Exception e)
{
System.out.println("Invalid Option");
return;
}
break;
case 2:
for(j=0;j<database_obj.businessclass_Atlantis.length;j++)
{
if(database_obj.businessclass_Atlantis[j]==null)
{
System.out.print(j+11+",");
}
}
System.out.print("\nEnter room number: ");
try{
rn=sc.nextInt();
rn=rn-11;
if(database_obj.businessclass_Atlantis[rn]!=null)
throw new NotAvailable();
CustomerDetails(i,rn);
}
catch(Exception e)
{
System.out.println("Invalid Option");
return;
}
break;
case 3:
for(j=0;j<database_obj.firstclass_Service_Apartment.length;j++)
{
if(database_obj.firstclass_Service_Apartment[j]==null)
{
System.out.print(j+31+",");
}
}
System.out.print("\nEnter room number: ");
try{

rn=sc.nextInt();
rn=rn-31;
if(database_obj.firstclass_Service_Apartment[rn]!=null)
throw new NotAvailable();
CustomerDetails(i,rn);
}
catch(Exception e)
{
System.out.println("Invalid Option");
return;
}
break;
case 4:
for(j=0;j<database_obj.businessclass_Service_Apartment.length;j++)
{
if(database_obj.businessclass_Service_Apartment[j]==null)
{
System.out.print(j+41+",");
}
}
System.out.print("\nEnter room number: ");
try{
rn=sc.nextInt();
rn=rn-41;
if(database_obj.businessclass_Service_Apartment[rn]!=null)
throw new NotAvailable();
CustomerDetails(i,rn);
}
catch(Exception e)
{
System.out.println("Invalid Option");
return;
}
break;
default:
System.out.println("Enter valid option");
break;
}
System.out.println("Room Booked");
}

static void RoomCatalogue(int i)
{
switch (i) {
case 1:System.out.println("Number of King size beds : 1\nSmoking room\nAC : Yes\nFree
breakfast, lunch & dinner : Yes\nCharge per day:4000 aed, Free access to spa ");
break;
case 2:System.out.println("Number of King size beds : 1\nSmoking room\nAC : No\nFree
breakfast : Yes\nCharge per day:3000 aed, Drinks on the house ");
break;
case 3:System.out.println("Number of Queen size beds : 1\nNon-Smoking room\nAC :
Yes\nFree breakfast, lunch & dinner : Yes\nCharge per day:2200 aed, Only Soft Drinks on the
house ");
break;
case 4:System.out.println("Number of Queen size beds : 1\nNon-Smoking room\nAC :
No\nFree breakfast : Yes\nCharge per day:1200 aed, complementary JetSkiing and Parasailing
");
break;
default:
System.out.println("Incorrect Option! Please enter a valid option");
break;
}
}
static void availability(int i)
{
int j,count=0;
switch (i) {
case 1:
for(j=0;j<10;j++)
{
if(database_obj.firstclass_Atlantis[j]==null)
count++;
}
break;
case 2:
for(j=0;j<database_obj.businessclass_Atlantis.length;j++)
{
if(database_obj.businessclass_Atlantis[j]==null)
count++;
}
break;
case 3:
for(j=0;j<database_obj.firstclass_Service_Apartment.length;j++)
{
if(database_obj.firstclass_Service_Apartment[j]==null)
count++;
}
break;
case 4:
for(j=0;j<database_obj.businessclass_Service_Apartment.length;j++)
{
if(database_obj.businessclass_Service_Apartment[j]==null)
count++;
}
break;
default:
System.out.println("Enter valid option");
break;
}
System.out.println("Number of rooms available : "+count);
}
static void Cheque(int rn,int rtype)
{
double amount=0;
String list[]={"Tiger Prawns ","Salmon with Caviar Biryani ","Rosemary
Lamb ","Wagyu Beef Sliders "};
System.out.println("\n*******");
System.out.println(" Cheque:-");
System.out.println("*******");
switch(rtype)
{
case 1:
amount+=4000;
System.out.println("\nPalace Charges - "+4000);
System.out.println("\n===============================================
====================================================");
System.out.println("Eatery Charges:- ");
System.out.println("================================================
=====================================================");
System.out.println("Commodity Quantity Cost");
System.out.println("------------------------------------------------------------------------------------
-----");
for(Food obb:database_obj.firstclass_Atlantis[rn].food)
{
amount+=obb.price;
String format = "%-10s%-10s%-10s%n";
System.out.printf(format,list[obb.itemno-1],obb.quantity,obb.price );
}
break;
case 2:amount+=3000;
System.out.println("Palace Charge - "+3000);
System.out.println("\nEatery Charges:- ");
System.out.println("================================================
===============================================");
System.out.println("Commodity Quantity Cost");
System.out.println("------------------------------------------------------------------------------------
-----");
for(Food obb:database_obj.businessclass_Atlantis[rn].food)
{
amount+=obb.price;
String format = "%-10s%-10s%-10s%n";
System.out.printf(format,list[obb.itemno-1],obb.quantity,obb.price );
}
break;
case 3:amount+=2200;
System.out.println("Palace Charge - "+2200);
System.out.println("\nEatery Charges:- ");
System.out.println("================================================
================================================");
System.out.println("Commodity Quantity Cost");
System.out.println("------------------------------------------------------------------------------------
---");
for(Food obb:database_obj.firstclass_Service_Apartment[rn].food)
{
amount+=obb.price;
String format = "%-10s%-10s%-10s%n";
System.out.printf(format,list[obb.itemno-1],obb.quantity,obb.price );
}
break;
case 4:amount+=1200;
System.out.println("Palace Charge - "+1200);
System.out.println("\nEatery Charges:- ");
System.out.println("================================================
===========================================");
System.out.println("Commodity Quantity Cost");
System.out.println("------------------------------------------------------------------------------------
---");
for(Food obb:database_obj.businessclass_Service_Apartment[rn].food)
{
amount+=obb.price;
String format = "%-10s%-10s%-10s%n";
System.out.printf(format,list[obb.itemno-1],obb.quantity,obb.price );
}
break;
default:
System.out.println("Not valid");
}
System.out.println("\nTotal Amount- "+amount);
}
static void Checkout(int rn,int rtype)
{
int j;
char w;
switch (rtype) {
case 1:
if(database_obj.firstclass_Atlantis[rn]!=null)
System.out.println("Room used by
"+database_obj.firstclass_Atlantis[rn].name);
else
{
System.out.println("Empty Already");
return;
}
System.out.println("Do you want to checkout ?(y/n)");
w=sc.next().charAt(0);
if(w=='y'||w=='Y')
{
Cheque(rn,rtype);
database_obj.firstclass_Atlantis[rn]=null;
System.out.println("Checkout succesfully done");
}
break;
case 2:
if(database_obj.businessclass_Atlantis[rn]!=null)
System.out.println("Room used by
"+database_obj.businessclass_Atlantis[rn].name);
else
{
System.out.println("Empty Already");
return;
}
System.out.println(" Do you want to checkout ?(y/n)");
w=sc.next().charAt(0);
if(w=='y'||w=='Y')
{
Cheque(rn,rtype);
database_obj.businessclass_Atlantis[rn]=null;
System.out.println("Checkout succesfully done");
}
break;
case 3:
if(database_obj.firstclass_Service_Apartment[rn]!=null)
System.out.println("Room used by
"+database_obj.firstclass_Service_Apartment[rn].name);
else
{
System.out.println("Empty Already");
return;
}
System.out.println(" Do you want to checkout ? (y/n)");
w=sc.next().charAt(0);
if(w=='y'||w=='Y')
{
Cheque(rn,rtype);
database_obj.firstclass_Service_Apartment[rn]=null;
System.out.println("Checkout succesfully done");
}
break;
case 4:
if(database_obj.businessclass_Service_Apartment[rn]!=null)
System.out.println("Room used by
"+database_obj.businessclass_Service_Apartment[rn].name);
else
{
System.out.println("Empty Already");
return;
}
System.out.println(" Do you want to checkout ? (y/n)");
w=sc.next().charAt(0);
if(w=='y'||w=='Y')
{
Cheque(rn,rtype);
database_obj.businessclass_Service_Apartment[rn]=null;
System.out.println("Checkout succesfully done");
}
break;
default:
System.out.println("\nEnter valid option : ");
break;
}
}
static void Request(int rn,int rtype)
{
int i,q;
char wish;
try{
System.out.println("\n=================================================\
n WELCOME TO NOBU
DUBAI \n=================================================\n\n 1.Tiger
Prawns AED 220\n 2.Salmon with Caviar AED 259\n 3.Rosemary
Lamb AED 125\n 4.Wagyu Beef Sliders AED 150\n");
do
{
i = sc.nextInt();
System.out.print("Quantity- ");
q=sc.nextInt();
switch(rtype){
case 1: database_obj.firstclass_Atlantis[rn].food.add(new Food(i,q));
break;
case 2: database_obj.businessclass_Atlantis[rn].food.add(new Food(i,q));
break;
case 3: database_obj.firstclass_Service_Apartment[rn].food.add(new Food(i,q));
break;
case 4: database_obj.businessclass_Service_Apartment[rn].food.add(new Food(i,q));
break;
}
System.out.println("Do you want to order anything else ? (y/n)");
wish=sc.next().charAt(0);
}while(wish=='y'||wish=='Y');
}
catch(NullPointerException e)
{
System.out.println("\nRoom not booked");
}
catch(Exception e)
{
System.out.println("Cannot be done");
}
}
}
class write implements Runnable
{
Database database_obj;
write(Database database_obj)
{
this.database_obj=database_obj;
}
@Override
public void run() {
try{
FileOutputStream fout=new FileOutputStream("backup");
ObjectOutputStream oos=new ObjectOutputStream(fout);
oos.writeObject(database_obj);
}
catch(Exception e)
{
System.out.println("Error in writing "+e);
}
}
}
class Main
{
public static void main(String[] args){
System.out.println("Welcome to the The Atlantis");
try
{
File f = new File("backup");
if(f.exists())
{
FileInputStream fin=new FileInputStream(f);
ObjectInputStream ois=new ObjectInputStream(fin);
Atlantis1.database_obj=(Database)ois.readObject();
}
Scanner sc = new Scanner(System.in);
int ch,ch2;
char wish;
x:
do{
System.out.println("\nEnter your choice :\n1.Room Details\n2.Room Availability
\n3.Book\n4.Order Food\n5.Checkout\n6.Exit\n");
ch = sc.nextInt();
switch(ch){
case 1: System.out.println("\nChoose room type :\n1.Firstclass Atlantis
\n2.Businessclass Atlantis \n3.Firstclass Service Apartment \n4.Businessclass Service
Apartment\n");
ch2 = sc.nextInt();
Atlantis1.RoomCatalogue(ch2);
break;
case 2:System.out.println("\nChoose room type :\n1.Firstclass Atlantis \n2.Businessclass
Atlantis \n3.Firstclass Service Apartment \n4.Businessclass Service Apartment\n");
ch2 = sc.nextInt();
Atlantis1.availability(ch2);
break;
case 3:System.out.println("\nChoose room type :\n1.Firstclass Atlantis \n2.Businessclass
Atlantis \n3.Firstclass Service Apartment \n4.Businessclass Service Apartment\n");
ch2 = sc.nextInt();
Atlantis1.RoomPreferance(ch2);
break;
case 4:
System.out.print("Room Number -");
ch2 = sc.nextInt();
if(ch2>60)
System.out.println("Room doesn't exist");
else if(ch2>40)
Atlantis1.Request(ch2-41,4);
else if(ch2>30)
Atlantis1.Request(ch2-31,3);
else if(ch2>10)
Atlantis1.Request(ch2-11,2);
else if(ch2>0)
Atlantis1.Request(ch2-1,1);
else
System.out.println("Room doesn't exist");
break;
case 5:

System.out.print("Room Number -");
ch2 = sc.nextInt();
if(ch2>60)
System.out.println("Room doesn't exist");
else if(ch2>40)
Atlantis1.Checkout(ch2-41,4);
else if(ch2>30)
Atlantis1.Checkout(ch2-31,3);
else if(ch2>10)
Atlantis1.Checkout(ch2-11,2);
else if(ch2>0)
Atlantis1.Checkout(ch2-1,1);
else
System.out.println("Room doesn't exist");
break;
case 6:break x;
}
System.out.println("\nContinue : (y/n)");
wish=sc.next().charAt(0);
if(!(wish=='y'||wish=='Y'||wish=='n'||wish=='N'))
{
System.out.println("Invalid Option");
System.out.println("\nContinue : (y/n)");
wish=sc.next().charAt(0);
}
}while(wish=='y'||wish=='Y');
Thread t=new Thread(new write(Atlantis1.database_obj));
t.start();
}
catch(Exception e)
{
System.out.println("Not a valid input");
}
}
}