
DROP DATABASE IF EXISTS pedidos;
DROP DATABASE IF EXISTS clientes;
DROP DATABASE IF EXISTS produtos;

CREATE DATABASE IF NOT EXISTS pedidos;
CREATE DATABASE IF NOT EXISTS clientes;
CREATE DATABASE IF NOT EXISTS produtos;

USE clientes;

CREATE TABLE clientes (
    codigo varchar(36) NOT NULL,
    primeiroNome varchar(255) NOT NULL,
    ultimoNome varchar(255) NOT NULL,
    email varchar(255),
    status varchar(255) NOT NULL,
	PRIMARY KEY (codigo)
);

INSERT INTO clientes (codigo, primeiroNome, ultimoNome, email, status) VALUES ("af8a7df4-7a1b-4f2f-b965-d9b090e67ec4", "Darice", "Pentecost", "dpentecost19@rakuten.co.jp", "INATIVO");

INSERT INTO clientes (codigo, primeiroNome, ultimoNome, email, status) VALUES ("7706dc25-c990-42cb-8938-c7662c6743c9", "Michael", "Thys", "mthysw@accuweather.com", "ATIVO");
 
INSERT INTO clientes (codigo, primeiroNome, ultimoNome, email, status) VALUES ("1ab8f0ac-c445-4e46-8eb6-5ec77bf24d8f", "Martelle", "Benez", "mbenez8@aol.com", "ATIVO");
 
INSERT INTO clientes (codigo, primeiroNome, ultimoNome, email, status) VALUES ("161f1664-1550-4d11-afae-a3dfa11c8542", "Patin", "Parkhouse", "pparkhouse10@shop-pro.jp", "ATIVO");
 
INSERT INTO clientes (codigo, primeiroNome, ultimoNome, email, status) VALUES ("5ef5d948-e641-4968-9f5c-96e3552bd033", "Michell", "Jaggers", "mjaggers6@spotify.com", "ATIVO");
 
INSERT INTO clientes (codigo, primeiroNome, ultimoNome, email, status) VALUES ("5269c190-f399-493f-acb5-df682ebab893", "Fayette", "Meeus", "fmeeus4@altervista.org", "INATIVO");
 
INSERT INTO clientes (codigo, primeiroNome, ultimoNome, email, status) VALUES ("da191feb-5d3d-4756-b149-e95aa321772f", "Andreas", "Davidsson", "adavidssoni@hp.com", "ATIVO");
 
INSERT INTO clientes (codigo, primeiroNome, ultimoNome, email, status) VALUES ("47f12704-a30c-4123-acb3-68739bf0d05e", "Kyle", "Simmance", "ksimmancef@sciencedirect.com", "ATIVO");
 
INSERT INTO clientes (codigo, primeiroNome, ultimoNome, email, status) VALUES ("3d55cbd0-3423-4345-8fc3-278324725a8b", "Maryanna", "Kelcey", "mkelceys@youtube.com", "ATIVO");
 
INSERT INTO clientes (codigo, primeiroNome, ultimoNome, email, status) VALUES ("2fb3232d-147b-4cb6-80b4-b7a8055fde30", "Billie", "Unwins", "bunwins11@chron.com", "ATIVO");
 
INSERT INTO clientes (codigo, primeiroNome, ultimoNome, email, status) VALUES ("378f4c88-ed30-4bd9-a8d6-8407d281bb56", "Patin", "Parkhouse", "pparkhouse10@shop-pro.jp", "ATIVO");
 
INSERT INTO clientes (codigo, primeiroNome, ultimoNome, email, status) VALUES ("08258671-5c33-4e31-b223-951c5e0bc973", "Fayette", "Meeus", "fmeeus4@altervista.org", "ATIVO");
 
INSERT INTO clientes (codigo, primeiroNome, ultimoNome, email, status) VALUES ("1cec8e41-1f35-42e4-b67a-fe01baf88859", "Brenda", "Kolin", "bkolinm@wiley.com", "ATIVO");
 
INSERT INTO clientes (codigo, primeiroNome, ultimoNome, email, status) VALUES ("7d38da93-03b2-44c7-b449-7aa278428aee", "Maible", "Norcross", "mnorcrossv@ftc.gov", "INATIVO");
 
INSERT INTO clientes (codigo, primeiroNome, ultimoNome, email, status) VALUES ("d9c6520c-90bf-464a-9817-0cedfa973d70", "Lilian", "Kither", "lkither15@geocities.jp", "ATIVO");
 
INSERT INTO clientes (codigo, primeiroNome, ultimoNome, email, status) VALUES ("715f4237-f86f-417b-8d07-902b3145a84c", "Filberto", "Breit", "fbreit13@nhs.uk", "ATIVO");
 
INSERT INTO clientes (codigo, primeiroNome, ultimoNome, email, status) VALUES ("08593e05-f3ba-418d-82a9-11395b28b011", "Martelle", "Benez", "mbenez8@aol.com", "ATIVO");
 
INSERT INTO clientes (codigo, primeiroNome, ultimoNome, email, status) VALUES ("e1c2eccc-a919-4885-870d-43f87beb2860", "Josepha", "Checkley", "jcheckley7@ning.com", "ATIVO");
 
INSERT INTO clientes (codigo, primeiroNome, ultimoNome, email, status) VALUES ("19b2313d-9b44-4903-a2bc-a14cddf097d5", "Shelly", "Dummett", "sdummettc@apple.com", "ATIVO");
 
INSERT INTO clientes (codigo, primeiroNome, ultimoNome, email, status) VALUES ("922b0d69-e27e-4bb4-8bad-64547b82d3d0", "Linzy", "McSorley", "lmcsorleyp@princeton.edu", "ATIVO");
 
INSERT INTO clientes (codigo, primeiroNome, ultimoNome, email, status) VALUES ("84fbd9ae-93d0-49ee-bd48-59332ed7a021", "Alessandra", "Drillingcourt", "adrillingcourt0@rediff.com", "INATIVO");
 
INSERT INTO clientes (codigo, primeiroNome, ultimoNome, email, status) VALUES ("c8dbe9b5-527d-4ac7-a02d-20e0ac504812", "Shelly", "Dummett", "sdummettc@apple.com", "ATIVO");
 
INSERT INTO clientes (codigo, primeiroNome, ultimoNome, email, status) VALUES ("d6e2e72d-abf3-475f-9d40-f8e0fea99710", "Olly", "Audley", "oaudley5@wp.com", "ATIVO");
 
INSERT INTO clientes (codigo, primeiroNome, ultimoNome, email, status) VALUES ("55fee601-e8ce-4d85-8b30-dc65a3efd98b", "Shelly", "Dummett", "sdummettc@apple.com", "ATIVO");
 
INSERT INTO clientes (codigo, primeiroNome, ultimoNome, email, status) VALUES ("725bba83-04f9-400e-9c41-7b4aa533f8d6", "Shelly", "Dummett", "sdummettc@apple.com", "ATIVO");
 
INSERT INTO clientes (codigo, primeiroNome, ultimoNome, email, status) VALUES ("17506df3-bf77-4d08-8ec7-e2677fd19def", "Evie", "Eldershaw", "eeldershaw14@netscape.com", "ATIVO");
 
INSERT INTO clientes (codigo, primeiroNome, ultimoNome, email, status) VALUES ("09f57423-3b58-4e87-a048-01993e5f2333", "Brenda", "Kolin", "bkolinm@wiley.com", "ATIVO");
 
INSERT INTO clientes (codigo, primeiroNome, ultimoNome, email, status) VALUES ("87d59fdd-0ead-4690-9c12-499acc09a29e", "Gert", "Parffrey", "gparffreye@hexun.com", "ATIVO");
 
INSERT INTO clientes (codigo, primeiroNome, ultimoNome, email, status) VALUES ("1d75de17-ff4c-4c77-8f6f-ef969c5dc4fa", "Zacharia", "Shatliff", "zshatliff16@zimbio.com", "ATIVO");
 
INSERT INTO clientes (codigo, primeiroNome, ultimoNome, email, status) VALUES ("ef83b696-9ccc-4834-a1ca-fa49688d5612", "Filberto", "Breit", "fbreit13@nhs.uk", "ATIVO");

INSERT INTO clientes (codigo, primeiroNome, ultimoNome, email, status) VALUES ("dee96573-48a2-408e-9a43-ed6d9af9895c", "Lauraine", "Widmoor", "lwidmoor9@woothemes.com", "ATIVO");
 
INSERT INTO clientes (codigo, primeiroNome, ultimoNome, email, status) VALUES ("f5aeb3d6-3433-4f40-a85c-4e93c8804bae", "Andreas", "Davidsson", "adavidssoni@hp.com", "BLOQUEADO");
 
INSERT INTO clientes (codigo, primeiroNome, ultimoNome, email, status) VALUES ("53b730b9-7b29-4812-9a73-6735f98372b1", "Shelly", "Dummett", "sdummettc@apple.com", "ATIVO");
 
INSERT INTO clientes (codigo, primeiroNome, ultimoNome, email, status) VALUES ("53954de6-57c0-4e6f-8a3f-de65425e1fa5", "Roxane", "Gewer", "rgewerb@cloudflare.com", "ATIVO");
 
INSERT INTO clientes (codigo, primeiroNome, ultimoNome, email, status) VALUES ("d014daba-c987-41ef-b009-6b18d13f9811", "Felicdad", "Tulloch", "ftulloch12@yellowpages.com", "BLOQUEADO");
 
INSERT INTO clientes (codigo, primeiroNome, ultimoNome, email, status) VALUES ("f575caa4-d995-4022-bc6d-09bf37df8ad6", "Kyle", "Simmance", "ksimmancef@sciencedirect.com", "ATIVO");
 
INSERT INTO clientes (codigo, primeiroNome, ultimoNome, email, status) VALUES ("024ee1b6-3a29-479f-91ee-dcb66586d514", "Darice", "Pentecost", "dpentecost19@rakuten.co.jp", "ATIVO");
 
INSERT INTO clientes (codigo, primeiroNome, ultimoNome, email, status) VALUES ("f7d29c28-491d-4ee6-98cd-4d5b0d5b00de", "Maybelle", "Handmore", "mhandmore17@mapquest.com", "ATIVO");
 
INSERT INTO clientes (codigo, primeiroNome, ultimoNome, email, status) VALUES ("077d5c5b-fcb9-4531-9225-780929f4d6cd", "Zacharia", "Shatliff", "zshatliff16@zimbio.com", "ATIVO");
 
INSERT INTO clientes (codigo, primeiroNome, ultimoNome, email, status) VALUES ("ef372a53-2346-47bf-8e35-b7a2506237bc", "Delmore", "Carnegie", "dcarnegieh@nps.gov", "ATIVO");
 
INSERT INTO clientes (codigo, primeiroNome, ultimoNome, email, status) VALUES ("01ff690a-ebe2-42b4-8347-52823d9d27e4", "Maryanna", "Kelcey", "mkelceys@youtube.com", "ATIVO");
 
INSERT INTO clientes (codigo, primeiroNome, ultimoNome, email, status) VALUES ("c397c072-5d27-498d-ae09-885f6b0c7d44", "Barnard", "Lang", "blangq@ezinearticles.com", "ATIVO");
 
INSERT INTO clientes (codigo, primeiroNome, ultimoNome, email, status) VALUES ("1a0ccd80-0067-4625-839c-f88c9a016c6b", "Blinnie", "Osmar", "bosmarj@artisteer.com", "ATIVO");
 
INSERT INTO clientes (codigo, primeiroNome, ultimoNome, email, status) VALUES ("34060e21-f4a0-4815-a2b0-981bea550dce", "Chere", "Campos", "ccampos1b@si.edu", "ATIVO");
 
INSERT INTO clientes (codigo, primeiroNome, ultimoNome, email, status) VALUES ("0fd457e6-5387-4d17-afa6-793803ebfd14", "Rahal", "Somerfield", "rsomerfieldo@xing.com", "BLOQUEADO");
 
INSERT INTO clientes (codigo, primeiroNome, ultimoNome, email, status) VALUES ("dc24d72a-0ab2-4197-873d-cbdc5ab6fc7a", "Chere", "Campos", "ccampos1b@si.edu", "ATIVO");
 
INSERT INTO clientes (codigo, primeiroNome, ultimoNome, email, status) VALUES ("b268b39e-cd6e-4e83-b1ab-fd879e2d5345", "Billie", "Unwins", "bunwins11@chron.com", "ATIVO");
 
INSERT INTO clientes (codigo, primeiroNome, ultimoNome, email, status) VALUES ("9f34fe11-6327-4f05-b61e-ae447de561f6", "Debor", "Spillett", "dspillettd@imgur.com", "ATIVO");
 
INSERT INTO clientes (codigo, primeiroNome, ultimoNome, email, status) VALUES ("e9bbeed8-ec64-4981-b926-78bf221eaed3", "Maybelle", "Handmore", "mhandmore17@mapquest.com", "ATIVO");
 
INSERT INTO clientes (codigo, primeiroNome, ultimoNome, email, status) VALUES ("6e6d5432-545c-4cfa-b72e-675bbbe0feb1", "Fran", "Solesbury", "fsolesburyt@a8.net", "INATIVO");
 
INSERT INTO clientes (codigo, primeiroNome, ultimoNome, email, status) VALUES ("9bb60564-efa0-4f7f-8121-8e156fae29f3", "Josepha", "Checkley", "jcheckley7@ning.com", "ATIVO");

USE produtos;

create table produtos (
    codigo varchar(255) not null,
    descricao varchar(255),
    quantidade decimal(19,2) UNSIGNED,
    valor decimal(19,2),
    primary key (codigo)
);

INSERT INTO produtos
(codigo, descricao, quantidade, valor)
VALUES('73d42efa-68d2-4296-ac1e-8201119adadc', 'Mochila de hidratacao', 1, 200.00);

INSERT INTO produtos
(codigo, descricao, quantidade, valor)
VALUES('cadeb8e6-9594-41af-8769-b083e897b4c1', 'Tenis de trilha', 1, 350.00);

