CREATE DATABASE IF NOT EXISTS opencode
  DEFAULT CHARACTER SET utf8mb4
  DEFAULT COLLATE utf8mb4_unicode_ci;

USE opencode;

CREATE TABLE usuarios (
  id INT AUTO_INCREMENT PRIMARY KEY,
  nome VARCHAR(100) NOT NULL,
  email VARCHAR(150) NOT NULL UNIQUE,
  senha VARCHAR(255) NOT NULL,
  bio TEXT,
  criado_em TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE publicacoes (
  id INT AUTO_INCREMENT PRIMARY KEY,
  titulo VARCHAR(200) NOT NULL,
  descricao TEXT,
  tipo ENUM('Texto', 'Midia') NOT NULL,
  criado_em DATETIME DEFAULT CURRENT_TIMESTAMP,
  autor_id INT NOT NULL,
  FOREIGN KEY (autor_id) REFERENCES usuarios(id)
    ON DELETE CASCADE
);

CREATE TABLE midias (
  id INT AUTO_INCREMENT PRIMARY KEY,
  publicacao_id INT NOT NULL,
  caminho_arquivo VARCHAR(255) NOT NULL,
  tipo_midia ENUM('Imagem', 'Video') NOT NULL,
  FOREIGN KEY (publicacao_id) REFERENCES publicacoes(id)
    ON DELETE CASCADE
);

CREATE TABLE comentarios (
  id INT AUTO_INCREMENT PRIMARY KEY,
  texto TEXT NOT NULL,
  criado_em TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  publicacao_id INT NOT NULL,
  autor_id INT NOT NULL,
  FOREIGN KEY (publicacao_id) REFERENCES publicacoes(id)
    ON DELETE CASCADE,
  FOREIGN KEY (autor_id) REFERENCES usuarios(id)
    ON DELETE SET NULL
);

CREATE TABLE avaliacoes (
  id INT AUTO_INCREMENT PRIMARY KEY,
  tipo ENUM('LIKE', 'DISLIKE') NOT NULL,
  criado_em TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  publicacao_id INT NOT NULL,
  autor_id INT NOT NULL,
  FOREIGN KEY (publicacao_id) REFERENCES publicacoes(id)
    ON DELETE CASCADE,
  FOREIGN KEY (autor_id) REFERENCES usuarios(id)
    ON DELETE SET NULL,
  UNIQUE KEY unica_avaliacao (publicacao_id, autor_id)
);

INSERT INTO usuarios (nome, email, senha, bio) VALUES
('Alice', 'alice@email.com', '123', 'Dev Java e Spring Boot');