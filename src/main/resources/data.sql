INSERT INTO CUSTOMER (ID, NAME, EMAIL, DOCUMENT, BIRTH_DATE, CUSTOMER_KIND) values
    (1, 'Fábio Ryan Vitor Duarte', 'ffabioryanvitorduarte@ibest.com.br', '26552382812', '1997-12-13', 1),
    (2, 'Alícia e André Vidros ME', 'contato@aliciaeandrevidrosme.com.br', '92284990000155', '2015-12-27', 2),
    (3, 'Tiago Luís Mendes', 'tmendes@gmail.com.br', '93374972802', '1957-12-26', 1);

INSERT INTO ADDRESS (CUSTOMER_ID, ZIP_CODE, STREET, NUMBER, COMPLEMENT, NEIGHBORHOOD, CITY, STATE) values
    (1, '01216971', 'Alameda Nothmann', 470, NULL, 'Campos Elíseos', 'São Paulo', 'SP'),
    (2, '01327000', 'Rua Treze de Maio', 372, 'CJ 200', 'Bela Vista', 'São Paulo', 'SP'),
    (3, '03738030', 'Rua Jorge Pimenta', 671, NULL, 'Vila Sampaio', 'São Paulo', 'SP');

INSERT INTO CUSTOMER_PHONES (CUSTOMER_ID, PHONES) values
    (1, '11985885460'),
    (2, '1126885413'),
    (3, '11999108300');