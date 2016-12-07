-- Table: public.users

-- DROP TABLE public.users;

CREATE TABLE public.users
(
  id bigint NOT NULL,
  password character varying(255),
  username character varying(255),
  CONSTRAINT users_pkey PRIMARY KEY (id)
)
WITH (
OIDS=FALSE
);
ALTER TABLE public.users
  OWNER TO root;

-- Sequence: public.hibernate_sequence
-- DROP SEQUENCE public.hibernate_sequence;

CREATE SEQUENCE public.hibernate_sequence
INCREMENT 1
MINVALUE 1
MAXVALUE 9223372036854775807
START 1
CACHE 1;
ALTER TABLE public.hibernate_sequence
  OWNER TO root;
