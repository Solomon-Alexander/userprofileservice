insert into configuration(ID,NAME,TYPE_,VALUE_,ISACTIVE,APPLICATION_NAME) values(9999,'AppName','String','Url',1,'EnesApp');
insert into configuration(ID,NAME,TYPE_,VALUE_,ISACTIVE,APPLICATION_NAME) values(10000,'TimeOut','Integer','61',1,'EnesApp');
insert into configuration(ID,NAME,TYPE_,VALUE_,ISACTIVE,APPLICATION_NAME) values(10001,'Count','Double','100000',1,'SampleApp');
insert into configuration(ID,NAME,TYPE_,VALUE_,ISACTIVE,APPLICATION_NAME) values(10002,'IsChanged','Boolean','false',1,'EnesApp');

User Profile Microservice:
Tables needed:
1)USER
2)ROLE
3)USER_ROLE
4)GROUP
5)USER_GROUP
6)ORGANIZATION
7)USER_ORGANIZATION

CREATE TABLE ROLE(
   ID INT NOT NULL AUTO_INCREMENT,
   ROLE_NAME VARCHAR(50) NOT NULL,
   ROLE_DESCRIPTION VARCHAR(50),
   PRIMARY KEY ( ID )
);

CREATE TABLE GRP(
   ID INT NOT NULL AUTO_INCREMENT,
   GROUP_NAME VARCHAR(50) NOT NULL,
   GROUP_DESCRIPTION VARCHAR(50),
   PRIMARY KEY ( ID )
);

CREATE TABLE ORGANIZATION(
   ID INT NOT NULL AUTO_INCREMENT,
   ORG_NAME VARCHAR(50) NOT NULL,
   ABN VARCHAR(11) NOT NULL,
   STREET_1 VARCHAR(50),
   STREET_2 VARCHAR(50),
   CITY VARCHAR(50),
   STATE VARCHAR(50),
   POSTCODE VARCHAR(10),
   COUNTRY VARCHAR(50),
   PHONE VARCHAR(50),
   EMAIL VARCHAR(50),
   PRIMARY KEY ( ID )
);

CREATE TABLE USER(
   ID INT NOT NULL AUTO_INCREMENT,
   USER_NAME VARCHAR(50) NOT NULL,
   PASSWORD VARCHAR(15) NOT NULL,
   FIRST_NAME VARCHAR(50),
   LAST_NAME VARCHAR(50),
   STREET_1 VARCHAR(50),
   STREET_2 VARCHAR(50),
   CITY VARCHAR(50),
   STATE VARCHAR(50),
   POSTCODE VARCHAR(10),
   COUNTRY VARCHAR(50),
   PHONE VARCHAR(50),
   EMAIL VARCHAR(50),
   ACTIVE INT(1) DEFAULT 1 NOT NULL,
   PRIMARY KEY ( ID )
);

CREATE TABLE USER_ROLE(
   ID INT NOT NULL AUTO_INCREMENT,
   USER_ID INT NOT NULL,
   ROLE_ID INT NOT NULL,
   PRIMARY KEY ( ID ),
   FOREIGN KEY (USER_ID)
      REFERENCES USER(ID),
	 FOREIGN KEY (ROLE_ID)
      REFERENCES ROLE(ID)
);

CREATE TABLE USER_GROUP(
   ID INT NOT NULL AUTO_INCREMENT,
   USER_ID INT NOT NULL,
   GROUP_ID INT NOT NULL,
   PRIMARY KEY ( ID ),
   FOREIGN KEY (USER_ID)
      REFERENCES USER(ID),
	 FOREIGN KEY (GROUP_ID)
      REFERENCES GRP(ID)
);

CREATE TABLE USER_ORGANIZATION(
   ID INT NOT NULL AUTO_INCREMENT,
   USER_ID INT NOT NULL,
   ORGANIZATION_ID INT NOT NULL,
   PRIMARY KEY ( ID ),
   FOREIGN KEY (USER_ID)
      REFERENCES USER(ID),
	 FOREIGN KEY (ORGANIZATION_ID)
      REFERENCES ORGANIZATION(ID)
);

INSERT INTO ROLE VALUES (1,'REG_USER','Regular Public facing User');
INSERT INTO ROLE VALUES (2,'CEO','Chief Executive Officer');
INSERT INTO ROLE VALUES (3,'DEV','Developer');
INSERT INTO ROLE VALUES (4,'SENIOR_DEV','Senior Developer');
INSERT INTO ROLE VALUES (5,'SUPPORT_ANALYST','Support Analyst');

INSERT INTO GRP VALUES (1,'REG_GROUP','Regular Public facing User Group');
INSERT INTO GRP VALUES (2,'SUPER_ADMIN_GROUP','Super Admin User Group');
INSERT INTO GRP VALUES (3,'ORGANIZATION_ADMIN_GROUP','Admin User Group for an Organization');

INSERT INTO ORGANIZATION VALUES (1,'INNOVATIVE SOLUTIONS INC','01123456789','11 BOURKE STREET','','MELBOURNE','VIC','3000','AUSTRALIA','0416182811','info@innovativesolutions.com');
INSERT INTO ORGANIZATION VALUES (2,'IBM TECHNOLOGIES','01123456111','25 SWANSTON STREET','','MELBOURNE','VIC','3000','AUSTRALIA','0416182444','info@ibm.com');
INSERT INTO ORGANIZATION VALUES (3,'ORACLE CORPORATION','01123456333','32 COLLINS STREET','','MELBOURNE','VIC','3000','AUSTRALIA','0416182222','info@oracle.com');

INSERT INTO USER VALUES (1,'alexanders','password','Solomon','Alexander','11 EVADENE DR','','TARNEIT','VIC','3029','AUSTRALIA','0416182877','solomonprathap@gmail.com',1);
INSERT INTO USER VALUES (2,'thorpea','password','Abraham','Thorpe','15 BARKLEY ROAD','','ST KILDA','VIC','3205','AUSTRALIA','0416182811','abrahamthorpe@gmail.com',1);
INSERT INTO USER VALUES (3,'wangd','password','Denny','Wang','29 HOLLOWAY STREET','','ORMOND','VIC','3204','AUSTRALIA','0416182877','dennywang@gmail.com',1);

INSERT INTO ROLE VALUES (2,'CEO','Chief Executive Officer');
INSERT INTO ROLE VALUES (3,'DEV','Developer');
INSERT INTO ROLE VALUES (4,'SENIOR_DEV','Senior Developer');
INSERT INTO ROLE VALUES (5,'SUPPORT_ANALYST','Support Analyst');

INSERT INTO USER_ROLE VALUES (1,1,2);
INSERT INTO USER_ROLE VALUES (2,2,1);
INSERT INTO USER_ROLE VALUES (3,3,1);
INSERT INTO USER_ROLE VALUES (4,1,4);

INSERT INTO USER_GROUP VALUES (1,1,2);
INSERT INTO USER_GROUP VALUES (2,2,1);
INSERT INTO USER_GROUP VALUES (3,3,1);

INSERT INTO USER_ORGANIZATION VALUES (1,1,1);
INSERT INTO USER_ORGANIZATION VALUES (2,2,2);
INSERT INTO USER_ORGANIZATION VALUES (3,3,3);
