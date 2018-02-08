CREATE OR REPLACE VIEW booking_overview AS
  SELECT
    b.id,
    b.time_start,
    b.time_start + sr.duration_minutes * INTERVAL '1 minute'                         AS time_end,
    b.time_start + (sr.duration_minutes + sr.cooldown_minutes) * INTERVAL '1 minute' AS next_available_booking,
    sr.duration_minutes,
    sr.cooldown_minutes,
    b.service_id,
    b.specialist_id
  FROM booking b
    JOIN service sr ON b.service_id = sr.id
    JOIN specialist spec ON b.specialist_id = spec.id;