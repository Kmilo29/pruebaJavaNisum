CREATE TABLE USERS (
	id UUID PRIMARY KEY NOT NULL,
	name VARCHAR(100) NOT NULL,	
	email VARCHAR(100) UNIQUE NOT NULL,
	password VARCHAR(100) NOT NULL, 
	created DATE NOT NULL,
	modified DATE NOT NULL,
	last_login DATE NOT NULL,
	is_active BOOLEAN NOT NULL
);

CREATE TABLE SESSION ( 
   id UUID PRIMARY KEY NOT NULL, 
   token VARCHAR(300) NOT NULL, 
   created DATE NOT NULL,
   is_active BOOLEAN NOT NULL,
   user_id UUID NOT NULL
);

CREATE TABLE PHONE (
	id UUID PRIMARY KEY NOT NULL,
	number VARCHAR(20) NOT NULL,	
	city_code_id UUID NOT NULL,
	country_code_id UUID NOT NULL,
	user_id UUID NOT NULL
);

CREATE TABLE LOCATION ( 
   id UUID PRIMARY KEY NOT NULL, 
   type_location VARCHAR(100) NOT NULL, 
   name VARCHAR(100) NOT NULL, 
   code VARCHAR(10) NOT NULL, 
   parent_id UUID NULL
);

COMMIT;


ALTER TABLE session ADD CONSTRAINT fk_user_ss FOREIGN KEY (user_id) REFERENCES users (id);

ALTER TABLE phone ADD CONSTRAINT fk_city_code FOREIGN KEY (city_code_id) REFERENCES location (id);
ALTER TABLE phone ADD CONSTRAINT fk_country_code FOREIGN KEY (country_code_id) REFERENCES location (id);
ALTER TABLE phone ADD CONSTRAINT fk_user_ph FOREIGN KEY (user_id) REFERENCES users (id);

ALTER TABLE location ADD CONSTRAINT fk_parent FOREIGN KEY (parent_id) REFERENCES location (id);

COMMIT;