-- Services
INSERT INTO "service" (name, duration_minutes, cooldown_minutes) VALUES ('ServiceEntity-45-15', 45, 15);
INSERT INTO "service" (name, duration_minutes, cooldown_minutes) VALUES ('ServiceEntity-60-0', 60, 0);
INSERT INTO "service" (name, duration_minutes, cooldown_minutes) VALUES ('ServiceEntity-30-5', 30, 5);

-- Specialists
INSERT INTO "specialist" (first_name, second_name) VALUES ('Specone', 'First');
INSERT INTO "specialist" (first_name, second_name) VALUES ('Spectwo', 'Second');

-- Service_Specialists relation
INSERT INTO "service_specialist" (service_id, specialist_id) VALUES (1, 1);
INSERT INTO "service_specialist" (service_id, specialist_id) VALUES (1, 2);
INSERT INTO "service_specialist" (service_id, specialist_id) VALUES (2, 1);
INSERT INTO "service_specialist" (service_id, specialist_id) VALUES (3, 2);
