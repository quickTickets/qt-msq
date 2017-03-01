CREATE TABLE public.tickets
(
  id bigint NOT NULL,
  name character varying(255),
  price decimal(7,2),
  CONSTRAINT tickets_pkey PRIMARY KEY (id)
)
WITH (
OIDS=FALSE
);
ALTER TABLE public.tickets
  OWNER TO postgres;
