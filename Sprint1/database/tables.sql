CREATE TABLE zair."Flight"
(
    "flightID" serial NOT NULL,
    "origin" zair."location",
    "destination" zair."location",
    "dateOfDeparture" zair."Date",
    "dateOfArrival" zair."Date",
    "timeOfDeparture" zair."Time",
    "timeOfArrival" zair."Time",
    "nrOfTickets" zair."numberOfTickets",
    "nrOfTicketsLeft" zair."numberOfTickets",
    price zair."price",
    PRIMARY KEY ("flightID")
);
CREATE TABLE zair."Ticket"
(
    "ticketID" serial NOT NULL,
    "flightID" serial NOT NULL,
    seat zair."Seat" NOT NULL,
    "customerID" serial NOT NULL,
    PRIMARY KEY ("ticketID", "flightID"),
    UNIQUE("ticketID"),
    CONSTRAINT "flightID" FOREIGN KEY ("flightID")
        REFERENCES zair."Flight" ("flightID") MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION,  
    CONSTRAINT "customerID" FOREIGN KEY ("customerID")
    REFERENCES zair."Customer" ("customerID") MATCH SIMPLE
    ON UPDATE NO ACTION
    ON DELETE NO ACTION
);
CREATE TABLE zair."Customer"
(
    "customerID" serial NOT NULL,
    "fName" zair."Name" NOT NULL,
    "lName" zair."Name" NOT NULL,
    email zair."email",
    "ticketID" serial NOT NULL,
    "passportNo" character(15),
    "phone" character(15),
    PRIMARY KEY ("customerID")
);
CREATE TABLE zair."CustomerCredentials"
(
    "customerID" serial NOT NULL,
    password zair."password" NOT NULL,
    FOREIGN KEY ("customerID")
        REFERENCES zair."Customer" ("customerID") MATCH SIMPLE
);