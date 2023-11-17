DO
$BODY$
    BEGIN
        INSERT INTO car(id, vin, brand, car_model)
        VALUES (1, 'LGWFF6A54PH958745', 'Haval', 'H6'),
               (2, 'LGWFF6A54PH947315', 'Haval', 'Dargo'),
               (3, 'LGWFF6A54PH705867', 'Haval', 'Jolion'),
               (4, 'LGWFF6A5XPH670808', 'Tank', '300');

        INSERT INTO icecar(id, engine_volume)
        VALUES (1, '1.5T'),
               (2, '2.0T'),
               (3, '3.0TT'),
               (4, '2.0T');

        INSERT INTO charging(id, charge_date, car_id)
        VALUES (1, '2023-10-29', 2),
               (2, '2023-10-30', 2),
               (3, '2023-10-31', 1),
               (4, '2023-11-02', 3);

        INSERT INTO defect(id, name, car_id)
        VALUES (1, 'Поцарапан бампер', 2);


        INSERT INTO dictionary(id, name, dictionary_type)
        VALUES (1, '1.5T', 'engine_volume'),
               (2, '2.0T', 'engine_volume'),
               (3, '3.0TT', 'engine_volume'),
               (4, 'Haval', 'brand'),
               (5, 'Tank', 'brand'),
               (6, 'Jolion', 'car_model'),
               (7, 'H6', 'car_model'),
               (8, 'Dargo', 'car_model'),
               (9, '300', 'car_model'),
               (10, '500', 'car_model'),
               (11, 'Comfort', 'spec'),
               (12, 'Elite', 'spec'),
               (13, 'Premium', 'spec'),
               (14, 'Tech Plus', 'spec'),
               (15, 'White', 'exterior_color'),
               (16, 'Black', 'exterior_color'),
               (17, 'Blue', 'exterior_color'),
               (18, 'Red', 'exterior_color'),
               (19, 'Grey', 'exterior_color'),
               (20, 'Brown', 'exterior_color'),
               (21, 'Gold', 'exterior_color'),
               (22, 'Green', 'exterior_color'),
               (23, 'Orange', 'exterior_color'),
               (24, 'Black', 'interior_color'),
               (25, 'White', 'interior_color'),
               (26, 'Red/Black', 'interior_color'),
               (27, 'Brown/Black', 'interior_color'),
               (27, 'Orange/Black', 'interior_color');
    END

$BODY$ LANGUAGE plpgsql;