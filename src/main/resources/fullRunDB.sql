DROP TABLE IF EXISTS da_full_runs;

CREATE TABLE da_full_runs (
    full_run_id SERIAL,
    full_run_num integer not null,
    full_run_start_date date,
    full_run_bit_type varchar(50),
    full_run_bit_IADC varchar(10),
    full_run_bit_serial varchar(50),
    full_run_start_depth float not null,
    full_run_end_depth float not null,
    full_run_penetration float not null,
    full_run_drilling_time float not null,
    full_run_ROP float not null,
    full_run_bit_diameter float,
    full_run_pad_name varchar(10) not null,
    full_run_well_name varchar(10) not null,
    full_run_purpose varchar(50),
    full_run_well_construction varchar(50),
    full_run_bit_producer varchar(30),
    full_run_pad_set varchar(10),
    full_run_field_name varchar(50) not null,
    PRIMARY KEY (full_run_id)
)