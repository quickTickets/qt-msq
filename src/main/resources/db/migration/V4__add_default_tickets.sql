INSERT INTO public.tickets (id, name, price)
VALUES ((select nextval('hibernate_sequence')), 'terminator', 5.10);

INSERT INTO public.tickets (id, name, price)
VALUES ((select nextval('hibernate_sequence')), 'vizivsii', '7.11');

COMMIT;