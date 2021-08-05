CREATE TABLE ARENA(
  ID BIGINT AUTO_INCREMENT PRIMARY KEY,
  ARENA_NAME VARCHAR(64),
  ADDRESS VARCHAR(64),
  CITY VARCHAR(64),
  ARENA_CAPACITY VARCHAR(64)
);

CREATE TABLE CONCERT(
  ID BIGINT AUTO_INCREMENT PRIMARY KEY,
  ARTIST VARCHAR(64) NOT NULL,
  DATE VARCHAR(64) NOT NULL,
  TICKET_PRICE BIGINT NOT NULL,
  ARENA_ID BIGINT NOT NULL,
  CONCERT_DESCRIPTION VARCHAR(64) NOT NULL,
  TICKETS_SOLD BIGINT NOT NULL,
  PICTURE_ADDRESS VARCHAR(64) NOT NULL
);

ALTER TABLE CONCERT ADD FOREIGN KEY (ARENA_ID) REFERENCES ARENA(ID);
