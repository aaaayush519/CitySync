CREATE database citysync;




INSERT INTO
    `citysync`.`Departments`(id,name,description,contact_no)
VALUES
    (1,'Department of Health', 'Description for Department of Health' , 1081),
    (2,'Water Department', 'Description for Water Department' , 1082),
    (3,'Department of Garbage Collection', 'Description for Department of Garbage Collection' ,1083 ),
    (4,'Public Works Department', 'Description for Public Works Department' , 1084);


INSERT INTO
    `citysync`.`users`(id , email , name , username, password, role , department_id)
VALUES
    (1,'admin@gmail.com','admin','admin','$2a$10$Kk5EMeUstEd3Ykr4zLzcBujImTEoIXHL2z1Dtjq11cvPqf5rfUeca','admin',1);