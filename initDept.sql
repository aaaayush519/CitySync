CREATE database citysync;



INSERT INTO
    `citysync`.`users`(id , email , name , username, password, role , department_id)
VALUES
    (1,'admin@gmail.com','admin','admin','$2a$10$Kk5EMeUstEd3Ykr4zLzcBujImTEoIXHL2z1Dtjq11cvPqf5rfUeca','admin',null);