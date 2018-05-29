CREATE TABLE Flight
(
    flightID varchar(20) NOT NULL,
    origin varchar(30),
    destination varchar(30),
    dateOfDeparture date,
    dateOfArrival date,
    timeOfDeparture time without time zone,
    timeOfArrival time without time zone,
    nrOfTickets integer,
    price numeric(6,0),
    PRIMARY KEY (flightID)
);

CREATE TABLE Customer
(
    customerID varchar(20) NOT NULL,
    fName varchar(20)  NOT NULL,
    lName varchar(20)  NOT NULL,
    email varchar(18),
    passportNo varchar(15),
    phone varchar(15),
    PRIMARY KEY (customerID)
);

CREATE TABLE Seat
(
    seatPo varchar(4) NOT NULL,
    seatValue boolean NOT NULL,
    flightID varchar(20) NOT NULL,
    
    CONSTRAINT flightID FOREIGN KEY (flightID)
        REFERENCES Flight (flightID) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION,
        PRIMARY KEY (seatPo,flightID)
);

CREATE TABLE Ticket
(
    ticketID varchar(20) NOT NULL,
    flightID varchar(20) NOT NULL,
    seatPo varchar(4) NOT NULL,
    customerID varchar(20) NOT NULL,
    PRIMARY KEY (ticketID, flightID),
    UNIQUE(ticketID),
    CONSTRAINT flightIDPrimary FOREIGN KEY (flightID)
        REFERENCES Flight (flightID) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION,  
    CONSTRAINT customerID FOREIGN KEY (customerID)
    REFERENCES Customer (customerID) MATCH SIMPLE
    ON UPDATE NO ACTION
    ON DELETE NO ACTION,
    CONSTRAINT seatPo FOREIGN KEY (seatPo, flightID)
    REFERENCES Seat (seatPo, flightID) MATCH SIMPLE
    ON UPDATE NO ACTION
    ON DELETE NO ACTION
);

CREATE TABLE CustomerCredentials
(
    customerID varchar(20) NOT NULL,
    userID varchar(20) NOT NULL,
    password varchar(24) NOT NULL,
    FOREIGN KEY (customerID)
        REFERENCES Customer (customerID) MATCH SIMPLE
);