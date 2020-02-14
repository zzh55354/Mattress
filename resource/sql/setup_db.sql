CREATE DATABASE mattress_components;
CREATE TABLE foams(foam_name VARCHAR(100) NOT NULL, unit_price double(4,2) NOT NULL);
INSERT INTO foams(foam_name, unit_price) VALUES ("conventional white foam", 1.03);
INSERT INTO foams(foam_name, unit_price) VALUES ("copper infused memory foam", 1.78);
INSERT INTO foams(foam_name, unit_price) VALUES ("gel infused memory foam", 1.56);

CREATE TABLE outercovers(name VARCHAR(100) NOT NULL, unit_price double(4,2 NOT NULL));
INSERT INTO outercovers(name, unit_price) VALUES ("30% Tencent",  0.12);
INSERT INTO outercovers(name, unit_price) VALUES ("100% Polyester",  0.10);

