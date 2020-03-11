CREATE DATABASE mattress_components;
CREATE TABLE foams(foam_name VARCHAR(100) NOT NULL, unit_price double(4,2) NOT NULL);
INSERT INTO foams(foam_name, unit_price) VALUES ("conventional white foam", 1.03);
INSERT INTO foams(foam_name, unit_price) VALUES ("copper infused memory foam", 1.78);
INSERT INTO foams(foam_name, unit_price) VALUES ("gel infused memory foam", 1.56);

CREATE TABLE outercovers(name VARCHAR(100) NOT NULL, unit_price double(4,2 NOT NULL));
INSERT INTO outercovers(name, unit_price) VALUES ("30% Tencent",  0.12);
INSERT INTO outercovers(name, unit_price) VALUES ("100% Polyester",  0.10);

CREATE TABLE OUTER_COVERS(Cover_ID VARCHAR(100) NOT NULL, Cover_Name VARCHAR(100) NOT NULL,Twin Double(5,2) NOT NULL,Txl Double(5,2) NOT NULL, Full Double(5,2) NOT NULL,Queen Double(5,2) NOT NULL, King Double(5,2) NOT NULL, Cking Double(5,2) NOT NULL);
INSERT INTO OUTER_COVERS(Cover_ID, Cover_Name, Twin,Txl,Full,Queen,King,Cking) VALUES ("NSSB001","SEAR BED OUTER COVER", 6.7,7.8,9.0,12.5,14.8,14.7);
