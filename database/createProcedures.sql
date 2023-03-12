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
	-- Adds a company to the companyList table --
    CALL addCompanyList('Microsoft', 'Vancouver', getUserId("Bob"));
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
	-- Deletes a company from the companyList table --
    CALL deleteCompanyList('Microsoft', 'Vancouver', getUserId("Bob"));
*/

CREATE PROCEDURE deleteCompanyList (
  IN companyName VARCHAR(20),
  IN compLocation VARCHAR(20),
  IN userID INT
)
BEGIN
  DELETE FROM companyList WHERE userID = userID AND compLocation = compLocation AND compName = companyName;
END//

DELIMITER ;



DELIMITER //

/*
    -- Gets the ID of a user from the users table --
    SELECT getUserId("Bob"); -> returns the id of the user Bob as int
*/

CREATE FUNCTION getUserId (
  user VARCHAR(20)
)
RETURNS INT
DETERMINISTIC
BEGIN
  DECLARE userId INT;
  SELECT id INTO userId FROM users WHERE userName = user;
  RETURN userId;
END//

DELIMITER ;


