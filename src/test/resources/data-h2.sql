INSERT INTO films (filmsid, films_classification, films_is_feature, filmsomdbid, films_title, films_currently_released) VALUES
    ('1', '12A', 1, 'tt4154756', 'Avengers: Infinity War', 1),
    ('2', '15', 1, 'tt1431045', 'Deadpool', 1),
    ('3', 'U', 1, 'tt0080684', 'Star Wars: Episode V - The Empire Strikes Back', 0),
    ('4', '12A', 0, 'tt3498820', 'Captain America: Civil War', 0),
    ('5', '12A', 1, 'tt4154796', 'Avengers: Endgame', 1);

INSERT INTO standard_screen (standard_screening_id, filmsid, standard_screen_screening_time, standard_screen_seats_booked, standard_screen_date) VALUES
    ('1', null, '12.00', 'A01,A02,A03,A04,A05,A06,A07,A08,A09,A10,A11,A12,A13,A14,A12', '2020-02-12'),
    ('2', null, '14.20', 'A01,A02,A03,A04,A05,A06,A07,A08,A09,A10,A11,A12,A13,A14,B02', '2020-05-10'),
    ('3', null, '16.25', 'C07', '2020-04-11'),
    ('4', null, '10.25', 'B12', '2020-05-09'),
    ('5', null, '18.00', 'A01,A02,A03,A04,A05,A06,A07,A08,A09,A10,A11,A12,A13,A14', '2020-06-20');

INSERT INTO deluxe_screen (deluxe_screening_id, filmsid, deluxe_screening_time, deluxe_seats_booked, deluxe_screen_date) VALUES
    ('1', null, '13.00', 'A01,A02,A03,A04,A05,A06,A07,A08,A09,A10,A11,A12,A13,A14,C08', '2020-05-18'),
    ('2', null, '13.00', 'A01,A02,A03,A04,A05,A06,A07,A08,A09,A10,A11,A12,A13,A14,C07', '2020-04-17'),
    ('3', null, '13.00', 'A01,A02,A03,A04,A05,A06,A07,A08,A09,A10,A11,A12,A13,A14,C06', '2020-02-19'),
    ('4', null, '13.00', 'C08', '2020-06-19'),
    ('5', null, '13.00', 'C08', '2020-05-12');

INSERT INTO booking_info (booking_info_id, deluxe_screen_deluxe_screening_id, standard_screen_standard_screening_id, first_name, surname, date_of_birth, email, phone_number, address, post_code) VALUES
    ('1', null, null, 'John', 'Doe', '1967-03-12', 'johnd@gmail.com', '01234 567891', '1 Standard Street, Standard Village, Manchester', 'M1 1AG'),
    ('2', null, null, 'David', 'Lyac', '1981-03-12', 'davyl@gmail.com', '01234 567891', '1 Standard Street, Standard Village, Manchester', 'M1 1AG'),
    ('3', null, null, 'Sam', 'Gill', '1967-03-12', 'samgilly@gmail.com', '01234 567891', '1 Standard Street, Standard Village, Manchester', 'M1 1AG'),
    ('4', null, null, 'Paul', 'Mc-DuckingField', '1950-03-12', 'duckman82@gmail.com', '01234 567891', '1 Standard Street, Standard Village, Manchester', 'M1 1AG'),
    ('5', null, null, 'Jordan', 'Wizard', '1820-03-12', 'i_love_java@gmail.com', '01234 567891', '1 Standard Street, Standard Village, Manchester', 'M1 1AG');