# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table Area (
  id                        bigint auto_increment not null,
  name                      varchar(255),
  scope                     varchar(16),
  constraint ck_Area_scope check (scope in ('REGION','COUNTRY','GROUPOFCOUNTRIES','CONTINENT')),
  constraint pk_Area primary key (id))
;

create table Follow (
  id                        bigint auto_increment not null,
  indicator_id              bigint,
  user_id                   bigint,
  constraint pk_Follow primary key (id))
;

create table Indicator (
  id                        bigint auto_increment not null,
  name                      varchar(255),
  constraint pk_Indicator primary key (id))
;

create table Membership (
  id                        bigint auto_increment not null,
  user_id                   bigint,
  organization_id           bigint,
  constraint pk_Membership primary key (id))
;

create table Observation (
  id                        bigint auto_increment not null,
  value                     varchar(255),
  measure                   varchar(255),
  time_id                   bigint,
  indicator_id              bigint,
  area_id                   bigint,
  provider_id               bigint,
  publish_date              datetime,
  constraint pk_Observation primary key (id))
;

create table Organization (
  organization_type         varchar(31) not null,
  id                        bigint auto_increment not null,
  name                      varchar(255),
  site                      varchar(255),
  acronym                   varchar(255),
  parent_id                 bigint,
  constraint pk_Organization primary key (id))
;

create table Time (
  time_type                 varchar(31) not null,
  id                        bigint auto_increment not null,
  instant                   varchar(255),
  start_id                  bigint,
  end_id                    bigint,
  constraint pk_Time primary key (id))
;

create table User (
  id                        bigint auto_increment not null,
  name                      varchar(255),
  surname                   varchar(255),
  email                     varchar(255),
  password                  varchar(255),
  constraint pk_User primary key (id))
;

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

SET FOREIGN_KEY_CHECKS=0;

drop table Area;

drop table Follow;

drop table Indicator;

drop table Membership;

drop table Observation;

drop table Organization;

drop table Time;

drop table User;

SET FOREIGN_KEY_CHECKS=1;

