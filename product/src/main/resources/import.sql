INSERT INTO CATEGORY (id, description) VALUES (1, 'Comic Books')
INSERT INTO CATEGORY (id, description) VALUES (2, 'Movies')
INSERT INTO CATEGORY (id, description) VALUES (3, 'Books')


INSERT INTO Supplier (id, name) VALUES (1, 'Panini Comics')
INSERT INTO Supplier (id, name) VALUES (2, 'Amazon')
INSERT INTO Supplier (id, name) VALUES (3, 'Livraria Online')


INSERT INTO Product (id, name, fk_category, fk_supplier, quantity_available) VALUES (1, 'Crise nas infinitas terras',1,1,10)
INSERT INTO Product (id, name,fk_category,fk_supplier,quantity_available) VALUES (2, 'Naruto',2,2,20)
INSERT INTO Product (id, name,fk_category,fk_supplier ,quantity_available) VALUES (3, 'One Puch Man',3,3,100)