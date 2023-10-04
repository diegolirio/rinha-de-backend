DROP TABLE IF EXISTS PUBLIC.PESSOAS;

CREATE TABLE PUBLIC.PESSOAS (
    ID uuid not null primary key,
    APELIDO varchar(32) unique not null,
    NASCIMENTO varchar(12) not null,
    NOME varchar(150) not null,
    STACK varchar(1000)
);

CREATE INDEX ANS_IDX ON PESSOAS (APELIDO, NOME, STACK);
-- CREATE INDEX ANS_IDX ON PESSOAS USING gin(APELIDO gin_trgm_ops, NOME gin_trgm_ops, STACK gin_trgm_ops);