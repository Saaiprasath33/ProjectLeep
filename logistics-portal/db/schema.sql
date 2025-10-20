-- PostgreSQL schema for logistics portal (optional)
CREATE TABLE IF NOT EXISTS users (
  user_id SERIAL PRIMARY KEY,
  name VARCHAR(50) NOT NULL,
  email VARCHAR(100) UNIQUE NOT NULL,
  contact VARCHAR(20),
  role VARCHAR(20),
  join_date TIMESTAMP
);

CREATE TABLE IF NOT EXISTS pickup_requests (
  request_id SERIAL PRIMARY KEY,
  user_id INT NOT NULL REFERENCES users(user_id),
  item_description VARCHAR(255),
  pickup_address VARCHAR(255),
  drop_address VARCHAR(255),
  request_status VARCHAR(20),
  requested_at TIMESTAMP,
  assigned_to INT REFERENCES users(user_id),
  assigned_at TIMESTAMP,
  completed_at TIMESTAMP,
  remarks VARCHAR(255)
);

CREATE TABLE IF NOT EXISTS pickup_logs (
  log_id SERIAL PRIMARY KEY,
  request_id INT NOT NULL REFERENCES pickup_requests(request_id),
  action VARCHAR(50),
  performed_by INT REFERENCES users(user_id),
  timestamp TIMESTAMP,
  remarks VARCHAR(255)
);
