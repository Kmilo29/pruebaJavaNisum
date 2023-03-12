INSERT INTO users (id, name, email, password, created, modified, last_login, is_active) 
VALUES (
'e333be9c-b8e9-434e-a420-42dc80502001', 
'John Doe', 
'john.doe@gmail.com', 
'$2a$10$CNelnV3AZKfOBs1u6u/jfePeSnh1k73TSwvDa.YEOISbPLM2yk1l2',
DATE '2023-03-10', 
DATE '2023-03-11', 
DATE '2023-03-13',
1);
commit;


INSERT INTO session (id, token, created, is_active, user_id) 
VALUES (
'e333be9c-b8e9-434e-c420-42dc80504001', 
'eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJqb2huLmRvZUBnbWFpbC5jb20iLCJleHAiOjYzNzUyNTE5NjQ2MTA2MSwibmFtZSI6InBydWViYTEyNUFAIn0.PdcO3CpOikWqmca1uaAlUGukhJnysJtir5dhEF3mZgQ',
DATE '2023-03-10', 
1,
'e333be9c-b8e9-434e-a420-42dc80502001');
commit;

INSERT INTO location (id, type_location, name, code) VALUES ('f333be9c-b8e9-434e-a420-42dc80502001', 'COUNTRY', 'Perú', '51');
INSERT INTO location (id, type_location, name, code) VALUES ('f333be9c-b8e9-434e-a420-42dc80502002', 'COUNTRY', 'Argentina', '54');
INSERT INTO location (id, type_location, name, code) VALUES ('f333be9c-b8e9-434e-a420-42dc80502003', 'COUNTRY', 'Brasil', '55');
INSERT INTO location (id, type_location, name, code) VALUES ('f333be9c-b8e9-434e-a420-42dc80502004', 'COUNTRY', 'Chile', '56');
INSERT INTO location (id, type_location, name, code) VALUES ('f333be9c-b8e9-434e-a420-42dc80502005', 'COUNTRY', 'Colombia', '57');
commit;

INSERT INTO location (id, type_location, name, code, parent_id) VALUES ('e333be9c-b8e9-434e-a420-42dc80503001', 'CITY', 'Bogotá', '1', 'f333be9c-b8e9-434e-a420-42dc80502005');
INSERT INTO location (id, type_location, name, code, parent_id) VALUES ('e333be9c-b8e9-434e-a420-42dc80503002', 'CITY', 'Cali', '2', 'f333be9c-b8e9-434e-a420-42dc80502005');
INSERT INTO location (id, type_location, name, code, parent_id) VALUES ('e333be9c-b8e9-434e-a420-42dc80503003', 'CITY', 'Medellín', '4', 'f333be9c-b8e9-434e-a420-42dc80502005');
INSERT INTO location (id, type_location, name, code, parent_id) VALUES ('e333be9c-b8e9-434e-a420-42dc80503004', 'CITY', 'Barranquilla', '5', 'f333be9c-b8e9-434e-a420-42dc80502005');
INSERT INTO location (id, type_location, name, code, parent_id) VALUES ('e333be9c-b8e9-434e-a420-42dc80503005', 'CITY', 'Bucaramanga', '7', 'f333be9c-b8e9-434e-a420-42dc80502005');
commit;


INSERT INTO phone (id, number, city_code_id, country_code_id, user_id) 
VALUES (
'e333be9c-b8e9-434e-a420-42dc80502003', 
'3178255',
'e333be9c-b8e9-434e-a420-42dc80503001',
'f333be9c-b8e9-434e-a420-42dc80502005',
'e333be9c-b8e9-434e-a420-42dc80502001');
INSERT INTO phone (id, number, city_code_id, country_code_id, user_id) 
VALUES (
'e333be9c-b8e9-434e-a420-42dc80502004', 
'3001212014',
'e333be9c-b8e9-434e-a420-42dc80503001',
'f333be9c-b8e9-434e-a420-42dc80502005',
'e333be9c-b8e9-434e-a420-42dc80502001');
commit;

