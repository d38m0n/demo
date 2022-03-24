DROP table if exists users;
CREATE TABLE users(
ID varchar  primary key auto_increment,
EMAIL varchar (255),
EVIDENCE_ID varchar (255),
IS_ACTIVE bit,
LOGIN varchar (255),
PSW varchar (255),
USER_ID varchar (255)
);
DROP table if exists companies;
CREATE TABLE companies(
ID varchar  primary key auto_increment,
EVIDENCE_ID varchar (255),
NAME varchar (255),
STATUS varchar (255),
DESCRIPTION varchar (255),
COMPANY_ID varchar (255)
);
DROP  table  if exists evidence;
CREATE TABLE evidence(
ID varchar  primary key auto_increment,
NAME varchar (255),
SURE_NAME varchar (255),
PESEL varchar (255),
SEX varchar (255),
STREET varchar (255),
CITY varchar (255),
COUNTRY varchar (255),
NIP varchar (255),
BRAND varchar (255),
LOGO_URL varchar (255)
);
DROP  table  if exists logbook;
CREATE TABLE logbook(
ID varchar  primary key auto_increment,
LOG varchar (255)
);
DROP table if exists items;
CREATE TABLE items(
ID varchar  primary key auto_increment,
BRAND varchar (255),
NAME varchar (255),
SN varchar (255),
MODEL varchar (255),
TYPE varchar (255),
STATUS varchar (255),
DESCRIPTION varchar (255),
isUsed bit
);
DROP table if exists jobsheets;
CREATE TABLE jobsheets(
ID varchar  primary key auto_increment,
DATE varchar (255),
TIME_STOP varchar (255),
TIME_START varchar (255),
TIME_DRIVE varchar (255),
DISTANCE varchar (255),
PROJECT_NUMBER varchar (255),
USER_ID varchar (255),
JOBSHEET_ID varchar (255),
STATUS varchar (255)
);
DROP table if exists clients;
CREATE TABLE clients(
ID varchar  primary key auto_increment,
CLIENT_ID varchar (255),
EVIDENCE_ID varchar (255),
DESCRIPTION_1 varchar (255),
DESCRIPTION_2 varchar (255),
IS_ACTIVE bit
);DROP table if exists orders;
CREATE TABLE orders(
ID varchar  primary key auto_increment,
ORDER_ID varchar (255),
CREATED_ON varchar (255),
UPDATED_ON varchar (255),
CLOSED_ON varchar (255),
STATUS varchar (255),
DESCRIPTION varchar (255)
);

