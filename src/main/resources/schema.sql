CREATE TABLE IF NOT EXISTS Ingredient(
    id VARCHAR(4) NOT NULL,
    name VARCHAR(25) NOT NULL,
    type VARCHAR(10) NOT NULL
);

CREATE TABLE IF NOT EXISTS Taco(
    id IDENTITY,
    name VARCHAR(50) NOT NULL,
    createdAt TIMESTAMP NOT NULL
);

CREATE TABLE IF NOT EXISTS Taco_Ingredients(
    taco bigint NOT NULL,
    ingredient VARCHAR(4) NOT NULL
);

alter table Taco_Ingredients add foreign key (taco) references Taco(id);
alter table Taco_Ingredients add foreign key (ingredient) references Ingredient(id);
create table if not exists Taco_Order (
    id identity,
    deliveryName varchar(50) not null,
    deliveryStreet varchar(50) not null,
    deliveryCity varchar(50) not null,
    deliveryState varchar(2) not null,
    deliveryZip varchar(10) not null,
    ccNumber varchar(16) not null,
    ccExpiration varchar(5) not null,
    ccCVV varchar(3) not null,
    placedAt timestamp not null
);

create table if not exists Taco_Order_Tacos (
    tacoOrder bigint not null,
    taco bigint not null
);

alter table Taco_Order_Tacos add foreign key (tacoOrder) references Taco_Order(id);
alter table Taco_Order_Tacos add foreign key (taco) references Taco(id);