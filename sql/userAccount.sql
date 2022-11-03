-- Table: public.user_account

-- DROP TABLE IF EXISTS public.user_account;

CREATE TABLE IF NOT EXISTS public.user_account
(
    id integer NOT NULL,
    name character varying(255) COLLATE pg_catalog."default" NOT NULL,
    email character varying(255) COLLATE pg_catalog."default" NOT NULL,
    password character varying(80) COLLATE pg_catalog."default" NOT NULL,
    tenant_id integer NOT NULL,
    enabled boolean NOT NULL DEFAULT true,
    deleted boolean NOT NULL DEFAULT false,
    date_created timestamp without time zone NOT NULL,
    date_modified timestamp without time zone,
    area_permissions jsonb,
    settings jsonb NOT NULL,
    role character varying(80) COLLATE pg_catalog."default" NOT NULL,
    CONSTRAINT user_account_id PRIMARY KEY (id),
    CONSTRAINT user_account_email_tenant_id_key UNIQUE (email, tenant_id),
    CONSTRAINT user_account_tenant_id_fkey FOREIGN KEY (tenant_id)
        REFERENCES public.tenant (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.user_account
    OWNER to vishal;