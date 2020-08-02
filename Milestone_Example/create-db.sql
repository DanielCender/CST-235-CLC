-- Create Schema
DROP TABLE IF EXISTS "GCU".Users;
DROP TABLE IF EXISTS "GCU".Posts;
DROP SCHEMA IF EXISTS "GCU"
RESTRICT;

-- SCHEMA: GCU

-- DROP SCHEMA "GCU" ;

CREATE SCHEMA "GCU"
    AUTHORIZATION postgres;

-- Create Tables

-- Table: GCU.users

-- DROP TABLE "GCU".users;

CREATE TABLE "GCU".users
(
	email character varying(200) COLLATE pg_catalog
	."default" NOT NULL,
    firstname character varying
	(50) COLLATE pg_catalog."default" NOT NULL,
    lastname character varying
	(50) COLLATE pg_catalog."default" NOT NULL,
    username character varying
	(50) COLLATE pg_catalog."default" NOT NULL,
    password character varying
	(200) COLLATE pg_catalog."default" NOT NULL,
    CONSTRAINT primary_key PRIMARY KEY
	(email)
)

TABLESPACE pg_default;

	ALTER TABLE "GCU".users
    OWNER to postgres;


	-- Table: GCU.posts

	-- DROP TABLE "GCU".posts;

	CREATE TABLE "GCU".posts
	(
		id integer NOT NULL
		GENERATED ALWAYS AS IDENTITY
		( INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 2147483647 CACHE 1 ),
    title character varying
		(255) COLLATE pg_catalog."default" NOT NULL,
    content text COLLATE pg_catalog."default" NOT NULL,
    authorid character varying
		(200) COLLATE pg_catalog."default" NOT NULL,
    CONSTRAINT post_author_id FOREIGN KEY
		(authorid)
        REFERENCES "GCU".users
		(email) MATCH SIMPLE
        ON
		UPDATE NO ACTION
        ON
		DELETE NO ACTION
)

TABLESPACE
		pg_default;

		ALTER TABLE "GCU".posts
    OWNER to postgres;
