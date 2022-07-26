create table if not exists validation_db(
    "id" bigserial primary key,
    uuid varchar (255) not null,
    login varchar (255) not null,
    tempPassword varchar (255) not null,
    access_time_start timestamp not null;
    isAuthorizedNow boolean;
);