--liquibase formatted sql

--changeset Bharat Solanki:1 failOnError=false

--comment: create table for request and response mapping mapping 

create table USER_INFO(
		USER_ID NUMBER GENERATED BY DEFAULT AS IDENTITY (START WITH 1) NOT NULL,
		EMAIL VARCHAR2(200),
		FULL_NAME VARCHAR2(200),
		USERNAME VARCHAR2(200),
		PASSWORD VARCHAR2(200),
		PHONE_NUMBER VARCHAR2(200),
		NATIONAL_ID VARCHAR2(250),
		DATE_OF_BIRTH DATE,
		NATIONALITY VARCHAR2(20),
		ROLE_ID VARCHAR2(50),
		CONSTRAINT PK_DAWY_USER_ID PRIMARY KEY (USER_ID)
)TABLESPACE NORA_DATA;


