DELIMITER //
/*
	-- Insert a user into the users table --
    CALL addUser('johndoe', 'password123');
*/

CREATE PROCEDURE addUser(
    IN p_userName VARCHAR(20),
    IN p_userPassword VARCHAR(20)
)
BEGIN
    INSERT INTO users (userName, userPassword)
    VALUES (p_userName, p_userPassword);
END//

DELIMITER ;



DELIMITER //
/*
	-- Insert a user into the users table --
    CALL addCompanyList('Microsoft', 'Vancouver');
*/

CREATE PROCEDURE addCompanyList (
  IN companyName VARCHAR(20),
  IN compLocation VARCHAR(20),
  IN userID INT
)
BEGIN
  INSERT INTO companyList (compName, compLocation, userID)
  VALUES (companyName, compLocation, userID);
END//

DELIMITER ;



DELIMITER //
/*
	-- Insert a user into the users table --
    CALL deleteCompanyList('Microsoft', 'Vancouver', );
*/

CREATE PROCEDURE deleteCompanyList (
  IN companyName VARCHAR(20),
  IN compLocation VARCHAR(20),
  IN userID INT
)
BEGIN
  DELETE FROM companyList WHERE userID = userID, compLocation = compLocation, compName = companyName;
END//

DELIMITER ;


DELIMITER //
/*
	-- Gets the ID of a user from the users table --
    CALL deleteCompanyList('Bob');
*/

CREATE PROCEDURE getUserId (
  IN user VARCHAR(20),
)
BEGIN
  SELECT id FROM users
  WHERE userName = user;
END//

DELIMITER ;