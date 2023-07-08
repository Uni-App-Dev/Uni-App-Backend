create table person (
    id bigint PRIMARY KEY NOT NULL,
    name varchar(255) NOT NULL,
    phone varchar(20) NOT NULL,
    sex varchar(10) NOT NULL check (sex in ('MASCULINO','FEMININO')),
    frequent_church varchar(50) check (frequent_church in ('SIM','JA_FREQUENTOU','NUNCA_FREQUENTOU')),
    avaliable_week_day varchar(50) check (avaliable_week_day in ('SEGUNDA','TERCA','QUARTA','QUINTA'))
);