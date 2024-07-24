-- 1.	По идентификатору заказа получить данные заказа и данные клиента,  создавшего этот заказ
select
o.order_date as "Дата покупки",
f.flower as "Наименование",
f.price as "Стоимость",
o.count_buy as "Количество",
(f.price * o.count_buy) as "Итоговая стоимость",
c.client_name as "Покупатель",
c.client_phone as "Номер телефона"
from orders o
join clients c on c."id" = o.buyer
join  flowers f on f."id" = o.flower
where o.id = 1
-- 2.	Получить данные всех заказов одного клиента по идентификатору клиента за последний месяц
select
o.order_date as "Дата покупки",
f.flower as "Наименование",
f.price as "Стоимость",
o.count_buy as "Количество",
(f.price * o.count_buy) as "Итоговая стоимость",
c.client_name as "Покупатель",
c.client_phone as "Номер телефона"
from orders o
join clients c on c."id" = o.buyer
join  flowers f on f."id" = o.flower
where c.id = 3 and o.order_date >=now() - interval '1 month'
-- 3.	Найти заказ с максимальным количеством купленных цветов, вывести их название и количество
select
f.flower as "Наименование",
max(o.count_buy) as "Количество"
from flowers f join orders o
on f."id"=o.flower
group by f.flower
order by max(o.count_buy) desc
limit 1
-- 4.   Вывести общую выручку (сумму золотых монет по всем заказам) за все время
select sum(f.price * o.count_buy) as "Сумму золотых монет по всем заказам"
from orders o
join flowers f on o.id = f.id;