BEGIN TRANSACTION;

DROP TABLE IF EXISTS MT_user, deposits;
DROP SEQUENCE IF EXISTS seq_user_id;

CREATE SEQUENCE seq_user_id
  INCREMENT BY 1
  START WITH 1001
  NO MAXVALUE;

CREATE TABLE MT_user (
	user_id int NOT NULL DEFAULT nextval('seq_user_id'),
	full_name varchar(50) NOT NULL,
	username varchar(50) UNIQUE NOT NULL,
 	password_hash varchar(200) NOT NULL,
	role varchar(20),
	CONSTRAINT PK_MT_user PRIMARY KEY (user_id),
	CONSTRAINT UQ_username UNIQUE (username)
);

CREATE TABLE deposits (
	user_id int NOT NULL,
	depositor_id int,
	material_type varchar(50) NOT NULL,
	wood_type varchar(50),
	date date NOT NULL,
	hardware_weight int,
	deposit_weight int NOT NULL,
	donor_name varchar(50) NOT NULL,
	CONSTRAINT PK_deposits PRIMARY KEY (depositor_id),
	CONSTRAINT FK_deposits FOREIGN KEY (user_id) REFERENCES mt_user (user_id)
	
	
);

COMMIT;
