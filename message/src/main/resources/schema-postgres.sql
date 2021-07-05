DROP TABLE IF EXISTS message;

CREATE TABLE message(
	id serial PRIMARY KEY,
	date TIMESTAMP,
	text VARCHAR(255),
	emitter VARCHAR(255),
	receiver VARCHAR(255)
);