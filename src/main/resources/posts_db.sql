drop database posts_db;

create database posts_db;

use posts_db;


INSERT INTO posts (id, title, body, user_id)
VALUES
(1, 'title1', 'oh', 1),
(2, 'title2', 'hey', 2),
(3, 'title3', 'there', 3);


INSERT INTO post_details(history_of_post, is_awesome,topic_description, post_id)
VALUES
('history and stuff1', true,  'topic and stuff1', 1),
('history and stuff2', false,  'topic and stuff2', 2),
('history and stuff3', true,  'topic and stuff3', 3);


INSERT INTO post_image(url, post_image_id)
VALUES ('https://images.pexels.com/photos/617278/pexels-photo-617278.jpeg?auto=compress&cs=tinysrgb&dpr=1&w=500', 1),
       ('https://www.petmd.com/sites/default/files/adult-homeless-cat-asking-for-food-picture-id847415388.jpg', 2),
       ('https://images.pexels.com/photos/45201/kitty-cat-kitten-pet-45201.jpeg?auto=compress&cs=tinysrgb&dpr=1&w=500',3);

INSERT INTO users(id, username, email, password)
VALUES (1, 'bananaman', 'banana@gmail.com', 'ihatebananas'),
       (2, 'banana', 'bana@gmail.com', 'somebananas'),
       (3, 'ananab', 'anaaaa@gmail.com', 'stillhatebananas');








