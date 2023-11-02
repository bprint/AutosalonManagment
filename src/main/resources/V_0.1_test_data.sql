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
               (3, '2023-10-31', 1);

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
               (10, '500', 'car_model');
    END

$BODY$ LANGUAGE plpgsql;