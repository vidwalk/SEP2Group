CREATE DOMAIN zair."Location"
    AS character(30);
CREATE DOMAIN zair."Time"
    AS time without time zone;
CREATE DOMAIN zair."Date"
    AS date;
CREATE DOMAIN zair."numberOfTickets"
    AS numeric(2,0);
CREATE DOMAIN zair.price
    AS numeric(6,0);
CREATE DOMAIN zair."Seat"
    AS character(3);
CREATE DOMAIN zair."Name"
    AS character(12);   
CREATE DOMAIN zair."email"
    AS character(18);
CREATE DOMAIN zair."password"
    AS character(24);