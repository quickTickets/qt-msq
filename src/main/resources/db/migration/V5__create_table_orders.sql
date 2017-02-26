CREATE TABLE public.orders
(
  id bigint NOT NULL,
  user_id bigint NOT NULL,
  ticket_id bigint NOT NULL,
  quantity integer NOT NULL,
  CONSTRAINT orders_pkey PRIMARY KEY (id),
  CONSTRAINT "fk_ticket_id" FOREIGN KEY ("ticket_id") REFERENCES "tickets" ("id"),
  CONSTRAINT "fk_user_id" FOREIGN KEY ("user_id") REFERENCES "users" ("id")
)
WITH (
OIDS=FALSE
);
ALTER TABLE public.orders
  OWNER TO root;