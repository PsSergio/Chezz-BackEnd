create database chezz
use chezz

drop database chezz

create table Player (

	id bigint primary key AUTO_INCREMENT,
	email varchar(50) not null,
	password varchar(50) not null,
	username varchar(30) not null

)

create table MatchGame (

	id bigint primary key AUTO_INCREMENT,
	owner_id bigint not null,
	guest_id bigint,
	foreign key (owner_id) references Player(id),
	foreign key (guest_id) references Player(id)

)

create table SessionPlayer (

	id bigint primary key auto_increment,
	playerId bigint not null,
	init_date Date not null,
	final_date Date not null,
	foreign key (playerId) references Player(id)

)

select * from Player

-- Inserindo o primeiro jogador (Owner)
INSERT INTO Player (id, email, password, username)
VALUES (1, 'owner@example.com', 'password123', 'OwnerPlayer');

-- Inserindo o segundo jogador (Guest)
INSERT INTO Player (id, email, password, username)
VALUES (2, 'guest@example.com', 'password456', 'GuestPlayer');

-- Inserindo uma partida com o primeiro jogador como Owner e o segundo jogador como Guest
INSERT INTO MatchGame (id, owner_id, guest_id)
VALUES (1, 1, 2);
