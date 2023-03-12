CREATE DATABASE trackmate

CREATE TABLE users (
  id INT NOT NULL AUTO_INCREMENT,
  userName VARCHAR(20) NOT NULL,
  userPassword VARCHAR(20) NOT NULL,
  PRIMARY KEY (id)
);

/*
    -- INSERT into Users Table --
	INSERT INTO users (userName, userPassword)
    VALUES ('Bob', 'Password');

*/

CREATE TABLE companyList (
  compName VARCHAR(20) NOT NULL,
  compLocation VARCHAR(20) NOT NULL,
  compStatus tinyint(1) DEFAULT FALSE,
  userID INT NOT NULL
);

/*
	-- Insert into Company List Table--
	INSERT INTO companylist (compName, compLocation, userID)
	VALUES ('Microsoft', 'Vancouver', 1);
*/