drop database if exists testticketdb;
create database testticketdb;
use testticketdb;

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


