CREATE DATABASE IF NOT EXISTS movies;

USE movies;

DROP TABLE IF EXISTS movies;

CREATE TABLE movies (
	id INT(10) NOT NULL AUTO_INCREMENT,
    title VARCHAR(50) NOT NULL,
    year INT(4) NOT NULL,
    genre VARCHAR(50) NOT NULL,
    PRIMARY KEY(id)
);

DESC movies;

-- Queries:

-- SELECT * FROM movies;

-- INSERT INTO movies(title, year, genre) values("The Usual Suspects", 1995, "Neo-Noir");

-- UPDATE movies SET title = 'Heat', year = 1995, genre = "Action" WHERE id = 3;

-- DELETE FROM movies WHERE ID = 2;

