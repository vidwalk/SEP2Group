CREATE TABLE zair."Flight"
(
    "flightID" varchar(20) NOT NULL,
    "origin" varchar(30),
    "destination" varchar(30),
    "dateOfDeparture" zair."Date",
    "dateOfArrival" zair."Date",
    "timeOfDeparture" zair."Time",
    "timeOfArrival" zair."Time",
    "nrOfTickets" zair."numberOfTickets",
    price zair."price",
    PRIMARY KEY ("flightID")
);

CREATE TABLE zair."Ticket"
(
    "ticketID" varchar(20) NOT NULL,
    "flightID" varchar(20) NOT NULL,
    "seatPo" varchar(4) NOT NULL,
    "customerID" varchar(20) NOT NULL,
    PRIMARY KEY ("ticketID", "flightID"),
    UNIQUE("ticketID"),
    CONSTRAINT "flightID" FOREIGN KEY ("flightID")
        REFERENCES zair."Flight" ("flightID") MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION,  
    CONSTRAINT "customerID" FOREIGN KEY ("customerID")
    REFERENCES zair."Customer" ("customerID") MATCH SIMPLE
    ON UPDATE NO ACTION
    ON DELETE NO ACTION,
    CONSTRAINT "seatPo" FOREIGN KEY ("seatPo", "flightID")
    REFERENCES zair."Seats" ("seatPo", "flightID") MATCH SIMPLE
    ON UPDATE NO ACTION
    ON DELETE NO ACTION
);
CREATE TABLE zair."Customer"
(
    "customerID" varchar(20) NOT NULL,
    "fName" varchar(20)  NOT NULL,
    "lName" varchar(20)  NOT NULL,
    email varchar(18),
    "passportNo" varchar(15),
    "phone" varchar(15),
    PRIMARY KEY ("customerID")
);
CREATE TABLE zair."CustomerCredentials"
(
    "customerID" varchar(20) NOT NULL,
    "userID" varchar(20) NOT NULL,
    password varchar(24) NOT NULL,
    FOREIGN KEY ("customerID")
        REFERENCES zair."Customer" ("customerID") MATCH SIMPLE
);
CREATE TABLE zair."Seats"
(
    "seatPo" varchar(4) NOT NULL,
    "seatValue" boolean NOT NULL,
    "flightID" varchar(20) NOT NULL,
    
    CONSTRAINT "flightID" FOREIGN KEY ("flightID")
        REFERENCES zair."Flight" ("flightID") MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION,
        PRIMARY KEY ("seatPo","flightID")
);