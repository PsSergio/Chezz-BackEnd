create database chezz
use chezz

create table Player (

	id bigint primary key,
	email varchar(50) not null,
	password varchar(50) not null,
	username varchar(30) not null

)

create table MatchGame (

	id bigint primary key,
	owner_id bigint not null,
	guest_id bigint not null,
	foreign key (owner_id) references Player(id),
	foreign key (guest_id) references Player(id)

)