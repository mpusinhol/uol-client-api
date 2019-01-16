CREATE TABLE locations (
	id 				SERIAL NOT NULL,
	continent		VARCHAR(50) NOT NULL,
	country			VARCHAR(50) NOT NULL,
	subdivision_1	VARCHAR(50),
	subdivision_2	VARCHAR(50),
	city			VARCHAR(50) NOT NULL,
	latitute		DECIMAL NOT NULL,
	longitude		DECIMAL NOT NULL,
	created_at 		TIMESTAMP NOT NULL,
	
	CONSTRAINT pk_location PRIMARY KEY (id),
	CONSTRAINT uk_lat_long UNIQUE (latitute, longitude)
);

CREATE TABLE temperatures (
	id 				BIGSERIAL NOT NULL,
	date			DATE NOT NULL,
	maximum			DECIMAL NOT NULL,
	minimum			DECIMAL NOT NULL,
	location_id		SERIAL NOT NULL,
	
	CONSTRAINT pk_temperature PRIMARY KEY (id),
	CONSTRAINT fk_location FOREIGN KEY (location_id) REFERENCES locations (id),
	CONSTRAINT uk_daily_temp_location UNIQUE (date, location_id)
);

CREATE TABLE clients (
	id 				SERIAL NOT NULL,
	name 			VARCHAR(50) NOT NULL,
	age  			SMALLINT,
	created_at 		TIMESTAMP NOT NULL,
	updated_at 		TIMESTAMP NOT NULL,
	temperature_id 	BIGSERIAL NOT NULL,
	
	CONSTRAINT pk_client PRIMARY KEY (id),
	CONSTRAINT fk_temperature FOREIGN KEY (temperature_id) REFERENCES temperatures (id)
);