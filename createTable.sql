CREATE TABLE country_population (
    id INT AUTO_INCREMENT,          			
    country_name VARCHAR(100) NOT NULL,         
    population BIGINT NOT NULL,                 
    region VARCHAR(100),                        
    area DOUBLE,								
	PRIMARY KEY(id)
);