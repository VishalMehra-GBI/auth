-- Table: public.tenant

-- DROP TABLE IF EXISTS public.tenant;

CREATE TABLE IF NOT EXISTS public.tenant
(
    id integer NOT NULL,
    name character varying(80) COLLATE pg_catalog."default" NOT NULL,
    enabled boolean NOT NULL DEFAULT true,
    company_name character varying(255) COLLATE pg_catalog."default" NOT NULL,
    active_key_1 character varying(255) COLLATE pg_catalog."default" NOT NULL,
    active_key_2 character varying(255) COLLATE pg_catalog."default",
    date_created timestamp without time zone NOT NULL,
    date_modified timestamp without time zone,
    settings jsonb NOT NULL,
    consul_name character varying COLLATE pg_catalog."default",
    modified_by integer,
    CONSTRAINT tenant_id PRIMARY KEY (id),
    CONSTRAINT tenant_name_key UNIQUE (name)
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.tenant
    OWNER to vishal;