-- Insert dummy data into the Product table
INSERT INTO Product (id, name, price) VALUES
(1, 'Product A', 10.99),
(2, 'Product B', 15.49),
(3, 'Product C', 20.00),
(4, 'Product D', 25.75),
(5, 'Product E', 30.50);

-- Insert dummy data into the User table
INSERT INTO "USERENTITY" (id, name, email) VALUES
(1, 'Alice Smith', 'alice.smith@example.com'),
(2, 'Bob Johnson', 'bob.johnson@example.com'),
(3, 'Charlie Brown', 'charlie.brown@example.com'),
(4, 'Diana Prince', 'diana.prince@example.com'),
(5, 'Eve Adams', 'eve.adams@example.com');

-- Insert dummy data into the Order table
INSERT INTO "ORDERENTITY" (id, productId, userId) VALUES
(1, 1, 1),
(2, 2, 2),
(3, 3, 3),
(4, 4, 4),
(5, 5, 5),
(6, 1, 2),
(7, 2, 3),
(8, 3, 4),
(9, 4, 5),
(10, 5, 1);
