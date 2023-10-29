
DROP SEQUENCE seq_queuetransaction;
CREATE SEQUENCE seq_queuetransaction  INCREMENT 2  MINVALUE 10;

DROP SEQUENCE seq_custtransaction
CREATE SEQUENCE seq_custtransaction  INCREMENT 2  MINVALUE 11;



--- 
java -jar demo-0.0.1-SNAPSHOT.jar --server.port='8081' --app.dc='81'
java -jar demo-0.0.1-SNAPSHOT.jar --server.port='8082' --app.dc='82'


