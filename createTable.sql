CREATE TABLE country_population (
    id INT AUTO_INCREMENT,          			-- Identificador único para cada registro
    country_name VARCHAR(100) NOT NULL,         -- Nombre del país
    population BIGINT NOT NULL,                 -- Número de habitantes
    region VARCHAR(100),                        -- Región o continente (opcional)
    area DOUBLE,								-- Área del país en km² (opcional)
	PRIMARY KEY(id)
);