INSERT INTO dashboards (id,created_at,title,updated_at) VALUES(1,'2018-11-01 8:23:12',"Title 1",'2018-11-01 8:23:12');
INSERT INTO dashboards (id,created_at,title,updated_at)  VALUES(2,'2018-11-02 8:23:12',"Title 2",'2018-11-02 8:23:12');
INSERT INTO dashboards (id,created_at,title,updated_at)  VALUES(3,'2018-11-03 8:23:12',"Title 3",'2018-11-03 8:23:12');
INSERT INTO dashboards (id,created_at,title,updated_at)  VALUES(4,'2018-11-04 8:23:12',"Title 4",'2018-11-04 8:23:12');
INSERT INTO dashboards (id,created_at,title,updated_at)  VALUES(5,'2018-11-05 8:23:12',"Title 5",'2018-11-05 8:23:12');
INSERT INTO dashboards (id,created_at,title,updated_at)  VALUES(6,'2018-11-06 8:23:12',"Title 6",'2018-11-06 8:23:12');
INSERT INTO dashboards (id,created_at,title,updated_at)  VALUES(7,'2018-11-07 8:23:12',"Title 7",'2018-11-07 8:23:12');
INSERT INTO dashboards (id,created_at,title,updated_at)  VALUES(8,'2018-11-08 8:23:12',"Title 8",'2018-11-08 8:23:12');
INSERT INTO dashboards (id,created_at,title,updated_at)  VALUES(9,'2018-11-09 8:23:12',"Title 9",'2018-11-09 8:23:12');
INSERT INTO dashboards (id,created_at,title,updated_at)  VALUES(10,'2018-11-10 8:23:12',"Title 10",'2018-11-10 8:23:12');
INSERT INTO dashboards (id,created_at,title,updated_at)  VALUES(12,'2018-11-11 8:23:12',"Title 11",'2018-11-11 8:23:12');
INSERT INTO dashboards (id,created_at,title,updated_at)  VALUES(13,'2018-11-12 8:23:12',"Title 12",'2018-11-12 8:23:12');

select * from 
SELECT * FROM dashboards;

DELETE FROM dashboards where id = '13';
DROP TABLE dashboards;
use definitions;
CREATE TABLE IF NOT EXISTS dashboards (
  id int(11) NOT NULL AUTO_INCREMENT,
  createdAt TIMESTAMP NOT NULL DEFAULT NOW(),
  updatedAt TIMESTAMP NOT NULL DEFAULT NOW() ON UPDATE NOW(),
  title varchar(100) NOT NULL,
 PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
