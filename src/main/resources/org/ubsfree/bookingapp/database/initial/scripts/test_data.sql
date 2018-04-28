-- User
INSERT INTO "user" (id, outer_id, name) VALUES (1, '4819', 'User Test');
ALTER SEQUENCE service_id_seq RESTART WITH 1;

-- Services
INSERT INTO "service" (id, name, description, duration_minutes, cooldown_minutes, user_id) VALUES (200, 'ServiceEntity-45-15', 'Test description', 45, 15, 1);
INSERT INTO "service" (id, name, duration_minutes, cooldown_minutes, user_id) VALUES (201, 'ServiceEntity-60-0', 60, 0, 1);
INSERT INTO "service" (id, name, duration_minutes, cooldown_minutes, conflictable, user_id) VALUES (202, 'ServiceEntity-30-5', 30, 5, false, 1);
INSERT INTO "service" (id, name, duration_minutes, cooldown_minutes, conflictable, user_id) VALUES (203, 'ServiceEntity-30-10', 30, 10, false, 1);
INSERT INTO "service" (id, name, duration_minutes, cooldown_minutes, user_id) VALUES (204, 'ServiceEntity-50-10', 50, 10, 1);
INSERT INTO "service" (id, name, duration_minutes, cooldown_minutes, user_id) VALUES (205, 'ServiceEntity-60-10', 60, 10, 1);
INSERT INTO "service" (id, name, duration_minutes, cooldown_minutes, user_id) VALUES (206, 'ServiceEntity-60-15', 60, 15, 1);
INSERT INTO "service" (id, name, duration_minutes, cooldown_minutes, user_id) VALUES (207, 'ServiceEntity-90-20', 90, 20, 1);
ALTER SEQUENCE service_id_seq RESTART WITH 207;

-- Specialists
INSERT INTO "specialist" (id, first_name, second_name, middle_name, user_id) VALUES (300, 'Specone', 'First', 'Middle', 1);
INSERT INTO "specialist" (id, first_name, second_name, user_id) VALUES (301, 'Spectwo', 'Second', 1);
INSERT INTO "specialist" (id, first_name, second_name, user_id) VALUES (302, 'Specthree', 'Third', 1);
INSERT INTO "specialist" (id, first_name, second_name, user_id) VALUES (303, 'SpecBoss', 'Zero', 1);
ALTER SEQUENCE specialist_id_seq RESTART WITH 303;

-- Service_Specialists relation
INSERT INTO "service_specialist" (specialist_id, service_id) VALUES (300, 200);
INSERT INTO "service_specialist" (specialist_id, service_id) VALUES (300, 201);
INSERT INTO "service_specialist" (specialist_id, service_id) VALUES (300, 204);
INSERT INTO "service_specialist" (specialist_id, service_id) VALUES (300, 206);
INSERT INTO "service_specialist" (specialist_id, service_id) VALUES (301, 200);
INSERT INTO "service_specialist" (specialist_id, service_id) VALUES (301, 201);
INSERT INTO "service_specialist" (specialist_id, service_id) VALUES (301, 204);
INSERT INTO "service_specialist" (specialist_id, service_id) VALUES (301, 206);
INSERT INTO "service_specialist" (specialist_id, service_id) VALUES (302, 201);
INSERT INTO "service_specialist" (specialist_id, service_id) VALUES (302, 202);
INSERT INTO "service_specialist" (specialist_id, service_id) VALUES (302, 207);
INSERT INTO "service_specialist" (specialist_id, service_id) VALUES (303, 200);
INSERT INTO "service_specialist" (specialist_id, service_id) VALUES (303, 201);
INSERT INTO "service_specialist" (specialist_id, service_id) VALUES (303, 202);
INSERT INTO "service_specialist" (specialist_id, service_id) VALUES (303, 203);
INSERT INTO "service_specialist" (specialist_id, service_id) VALUES (303, 204);
INSERT INTO "service_specialist" (specialist_id, service_id) VALUES (303, 205);
INSERT INTO "service_specialist" (specialist_id, service_id) VALUES (303, 206);
INSERT INTO "service_specialist" (specialist_id, service_id) VALUES (303, 207);
