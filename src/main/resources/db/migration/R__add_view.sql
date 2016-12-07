-- View: public.current_date

-- DROP VIEW public.current_date;

CREATE OR REPLACE VIEW public.current_date AS
  SELECT 'now'::text::date AS date;

ALTER TABLE public.current_date
  OWNER TO root;
