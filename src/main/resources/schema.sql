create database redditclone ;
drop database redditclone;
use redditclone;

select * from users;
select * from communities;
select * from reaction;
select * from posts;

INSERT INTO users ( description, display_name, email, password, registration_date, username, role)
VALUES ('description', 'HEADADMIN', 'admin@admin.com','$2a$04$dDm7WU35eSIg9KAZD.muq.pTlSrFz3aeWMnVOiT292iYBjpYRUmKe','1000-01-01','admin', 'ADMIN');

INSERT INTO communities(name, description, creation_date, moderator_id)
VALUES ('Test1', ' ovo je moj prvi community', '1111-01-01',1);


