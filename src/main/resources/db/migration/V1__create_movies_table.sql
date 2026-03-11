CREATE TABLE movies (
                        id BIGSERIAL PRIMARY KEY,
                        title VARCHAR(255) NOT NULL,
                        description TEXT,
                        director VARCHAR(255),
                        release_date DATE,
                        duration_minutes INTEGER,
                        created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);