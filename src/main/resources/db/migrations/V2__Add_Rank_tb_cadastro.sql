-- v2 migration para adicionar coluna de ranking na tabela de cadastro

ALTER TABLE tb_cadastro
ADD COLUMN rank VARCHAR(255)
