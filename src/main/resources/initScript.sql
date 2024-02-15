CREATE TABLE plant (
    id INTEGER AUTO_INCREMENT PRIMARY KEY ,
    name varchar(255) NOT NULL ,
    address VARCHAR NOT NULL ,
    date_of_construction DATE ,
    date_of_db_addition DATE
);

INSERT INTO plant (name, address, date_of_construction, date_of_db_addition)
VALUES
    ('Завод №56', 'Nignegorsk34, 1-st str.',  '1956-07-02', '2024-02-14'),
    ('Завод №34', 'Arzamas18, Gorkogo str.', '1952-08-09', '2024-02-14'),
    ('Завод №12', 'Tula26, Lenina str.',  '1953-03-16', '2024-02-14'),
    ('Завод №10', 'Timetau17, Shota Rustaveli str.', '1949-05-03', '2024-02-14'),
    ('Завод №188', 'Astrakhayn65, Sukhova str.', '1948-04-11', '2024-02-14'),
    ('Завод №216', 'Beliz63, RolanaBykova str.', '1943-06-26', '2024-02-14'),
    ('Завод №305', 'Moskva104, Pushkina str.', '1962-07-30', '2024-02-14');

CREATE TABLE device (
                        id INT AUTO_INCREMENT PRIMARY KEY,
                        name VARCHAR(255) NOT NULL,
                        assembling_date DATE NOT NULL,
                        first_name_of_shift_head VARCHAR(255) NOT NULL,
                        last_name_of_shift_head VARCHAR(255) NOT NULL,
                        plant_id INT,
                        FOREIGN KEY (plant_id) REFERENCES Plant(id)
);

INSERT INTO device (name, assembling_date, first_name_of_shift_head, last_name_of_shift_head, plant_id)
VALUES
    ('изделие №32', '2024-02-14', 'Sergey', 'Skvortsov', 1),
    ('изделие №33', '2024-02-14', 'Sergey', 'Skvortsov', 1),
    ('изделие №34', '2024-02-13', 'Gennadiy', 'Orlov', 2),
    ('изделие №35', '2024-02-13', 'Gennadiy', 'Orlov', 2),
    ('изделие №36', '2024-02-13', 'Andrey', 'Sokolov', 3),
    ('изделие №37', '2024-02-10', 'Vladimir', 'Petukhov', 4),
    ('изделие №38', '2024-02-11', 'Vladimir', 'Petukhov', 4),
    ('изделие №39', '2024-02-11', 'Vladimir', 'Petukhov', 4),
    ('изделие №40', '2024-02-12', 'Grigory', 'Protasov', 5),
    ('изделие №41', '2024-02-12', 'Petr', 'Kalinin', 6),
    ('изделие №42', '2024-02-12', 'Mikhail', 'Lugovoy', 7),
    ('изделие №43', '2024-02-12', 'Mikhail', 'Lugovoy', 7),
    ('изделие №44', '2024-02-12', 'Mikhail', 'Lugovoy', 7),
    ('изделие №45', '2024-01-01', 'Mikhail', 'Lugovoy', 7),
    ('изделие №46', '2024-01-02', 'Mikhail', 'Lugovoy', 7),
    ('изделие №47', '2024-01-03', 'Mikhail', 'Lugovoy', 7);