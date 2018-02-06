-- Services
INSERT INTO "service" (id, name, duration_minutes, cooldown_minutes) VALUES (1, 'ServiceEntity-45-15', 45, 15);
INSERT INTO "service" (id, name, duration_minutes, cooldown_minutes) VALUES (2, 'ServiceEntity-60-0', 60, 0);
INSERT INTO "service" (id, name, duration_minutes, cooldown_minutes) VALUES (3, 'ServiceEntity-30-5', 30, 5);
INSERT INTO "service" (id, name, duration_minutes, cooldown_minutes) VALUES (4, 'ServiceEntity-30-10', 30, 10);
INSERT INTO "service" (id, name, duration_minutes, cooldown_minutes) VALUES (5, 'ServiceEntity-50-10', 50, 10);
INSERT INTO "service" (id, name, duration_minutes, cooldown_minutes) VALUES (6, 'ServiceEntity-60-10', 60, 10);
INSERT INTO "service" (id, name, duration_minutes, cooldown_minutes) VALUES (7, 'ServiceEntity-60-15', 60, 15);
INSERT INTO "service" (id, name, duration_minutes, cooldown_minutes) VALUES (8, 'ServiceEntity-90-20', 90, 20);
ALTER SEQUENCE service_id_seq RESTART WITH 8;

-- Specialists
INSERT INTO "specialist" (id, first_name, second_name) VALUES (1, 'Specone', 'First');
INSERT INTO "specialist" (id, first_name, second_name) VALUES (2, 'Spectwo', 'Second');
INSERT INTO "specialist" (id, first_name, second_name) VALUES (3, 'Specthree', 'Third');
INSERT INTO "specialist" (id, first_name, second_name) VALUES (4, 'SpecBoss', 'Zero');
ALTER SEQUENCE specialist_id_seq RESTART WITH 4;

-- Service_Specialists relation
INSERT INTO "service_specialist" (specialist_id, service_id) VALUES (1, 1);
INSERT INTO "service_specialist" (specialist_id, service_id) VALUES (1, 2);
INSERT INTO "service_specialist" (specialist_id, service_id) VALUES (1, 5);
INSERT INTO "service_specialist" (specialist_id, service_id) VALUES (1, 7);
INSERT INTO "service_specialist" (specialist_id, service_id) VALUES (2, 1);
INSERT INTO "service_specialist" (specialist_id, service_id) VALUES (2, 2);
INSERT INTO "service_specialist" (specialist_id, service_id) VALUES (2, 5);
INSERT INTO "service_specialist" (specialist_id, service_id) VALUES (2, 7);
INSERT INTO "service_specialist" (specialist_id, service_id) VALUES (3, 2);
INSERT INTO "service_specialist" (specialist_id, service_id) VALUES (3, 3);
INSERT INTO "service_specialist" (specialist_id, service_id) VALUES (3, 8);
INSERT INTO "service_specialist" (specialist_id, service_id) VALUES (4, 1);
INSERT INTO "service_specialist" (specialist_id, service_id) VALUES (4, 2);
INSERT INTO "service_specialist" (specialist_id, service_id) VALUES (4, 3);
INSERT INTO "service_specialist" (specialist_id, service_id) VALUES (4, 4);
INSERT INTO "service_specialist" (specialist_id, service_id) VALUES (4, 5);
INSERT INTO "service_specialist" (specialist_id, service_id) VALUES (4, 6);
INSERT INTO "service_specialist" (specialist_id, service_id) VALUES (4, 7);
INSERT INTO "service_specialist" (specialist_id, service_id) VALUES (4, 8);
