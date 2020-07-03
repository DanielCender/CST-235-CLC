-- Populate some entries for Users
INSERT INTO GCU.Users
	(FirstName, MiddleInitial, LastName, Username, Password, Email)
VALUES
	('Daniel', 'R', 'Cender', 'daniel', '123456', 'dan@dan.com');
INSERT INTO GCU.Users
	(FirstName, MiddleInitial, LastName, Username, Password, Email)
VALUES
	('Eric', 'R', 'Erickson', 'ericson', '123456', 'e@gmail.com');

-- Populate some entries for Books
INSERT INTO GCU.Books
	(Title, Author, ISBN, Publisher)
VALUES
	('To Kill A Mockingbird', 'Harper Lee', '1232-432432', 'Harper Collins');
INSERT INTO GCU.Books
	(Title, Author, ISBN, Publisher)
VALUES
	('The Fellowship of the Ring', 'J.R.R. Tokien', '1232-432433', 'Harper Collins');
INSERT INTO GCU.Books
	(Title, Author, ISBN, Publisher)
VALUES
	('The BFG', 'Roald Dahl', '1232-432443243', 'Harper Collins');
