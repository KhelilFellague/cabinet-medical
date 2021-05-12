/* 
 * Code PL/SQL pour creer les tables utilisés
 * 
 * pour la sequence id_patient_seq si elle existe déja elle doit etre supprimé 
 * 
 * pour le trigger il faut ajouter le / à la fin (meme si il y est deja) si il n'a pas été compilé 
 */
/* medecin*/
DROP TABLE IF EXISTS Medecin ;
CREATE TABLE Medecin (
id_user NUMBER (3) PRIMARY KEY NOT NULL,
login VARCHAR2 (8) NOT NULL UNIQUE,
mdp VARCHAR2 (8) NOT NULL,
nom VARCHAR2 (15) NOT NULL,
prenom VARCHAR2 (15) NOT NULL,
adresse VARCHAR2(50) NOT NULL,
num_tel NUMBER (10) NOT NULL,
email VARCHAR2 (30) NOT NULL,
specialite VARCHAR2 (90) NOT NULL,
adresse_cabinet VARCHAR2 (50) NOT NULL,
num_ordre VARCHAR2 (10) NOT NULL
);

/* Secretaire*/
DROP TABLE IF EXISTS Secretaire;
CREATE TABLE Secretaire (
id_user NUMBER (3) PRIMARY KEY NOT NULL,
login VARCHAR2 (8) NOT NULL UNIQUE,
mdp VARCHAR2 (8) NOT NULL,
nom VARCHAR2 (15) NOT NULL,
prenom VARCHAR2 (15) NOT NULL,
adresse VARCHAR2(50) NOT NULL,
num_tel NUMBER (10) NOT NULL,
email VARCHAR2 (30) NOT NULL
 );
/*
 * La secretaire et le medecin utilisé ici (peuvent etre changés)
 * 
 */
 
insert into Medecin values(1,'mohamed','1234','BACHIRI','Mohamed','Bab Ezzouar',0554647466,'mohamedB@gmail.com',
'Cardiologue spécialiste des maladies du coeur et des vaisseaux','Bab Ezzouar','00756/ALG');

insert into Secretaire values (2,'kahina','0000','ZAHRAOUI','Kahina','Alger Centre',0772345689,'Zah_kahina@gmail.com');

 
 /* patient*/
 DROP TABLE IF EXISTS Patient ;
CREATE TABLE Patient (
id_patient NUMBER (5) PRIMARY KEY NOT NULL,
nom VARCHAR2 (15) NOT NULL,
prenom VARCHAR2 (15) NOT NULL,
date_naissance Date NOT NULL,
sexe VARCHAR2(5) NOT NULL,
adresse VARCHAR2(50) NOT NULL,
num_tel NUMBER (10) NOT NULL,
email VARCHAR2 (30) NOT NULL
);

CREATE SEQUENCE id_patient_seq START WITH 1 INCREMENT BY 1  ;

CREATE OR REPLACE TRIGGER patient_tri
BEFORE INSERT ON Patient
FOR EACH ROW
BEGIN
  SELECT id_patient_seq.nextval
  INTO :new.id_patient
  FROM dual;
END;
/

/* rdv*/
DROP TABLE IF EXISTS Rdv;
CREATE TABLE Rdv
(
date_rdv Date NOT NULL,
heure_rdv VARCHAR2 (5) NOT NULL,
type VARCHAR2(30) NOT NULL,
id_patient NUMBER (5),
id_user NUMBER (3) DEFAULT 1,
FOREIGN KEY (id_patient)REFERENCES Patient ON DELETE SET NULL,
FOREIGN KEY (id_user)REFERENCES Medecin ON DELETE SET NULL,
constraint  pk_rdv  primary key (date_rdv,  heure_rdv)
);

/*
 * DOSSIER
 */
DROP TABLE IF EXISTS Dossier;
CREATE TABLE Dossier (
groupe_sanguin VARCHAR2 (3) NOT NULL,
taille VARCHAR2 (3) NOT NULL,
antecedants VARCHAR2(600) NOT NULL,
id_patient NUMBER (5) PRIMARY KEY NOT NULL,
FOREIGN KEY (id_patient)REFERENCES Patient ON DELETE CASCADE
);

/*
 * consultation
 */
DROP TABLE IF EXISTS Consultation;
CREATE TABLE Consultation (
id_consultation number(10) NOT NULL,
date_consultation Date NOT NULL,
heure_consultation VARCHAR2 (5) NOT NULL,
poids FLOAT(3),
glycemie FLOAT(3),
cholesterol FLOAT(3),
tension FLOAT(3),
maladies VARCHAR2(600),
observation VARCHAR2(600),
montant_paye FLOAT(4) NOT NULL,
id_patient number(5) NOT NULL,
FOREIGN KEY (id_patient)REFERENCES Dossier ON DELETE CASCADE,
constraint  pk_consultation  primary key (id_consultation,  id_patient)
);

/*
 * bilans
 */
DROP TABLE IF EXISTS Bilan;
CREATE TABLE Bilan (
id_bilan number(5) NOT NULL,
nom_bilan VARCHAR2 (300) NOT NULL,
resultat_bilan VARCHAR2 (300) NOT NULL,
id_consultation number(10) NOT NULL,
id_patient number(5) NOT NULL,
FOREIGN KEY (id_consultation,id_patient) REFERENCES Consultation(id_consultation,id_patient) ON DELETE CASCADE,
constraint  pk_Bilan primary key (id_bilan,  id_consultation)
);

/*
 * ordonnance*/
DROP TABLE IF EXISTS Ordonnance;
CREATE TABLE Ordonnance (
id_med number(5) NOT NULL,
nom_med VARCHAR2 (300) NOT NULL,
dosage_med number (4) NOT NULL,
dureeTraitement VARCHAR2 (300) NOT NULL,
posologie VARCHAR2 (300) NOT NULL,
id_consultation number(10),
id_patient number(5) NOT NULL,
FOREIGN KEY (id_consultation,id_patient) REFERENCES Consultation(id_consultation,id_patient) ON DELETE CASCADE,
constraint  pk_Ordonnance primary key (id_med,  id_consultation)
);
