INSERT INTO user (id, e_mail, username, password, first_name, last_name, role)
              VALUES (1,'miroslav@maildrop.cc','miroslav','$2y$12$NH2KM2BJaBl.ik90Z1YqAOjoPgSd0ns/bF.7WedMxZ54OhWQNNnh6','Miroslav','Ilic','ADMIN');
INSERT INTO user (id, e_mail, username, password, first_name, last_name, role)
              VALUES (2,'tamara@maildrop.cc','tamara','$2y$12$DRhCpltZygkA7EZ2WeWIbewWBjLE0KYiUO.tHDUaJNMpsHxXEw9Ky','Tamara','Milosavljevic','USER');
INSERT INTO user (id, e_mail, username, password, first_name, last_name, role)
              VALUES (3,'petar@maildrop.cc','petar','$2y$12$i6/mU4w0HhG8RQRXHjNCa.tG2OwGSVXb0GYUnf8MZUdeadE4voHbC','Petar','Jovic','USER');
     
--AUDITORIUMS
INSERT INTO auditorium(id, name)  VALUES (1, "A1");            
INSERT INTO auditorium(id, name)  VALUES (2, "A2");            
INSERT INTO auditorium(id, name)  VALUES (3, "B1");            
INSERT INTO auditorium(id, name)  VALUES (4, "B2");            
     
--PROJECTION TYPES
INSERT INTO projection_type(id, type, auditorium_id) VALUES (1, "2D", 1);
INSERT INTO projection_type(id, type, auditorium_id) VALUES (2, "2D", 2);
INSERT INTO projection_type(id, type, auditorium_id) VALUES (3, "3D", 3);
INSERT INTO projection_type(id, type, auditorium_id) VALUES (4, "4D", 4);

--FILMS
INSERT INTO film(id, name, director, cast, length, distributor, country, year, about, poster_url) VALUES (1, "Pulp Fiction", "Quentin Tarantino", "John Travolta, Uma Thurman, Samuel L. Jackson", 154, "Miramax", "United States", 1994, "The lives of two mob hitmen, a boxer, a gangster and his wife, and a pair of diner bandits intertwine in four tales of violence and redemption.", "https://m.media-amazon.com/images/M/MV5BNGNhMDIzZTUtNTBlZi00MTRlLWFjM2ItYzViMjE3YzI5MjljXkEyXkFqcGdeQXVyNzkwMjQ5NzM@._V1_SX300.jpg");
INSERT INTO film(id, name, director, cast, length, distributor, country, year, about, poster_url) VALUES (2, "Reservoir Dogs", "Quentin Tarantino", "Harvey Keitel, Tim Roth, Michael Madsen", 99, "Miramax", "United States", 1992, "When a simple jewelry heist goes horribly wrong, the surviving criminals begin to suspect that one of them is a police informant.", "https://m.media-amazon.com/images/M/MV5BZmExNmEwYWItYmQzOS00YjA5LTk2MjktZjEyZDE1Y2QxNjA1XkEyXkFqcGdeQXVyMTQxNzMzNDI@._V1_SX300.jpg");
INSERT INTO film(id, name, director, cast, length, distributor, country, year, about, poster_url) VALUES (3, "Forrest Gump", "Robert Zemeckis", "Tom Hanks, Robin Wright, Gary Sinise", 144, "Paramount Pictures", "United States", 1994, "The history of the United States from the 1950s to the '70s unfolds from the perspective of an Alabama man with an IQ of 75, who yearns to be reunited with his childhood sweetheart.", "https://m.media-amazon.com/images/M/MV5BNWIwODRlZTUtY2U3ZS00Yzg1LWJhNzYtMmZiYmEyNmU1NjMzXkEyXkFqcGdeQXVyMTQxNzMzNDI@._V1_SX300.jpg");
INSERT INTO film(id, name, director, cast, length, distributor, country, year, about, poster_url) VALUES (4, "The Godfather", "Francis Ford Coppola", "Marlon Brando, Al Pacino, James Caan", 175, "Paramount Pictures", "United States", 1972, "Don Vito Corleone, head of a mafia family, decides to hand over his empire to his youngest son Michael. However, his decision unintentionally puts the lives of his loved ones in grave danger.", "https://m.media-amazon.com/images/M/MV5BM2MyNjYxNmUtYTAwNi00MTYxLWJmNWYtYzZlODY3ZTk3OTFlXkEyXkFqcGdeQXVyNzkwMjQ5NzM@._V1_SX300.jpg");
INSERT INTO film(id, name, director, cast, length, distributor, country, year, about, poster_url) VALUES (5, "The Lord of the Rings: The Return of the King", "Peter Jackson", "Elijah Wood, Viggo Mortensen, Ian McKellen", 201, "New Line Cinema", "United States", 2003, "Gandalf and Aragorn lead the World of Men against Sauron's army to draw his gaze from Frodo and Sam as they approach Mount Doom with the One Ring.", "https://m.media-amazon.com/images/M/MV5BNzA5ZDNlZWMtM2NhNS00NDJjLTk4NDItYTRmY2EwMWZlMTY3XkEyXkFqcGdeQXVyNzkwMjQ5NzM@._V1_SX300.jpg");

--GENRES
INSERT INTO genre(id, name) VALUES (1, "Action");
INSERT INTO genre(id, name) VALUES (2, "Adventure");
INSERT INTO genre(id, name) VALUES (3, "Drama");
INSERT INTO genre(id, name) VALUES (4, "Comedy");
INSERT INTO genre(id, name) VALUES (5, "Crime");
INSERT INTO genre(id, name) VALUES (6, "Horror");
INSERT INTO genre(id, name) VALUES (7, "Western");
INSERT INTO genre(id, name) VALUES (8, "Science Fiction");
INSERT INTO genre(id, name) VALUES (9, "Thriller");
INSERT INTO genre(id, name) VALUES (10, "Romance");
INSERT INTO genre(id, name) VALUES (11, "Fantasy");
INSERT INTO genre(id, name) VALUES (12, "Historical");
INSERT INTO genre(id, name) VALUES (13, "Mystery");

--MOVIES/GENRES
INSERT INTO film_genre(film_id, genre_id) VALUES (1, 3);
INSERT INTO film_genre(film_id, genre_id) VALUES (1, 5);
INSERT INTO film_genre(film_id, genre_id) VALUES (2, 5);
INSERT INTO film_genre(film_id, genre_id) VALUES (2, 9);
INSERT INTO film_genre(film_id, genre_id) VALUES (3, 3);
INSERT INTO film_genre(film_id, genre_id) VALUES (3, 10);
INSERT INTO film_genre(film_id, genre_id) VALUES (4, 3);
INSERT INTO film_genre(film_id, genre_id) VALUES (4, 5);
INSERT INTO film_genre(film_id, genre_id) VALUES (5, 1);
INSERT INTO film_genre(film_id, genre_id) VALUES (5, 2);
INSERT INTO film_genre(film_id, genre_id) VALUES (5, 3);


--PROJECTIONS
INSERT INTO projection(id, date_time, price, film_id, auditorium_id, projection_type_id) VALUES (1, "2023-01-01 18:00", 700.0, 1, 1, 1);
INSERT INTO projection(id, date_time, price, film_id, auditorium_id, projection_type_id) VALUES (2, "2023-01-01 18:30", 700.0, 2, 3, 2);
INSERT INTO projection(id, date_time, price, film_id, auditorium_id, projection_type_id) VALUES (3, "2023-01-02 15:00", 700.0, 1, 2, 1);
INSERT INTO projection(id, date_time, price, film_id, auditorium_id, projection_type_id) VALUES (4, "2023-01-02 19:30", 700.0, 2, 3, 2);
INSERT INTO projection(id, date_time, price, film_id, auditorium_id, projection_type_id) VALUES (5, "2023-01-03 12:00", 700.0, 1, 2, 1);
INSERT INTO projection(id, date_time, price, film_id, auditorium_id, projection_type_id) VALUES (6, "2023-01-03 15:00", 700.0, 1, 2, 1);
INSERT INTO projection(id, date_time, price, film_id, auditorium_id, projection_type_id) VALUES (7, "2023-01-03 14:00", 700.0, 3, 1, 1);
INSERT INTO projection(id, date_time, price, film_id, auditorium_id, projection_type_id) VALUES (8, "2023-01-03 20:15", 700.0, 4, 3, 2);
INSERT INTO projection(id, date_time, price, film_id, auditorium_id, projection_type_id) VALUES (9, "2023-01-04 18:00", 700.0, 3, 2, 1);
INSERT INTO projection(id, date_time, price, film_id, auditorium_id, projection_type_id) VALUES (10, "2023-01-04 16:45", 700.0, 4, 3, 2);
INSERT INTO projection(id, date_time, price, film_id, auditorium_id, projection_type_id) VALUES (11, "2023-01-05 18:00", 1200.0, 5, 4, 3);
INSERT INTO projection(id, date_time, price, film_id, auditorium_id, projection_type_id) VALUES (12, "2023-01-05 22:30", 1000.0, 5, 4, 3);


--SEATS
--A1
INSERT INTO seat(id, number, auditorium_id) VALUES (1, 1, 1);
INSERT INTO seat(id, number, auditorium_id) VALUES (2, 2, 1);
INSERT INTO seat(id, number, auditorium_id) VALUES (3, 3, 1);
INSERT INTO seat(id, number, auditorium_id) VALUES (4, 4, 1);
INSERT INTO seat(id, number, auditorium_id) VALUES (5, 5, 1);
INSERT INTO seat(id, number, auditorium_id) VALUES (6, 6, 1);
INSERT INTO seat(id, number, auditorium_id) VALUES (7, 7, 1);
INSERT INTO seat(id, number, auditorium_id) VALUES (8, 8, 1);
INSERT INTO seat(id, number, auditorium_id) VALUES (9, 9, 1);
INSERT INTO seat(id, number, auditorium_id) VALUES (10, 10, 1);
INSERT INTO seat(id, number, auditorium_id) VALUES (11, 11, 1);
INSERT INTO seat(id, number, auditorium_id) VALUES (12, 12, 1);
INSERT INTO seat(id, number, auditorium_id) VALUES (13, 13, 1);
INSERT INTO seat(id, number, auditorium_id) VALUES (14, 14, 1);
INSERT INTO seat(id, number, auditorium_id) VALUES (15, 15, 1);
INSERT INTO seat(id, number, auditorium_id) VALUES (16, 16, 1);
INSERT INTO seat(id, number, auditorium_id) VALUES (17, 17, 1);
INSERT INTO seat(id, number, auditorium_id) VALUES (18, 18, 1);
INSERT INTO seat(id, number, auditorium_id) VALUES (19, 19, 1);
INSERT INTO seat(id, number, auditorium_id) VALUES (20, 20, 1);
--A2
INSERT INTO seat(id, number, auditorium_id) VALUES (21, 1, 2);
INSERT INTO seat(id, number, auditorium_id) VALUES (22, 2, 2);
INSERT INTO seat(id, number, auditorium_id) VALUES (23, 3, 2);
INSERT INTO seat(id, number, auditorium_id) VALUES (24, 4, 2);
INSERT INTO seat(id, number, auditorium_id) VALUES (25, 5, 2);
INSERT INTO seat(id, number, auditorium_id) VALUES (26, 6, 2);
INSERT INTO seat(id, number, auditorium_id) VALUES (27, 7, 2);
INSERT INTO seat(id, number, auditorium_id) VALUES (28, 8, 2);
INSERT INTO seat(id, number, auditorium_id) VALUES (29, 9, 2);
INSERT INTO seat(id, number, auditorium_id) VALUES (30, 10, 2);
INSERT INTO seat(id, number, auditorium_id) VALUES (31, 11, 2);
INSERT INTO seat(id, number, auditorium_id) VALUES (32, 12, 2);
INSERT INTO seat(id, number, auditorium_id) VALUES (33, 13, 2);
INSERT INTO seat(id, number, auditorium_id) VALUES (34, 14, 2);
INSERT INTO seat(id, number, auditorium_id) VALUES (35, 15, 2);
INSERT INTO seat(id, number, auditorium_id) VALUES (36, 16, 2);
INSERT INTO seat(id, number, auditorium_id) VALUES (37, 17, 2);
INSERT INTO seat(id, number, auditorium_id) VALUES (38, 18, 2);
INSERT INTO seat(id, number, auditorium_id) VALUES (39, 19, 2);
INSERT INTO seat(id, number, auditorium_id) VALUES (40, 20, 2);
--B1
INSERT INTO seat(id, number, auditorium_id) VALUES (41, 1, 3);
INSERT INTO seat(id, number, auditorium_id) VALUES (42, 2, 3);
INSERT INTO seat(id, number, auditorium_id) VALUES (43, 3, 3);
INSERT INTO seat(id, number, auditorium_id) VALUES (44, 4, 3);
INSERT INTO seat(id, number, auditorium_id) VALUES (45, 5, 3);
INSERT INTO seat(id, number, auditorium_id) VALUES (46, 6, 3);
INSERT INTO seat(id, number, auditorium_id) VALUES (47, 7, 3);
INSERT INTO seat(id, number, auditorium_id) VALUES (48, 8, 3);
INSERT INTO seat(id, number, auditorium_id) VALUES (49, 9, 3);
INSERT INTO seat(id, number, auditorium_id) VALUES (50, 10, 3);
INSERT INTO seat(id, number, auditorium_id) VALUES (51, 11, 3);
INSERT INTO seat(id, number, auditorium_id) VALUES (52, 12, 3);
INSERT INTO seat(id, number, auditorium_id) VALUES (53, 13, 3);
INSERT INTO seat(id, number, auditorium_id) VALUES (54, 14, 3);
INSERT INTO seat(id, number, auditorium_id) VALUES (55, 15, 3);
INSERT INTO seat(id, number, auditorium_id) VALUES (56, 16, 3);
INSERT INTO seat(id, number, auditorium_id) VALUES (57, 17, 3);
INSERT INTO seat(id, number, auditorium_id) VALUES (58, 18, 3);
INSERT INTO seat(id, number, auditorium_id) VALUES (59, 19, 3);
INSERT INTO seat(id, number, auditorium_id) VALUES (60, 20, 3);
--B2
INSERT INTO seat(id, number, auditorium_id) VALUES (61, 1, 4);
INSERT INTO seat(id, number, auditorium_id) VALUES (62, 2, 4);
INSERT INTO seat(id, number, auditorium_id) VALUES (63, 3, 4);
INSERT INTO seat(id, number, auditorium_id) VALUES (64, 4, 4);
INSERT INTO seat(id, number, auditorium_id) VALUES (65, 5, 4);
INSERT INTO seat(id, number, auditorium_id) VALUES (66, 6, 4);
INSERT INTO seat(id, number, auditorium_id) VALUES (67, 7, 4);
INSERT INTO seat(id, number, auditorium_id) VALUES (68, 8, 4);
INSERT INTO seat(id, number, auditorium_id) VALUES (69, 9, 4);
INSERT INTO seat(id, number, auditorium_id) VALUES (70, 10, 4);
INSERT INTO seat(id, number, auditorium_id) VALUES (71, 11, 4);
INSERT INTO seat(id, number, auditorium_id) VALUES (72, 12, 4);
INSERT INTO seat(id, number, auditorium_id) VALUES (73, 13, 4);
INSERT INTO seat(id, number, auditorium_id) VALUES (74, 14, 4);
INSERT INTO seat(id, number, auditorium_id) VALUES (75, 15, 4);
INSERT INTO seat(id, number, auditorium_id) VALUES (76, 16, 4);
INSERT INTO seat(id, number, auditorium_id) VALUES (77, 17, 4);
INSERT INTO seat(id, number, auditorium_id) VALUES (78, 18, 4);
INSERT INTO seat(id, number, auditorium_id) VALUES (79, 19, 4);
INSERT INTO seat(id, number, auditorium_id) VALUES (80, 20, 4);


--TICKETS
INSERT INTO ticket(id, projection_id, seat_id, sale_date_time) VALUES (1, 1, 1, "2022-12-22 15:12");
INSERT INTO ticket(id, projection_id, seat_id, sale_date_time) VALUES (2, 1, 2, "2022-12-23 04:10");
INSERT INTO ticket(id, projection_id, seat_id, sale_date_time) VALUES (3, 1, 1, "2022-12-24 23:34");
INSERT INTO ticket(id, projection_id, seat_id, sale_date_time) VALUES (4, 1, 5, "2022-12-25 12:36");
INSERT INTO ticket(id, projection_id, seat_id, sale_date_time) VALUES (5, 1, 6, "2022-12-25 13:00");
INSERT INTO ticket(id, projection_id, seat_id, sale_date_time) VALUES (6, 1, 1, "2022-12-26 14:00");
INSERT INTO ticket(id, projection_id, seat_id, sale_date_time) VALUES (7, 1, 8, "2022-12-26 09:00");
INSERT INTO ticket(id, projection_id, seat_id, sale_date_time) VALUES (8, 1, 10, "2022-12-26 22:12");
INSERT INTO ticket(id, projection_id, seat_id, sale_date_time) VALUES (9, 1, 12, "2022-12-27 19:54");
INSERT INTO ticket(id, projection_id, seat_id, sale_date_time) VALUES (10, 1, 13, "2022-12-27 18:00");
INSERT INTO ticket(id, projection_id, seat_id, sale_date_time) VALUES (11, 1, 15, "2022-12-28 04:47");
INSERT INTO ticket(id, projection_id, seat_id, sale_date_time) VALUES (12, 1, 19, "2022-12-29 20:25");