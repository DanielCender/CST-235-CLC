-- Populate some entries for Users
INSERT INTO "GCU".Users
	(FirstName, LastName, Username, Password, Email)
VALUES
	('Daniel', 'Cender', 'danc', 'danc', 'dan@gmail.com');
INSERT INTO "GCU".Users
	(FirstName, LastName, Username, Password, Email)
VALUES
	('Marc', 'Teixeira', 'marct', 'marct', 'marc@gmail.com');
INSERT INTO "GCU".Users
	(FirstName, LastName, Username, Password, Email)
VALUES
	('Tim', 'James', 'timj', 'timj', 'tim@gmail.com');
INSERT INTO "GCU".Users
	(FirstName, LastName, Username, Password, Email)
VALUES
	('Chance', 'Anderson', 'chancea', 'chancea', 'chance@gmail.com');

-- Populate some entries for Posts
INSERT INTO "GCU".Posts
	(Title, AuthorId, Content)
VALUES
	('Post 1', 'dan@gmail.com', 'Some post content')
INSERT INTO "GCU".Posts
	(Title, AuthorId, Content)
VALUES
	('To Kill A Mockingbird', 'dan@gmail.com', 'Some post content')
INSERT INTO "GCU".Posts
	(Title, AuthorId, Content)
VALUES
	('The Fellowship of the Ring', 'dan@gmail.com', 'Some post content')
INSERT INTO "GCU".Posts
	(Title, AuthorId, Content)
VALUES
	('The BFG', 'dan@gmail.com', 'Some post content')
