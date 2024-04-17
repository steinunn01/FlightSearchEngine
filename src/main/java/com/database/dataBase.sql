DROP TABLE IF EXISTS Users;
DROP TABLE IF EXISTS Flight;
DROP TABLE IF EXISTS Airplane;
DROP TABLE IF EXISTS Seat;
DROP TABLE IF EXISTS Ticked;

Create TABLE Users(
	ID VARCHAR(11) PRIMARY KEY,
	FName VARCHAR(25),
	LName VARCHAR(25),
	email CHAR,
	Pasword VARCHAR(255)
);

Create TABLE Airplane(
	id VARCHAR(6) PRIMARY KEY,
	airline VARCHAR(14)
);

Create TABLE Seat(
	r int,
	c VARCHAR(1),
	price int,
	avilable boolean,
	airplaneID VARCHAR(6) REFERENCES Airplane(id),
	depart DATE,
	departTime Time,
	PRIMARY KEY(r, c, airplaneID, depart, departTime),
	FOREIGN KEY(depart, departTime) REFERENCES Flight(depart, departTime)
);

CREATE TABLE Flight(
	airplaneID VARCHAR(6) REFERENCES Airplane(id),
	departLoc VARCHAR(25),
	depart DATE,
	departTime Time,
	arrivalLoc VARCHAR(25),
	arrival time,
	status varChar(14),
	PRIMARY KEY(airplaneID,depart,departTime)
);

CREATE TABLE Ticked(
	userID VARCHAR(11) REFERENCES Users(ID),
	passportID VARCHAR(11),
	airplaneID VARCHAR(6),
	depart DATE,
	departTime Time,
	id VARCHAR(17),
	bagas int,
	r int,
	c VARCHAR(1),
	PRIMARY KEY(userID, passportID, airplaneID, depart, departTime, r, c),
	FOREIGN KEY(airplaneID, depart, departTime) REFERENCES Flight(airplaneID, depart, departTime),
	FOREIGN KEY(r,c) REFERENCES Seat(r,c)
);

INSERT INTO Users VALUES
	('160980-2309', 'Jón', 'Jóhansson', 'Jón@email.com', '1234');

INSERT INTO Airplane (id, airline) VALUES ('FN-757', 'deta'), ('FN-755', 'beta');

INSERT INTO Seat VALUES 
	(1, 'A', 20000, TRUE, 'FN-757', '2024-08-15', '08:30:00'),
	(1, 'B', 20000, TRUE, 'FN-757', '2024-08-15', '08:30:00'),
	(1, 'C', 20000, TRUE, 'FN-757', '2024-08-15', '08:30:00'),
	(1, 'D', 20000, TRUE, 'FN-757', '2024-08-15', '08:30:00'),
	(2, 'A', 20000, TRUE, 'FN-757', '2024-08-15', '08:30:00'),
	(2, 'B', 20000, TRUE, 'FN-757', '2024-08-15', '08:30:00'),
	(2, 'C', 20000, TRUE, 'FN-757', '2024-08-15', '08:30:00'),
	(2, 'D', 20000, TRUE, 'FN-757', '2024-08-15', '08:30:00'),
	(3, 'A', 20000, TRUE, 'FN-757', '2024-08-15', '08:30:00'),
	(3, 'B', 20000, TRUE, 'FN-757', '2024-08-15', '08:30:00'),
	(3, 'C', 20000, TRUE, 'FN-757', '2024-08-15', '08:30:00'),
	(3, 'D', 20000, TRUE, 'FN-757', '2024-08-15', '08:30:00'),
	(4, 'A', 20000, TRUE, 'FN-757', '2024-08-15', '08:30:00'),
	(4, 'B', 20000, TRUE, 'FN-757', '2024-08-15', '08:30:00'),
	(4, 'C', 20000, TRUE, 'FN-757', '2024-08-15', '08:30:00'),
	(4, 'D', 20000, TRUE, 'FN-757', '2024-08-15', '08:30:00'),
	(5, 'A', 20000, TRUE, 'FN-757', '2024-08-15', '08:30:00'),
	(5, 'B', 20000, TRUE, 'FN-757', '2024-08-15', '08:30:00'),
	(5, 'C', 20000, TRUE, 'FN-757', '2024-08-15', '08:30:00'),
	(5, 'D', 20000, TRUE, 'FN-757', '2024-08-15', '08:30:00'),
	(6, 'A', 20000, TRUE, 'FN-757', '2024-08-15', '08:30:00'),
	(6, 'B', 20000, TRUE, 'FN-757', '2024-08-15', '08:30:00'),
	(6, 'C', 20000, TRUE, 'FN-757', '2024-08-15', '08:30:00'),
	(6, 'D', 20000, TRUE, 'FN-757', '2024-08-15', '08:30:00'),
	(7, 'A', 20000, TRUE, 'FN-757', '2024-08-15', '08:30:00'),
	(7, 'B', 20000, TRUE, 'FN-757', '2024-08-15', '08:30:00'),
	(7, 'C', 20000, TRUE, 'FN-757', '2024-08-15', '08:30:00'),
	(7, 'D', 20000, TRUE, 'FN-757', '2024-08-15', '08:30:00'),
	(8, 'A', 20000, TRUE, 'FN-757', '2024-08-15', '08:30:00'),
	(8, 'B', 20000, TRUE, 'FN-757', '2024-08-15', '08:30:00'),
	(8, 'C', 20000, TRUE, 'FN-757', '2024-08-15', '08:30:00'),
	(8, 'D', 20000, TRUE, 'FN-757', '2024-08-15', '08:30:00'),
	(9, 'A', 20000, TRUE, 'FN-757', '2024-08-15', '08:30:00'),
	(9, 'B', 20000, TRUE, 'FN-757', '2024-08-15', '08:30:00'),
	(9, 'C', 20000, TRUE, 'FN-757', '2024-08-15', '08:30:00'),
	(9, 'D', 20000, TRUE, 'FN-757', '2024-08-15', '08:30:00'),
	(10, 'A', 20000, TRUE, 'FN-757', '2024-08-15', '08:30:00'),
	(10, 'B', 20000, TRUE, 'FN-757', '2024-08-15', '08:30:00'),
	(10, 'C', 20000, TRUE, 'FN-757', '2024-08-15', '08:30:00'),
	(10, 'D', 20000, TRUE, 'FN-757', '2024-08-15', '08:30:00'),
	(11, 'A', 20000, TRUE, 'FN-757', '2024-08-15', '08:30:00'),
	(11, 'B', 20000, TRUE, 'FN-757', '2024-08-15', '08:30:00'),
	(11, 'C', 20000, TRUE, 'FN-757', '2024-08-15', '08:30:00'),
	(11, 'D', 20000, TRUE, 'FN-757', '2024-08-15', '08:30:00'),
	(12, 'A', 20000, TRUE, 'FN-757', '2024-08-15', '08:30:00'),
	(12, 'B', 20000, TRUE, 'FN-757', '2024-08-15', '08:30:00'),
	(12, 'C', 20000, TRUE, 'FN-757', '2024-08-15', '08:30:00'),
	(12, 'D', 20000, TRUE, 'FN-757', '2024-08-15', '08:30:00'),
	(13, 'A', 20000, TRUE, 'FN-757', '2024-08-15', '08:30:00'),
	(13, 'B', 20000, TRUE, 'FN-757', '2024-08-15', '08:30:00'),
	(13, 'C', 20000, TRUE, 'FN-757', '2024-08-15', '08:30:00'),
	(13, 'D', 20000, TRUE, 'FN-757', '2024-08-15', '08:30:00'),
	(14, 'A', 20000, TRUE, 'FN-757', '2024-08-15', '08:30:00'),
	(14, 'B', 20000, TRUE, 'FN-757', '2024-08-15', '08:30:00'),
	(14, 'C', 20000, TRUE, 'FN-757', '2024-08-15', '08:30:00'),
	(14, 'D', 20000, TRUE, 'FN-757', '2024-08-15', '08:30:00'),
	(1, 'A', 20000, TRUE, 'FN-757', '2024-08-15', '11:30:00'),
	(1, 'B', 20000, TRUE, 'FN-757', '2024-08-15', '11:30:00'),
	(1, 'C', 20000, TRUE, 'FN-757', '2024-08-15', '11:30:00'),
	(1, 'D', 20000, TRUE, 'FN-757', '2024-08-15', '11:30:00'),
	(2, 'A', 20000, TRUE, 'FN-757', '2024-08-15', '11:30:00'),
	(2, 'B', 20000, TRUE, 'FN-757', '2024-08-15', '11:30:00'),
	(2, 'C', 20000, TRUE, 'FN-757', '2024-08-15', '11:30:00'),
	(2, 'D', 20000, TRUE, 'FN-757', '2024-08-15', '11:30:00'),
	(3, 'A', 20000, TRUE, 'FN-757', '2024-08-15', '11:30:00'),
	(3, 'B', 20000, TRUE, 'FN-757', '2024-08-15', '11:30:00'),
	(3, 'C', 20000, TRUE, 'FN-757', '2024-08-15', '11:30:00'),
	(3, 'D', 20000, TRUE, 'FN-757', '2024-08-15', '11:30:00'),
	(4, 'A', 20000, TRUE, 'FN-757', '2024-08-15', '11:30:00'),
	(4, 'B', 20000, TRUE, 'FN-757', '2024-08-15', '11:30:00'),
	(4, 'C', 20000, TRUE, 'FN-757', '2024-08-15', '11:30:00'),
	(4, 'D', 20000, TRUE, 'FN-757', '2024-08-15', '11:30:00'),
	(5, 'A', 20000, TRUE, 'FN-757', '2024-08-15', '11:30:00'),
	(5, 'B', 20000, TRUE, 'FN-757', '2024-08-15', '11:30:00'),
	(5, 'C', 20000, TRUE, 'FN-757', '2024-08-15', '11:30:00'),
	(5, 'D', 20000, TRUE, 'FN-757', '2024-08-15', '11:30:00'),
	(6, 'A', 20000, TRUE, 'FN-757', '2024-08-15', '11:30:00'),
	(6, 'B', 20000, TRUE, 'FN-757', '2024-08-15', '11:30:00'),
	(6, 'C', 20000, TRUE, 'FN-757', '2024-08-15', '11:30:00'),
	(6, 'D', 20000, TRUE, 'FN-757', '2024-08-15', '11:30:00'),
	(7, 'A', 20000, TRUE, 'FN-757', '2024-08-15', '11:30:00'),
	(7, 'B', 20000, TRUE, 'FN-757', '2024-08-15', '11:30:00'),
	(7, 'C', 20000, TRUE, 'FN-757', '2024-08-15', '11:30:00'),
	(7, 'D', 20000, TRUE, 'FN-757', '2024-08-15', '11:30:00'),
	(8, 'A', 20000, TRUE, 'FN-757', '2024-08-15', '11:30:00'),
	(8, 'B', 20000, TRUE, 'FN-757', '2024-08-15', '11:30:00'),
	(8, 'C', 20000, TRUE, 'FN-757', '2024-08-15', '11:30:00'),
	(8, 'D', 20000, TRUE, 'FN-757', '2024-08-15', '11:30:00'),
	(9, 'A', 20000, TRUE, 'FN-757', '2024-08-15', '11:30:00'),
	(9, 'B', 20000, TRUE, 'FN-757', '2024-08-15', '11:30:00'),
	(9, 'C', 20000, TRUE, 'FN-757', '2024-08-15', '11:30:00'),
	(9, 'D', 20000, TRUE, 'FN-757', '2024-08-15', '11:30:00'),
	(10, 'A', 20000, TRUE, 'FN-757', '2024-08-15', '11:30:00'),
	(10, 'B', 20000, TRUE, 'FN-757', '2024-08-15', '11:30:00'),
	(10, 'C', 20000, TRUE, 'FN-757', '2024-08-15', '11:30:00'),
	(10, 'D', 20000, TRUE, 'FN-757', '2024-08-15', '11:30:00'),
	(11, 'A', 20000, TRUE, 'FN-757', '2024-08-15', '11:30:00'),
	(11, 'B', 20000, TRUE, 'FN-757', '2024-08-15', '11:30:00'),
	(11, 'C', 20000, TRUE, 'FN-757', '2024-08-15', '11:30:00'),
	(11, 'D', 20000, TRUE, 'FN-757', '2024-08-15', '11:30:00'),
	(12, 'A', 20000, TRUE, 'FN-757', '2024-08-15', '11:30:00'),
	(12, 'B', 20000, TRUE, 'FN-757', '2024-08-15', '11:30:00'),
	(12, 'C', 20000, TRUE, 'FN-757', '2024-08-15', '11:30:00'),
	(12, 'D', 20000, TRUE, 'FN-757', '2024-08-15', '11:30:00'),
	(13, 'A', 20000, TRUE, 'FN-757', '2024-08-15', '11:30:00'),
	(13, 'B', 20000, TRUE, 'FN-757', '2024-08-15', '11:30:00'),
	(13, 'C', 20000, TRUE, 'FN-757', '2024-08-15', '11:30:00'),
	(13, 'D', 20000, TRUE, 'FN-757', '2024-08-15', '11:30:00'),
	(14, 'A', 20000, TRUE, 'FN-757', '2024-08-15', '11:30:00'),
	(14, 'B', 20000, TRUE, 'FN-757', '2024-08-15', '11:30:00'),
	(14, 'C', 20000, TRUE, 'FN-757', '2024-08-15', '11:30:00'),
	(14, 'D', 20000, TRUE, 'FN-757', '2024-08-15', '11:30:00'),
	(1, 'A', 20000, TRUE, 'FN-757', '2024-08-15', '14:30:00'),
	(1, 'B', 20000, TRUE, 'FN-757', '2024-08-15', '14:30:00'),
	(1, 'C', 20000, TRUE, 'FN-757', '2024-08-15', '14:30:00'),
	(1, 'D', 20000, TRUE, 'FN-757', '2024-08-15', '14:30:00'),
	(2, 'A', 20000, TRUE, 'FN-757', '2024-08-15', '14:30:00'),
	(2, 'B', 20000, TRUE, 'FN-757', '2024-08-15', '14:30:00'),
	(2, 'C', 20000, TRUE, 'FN-757', '2024-08-15', '14:30:00'),
	(2, 'D', 20000, TRUE, 'FN-757', '2024-08-15', '14:30:00'),
	(3, 'A', 20000, TRUE, 'FN-757', '2024-08-15', '14:30:00'),
	(3, 'B', 20000, TRUE, 'FN-757', '2024-08-15', '14:30:00'),
	(3, 'C', 20000, TRUE, 'FN-757', '2024-08-15', '14:30:00'),
	(3, 'D', 20000, TRUE, 'FN-757', '2024-08-15', '14:30:00'),
	(4, 'A', 20000, TRUE, 'FN-757', '2024-08-15', '14:30:00'),
	(4, 'B', 20000, TRUE, 'FN-757', '2024-08-15', '14:30:00'),
	(4, 'C', 20000, TRUE, 'FN-757', '2024-08-15', '14:30:00'),
	(4, 'D', 20000, TRUE, 'FN-757', '2024-08-15', '14:30:00'),
	(5, 'A', 20000, TRUE, 'FN-757', '2024-08-15', '14:30:00'),
	(5, 'B', 20000, TRUE, 'FN-757', '2024-08-15', '14:30:00'),
	(5, 'C', 20000, TRUE, 'FN-757', '2024-08-15', '14:30:00'),
	(5, 'D', 20000, TRUE, 'FN-757', '2024-08-15', '14:30:00'),
	(6, 'A', 20000, TRUE, 'FN-757', '2024-08-15', '14:30:00'),
	(6, 'B', 20000, TRUE, 'FN-757', '2024-08-15', '14:30:00'),
	(6, 'C', 20000, TRUE, 'FN-757', '2024-08-15', '14:30:00'),
	(6, 'D', 20000, TRUE, 'FN-757', '2024-08-15', '14:30:00'),
	(7, 'A', 20000, TRUE, 'FN-757', '2024-08-15', '14:30:00'),
	(7, 'B', 20000, TRUE, 'FN-757', '2024-08-15', '14:30:00'),
	(7, 'C', 20000, TRUE, 'FN-757', '2024-08-15', '14:30:00'),
	(7, 'D', 20000, TRUE, 'FN-757', '2024-08-15', '14:30:00'),
	(8, 'A', 20000, TRUE, 'FN-757', '2024-08-15', '14:30:00'),
	(8, 'B', 20000, TRUE, 'FN-757', '2024-08-15', '14:30:00'),
	(8, 'C', 20000, TRUE, 'FN-757', '2024-08-15', '14:30:00'),
	(8, 'D', 20000, TRUE, 'FN-757', '2024-08-15', '14:30:00'),
	(9, 'A', 20000, TRUE, 'FN-757', '2024-08-15', '14:30:00'),
	(9, 'B', 20000, TRUE, 'FN-757', '2024-08-15', '14:30:00'),
	(9, 'C', 20000, TRUE, 'FN-757', '2024-08-15', '14:30:00'),
	(9, 'D', 20000, TRUE, 'FN-757', '2024-08-15', '14:30:00'),
	(10, 'A', 20000, TRUE, 'FN-757', '2024-08-15', '14:30:00'),
	(10, 'B', 20000, TRUE, 'FN-757', '2024-08-15', '14:30:00'),
	(10, 'C', 20000, TRUE, 'FN-757', '2024-08-15', '14:30:00'),
	(10, 'D', 20000, TRUE, 'FN-757', '2024-08-15', '14:30:00'),
	(11, 'A', 20000, TRUE, 'FN-757', '2024-08-15', '14:30:00'),
	(11, 'B', 20000, TRUE, 'FN-757', '2024-08-15', '14:30:00'),
	(11, 'C', 20000, TRUE, 'FN-757', '2024-08-15', '14:30:00'),
	(11, 'D', 20000, TRUE, 'FN-757', '2024-08-15', '14:30:00'),
	(12, 'A', 20000, TRUE, 'FN-757', '2024-08-15', '14:30:00'),
	(12, 'B', 20000, TRUE, 'FN-757', '2024-08-15', '14:30:00'),
	(12, 'C', 20000, TRUE, 'FN-757', '2024-08-15', '14:30:00'),
	(12, 'D', 20000, TRUE, 'FN-757', '2024-08-15', '14:30:00'),
	(13, 'A', 20000, TRUE, 'FN-757', '2024-08-15', '14:30:00'),
	(13, 'B', 20000, TRUE, 'FN-757', '2024-08-15', '14:30:00'),
	(13, 'C', 20000, TRUE, 'FN-757', '2024-08-15', '14:30:00'),
	(13, 'D', 20000, TRUE, 'FN-757', '2024-08-15', '14:30:00'),
	(14, 'A', 20000, TRUE, 'FN-757', '2024-08-15', '14:30:00'),
	(14, 'B', 20000, TRUE, 'FN-757', '2024-08-15', '14:30:00'),
	(14, 'C', 20000, TRUE, 'FN-757', '2024-08-15', '14:30:00'),
	(14, 'D', 20000, TRUE, 'FN-757', '2024-08-15', '14:30:00'),
	(1, 'A', 20000, TRUE, 'FN-757', '2024-08-15', '17:30:00'),
	(1, 'B', 20000, TRUE, 'FN-757', '2024-08-15', '17:30:00'),
	(1, 'C', 20000, TRUE, 'FN-757', '2024-08-15', '17:30:00'),
	(1, 'D', 20000, TRUE, 'FN-757', '2024-08-15', '17:30:00'),
	(2, 'A', 20000, TRUE, 'FN-757', '2024-08-15', '17:30:00'),
	(2, 'B', 20000, TRUE, 'FN-757', '2024-08-15', '17:30:00'),
	(2, 'C', 20000, TRUE, 'FN-757', '2024-08-15', '17:30:00'),
	(2, 'D', 20000, TRUE, 'FN-757', '2024-08-15', '17:30:00'),
	(3, 'A', 20000, TRUE, 'FN-757', '2024-08-15', '17:30:00'),
	(3, 'B', 20000, TRUE, 'FN-757', '2024-08-15', '17:30:00'),
	(3, 'C', 20000, TRUE, 'FN-757', '2024-08-15', '17:30:00'),
	(3, 'D', 20000, TRUE, 'FN-757', '2024-08-15', '17:30:00'),
	(4, 'A', 20000, TRUE, 'FN-757', '2024-08-15', '17:30:00'),
	(4, 'B', 20000, TRUE, 'FN-757', '2024-08-15', '17:30:00'),
	(4, 'C', 20000, TRUE, 'FN-757', '2024-08-15', '17:30:00'),
	(4, 'D', 20000, TRUE, 'FN-757', '2024-08-15', '17:30:00'),
	(5, 'A', 20000, TRUE, 'FN-757', '2024-08-15', '17:30:00'),
	(5, 'B', 20000, TRUE, 'FN-757', '2024-08-15', '17:30:00'),
	(5, 'C', 20000, TRUE, 'FN-757', '2024-08-15', '17:30:00'),
	(5, 'D', 20000, TRUE, 'FN-757', '2024-08-15', '17:30:00'),
	(6, 'A', 20000, TRUE, 'FN-757', '2024-08-15', '17:30:00'),
	(6, 'B', 20000, TRUE, 'FN-757', '2024-08-15', '17:30:00'),
	(6, 'C', 20000, TRUE, 'FN-757', '2024-08-15', '17:30:00'),
	(6, 'D', 20000, TRUE, 'FN-757', '2024-08-15', '17:30:00'),
	(7, 'A', 20000, TRUE, 'FN-757', '2024-08-15', '17:30:00'),
	(7, 'B', 20000, TRUE, 'FN-757', '2024-08-15', '17:30:00'),
	(7, 'C', 20000, TRUE, 'FN-757', '2024-08-15', '17:30:00'),
	(7, 'D', 20000, TRUE, 'FN-757', '2024-08-15', '17:30:00'),
	(8, 'A', 20000, TRUE, 'FN-757', '2024-08-15', '17:30:00'),
	(8, 'B', 20000, TRUE, 'FN-757', '2024-08-15', '17:30:00'),
	(8, 'C', 20000, TRUE, 'FN-757', '2024-08-15', '17:30:00'),
	(8, 'D', 20000, TRUE, 'FN-757', '2024-08-15', '17:30:00'),
	(9, 'A', 20000, TRUE, 'FN-757', '2024-08-15', '17:30:00'),
	(9, 'B', 20000, TRUE, 'FN-757', '2024-08-15', '17:30:00'),
	(9, 'C', 20000, TRUE, 'FN-757', '2024-08-15', '17:30:00'),
	(9, 'D', 20000, TRUE, 'FN-757', '2024-08-15', '17:30:00'),
	(10, 'A', 20000, TRUE, 'FN-757', '2024-08-15', '17:30:00'),
	(10, 'B', 20000, TRUE, 'FN-757', '2024-08-15', '17:30:00'),
	(10, 'C', 20000, TRUE, 'FN-757', '2024-08-15', '17:30:00'),
	(10, 'D', 20000, TRUE, 'FN-757', '2024-08-15', '17:30:00'),
	(11, 'A', 20000, TRUE, 'FN-757', '2024-08-15', '17:30:00'),
	(11, 'B', 20000, TRUE, 'FN-757', '2024-08-15', '17:30:00'),
	(11, 'C', 20000, TRUE, 'FN-757', '2024-08-15', '17:30:00'),
	(11, 'D', 20000, TRUE, 'FN-757', '2024-08-15', '17:30:00'),
	(12, 'A', 20000, TRUE, 'FN-757', '2024-08-15', '17:30:00'),
	(12, 'B', 20000, TRUE, 'FN-757', '2024-08-15', '17:30:00'),
	(12, 'C', 20000, TRUE, 'FN-757', '2024-08-15', '17:30:00'),
	(12, 'D', 20000, TRUE, 'FN-757', '2024-08-15', '17:30:00'),
	(13, 'A', 20000, TRUE, 'FN-757', '2024-08-15', '17:30:00'),
	(13, 'B', 20000, TRUE, 'FN-757', '2024-08-15', '17:30:00'),
	(13, 'C', 20000, TRUE, 'FN-757', '2024-08-15', '17:30:00'),
	(13, 'D', 20000, TRUE, 'FN-757', '2024-08-15', '17:30:00'),
	(14, 'A', 20000, TRUE, 'FN-757', '2024-08-15', '17:30:00'),
	(14, 'B', 20000, TRUE, 'FN-757', '2024-08-15', '17:30:00'),
	(14, 'C', 20000, TRUE, 'FN-757', '2024-08-15', '17:30:00'),
	(14, 'D', 20000, TRUE, 'FN-757', '2024-08-15', '17:30:00');

INSERT INTO Seat VALUES
	(1, 'A', 20000, TRUE, 'FN-755', '2024-08-15', '08:00:00'),
	(1, 'B', 20000, TRUE, 'FN-755', '2024-08-15', '08:00:00'),
	(1, 'C', 20000, TRUE, 'FN-755', '2024-08-15', '08:00:00'),
	(2, 'A', 20000, TRUE, 'FN-755', '2024-08-15', '08:00:00'),
	(2, 'B', 20000, TRUE, 'FN-755', '2024-08-15', '08:00:00'),
	(2, 'C', 20000, TRUE, 'FN-755', '2024-08-15', '08:00:00'),
	(3, 'A', 20000, TRUE, 'FN-755', '2024-08-15', '08:00:00'),
	(3, 'B', 20000, TRUE, 'FN-755', '2024-08-15', '08:00:00'),
	(3, 'C', 20000, TRUE, 'FN-755', '2024-08-15', '08:00:00'),
	(4, 'A', 20000, TRUE, 'FN-755', '2024-08-15', '08:00:00'),
	(4, 'B', 20000, TRUE, 'FN-755', '2024-08-15', '08:00:00'),
	(4, 'C', 20000, TRUE, 'FN-755', '2024-08-15', '08:00:00'),
	(5, 'A', 20000, TRUE, 'FN-755', '2024-08-15', '08:00:00'),
	(5, 'B', 20000, TRUE, 'FN-755', '2024-08-15', '08:00:00'),
	(5, 'C', 20000, TRUE, 'FN-755', '2024-08-15', '08:00:00'),
	(6, 'A', 20000, TRUE, 'FN-755', '2024-08-15', '08:00:00'),
	(6, 'B', 20000, TRUE, 'FN-755', '2024-08-15', '08:00:00'),
	(6, 'C', 20000, TRUE, 'FN-755', '2024-08-15', '08:00:00'),
	(7, 'A', 20000, TRUE, 'FN-755', '2024-08-15', '08:00:00'),
	(7, 'B', 20000, TRUE, 'FN-755', '2024-08-15', '08:00:00'),
	(7, 'C', 20000, TRUE, 'FN-755', '2024-08-15', '08:00:00'),
	(1, 'A', 20000, TRUE, 'FN-755', '2024-08-15', '11:00:00'),
	(1, 'B', 20000, TRUE, 'FN-755', '2024-08-15', '11:00:00'),
	(1, 'C', 20000, TRUE, 'FN-755', '2024-08-15', '11:00:00'),
	(2, 'A', 20000, TRUE, 'FN-755', '2024-08-15', '11:00:00'),
	(2, 'B', 20000, TRUE, 'FN-755', '2024-08-15', '11:00:00'),
	(2, 'C', 20000, TRUE, 'FN-755', '2024-08-15', '11:00:00'),
	(3, 'A', 20000, TRUE, 'FN-755', '2024-08-15', '11:00:00'),
	(3, 'B', 20000, TRUE, 'FN-755', '2024-08-15', '11:00:00'),
	(3, 'C', 20000, TRUE, 'FN-755', '2024-08-15', '11:00:00'),
	(4, 'A', 20000, TRUE, 'FN-755', '2024-08-15', '11:00:00'),
	(4, 'B', 20000, TRUE, 'FN-755', '2024-08-15', '11:00:00'),
	(4, 'C', 20000, TRUE, 'FN-755', '2024-08-15', '11:00:00'),
	(5, 'A', 20000, TRUE, 'FN-755', '2024-08-15', '11:00:00'),
	(5, 'B', 20000, TRUE, 'FN-755', '2024-08-15', '11:00:00'),
	(5, 'C', 20000, TRUE, 'FN-755', '2024-08-15', '11:00:00'),
	(6, 'A', 20000, TRUE, 'FN-755', '2024-08-15', '11:00:00'),
	(6, 'B', 20000, TRUE, 'FN-755', '2024-08-15', '11:00:00'),
	(6, 'C', 20000, TRUE, 'FN-755', '2024-08-15', '11:00:00'),
	(7, 'A', 20000, TRUE, 'FN-755', '2024-08-15', '11:00:00'),
	(7, 'B', 20000, TRUE, 'FN-755', '2024-08-15', '11:00:00'),
	(7, 'C', 20000, TRUE, 'FN-755', '2024-08-15', '11:00:00'),
	(1, 'A', 20000, TRUE, 'FN-755', '2024-08-15', '14:00:00'),
	(1, 'B', 20000, TRUE, 'FN-755', '2024-08-15', '14:00:00'),
	(1, 'C', 20000, TRUE, 'FN-755', '2024-08-15', '14:00:00'),
	(2, 'A', 20000, TRUE, 'FN-755', '2024-08-15', '14:00:00'),
	(2, 'B', 20000, TRUE, 'FN-755', '2024-08-15', '14:00:00'),
	(2, 'C', 20000, TRUE, 'FN-755', '2024-08-15', '14:00:00'),
	(3, 'A', 20000, TRUE, 'FN-755', '2024-08-15', '14:00:00'),
	(3, 'B', 20000, TRUE, 'FN-755', '2024-08-15', '14:00:00'),
	(3, 'C', 20000, TRUE, 'FN-755', '2024-08-15', '14:00:00'),
	(4, 'A', 20000, TRUE, 'FN-755', '2024-08-15', '14:00:00'),
	(4, 'B', 20000, TRUE, 'FN-755', '2024-08-15', '14:00:00'),
	(4, 'C', 20000, TRUE, 'FN-755', '2024-08-15', '14:00:00'),
	(5, 'A', 20000, TRUE, 'FN-755', '2024-08-15', '14:00:00'),
	(5, 'B', 20000, TRUE, 'FN-755', '2024-08-15', '14:00:00'),
	(5, 'C', 20000, TRUE, 'FN-755', '2024-08-15', '14:00:00'),
	(6, 'A', 20000, TRUE, 'FN-755', '2024-08-15', '14:00:00'),
	(6, 'B', 20000, TRUE, 'FN-755', '2024-08-15', '14:00:00'),
	(6, 'C', 20000, TRUE, 'FN-755', '2024-08-15', '14:00:00'),
	(7, 'A', 20000, TRUE, 'FN-755', '2024-08-15', '14:00:00'),
	(7, 'B', 20000, TRUE, 'FN-755', '2024-08-15', '14:00:00'),
	(7, 'C', 20000, TRUE, 'FN-755', '2024-08-15', '14:00:00'),
	(1, 'A', 20000, TRUE, 'FN-755', '2024-08-15', '17:00:00'),
	(1, 'B', 20000, TRUE, 'FN-755', '2024-08-15', '17:00:00'),
	(1, 'C', 20000, TRUE, 'FN-755', '2024-08-15', '17:00:00'),
	(2, 'A', 20000, TRUE, 'FN-755', '2024-08-15', '17:00:00'),
	(2, 'B', 20000, TRUE, 'FN-755', '2024-08-15', '17:00:00'),
	(2, 'C', 20000, TRUE, 'FN-755', '2024-08-15', '17:00:00'),
	(3, 'A', 20000, TRUE, 'FN-755', '2024-08-15', '17:00:00'),
	(3, 'B', 20000, TRUE, 'FN-755', '2024-08-15', '17:00:00'),
	(3, 'C', 20000, TRUE, 'FN-755', '2024-08-15', '17:00:00'),
	(4, 'A', 20000, TRUE, 'FN-755', '2024-08-15', '17:00:00'),
	(4, 'B', 20000, TRUE, 'FN-755', '2024-08-15', '17:00:00'),
	(4, 'C', 20000, TRUE, 'FN-755', '2024-08-15', '17:00:00'),
	(5, 'A', 20000, TRUE, 'FN-755', '2024-08-15', '17:00:00'),
	(5, 'B', 20000, TRUE, 'FN-755', '2024-08-15', '17:00:00'),
	(5, 'C', 20000, TRUE, 'FN-755', '2024-08-15', '17:00:00'),
	(6, 'A', 20000, TRUE, 'FN-755', '2024-08-15', '17:00:00'),
	(6, 'B', 20000, TRUE, 'FN-755', '2024-08-15', '17:00:00'),
	(6, 'C', 20000, TRUE, 'FN-755', '2024-08-15', '17:00:00'),
	(7, 'A', 20000, TRUE, 'FN-755', '2024-08-15', '17:00:00'),
	(7, 'B', 20000, TRUE, 'FN-755', '2024-08-15', '17:00:00'),
	(7, 'C', 20000, TRUE, 'FN-755', '2024-08-15', '17:00:00');


INSERT INTO Flight VALUES
	('FN-755', 'Reykjavik', '2024-08-15', '08:00:00', 'Hofn', '09:00:00', 'on Time'),
	('FN-755', 'Hofn', '2024-08-15', '11:00:00', 'Reykjavik', '12:00:00', 'on Time'),
	('FN-755', 'Reykjavik', '2024-08-15', '14:00:00', 'Hofn', '15:00:00', 'on Time'),
	('FN-755', 'Hofn', '2024-08-15', '17:00:00', 'Reykjavik', '18:00:00', 'on Time'),
	('FN-755', 'Reykjavik', '2024-08-15', '08:30:00', 'Akureyri', '09:30:00', 'on Time'),
	('FN-755', 'Akureyri', '2024-08-15', '11:30:00', 'Reykjavik', '12:30:00', 'on Time'),
	('FN-755', 'Reykjavik', '2024-08-15', '14:30:00', 'Akureyri', '15:30:00', 'on Time'),
	('FN-755', 'Akureyri', '2024-08-15', '17:30:00', 'Reykjavik', '18:30:00', 'on Time');
