create database Paymentapp;
Show Databases;
use Paymentapp;
create table User(UserId int NOT NULL, FirstName varchar(25)
,LastName varchar(25),Phoneno int, DateofBirth varchar(25)
,Address varchar(100),PassWord varchar(25),Wallet int, 
primary key(UserId));
show tables;
Select * from user;
drop table user;
describe user;
create table BankAccount(Bankacctno int NOT null , BankacctBankName varchar(25), Accttype varchar(10),
 BankIFSCCode varchar(25),BankacctPin Int, UserId int,BankBalance int,foreign key(UserId) references user(UserId),
 primary key(Bankacctno));
 describe BankAccount;
 drop table BankAccount;
 create table Transaction(TxnId varchar(30) not null,TxnDate Varchar (20),
 TxnAmount int, Txntype Varchar(20), TxnDestUserid int,UserId int,
 foreign key(UserId) references user(UserId), Primary key(TxnId));
  describe Transaction;
 drop table Transaction;