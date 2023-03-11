DELIMITER //

CREATE PROCEDURE addUser(
    IN p_userName VARCHAR(8),
    IN p_userPassword VARCHAR(20)
)
BEGIN
    INSERT INTO users (userName, userPassword)
    VALUES (p_userName, p_userPassword);
END//

DELIMITER ;

/*
	-- Insert a user into the users table --
    CALL addUser('johndoe', 'password123');
*/
