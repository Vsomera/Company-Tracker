DELIMITER //

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
