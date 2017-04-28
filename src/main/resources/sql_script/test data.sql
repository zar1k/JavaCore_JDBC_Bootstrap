INSERT INTO `test_db`.`role` (`id`, `name`) VALUES ('1', 'ADMIN');
INSERT INTO `test_db`.`role` (`id`, `name`) VALUES ('2', 'MODERATOR');
INSERT INTO `test_db`.`role` (`id`, `name`) VALUES ('3', 'USER');

INSERT INTO `test_db`.`address` (`id`, `country`, `street`, `zip_code`)
VALUES ('1', 'Ukraine', 'ul. Polevaya, 67', '61140');
INSERT INTO `test_db`.`address` (`id`, `country`, `street`, `zip_code`)
VALUES ('2', 'Ukraine', '1-go Maya ul.-Bortnichi', '02088');
INSERT INTO `test_db`.`address` (`id`, `country`, `street`, `zip_code`)
VALUES ('3', 'Ukraine', 'ul. Chicherina, 30', '49006');

INSERT INTO `test_db`.`music_type` (`id`, `name`) VALUES ('1', 'Blues');
INSERT INTO `test_db`.`music_type` (`id`, `name`) VALUES ('2', 'Jazz');
INSERT INTO `test_db`.`music_type` (`id`, `name`) VALUES ('3', 'Rock');

INSERT INTO `test_db`.`users` (`id`, `login`, `password`, `first_name`, `last_name`, `age`, `role_id`, `address_id`)
VALUES ('1', 'admin', 'admin', 'Ronald', 'Lloyd', '30', '1', '3');
INSERT INTO `test_db`.`users` (`id`, `login`, `password`, `first_name`, `last_name`, `age`, `role_id`, `address_id`)
VALUES ('2', 'moderator', 'moderator', 'Sophie', 'Nelson', '25', '2', '2');
INSERT INTO `test_db`.`users` (`id`, `login`, `password`, `first_name`, `last_name`, `age`, `role_id`, `address_id`)
VALUES ('3', 'user', 'user', 'David', 'McGee', '20', '3', '1');

INSERT INTO `test_db`.`users_has_music_type` (`users_id`, `music_type_id`) VALUES ('1', '2');
INSERT INTO `test_db`.`users_has_music_type` (`users_id`, `music_type_id`) VALUES ('1', '3');
INSERT INTO `test_db`.`users_has_music_type` (`users_id`, `music_type_id`) VALUES ('2', '3');
INSERT INTO `test_db`.`users_has_music_type` (`users_id`, `music_type_id`) VALUES ('3', '1');
INSERT INTO `test_db`.`users_has_music_type` (`users_id`, `music_type_id`) VALUES ('3', '3');
INSERT INTO `test_db`.`users_has_music_type` (`users_id`, `music_type_id`) VALUES ('3', '2');