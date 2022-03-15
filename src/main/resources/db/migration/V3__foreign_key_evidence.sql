alter table users
    add foreign key (evidence_id) references evidence (id);
alter table users
    add foreign key (user_id) references logbook (id);
 alter table companies
    add foreign key (evidence_id) references evidence (id);
alter table companies
    add foreign key (company_id) references users (id);