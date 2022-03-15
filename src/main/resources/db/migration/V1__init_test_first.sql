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
CREATE TABLE companies(
ID varchar  primary key auto_increment,
EVIDENCE_ID varchar (255),
NAME varchar (255),
STATUS varchar (255),
DESCRIPTION varchar (255),
COMPANY_ID varchar (255)
);
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
CREATE TABLE logbook(
ID varchar  primary key auto_increment,
LOG varchar (255)
);