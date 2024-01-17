CREATE TABLE account
(
    id          BIGINT AUTO_INCREMENT PRIMARY KEY,
    balance     DECIMAL             DEFAULT 0 NOT NULL,
    currency    VARCHAR(8) NULL,
    state       INT        NOT NULL DEFAULT 0,
    created_at  TIMESTAMP  NOT NULL DEFAULT current_timestamp,
    modified_at TIMESTAMP  NOT NULL DEFAULT current_timestamp ON UPDATE current_timestamp
);

CREATE TABLE transaction
(
    id                   BIGINT AUTO_INCREMENT PRIMARY KEY,
    sender_account_id    BIGINT     NOT NULL,
    recipient_account_id BIGINT     NOT NULL,
    amount               DECIMAL    NOT NULL,
    currency             VARCHAR(8) NULL,
    created_at           TIMESTAMP  NOT NULL DEFAULT current_timestamp,
    modified_at          TIMESTAMP  NOT NULL DEFAULT current_timestamp ON UPDATE current_timestamp
);

CREATE TABLE "user"
(
    id          BIGINT AUTO_INCREMENT PRIMARY KEY,
    name        VARCHAR(10) NOT NULL,
    phone       VARCHAR(15) NOT NULL,
    email       VARCHAR(30) NOT NULL,
    password    VARCHAR(30) NOT NULL,
    created_at  TIMESTAMP   NOT NULL DEFAULT current_timestamp,
    modified_at TIMESTAMP   NOT NULL DEFAULT current_timestamp ON UPDATE current_timestamp
);
