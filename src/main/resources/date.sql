DELETE FROM outcoing_call_task;
DELETE FROM delivery_order;
DELETE FROM customer;

insert into customer (first_name, last_name, phone_number) values ('Bilbo', 'Baggins', '+79500834008');
insert into delivery_order (order_number, customer_id) values ('R-155/MK', 1);
insert into customer (first_name, last_name, phone_number) values ('Bruce', 'Banner', '+73186769321');
insert into delivery_order (order_number, customer_id) values ('TIH-05-1962', 2);
insert into customer (first_name, last_name, phone_number) values ('Wade', 'Wilson', '+77343362498');
insert into delivery_order (order_number, customer_id) values ('NM-03-1991', 2);
insert into customer (first_name, last_name, phone_number) values ('Peter', 'Parker', '+75615826988');
insert into delivery_order (order_number, customer_id) values ('AF-08-1962', 3);

insert into outgoing_call_task (delivery_order_id, create_at) values (1, '2020-01-01 10:10:10');