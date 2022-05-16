--Drilling Analytics
DROP TABLE IF EXISTS da_runs;
DROP TABLE IF EXISTS da_bits;
DROP TABLE IF EXISTS da_sections;
DROP TABLE IF EXISTS da_wells;


CREATE TABLE da_wells (
     well_id SERIAL,
     field_name varchar(30) not null,
     pad_name varchar(15) not null,
     well_name varchar(15) not null,
     pad_set varchar(15),
     well_construction varchar(15),
     PRIMARY KEY(well_id)
);

CREATE TABLE da_sections (
     well_id integer not null,
     section_id SERIAL,
     section_start_date date,
--     section_diameter float not null,
     section_start_depth float not null,
     section_end_depth float not null,
     section_penetration float not null,
     section_drilling_time float not null,
     section_rop float not null,
     PRIMARY KEY(section_id),
     FOREIGN KEY(well_id) REFERENCES da_wells(well_id) ON DELETE RESTRICT
);

CREATE TABLE da_bits (
    bit_id SERIAL,
    bit_serial varchar(30) not null,
    bit_short_type varchar(10),
    bit_full_type varchar(30),
    bit_IADC_code varchar(10),
    bit_producer varchar(30),
    bit_diameter float not null,
    PRIMARY KEY(bit_id)
);

CREATE TABLE da_runs (
    run_id SERIAL,
    section_id integer not null,
    run_num integer not null,
    run_start_date date not null,
--    run_diameter float not null,
    run_start_depth float not null,
    run_end_depth float not null,
    run_penetration float not null,
    run_drilling_time float not null,
    run_rop float not null,
    run_purpose varchar(30) not null,
    bit_id integer not null,
    PRIMARY KEY(run_id),
    FOREIGN KEY(section_id) REFERENCES da_sections(section_id) ON DELETE RESTRICT,
--    FOREIGN KEY(run_diameter) REFERENCES da_sections(section_diameter) ON DELETE RESTRICT,
    FOREIGN KEY(bit_id) REFERENCES da_bits(bit_id) ON DELETE RESTRICT
);
