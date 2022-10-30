CREATE TABLE IF NOT EXISTS public.sport (
    id serial,
    name text
);

ALTER TABLE IF EXISTS public.sport OWNER to postgres;