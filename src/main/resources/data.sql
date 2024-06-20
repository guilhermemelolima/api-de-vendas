-- Inserção de clientes na tabela 'cliente'
INSERT INTO cliente (cep, email, nome, numero)
VALUES
    ('12345678', 'cliente1@example.com', 'João Silva', '123'),
    ('23456789', 'cliente2@example.com', 'Maria Souza', '456'),
    ('34567890', 'cliente3@example.com', 'Pedro Oliveira', '789'),
    ('45678901', 'cliente4@example.com', 'Ana Santos', '1011'),
    ('56789012', 'cliente5@example.com', 'Carlos Ferreira', '1213'),
    ('67890123', 'cliente6@example.com', 'Manuel Silva', '1415'),
    ('78901234', 'cliente7@example.com', 'Mariana Costa', '1617'),
    ('89012345', 'cliente8@example.com', 'Ricardo Souza', '1819'),
    ('90123456', 'cliente9@example.com', 'Fernanda Oliveira', '2021'),
    ('01234567', 'cliente10@example.com', 'Luisa Santos', '2223');

INSERT INTO vendedor (nome, email) VALUES
    ('Fernando Silva', 'fernando.silva@example.com'),
    ('Mariana Oliveira', 'mariana.oliveira@example.com'),
    ('Rafael Souza', 'rafael.souza@example.com'),
    ('Juliana Santos', 'juliana.santos@example.com'),
    ('Carlos Ferreira', 'carlos.ferreira@example.com'),
    ('Aline Costa', 'aline.costa@example.com'),
    ('Pedro Martins', 'pedro.martins@example.com'),
    ('Ana Rodrigues', 'ana.rodrigues@example.com'),
    ('Lucas Almeida', 'lucas.almeida@example.com'),
    ('Isabela Pereira', 'isabela.pereira@example.com');

-- Inserção de produtos na tabela 'produto'
INSERT INTO produto (nome, descricao, quantidade_estoque, valor, status)
VALUES
    ('Produto A', 'Descrição do Produto A', 10, 50.0, 'EM_ESTOQUE'),
    ('Produto B', 'Descrição do Produto B', 5, 100.0, 'EM_ESTOQUE'),
    ('Produto C', 'Descrição do Produto C', 15, 75.0, 'FORA_DE_ESTOQUE'),
    ('Produto D', 'Descrição do Produto D', 20, 30.0, 'EM_ESTOQUE'),
    ('Produto E', 'Descrição do Produto E', 8, 200.0, 'EM_ESTOQUE'),
    ('Produto F', 'Descrição do Produto F', 12, 120.0, 'DISPONIVEL_PARA_RESERVA'),
    ('Produto G', 'Descrição do Produto G', 3, 90.0, 'EM_ESTOQUE'),
    ('Produto H', 'Descrição do Produto H', 7, 60.0, 'EM_ESTOQUE'),
    ('Produto I', 'Descrição do Produto I', 0, 25.0, 'FORA_DE_ESTOQUE'),
    ('Produto J', 'Descrição do Produto J', 9, 150.0, 'EM_ESTOQUE');


INSERT INTO pedido (id_cliente, data, status, id_vendedor)
VALUES
    (1, '2024-04-20', 'PENDENTE', 1),
    (2, '2024-06-15', 'CONFIRMADO', 2),
    (3, '2024-05-05', 'EM_PROCESSAMENTO', 3),
    (4, '2024-03-10', 'ENVIADO', 4),
    (5, '2024-02-01', 'ENTREGUE', 5),
    (6, '2024-07-18', 'CANCELADO', 6),
    (7, '2024-08-22', 'DEVOLVIDO', 7),
    (8, '2024-09-14', 'REEMBOLSADO', 8),
    (9, '2024-10-30', 'AGUARDANDO_PAGAMENTO', 9),
    (10, '2024-11-05', 'FALHA_PAGAMENTO', 10),
    (1, '2024-12-12', 'PENDENTE', 1),
    (2, '2024-01-25', 'CONFIRMADO', 2),
    (3, '2024-02-29', 'EM_PROCESSAMENTO', 3),
    (4, '2024-03-08', 'ENVIADO', 4),
    (5, '2024-04-01', 'ENTREGUE', 5),
    (6, '2024-05-12', 'CANCELADO', 6),
    (7, '2024-06-06', 'DEVOLVIDO', 7),
    (8, '2024-07-17', 'REEMBOLSADO', 8),
    (9, '2024-08-28', 'AGUARDANDO_PAGAMENTO', 9),
    (10, '2024-09-09', 'FALHA_PAGAMENTO', 10);


       --(5, DATE_ADD(CURRENT_DATE(), INTERVAL FLOOR(RAND() * 30) DAY));

-- Inserção de itens de pedido na tabela 'pedido_itens'
INSERT INTO pedido_itens (quantidade, id_pedido, id_produto)
VALUES
    (2, 1, 1),
    (3, 2, 2),
    (1, 3, 3),
    (2, 4, 1),
    (1, 5, 2),
    (2, 6, 3),
    (3, 7, 4),
    (1, 8, 5),
    (2, 9, 1),
    (1, 10, 2),
    (2, 11, 3),
    (3, 12, 4),
    (1, 13, 5),
    (2, 14, 1),
    (1, 15, 2),
    (2, 16, 3),
    (3, 17, 4),
    (1, 18, 5),
    (2, 19, 1),
    (1, 20, 2);

    INSERT INTO transportadora (nome, telefone)
    VALUES
        ('Breda', '1599999999'),
        ('JadLog', '1588888888'),
        ('Correios', '1577777777'),
        ('Fedex', '1566666666'),
        ('Dhl', '1555555555');