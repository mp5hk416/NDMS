USE ndms_me_ams;





DROP TABLE IF EXISTS me_emp_admin_role;
DROP TABLE IF EXISTS me_emp_role_authority;

#機構管理員表

DROP TABLE IF EXISTS me_emp_admin;

CREATE TABLE me_emp_admin (id BIGINT UNSIGNED AUTO_INCREMENT COMMENT '機構人員ID',
							      username VARCHAR(50) NOT NULL COMMENT '用戶名稱',
							      emp_number VARCHAR(50) DEFAULT NULL COMMENT '員工編號',
							      password VARCHAR(64) DEFAULT NULL COMMENT '密碼',
							      mail VARCHAR(100) DEFAULT NULL COMMENT '信箱',
							      cell_phone VARCHAR(50) DEFAULT NULL COMMENT '手機',
							      enable TINYINT(4) UNSIGNED DEFAULT NULL COMMENT '是否可用',
							      locked TINYINT(4) UNSIGNED DEFAULT NULL COMMENT '是否上鎖',
							      last_login_ip VARCHAR(50) DEFAULT NULL COMMENT '最後更新位址',
							      login_count INT(10) DEFAULT NULL COMMENT '登陸次數',
							      gmt_last_login TIMESTAMP DEFAULT CURRENT_TIMESTAMP COMMENT '上次登入時間',
							      gmt_created TIMESTAMP DEFAULT CURRENT_TIMESTAMP COMMENT '帳號創建時間',
							      gmt_modified TIMESTAMP DEFAULT CURRENT_TIMESTAMP COMMENT '帳號修改時間',
									PRIMARY KEY(id),
									UNIQUE KEY(emp_number))
									ENGINE=INNODB COMMENT '機構管理員表' CHARSET=utF8mb4;
							
							
INSERT INTO me_emp_admin (id,username,emp_number,password,mail,cell_phone,enable,locked,last_login_ip,login_count,gmt_last_login,gmt_created,gmt_modified)
                         VALUES(1,'Jackie','IEC070821','mp5hk416','mp5hk416@gmail.com','886931969398',1,0,'127.0.0.1',12,'2020-01-05 15:30:59','2019-12-12 20:20:28','2019-12-25 08:35:23'),
                         		 (2,'Tom','IEC070820','tomtomisgood','tommail@gmail.com','886954287693',1,0,'127.0.0.1',15,'2020-01-03 20:37:42','2019-12-05 11:45:36','2019-12-06,13:42:56'),
                         		 (3,'Willison','IEC058346','WWWSSSdamn',NULL,NULL,1,0,'127.0.0.1',5,'2020-01-02 17:30:31','2019-12-28 15:36:33','2019-12-28 17:35:55'),
                         		 (4,'Logan','IEC959324','wolfrine','logantech@iecmail.com','886938965492',1,0,'127.0.0.1',17,'2020-01-08 21:35:55','2019-12-05 14:37:33','2019-12-05 17:50:39');
                         		 
#機構人員職稱表

DROP TABLE IF EXISTS me_emp_role;

CREATE TABLE me_emp_role (id BIGINT UNSIGNED AUTO_INCREMENT COMMENT '職稱表ID',
                          role_name VARCHAR(50) NOT NULL COMMENT '職稱名稱',
                          description TINYTEXT DEFAULT NULL COMMENT '職稱敘述',
                          sort TINYINT DEFAULT NULL COMMENT '類別',
                          gmt_created TIMESTAMP DEFAULT CURRENT_TIMESTAMP COMMENT '創建時間',
                          gmt_modified TIMESTAMP DEFAULT CURRENT_TIMESTAMP COMMENT '修改時間',
                          PRIMARY KEY(id),
                          UNIQUE KEY(role_name))
                          ENGINE=INNODB COMMENT '人員職稱表' CHARSET=utf8mb4;
                          
                          
INSERT INTO me_emp_role (id,role_name,description,sort,gmt_created,gmt_modified) VALUES
                         (1,'機構上級管理員',NULL,0,'2022-03-12 20:30:35','2022-03-12 20:30:35'),
								 (2,'機構中級管理員',NULL,0,'2022-03-12 20:33:57','2022-03-12 20:33:57'),
								 (3,'機構基礎管理員',NULL,0,'2022-03-12 21:05:52','2022-03-12 21:05:52');
								 
					



#機構人員權限表

DROP TABLE IF EXISTS me_emp_authority;
                     



CREATE TABLE me_emp_authority (id BIGINT UNSIGNED AUTO_INCREMENT COMMENT '權限ID',
                               authority VARCHAR(50) NOT NULL COMMENT '權限',
                               value VARCHAR(50) NOT NULL COMMENT '權限值',
                               description TINYTEXT DEFAULT NULL COMMENT '權限敘述',
                               sort TINYINT DEFAULT NULL COMMENT '類別',
                               gmt_created TIMESTAMP DEFAULT CURRENT_TIMESTAMP COMMENT '創建時間',
                               gmt_modified TIMESTAMP DEFAULT CURRENT_TIMESTAMP COMMENT '修改時間',
                               PRIMARY KEY(id),
                               UNIQUE KEY(authority))
                               ENGINE=INNODB COMMENT '權限表' CHARSET=utf8mb4;
                               
                               
INSERT INTO me_emp_authority(id,authority,value,description,sort,gmt_created,gmt_modified) VALUES
                            (1,'新增機構組件','/meElement/add',NULL,0,'2020-02-11 15:35:57','2020-02-11 15:35:57'),
									 (2,'刪除機構組件','/meElement/delete',NULL,0,'2020-02-11 15:37:43','2020-02-11 15:37:43'),
									 (3,'修改機構組件','/meElement/update',NULL,0,'2020-02-11 15:52:40','2020-02-11 15:52:40'),
									 (4,'查詢機構組件','/meElement/list',NULL,0,'2020-02-11 16:12:05','2020-02-11 16:12:05'),
									 (5,'新增人員','/admin/add',NULL,0,'2020-02-11 16:13:21','2020-02-11 16:13:21'),
									 (6,'刪除人員','/admin/delete',NULL,0,'2020-02-11 16:15:23','2020-02-11 16:15:23'),
									 (7,'修改人員','/admin/upddate',NULL,0,'2020-02-11 16:16:45','2020-02-11 16:16:45'),
									 (8,'查詢人員','/admin/list',NULL,0,'2020-02-11 16:17:02','2020-02-11 16:17:02');                              
                               




#機構管理員職稱表
                              

CREATE TABLE me_emp_admin_role(id BIGINT UNSIGNED AUTO_INCREMENT COMMENT 'ID',
                               admin_id BIGINT UNSIGNED NOT NULL COMMENT '管理員ID',
                               role_id BIGINT UNSIGNED NOT NULL COMMENT '職稱ID',
                               gmt_created TIMESTAMP DEFAULT CURRENT_TIMESTAMP COMMENT '創建時間',
                               gmt_update TIMESTAMP DEFAULT CURRENT_TIMESTAMP COMMENT '修改時間',
                               PRIMARY KEY(id),
                               FOREIGN KEY(admin_id) REFERENCES me_emp_admin(id),
										 FOREIGN KEY(role_id) REFERENCES me_emp_role(id))
                               ENGINE=INNODB COMMENT '管理員職稱表' CHARSET=utf8mb4;
                               
                               
INSERT INTO me_emp_admin_role(id,admin_id,role_id,gmt_created,gmt_update) VALUES
                             (1,1,3,'2020-01-11 13:35:24','2020-01-11 13:35:24'),
									  (2,2,3,'2020-01-11 13:52:33','2020-01-11 13:52:33'),
									  (3,3,3,'2020-01-11 14:51:05','2020-01-11 14:51:05'),
									  (4,3,2,'2020-01-11 13:32:02','2020-01-11 13:32:02'),
									  (5,4,1,'2020-01-12 17:35:14','2020-01-12 17:35:14'),
									  (6,4,2,'2020-01-12 17:35:14','2020-01-12 17:35:14'),
									  (7,4,3,'2020-01-12 17:35:14','2020-01-12 17:35:14');
									  


									  
									  
#機構職稱權限表									  
									  
								
CREATE TABLE me_emp_role_authority(id BIGINT UNSIGNED AUTO_INCREMENT COMMENT 'ID',
                                   role_id BIGINT UNSIGNED NOT NULL COMMENT '職稱ID',
                                   authority_id BIGINT UNSIGNED NOT NULL COMMENT '權威id',
                                   gmt_created TIMESTAMP DEFAULT CURRENT_TIMESTAMP COMMENT '創建時間',
                                   gmt_update TIMESTAMP DEFAULT CURRENT_TIMESTAMP COMMENT '修改時間',
                                   PRIMARY KEY(id),
                                   FOREIGN KEY(authority_id) REFERENCES me_emp_authority(id),
                                   FOREIGN KEY(role_id) REFERENCES me_emp_role(Id))
                                   ENGINE=INNODB COMMENT '職稱權限表' CHARSET=utf8mb4;
                                   
INSERT INTO me_emp_role_authority(id,role_id,authority_id,gmt_created,gmt_update) VALUES
                                 (1,1,1,'2020-01-01 15:33:44','2020-01-01 15:33:44'),
											(2,1,2,'2020-01-01 15:33:44','2020-01-01 15:33:44'),
											(3,1,3,'2020-01-01 15:33:44','2020-01-01 15:33:44'),
											(4,1,4,'2020-01-01 15:33:44','2020-01-01 15:33:44'),
											(5,1,5,'2020-01-01 15:33:44','2020-01-01 15:33:44'),
											(6,1,6,'2020-01-01 15:33:44','2020-01-01 15:33:44'),
											(7,1,7,'2020-01-01 15:33:44','2020-01-01 15:33:44'),
											(8,1,8,'2020-01-01 15:33:44','2020-01-01 15:33:44'),
											(9,2,1,'2020-01-01 15:33:44','2020-01-01 15:33:44'),
											(10,2,2,'2020-01-01 15:33:44','2020-01-01 15:33:44'),
											(11,2,3,'2020-01-01 15:33:44','2020-01-01 15:33:44'),
											(12,2,4,'2020-01-01 15:33:44','2020-01-01 15:33:44'),
											(13,2,5,'2020-01-01 15:33:44','2020-01-01 15:33:44'),
											(14,2,8,'2020-01-01 15:33:44','2020-01-01 15:33:44'),
											(15,3,1,'2020-01-01 15:33:44','2020-01-01 15:33:44'),
											(16,3,2,'2020-01-01 15:33:44','2020-01-01 15:33:44'),
											(17,3,3,'2020-01-01 15:33:44','2020-01-01 15:33:44'),
											(18,3,4,'2020-01-01 15:33:44','2020-01-01 15:33:44');                                   
                                   
                                   
                                   
                                   
									  
									                                
                               


								 
								                          
							      
							      