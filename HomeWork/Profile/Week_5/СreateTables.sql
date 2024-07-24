-- создание таблицы, с условием не дублирования
create table if not exists flowers
(
    id          serial PRIMARY KEY,
    flower      varchar(100) UNIQUE check (flower <> '') NOT NULL,
    price       integer NOT NULL
);

create table if not exists clients
(
    id                 serial PRIMARY KEY,
    client_name        varchar(255) NOT NULL,
    client_phone       varchar(20)  NOT NULL
);

create table if not exists orders
(
    id             serial primary key,
    order_date     timestamp not null,
    buyer          int references clients("id") not null,
    flower         int references flowers("id") not null,
    count_buy      int check (count_buy > 0 and count_buy < 1001)
);
-- получение всей информации
select * from flowers;
select * from clients;
select * from orders;



