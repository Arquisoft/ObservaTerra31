# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table Area (
  id                        bigint not null,
  name                      varchar(255),
  scope                     varchar(16),
  constraint ck_Area_scope check (scope in ('REGION','COUNTRY','GROUPOFCOUNTRIES','CONTINENT')),
  constraint pk_Area primary key (id))
;

create table Follow (
  id                        bigint not null,
  indicator_id              bigint,
  user_id                   bigint,
  constraint pk_Follow primary key (id))
;

create table Indicator (
  id                        bigint not null,
  name                      varchar(255),
  constraint pk_Indicator primary key (id))
;

create table Membership (
  id                        bigint not null,
  user_id                   bigint,
  organization_id           bigint,
  constraint pk_Membership primary key (id))
;

create table Observation (
  id                        bigint not null,
  value                     varchar(255),
  measure                   varchar(255),
  time_id                   bigint,
  indicator_id              bigint,
  area_id                   bigint,
  provider_id               bigint,
  publish_date              timestamp,
  constraint pk_Observation primary key (id))
;

create table Organization (
  organization_type         varchar(31) not null,
  id                        bigint not null,
  name                      varchar(255),
  site                      varchar(255),
  acronym                   varchar(255),
  parent_id                 bigint,
  constraint pk_Organization primary key (id))
;

create table Time (
  time_type                 varchar(31) not null,
  id                        bigint not null,
  instant                   varchar(255),
  start_id                  bigint,
  end_id                    bigint,
  constraint pk_Time primary key (id))
;

create table User (
  id                        bigint not null,
  name                      varchar(255),
  surname                   varchar(255),
  email                     varchar(255),
  password                  varchar(255),
  constraint pk_User primary key (id))
;

create sequence Area_seq;

create sequence Follow_seq;

create sequence Indicator_seq;

create sequence Membership_seq;

create sequence Observation_seq;

create sequence Organization_seq;

create sequence Time_seq;

create sequence User_seq;

alter table Follow add constraint fk_Follow_indicator_1 foreign key (indicator_id) references Indicator (id) on delete restrict on update restrict;
create index ix_Follow_indicator_1 on Follow (indicator_id);
alter table Follow add constraint fk_Follow_user_2 foreign key (user_id) references User (id) on delete restrict on update restrict;
create index ix_Follow_user_2 on Follow (user_id);
alter table Membership add constraint fk_Membership_user_3 foreign key (user_id) references User (id) on delete restrict on update restrict;
create index ix_Membership_user_3 on Membership (user_id);
alter table Membership add constraint fk_Membership_organization_4 foreign key (organization_id) references Organization (id) on delete restrict on update restrict;
create index ix_Membership_organization_4 on Membership (organization_id);
alter table Observation add constraint fk_Observation_time_5 foreign key (time_id) references Time (id) on delete restrict on update restrict;
create index ix_Observation_time_5 on Observation (time_id);
alter table Observation add constraint fk_Observation_indicator_6 foreign key (indicator_id) references Indicator (id) on delete restrict on update restrict;
create index ix_Observation_indicator_6 on Observation (indicator_id);
alter table Observation add constraint fk_Observation_area_7 foreign key (area_id) references Area (id) on delete restrict on update restrict;
create index ix_Observation_area_7 on Observation (area_id);
alter table Observation add constraint fk_Observation_provider_8 foreign key (provider_id) references Organization (id) on delete restrict on update restrict;
create index ix_Observation_provider_8 on Observation (provider_id);
alter table Organization add constraint fk_Organization_parent_9 foreign key (parent_id) references Organization (id) on delete restrict on update restrict;
create index ix_Organization_parent_9 on Organization (parent_id);
alter table Time add constraint fk_Time_start_10 foreign key (start_id) references Time (id) on delete restrict on update restrict;
create index ix_Time_start_10 on Time (start_id);
alter table Time add constraint fk_Time_end_11 foreign key (end_id) references Time (id) on delete restrict on update restrict;
create index ix_Time_end_11 on Time (end_id);



# --- !Downs

SET REFERENTIAL_INTEGRITY FALSE;

drop table if exists Area;

drop table if exists Follow;

drop table if exists Indicator;

drop table if exists Membership;

drop table if exists Observation;

drop table if exists Organization;

drop table if exists Time;

drop table if exists User;

SET REFERENTIAL_INTEGRITY TRUE;

drop sequence if exists Area_seq;

drop sequence if exists Follow_seq;

drop sequence if exists Indicator_seq;

drop sequence if exists Membership_seq;

drop sequence if exists Observation_seq;

drop sequence if exists Organization_seq;

drop sequence if exists Time_seq;

drop sequence if exists User_seq;

