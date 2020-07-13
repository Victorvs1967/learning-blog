-- DROP SCHEMA public;

CREATE SCHEMA public AUTHORIZATION ykjqwjuxdkeiye;

COMMENT ON SCHEMA public IS 'standard public schema';

-- DROP TYPE _account;

CREATE TYPE _account (
	INPUT = array_in,
	OUTPUT = array_out,
	RECEIVE = array_recv,
	SEND = array_send,
	ANALYZE = array_typanalyze,
	ALIGNMENT = 8,
	STORAGE = any,
	CATEGORY = A,
	ELEMENT = account,
	DELIMITER = ',');

-- DROP TYPE _article;

CREATE TYPE _article (
	INPUT = array_in,
	OUTPUT = array_out,
	RECEIVE = array_recv,
	SEND = array_send,
	ANALYZE = array_typanalyze,
	ALIGNMENT = 8,
	STORAGE = any,
	CATEGORY = A,
	ELEMENT = article,
	DELIMITER = ',');

-- DROP TYPE _category;

CREATE TYPE _category (
	INPUT = array_in,
	OUTPUT = array_out,
	RECEIVE = array_recv,
	SEND = array_send,
	ANALYZE = array_typanalyze,
	ALIGNMENT = 8,
	STORAGE = any,
	CATEGORY = A,
	ELEMENT = category,
	DELIMITER = ',');

-- DROP TYPE _comment;

CREATE TYPE _comment (
	INPUT = array_in,
	OUTPUT = array_out,
	RECEIVE = array_recv,
	SEND = array_send,
	ANALYZE = array_typanalyze,
	ALIGNMENT = 8,
	STORAGE = any,
	CATEGORY = A,
	ELEMENT = comment,
	DELIMITER = ',');

-- DROP SEQUENCE public.account_seq;

CREATE SEQUENCE public.account_seq
	INCREMENT BY 1
	MINVALUE 1
	MAXVALUE 9223372036854775807
	START 1
	CACHE 1
	NO CYCLE;
-- DROP SEQUENCE public.comment_seq;

CREATE SEQUENCE public.comment_seq
	INCREMENT BY 1
	MINVALUE 1
	MAXVALUE 9223372036854775807
	START 1
	CACHE 1
	NO CYCLE;-- public.account definition

-- Drop table

-- DROP TABLE public.account;

CREATE TABLE public.account (
	id int8 NOT NULL,
	email varchar(255) NOT NULL,
	"name" varchar(50) NOT NULL,
	avatar varchar(255) NULL,
	created timestamptz NOT NULL DEFAULT now(),
	CONSTRAINT account_pkey PRIMARY KEY (id)
);


-- public.category definition

-- Drop table

-- DROP TABLE public.category;

CREATE TABLE public.category (
	id int8 NOT NULL,
	"name" varchar(50) NOT NULL,
	url varchar(50) NOT NULL,
	articles int4 NOT NULL DEFAULT 0,
	CONSTRAINT category_pkey PRIMARY KEY (id)
);


-- public.article definition

-- Drop table

-- DROP TABLE public.article;

CREATE TABLE public.article (
	id int8 NOT NULL,
	title varchar(255) NOT NULL,
	url varchar(255) NOT NULL,
	logo varchar(255) NOT NULL,
	description varchar(255) NOT NULL,
	"content" text NOT NULL,
	id_category int8 NOT NULL,
	created timestamptz NOT NULL DEFAULT now(),
	"views" int4 NOT NULL DEFAULT 0,
	"comments" int4 NOT NULL DEFAULT 0,
	CONSTRAINT article_pkey PRIMARY KEY (id),
	CONSTRAINT id_category FOREIGN KEY (id_category) REFERENCES category(id) ON UPDATE CASCADE ON DELETE RESTRICT NOT VALID
);
CREATE INDEX article_indx ON public.article USING btree (id_category);


-- public."comment" definition

-- Drop table

-- DROP TABLE public."comment";

CREATE TABLE public."comment" (
	id int8 NOT NULL,
	id_account int8 NOT NULL,
	id_article int8 NOT NULL,
	"content" text NOT NULL,
	created timestamptz NOT NULL DEFAULT now(),
	CONSTRAINT comment_pkey PRIMARY KEY (id),
	CONSTRAINT id_account FOREIGN KEY (id_account) REFERENCES account(id) ON UPDATE CASCADE ON DELETE RESTRICT NOT VALID,
	CONSTRAINT id_article FOREIGN KEY (id_article) REFERENCES article(id) ON UPDATE CASCADE ON DELETE RESTRICT NOT VALID
);
CREATE INDEX comment_indx ON public.comment USING btree (id_article);
CREATE INDEX comment_indx1 ON public.comment USING btree (id_account);


