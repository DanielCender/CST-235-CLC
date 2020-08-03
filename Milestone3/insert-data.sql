-- Create Some Users
INSERT INTO GCU.Users
	(FirstName, MiddleInitial, LastName, Username, Password, Email)
VALUES
	('Daniel', 'R', 'Cender', 'daniel', '123456', 'dan@dan.com');
INSERT INTO GCU.Users
	(FirstName, MiddleInitial, LastName, Username, Password, Email)
VALUES
	('Eric', 'R', 'Erickson', 'ericson', '123456', 'e@gmail.com');

-- Create Some Tags - I know there's a more efficient method for this
INSERT INTO GCU.Tags
	(Name)
VALUES
	('education')
INSERT INTO GCU.Tags
	(Name)
VALUES
	('software development')
INSERT INTO GCU.Tags
	(Name)
VALUES
	('coding')
INSERT INTO GCU.Tags
	(Name)
VALUES
	('college life')

-- Create Some Posts
INSERT INTO GCU.Posts
	(Title, AuthorID, Content, Created, Updated)
VALUES
	('Click Funnel Strategies', 'e@gmail.com', 'Blog text....', DATETIME(), DATETIME());
INSERT INTO GCU.Posts
	(Title, AuthorID, Content, Created, Updated)
VALUES
	('Click Funnel Strategies', 'e@gmail.com', 'Blog text....', DATETIME(), DATETIME());


-- Create Some PostTags - need to revise
-- INSERT INTO GCU.PostTags
-- 	(PostID, TagID)
-- VALUES
-- 	()
