alter table users
    add foreign key (evidence_id) references evidence (id);
 alter table companies
    add foreign key (evidence_id) references evidence (id);