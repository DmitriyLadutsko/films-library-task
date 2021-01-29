insert into director(id, first_name, last_name, birth_date)
VALUES (1, 'Steven', 'Spielberg', 'December 18, 1946'),
       (2, 'Quentin', 'Tarantino', 'March 27, 1963'),
       (3, 'Akira', 'Kurosawa', 'March 23, 1910'),
       (4, 'Martin', 'Scorsese', 'November 17, 1942');

insert into film(director_id, name, release_date, genre)
VALUES (1, 'Saving Private Ryan', 'July 24, 1998', 'epic war film'),
       (1, 'Schindler''s List', 'November 30, 1993', 'epic historical drama'),
       (1, 'Catch Me If You Can', 'December 18, 2002', 'biographical crime film'),
       (1, 'The Terminal', 'June 18, 2004', 'comedy-drama'),
       (2, 'Kill Bill: Volume 2', 'April 8, 2004', 'martial arts film'),
       (2, 'My Name Is Modesty', 'April 8, 2004', 'action'),
       (2, 'Jackie Brown', 'December 8, 1997', 'crime film'),
       (4, 'The Aviator', 'December 14, 2004', 'epic biographical drama film');