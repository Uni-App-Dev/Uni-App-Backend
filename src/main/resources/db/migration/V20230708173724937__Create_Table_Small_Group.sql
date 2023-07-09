 create table small_group (
        id bigserial NOT NULL PRIMARY KEY,
        name varchar(255) NOT NULL,
        sex varchar(255) NOT NULL check (sex in ('MASCULINO','FEMININO')),
        time time(6) NOT NULL,
        week_day varchar(255) NOT NULL check (week_day in ('SEGUNDA','TERCA','QUARTA','QUINTA'))
    );