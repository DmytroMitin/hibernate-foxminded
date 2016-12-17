--<ScriptOptions statementTerminator=";"/>

drop table if exists public.department;
CREATE TABLE public.department (
	department_id BIGINT PRIMARY KEY ,
	dept_name VARCHAR(50) NOT NULL DEFAULT '0'
	
);


drop table if exists public.employee;

CREATE TABLE public.employee (
	employee_id BIGINT PRIMARY KEY,
	firstname VARCHAR(50) NULL DEFAULT NULL,
	lastname VARCHAR(50) NULL DEFAULT NULL,
	birth_date DATE NULL DEFAULT NULL,
	cell_phone VARCHAR(15) NULL DEFAULT NULL,
	department_id BIGINT references public.department(department_id)
);

create sequence public.hibernate_sequences;
create sequence public.hibernate_sequence;

