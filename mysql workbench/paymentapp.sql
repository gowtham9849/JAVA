create database Paymentapp;
Show Databases;
use Paymentapp;
CREATE TABLE User_Info (
    User_Id INT NOT NULL,
    First_Name VARCHAR(25),
    Last_Name VARCHAR(25),
    Phone_No varchar(15),
    Date_Of_Birth VARCHAR(25),
    Address VARCHAR(100),
    PassWord VARCHAR(25),
    Curr_Wallet_Balance double,
    PRIMARY KEY (User_Id)
);
show tables;
-- drop table User_Info;
describe User_Info;
CREATE TABLE Bank_Account_Details (
    Bank_AcctNo INT NOT NULL,
    Bank_AcctBankName VARCHAR(25),
    Acct_TypeId int,
    Bank_IFSC_Code VARCHAR(10),
    Bank_AcctPin INT,
    User_Id INT,
    Curr_Bank_Balance double,
    FOREIGN KEY (User_Id) REFERENCES User_Info (User_Id),
    FOREIGN KEY (Acct_TypeId) REFERENCES Acct_Types(Bank_AcctTypeId),
    PRIMARY KEY (Bank_AcctNo)
);
 describe BankAccount;
 -- drop table BankAccount;
 
 Create Table Acct_Types(
	Bank_AcctTypeId int NOT NULL,
    Bank_AcctTypeCode varchar(3),
    Bank_AcctTypeDesc varchar(20),
    primary Key (Bank_AcctTypeId)
 );
 drop table Acct_Types;
 CREATE TABLE Transaction (
    Txn_Id Int NOT NULL,
    Txn_Date date,
    Txn_Amount DOUBLE,
    Txn_Type Enum ("CREDIT","DEBIT"),
    Txn_AcctType enum("BANK_ACCOUNT","WALLET","CASH"),
    Txn_User_Id int,
    FOREIGN KEY (Txn_User_Id) REFERENCES User_Info (User_Id),
    PRIMARY KEY (Txn_Id)
);
  describe Transaction;
 drop table Transaction;