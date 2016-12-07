INSERT INTO public.users
  (id, password, username)
VALUES (0, 'root', 'root');

INSERT INTO public.users
(id, password, username)
VALUES
  ((select nextval('hibernate_sequence')),
   'admin',
   'admin');

COMMIT;
