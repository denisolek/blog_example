insert into users(id, username, password, display_name, description, created_at, updated_at) values (1,'admin', 'admin', 'Admin', 'Description of Admin', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);
insert into users(id, username, password, display_name, description, created_at, updated_at) values (2,'user', 'user', 'User One', 'Description of User One', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);
insert into users(id, username, password, display_name, description, created_at, updated_at) values (3,'user2', 'user2', 'User Two', 'Description of User Two', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);


insert into roles(id, name) values (1,'ROLE_ADMIN');
insert into roles(id, name) values (2,'ROLE_USER');

insert into user_role(user_id, role_id) values (1,1);
insert into user_role(user_id, role_id) values (1,2);
insert into user_role(user_id, role_id) values (2,2);
insert into user_role(user_id, role_id) values (3,2);

