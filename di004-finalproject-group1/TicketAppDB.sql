drop database ticketdb;
create database ticketdb;
use ticketdb;

create table venue(
venueName varchar(60) primary key,
capacity int);

insert into venue 
values('Apollo Theatre',500),
('WestEnd Theatre',250),
('Bixton O2', 1000),
('The Old Vic', 200),
('Rowan Way', 75),
('Brick Lane Theatre',45),
('Manchester Hippadrome',200),
('Edinburgh Central Theatre',176),
('Broad Street Theatre',83),
('Bristol Hippadrome',321);

create table seat(
seatId int primary key,
seatNumber int,
venueName varchar(60),
foreign key (venueName) references venue(venueName));

insert into seat
values(1,67,'Apollo Theatre'),
(2,68,'Apollo Theatre'),
(3,69,'Apollo Theatre'),
(4,70,'Apollo Theatre'),
(5,71,'Apollo Theatre'),
(6,72,'Apollo Theatre'),
(7,73,'Apollo Theatre'),
(8,13,'WestEnd Theatre'),
(9,14,'WestEnd Theatre'),
(10,15,'WestEnd Theatre'),
(11,16,'WestEnd Theatre'),
(12,17,'WestEnd Theatre'),
(13,103,'The Old Vic'),
(14,104,'The Old Vic'),
(15,105,'The Old Vic'),
(16,106,'The Old Vic'),
(17,107,'The Old Vic'),
(18,108,'The Old Vic'),
(19,109,'The Old Vic'),
(20,110,'The Old Vic'),
(21,111,'The Old Vic'),
(22,112,'The Old Vic'),
(23,113,'The Old Vic'),
(24,114,'The Old Vic'),
(25,01,'Rowan Way'),
(26,02,'Rowan Way'),
(27,03,'Rowan Way'),
(28,44,'Brick Lane Theatre'),
(29,45,'Brick Lane Theatre'),
(30, 05, 'Manchester Hippadrome'),
(31, 06, 'Manchester Hippadrome'),
(32, 07, 'Manchester Hippadrome'),
(33, 08, 'Manchester Hippadrome'),
(34, 09, 'Manchester Hippadrome'),
(35, 10, 'Manchester Hippadrome'),
(36, 140, 'Edinburgh Central Theatre'),
(37, 141, 'Edinburgh Central Theatre'),
(38, 142, 'Edinburgh Central Theatre'),
(39, 143, 'Edinburgh Central Theatre'),
(40, 144, 'Edinburgh Central Theatre'),
(41, 145, 'Edinburgh Central Theatre'),
(42, 146, 'Edinburgh Central Theatre'),
(43, 147, 'Edinburgh Central Theatre'),
(44,82,'Broad Street Theatre'),
(45,83,'Broad Street Theatre'),
(46, 77, 'Bristol Hippadrome'),
(47, 78, 'Bristol Hippadrome'),
(48, 79, 'Bristol Hippadrome'),
(49, 80, 'Bristol Hippadrome'),
(50, 81, 'Bristol Hippadrome'),
(51, 82, 'Bristol Hippadrome'),
(52, 83, 'Bristol Hippadrome'),
(53, 84, 'Bristol Hippadrome'),
(54, 85, 'Bristol Hippadrome'),
(55, 86, 'Bristol Hippadrome'),
(56, 87, 'Bristol Hippadrome');

create table ticket(
ticketId int primary key,
price double,
image varchar(250),
description varchar(200),
name varchar(35),
city varchar(25),
priceRange varchar(10),
date varchar(10),
venue varchar(60),
foreign key (venue) references venue(venueName)
);

insert into ticket
values(001,35.50,'https://britishtheatre.com/wp-content/uploads/2021/07/six-musical-vaudeville-theatre.jpg', 'Funny and light hearted! The perfect show!','SIX: The Musical', 'London','£30-£40','2023-08-08','Apollo Theatre'),
(002,55.75,'https://www.theatreroyal.org.uk/media/4dibwjfr/222_tour_social_media_assets_1920x1080_notext.jpg?width=845&height=622&rnd=133325106067770000', 'Very jumpy, will keep you guessing until the end','2:22', 'London','£50-£60','2023-10-12','WestEnd Theatre'),
(003,23.95,'https://upload.wikimedia.org/wikipedia/en/7/70/Tina_musical_poster.png', 'AMAZING! The best soundtrack you will hear all year','Tina: The Tina Turner Musical', 'London','£20-£30','2024-05-01','Bixton O2'),
(004,45.90,'https://media.wnyc.org/i/800/0/c/85/photologue/photos/bookofmormon.png', 'Outragously funny! Pushes the boundaries of comedy','The Book of Mormon', 'London','£40-£50','2024-05-12','The Old Vic'),
(005,18.50,'https://upload.wikimedia.org/wikipedia/en/0/0a/Cinderella_%28ALW_musical%29_poster.png', 'A new take on an old classic - fantasticly executed','Cinderella', 'London','£20-£30','2024-01-08','Rowan Way'),
(006, 20.99, 'https://valencia.berklee.edu/wp-content/files_mf/1519393739AChancetoDream.png', 'Concert for a Cause', 'Charity Concert', 'London', '£20-£30','2023-12-12','Brick Lane Theatre'),
(007, 29.50, 'https://images.app.goo.gl/xvDdAYXZmko1PXRg7', 'Art Exhibition', 'Artistic Expressions', 'Manchester', '£20-£30','2024-10-01','Manchester Hippadrome'),
(008, 30.50, 'https://images.app.goo.gl/9QjchHhU2rpH1cjG9', 'Theater Show', 'Drama in the Park', 'Edinburgh', '£30-£40','2023-09-11','Edinburgh Central Theatre'),
(009, 19.99, 'https://marketplace.canva.com/EAFHa7oiWLU/1/0/1131w/canva-black-modern-basketball-tournament-poster-portrait-9PYxBKhRiUU.jpg', 'Sports Event', 'Basketball Championship', 'Birmingham', '£15-£20','2024-03-12','Broad Street Theatre'),
(010, 50.99, 'https://images.app.goo.gl/H7BmqfqHuGkAYSBR6', 'Music Festival', 'Summer Beats Festival', 'Bristol', '£50-£60','2023-11-10','Bristol Hippadrome');

create table user(
username varchar(30) primary key,
firstName varchar(30),
lastName varchar(30),
password varchar(15),
email varchar(70)
);

insert into user values("jEdmonds","Juliet", "Edmonds", "jEdmonds123", "jEdmonds@gmail.com"),
("sBarnes","Sarah", "Barnes", "sBarnes678", "sBarnes@gmail.com"),
("lMoss","Lyndsey", "Moss", "lMoss456", "lMoss@gmail.com"),
("uWatts","Una", "Watts", "uWatts987", "uWatts@gmail.com"),
("cSampson","Christopher", "Sampson", "cSampson234", "cSampson@gmail.com");

create table admin(
adminUsername varchar(30) primary key,
password varchar(10)
);

insert into admin 
values('admin','admin');

create table basket (
basketId int primary key auto_increment,
username varchar(30),
ticketId int,
quantity int,
foreign key (username) references user(username),
foreign key (ticketId) references ticket(ticketId)
);



create table booking_seat(
seatId int,
basketId int,
foreign key (seatId) references seat(seatId),
foreign key (basketId) references basket(basketId),
constraint primary key(seatId, basketId));




create table review(
username varchar(30),
review varchar(250),
ticketId int,
reviewId int primary key,
foreign key (username) references user(username),
foreign key (ticketId) references ticket(ticketId)
);

INSERT INTO review (username, review, ticketId, reviewId)
VALUES 
  ('jEdmonds', 'Great show! Everything was perfect. Very gripping', 001, 1),
  ('sBarnes', 'The best evening at this show. I was there with family and we all loved it!', 002, 2),
  ('lMoss', 'Had some initial reservations about it, but by the second half I was obsessed.', 003, 3),
  ('uWatts', 'Not amazing, I thought the lead actor was not trying very hard.', 004, 4),
  ('cSampson', 'Just fantastic. Nothing more to say, you are missing out if you miss this', 005, 5);