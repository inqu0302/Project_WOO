CREATE DATABASE woo;

use woo;

CREATE TABLE tbl_addr(
		ar_code	CHAR(10)		PRIMARY KEY,
		ar_si	VARCHAR(10)	,
		ar_gu	VARCHAR(10)	,	
		ar_dong	VARCHAR(10)	,	
		ar_x	VARCHAR(5)	,	
		ar_y	VARCHAR(5)	,	
		ar_addr	VARCHAR(100)
);

select * from tbl_addr;