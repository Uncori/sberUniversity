-- добавление в таблицу
insert into flowers (flower, price) values ('rose', 100);
insert into flowers (flower, price) values ('lily', 50);
insert into flowers (flower, price) values ('chamomile', 25);

insert into clients (client_name, client_phone) values ('Sveta', '+79234567345')
insert into clients (client_name, client_phone) values ('Jonny', '+79456575454')
insert into clients (client_name, client_phone) values ('Mama', '+79234537590')

insert into orders(order_date, buyer, flower, count_buy) values (now() - interval '24h', 1, 1, 10)
insert into orders(order_date, buyer, flower, count_buy) values (now() - interval '12h', 2, 2, 15)
insert into orders(order_date, buyer, flower, count_buy) values (now() - interval '6h', 3, 3, 250)