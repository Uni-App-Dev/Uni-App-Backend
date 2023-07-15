create table person (
    id bigserial NOT NULL PRIMARY KEY,
    name varchar(255) NOT NULL,
    phone varchar(20) NOT NULL,
    sex varchar(10) NOT NULL check (sex in ('MASCULINO','FEMININO')),
    frequent_church varchar(50) check (frequent_church in ('SIM','JA_FREQUENTOU','NUNCA_FREQUENTOU')),
    avaliable_week_day varchar(50) check (avaliable_week_day in ('SEGUNDA','TERCA','QUARTA','QUINTA')),
    small_group_id bigint,
    small_group_role varchar(50) NOT NULL check (small_group_role in ('LIDER','MEMBRO','NAO_FREQUENTA')) default 'NAO_FREQUENTA'
);

alter table if exists person
       add constraint fk_person_small_group
       foreign key (small_group_id)
       references small_group;