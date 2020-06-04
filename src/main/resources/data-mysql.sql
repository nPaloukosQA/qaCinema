INSERT INTO films (films_classification, films_is_feature, filmsomdbid, films_title, films_currently_released) VALUES
    ('12A', 1, 'tt4154756', 'Avengers: Infinity War', 1),
    ('15', 1, 'tt1431045', 'Deadpool', 1),
    ('U', 1, 'tt0080684', 'Star Wars: Episode V - The Empire Strikes Back', 0),
    ('12A', 0, 'tt3498820', 'Captain America: Civil War', 0),
    ('12A', 1, 'tt4154796', 'Avengers: Endgame', 1);

INSERT INTO standard_screen (filmsid, standard_screen_screening_time, standard_screen_seats_booked, standard_screen_date) VALUES
    ('1', '12.00', 'A01,A02,A03,A04,A05,A06,A07,A08,A09,A10,A11,A12,A13,A14,A12', '2020-02-12'),
    ('2', '14.20', 'A01,A02,A03,A04,A05,A06,A07,A08,A09,A10,A11,A12,A13,A14,B02', '2020-05-10'),
    ('2', '16.25', 'C07', '2020-04-11'),
    ('5', '10.25', 'B12', '2020-05-09'),
    ('4', '18.00', 'A01,A02,A03,A04,A05,A06,A07,A08,A09,A10,A11,A12,A13,A14', '2020-06-20');

INSERT INTO deluxe_screen (filmsid, deluxe_screening_time, deluxe_seats_booked, deluxe_screen_date) VALUES
    ('2', '13.00', 'A01,A02,A03,A04,A05,A06,A07,A08,A09,A10,A11,A12,A13,A14,C08', '2020-05-18'),
    ('3', '13.00', 'A01,A02,A03,A04,A05,A06,A07,A08,A09,A10,A11,A12,A13,A14,C07', '2020-04-17'),
    ('4', '13.00', 'A01,A02,A03,A04,A05,A06,A07,A08,A09,A10,A11,A12,A13,A14,C06', '2020-02-19'),
    ('1', '13.00', 'C08', '2020-06-19'),
    ('2', '13.00', 'C08', '2020-05-12');

INSERT INTO booking_info (deluxe_screen_deluxe_screening_id, standard_screen_standard_screening_id, first_name, surname, date_of_birth, email, phone_number, address, post_code) VALUES
    ('1', "", 'John', 'Doe', '1967-03-12', 'johnd@gmail.com', '01234 567891', '1 Standard Street, Standard Village, Manchester', 'M1 1AG'),
    ("", '1', 'David', 'Lyac', '1981-03-12', 'davyl@gmail.com', '01234 567891', '1 Standard Street, Standard Village, Manchester', 'M1 1AG'),
    ("", '1', 'Sam', 'Gill', '1967-03-12', 'samgilly@gmail.com', '01234 567891', '1 Standard Street, Standard Village, Manchester', 'M1 1AG'),
    ('1', "", 'Paul', 'Mc-DuckingField', '1950-03-12', 'duckman82@gmail.com', '01234 567891', '1 Standard Street, Standard Village, Manchester', 'M1 1AG'),
    ('1', "", 'Jordan', 'Wizard', '1820-03-12', 'i_love_java@gmail.com', '01234 567891', '1 Standard Street, Standard Village, Manchester', 'M1 1AG');