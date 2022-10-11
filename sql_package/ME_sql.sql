USE ndms_me;

/*機構人員表*/


DROP TABLE IF EXISTS me_layer;
DROP TABLE IF EXISTS me_project;
DROP TABLE IF EXISTS me_db;
DROP TABLE IF EXISTS me_manufacture;
DROP TABLE IF EXISTS me_staff;



CREATE TABLE me_staff(id BIGINT NOT NULL AUTO_INCREMENT COMMENT '機構人員表ID',
                         username VARCHAR(50) NOT NULL COMMENT '人員名稱',
                         dept VARCHAR(50) NOT NULL COMMENT '部門名稱',
                         charge VARCHAR(50) NOT NULL COMMENT '負責項目',
                         is_parent INT DEFAULT NULL COMMENT '是否為上級',
                         parent_id BIGINT DEFAULT NULL COMMENT '上級ID',
                         depth INT DEFAULT NULL COMMENT '級別',
                         PRIMARY KEY (id))
                         ENGINE=INNODB COMMENT='機構人員表' CHARSET=utf8mb4;
                         
INSERT INTO me_staff(id,username,dept,charge,is_parent,parent_id,depth)
              VALUES(1,'logan','ME','sentry',1,NULL,0),
				  		  (2,'Scott','ME','sentry;pcb',1,1,1),
                    (3,'Sam','ME','sentry;c',1,2,2),
                    (4,'Jackie','ME','sentry;d',0,3,3),
                    (5,'Willison','ME','sentry;a',0,2,2),
                    (6,'Tom','ME','sentry;b',0,2,2);
                         

/*廠商表*/

DROP TABLE IF EXISTS me_manufacture;

CREATE TABLE me_manufacture(id BIGINT NOT NULL AUTO_INCREMENT COMMENT '廠商ID',
								    name VARCHAR(100) NOT NULL COMMENT '廠商名稱',
								    description TINYTEXT DEFAULT NULL COMMENT '敘述',
								    created_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP COMMENT '創建時間',
									PRIMARY KEY (id))
								   ENGINE=INNODB COMMENT='廠商表' CHARSET=utf8mb4;
								   
INSERT INTO me_manufacture(id,name,description,created_date)
                    VALUES(1,'巨寶',NULL,'2016-10-19 10:35:56'),
                          (2,'和宇田',NULL,'2016-10-19 10:36:38'),
                          (3,'昶寶',NULL,'2016-10-19 10:38:07'),
                          (4,'鑫和',NULL,'2016-10-19 10:40:56'),
                          (5,'宇海塑膠',NULL,'2016-10-19 10:41:06'),
								  (6,'辰和塑料',NULL,'2016-10-19 10:50:26');

                              

/*機構件表*/

DROP TABLE IF EXISTS me_db;

CREATE TABLE me_db(id BIGINT NOT NULL AUTO_INCREMENT COMMENT '機構件表ID',
						 name VARCHAR(100) NOT NULL COMMENT '機構名稱',
						 part_number VARCHAR(100) DEFAULT NULL COMMENT '料號',
						 attribution_id INT DEFAULT NULL COMMENT 'GTK/OTK',
						 uploader VARCHAR(100) NOT NULL COMMENT '上傳人員',
						 uploader_id BIGINT DEFAULT NULL COMMENT '上傳人員ID',
						 description TINYTEXT DEFAULT NULL COMMENT '敘述',
						 url_2d VARCHAR(255) DEFAULT NULL COMMENT '2D圖',
						 url_3d VARCHAR(255) DEFAULT NULL COMMENT '3D圖',
						 manufacture VARCHAR(100) DEFAULT NULL COMMENT '廠商',
						 manufacture_id BIGINT DEFAULT NULL COMMENT '廠商ID',
						 created_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP COMMENT '創建日期',
						 update_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP COMMENT '最後更新日期',
						 PRIMARY KEY (id),
						 UNIQUE KEY (part_number),
						 FOREIGN KEY (uploader_id) REFERENCES me_staff(id),
						 FOREIGN KEY (manufacture_id) REFERENCES me_manufacture(id))
						 ENGINE=INNODB COMMENT='機構組件表' CHARSET=utf8mb4;
						 
						 
INSERT INTO me_db(id,name,part_number,attribution_id,uploader,uploader_id,description,url_2d,url_3d,manufacture,manufacture_id,created_date,update_date)
				values(1,'sentry_wlan_d_cover','6053B0000001',1,'Jackie',3,'AZ91D',NULL,NULL,'聚寶製成',1,'2020-12-05 20:35:20','2021-11-15 15:25:03'),
						(2,'sentry_wwan_d_cover','6053B0000002',1,'Jackie',3,'AZ91D;INSERTMOLDING;PC=ABS',NULL,NULL,'聚寶製成',1,'2020-12-05 20:42:33','2021-10-30 13:48:52'),
						(3,'sentry_foot_front','6052B0000201',2,'Jackie',3,'RUBBER',NULL,NULL,'PCV;昶寶',3,'2020-09-22 08:22:33','2021-11-07 12:47:50'),
						(4,'sentry_foot_rear','6052B0000202',2,'Jackie',3,'RUBBER',NULL,NULL,'PCV;昶寶',3,'2020-09-22 09:05:59','2021-11-01 11:02:58'),
						(5,'floating_screw','6050B0009505',2,'Willison',4,'Fe-Ni',NULL,NULL,'鑫合製成',4,'2018-03-08 10:22:24','2018-04-01 09:03:05'),
						(6,'side_hook_1','6052B0000301',2,'Tom',5,'PC+ABS',NULL,NULL,'宇海塑膠',5,'2020-11-12 14:33:08','2022-02-17 15:40:32'),
						(7,'side_hook_2','6052B0000302',2,'Tom',5,'PC+ABS',NULL,NULL,'宇海塑膠',5,'2020-11-12 14:35:25','2022-02-17 15:50:53');						 



/*項目表*/

					                 
DROP TABLE IF EXISTS me_project;

CREATE TABLE me_project(id BIGINT NOT NULL AUTO_INCREMENT COMMENT '項目ID',
                        project_name VARCHAR(50) NOT NULL COMMENT '項目名稱',
                        leader VARCHAR(50)NOT NULL COMMENT '負責人',
                        leader_id BIGINT NOT NULL COMMENT '負責人ID',
                        created_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP COMMENT '項目創建時間',
                        PRIMARY KEY (id),
                        FOREIGN KEY (leader_id) REFERENCES me_staff(id))
                        ENGINE = INNODB COMMENT '項目表' CHARSET=utf8mb4;
                        
INSERT INTO me_project(id,project_name,leader,leader_id,created_date)
                VALUES(1,'sentry','logan',1,'2020-02-20 10:30:52'),
					       (2,'starfox','logan',1,'2020-02-19 11:32:33'),
							 (3,'hickory','logan',1,'2019-01-05 15:35:22');


DROP TABLE IF EXISTS me_layer;


/*項目層級表*/

CREATE TABLE me_layer(id BIGINT NOT NULL AUTO_INCREMENT COMMENT '機構類型ID',
									category_name VARCHAR(100) NOT NULL COMMENT '類型名稱',
									project_id BIGINT NOT NULL COMMENT '項目ID',
									parent_id BIGINT DEFAULT NULL COMMENT '上級ID',
									is_parent INT DEFAULT NULL COMMENT '是否為上級',
									depth INT DEFAULT NULL COMMENT '級別',
									description TINYTEXT DEFAULT NULL COMMENT '敘述',
									PRIMARY KEY (id),
									FOREIGN KEY (project_id) REFERENCES me_project(id))
									ENGINE=INNODB COMMENT='機構類別表' CHARSET=utf8mb4;
									
INSERT INTO me_layer(id,category_name,project_id,parent_id,is_parent,depth,description)
					           VALUES(1,'sentry_main_set',1,NULL,1,0,'main'),
					                 (2,'sentry_main_A_set',1,1,1,1,'A_SET'),
					                 (3,'sentry_main_B_set',1,1,1,1,'B_SET'),
					                 (4,'sentry_main_C_set',1,1,1,1,'C_SET'),
					                 (5,'sentry_main_D_set',1,1,1,1,'D_SET'),
					                 (6,'sentry_panel_set',1,2,1,2,'panel_set'),
					                 (7,'sentry_bezel_set',1,3,1,2,'bezel_set'),
					                 (8,'sentry_clip_set',1,4,1,2,'clip_set'),
					                 (9,'sentry_foot_set',1,5,1,2,'foot_set');


							 
							 


									
									
						 
desc me_db;

SHOW CREATE TABLE me_db;

SELECT * FROM me_db;
SELECT * FROM me_staff;
SELECT * FROM me_layer;
SELECT * FROM me_project;
SELECT * FROM me_manufacture;
						 
						 