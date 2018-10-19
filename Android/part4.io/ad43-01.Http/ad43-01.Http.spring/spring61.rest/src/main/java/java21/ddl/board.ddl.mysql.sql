--  -- springboard 데이터베이스 생성
--  DROP DATABASE IF EXISTS springboard;
--  
--  CREATE DATABASE springboard DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;
--  
--  
--  -- 사용자 추가
--  GRANT ALL ON springboard.* TO tester1@localhost IDENTIFIED BY '1234';
--  
--  FLUSH PRIVILEGES;

-- 데이터베이스 변경
USE springboard;



-- 테이블 제거하기
DROP TABLE IF EXISTS TB_Bbs_Comments;
DROP TABLE IF EXISTS TB_Bbs_Attachfile;
DROP TABLE IF EXISTS TB_Bbs_Article;
DROP TABLE IF EXISTS TB_Bbs_Board;
DROP TABLE IF EXISTS TB_Bbs_Recommend;
DROP TABLE IF EXISTS TB_User;
DROP TABLE IF EXISTS TB_Logs;

-- 게시판 종류 테이블
CREATE TABLE IF NOT EXISTS  TB_Bbs_Board (
      boardcd       NVARCHAR(20)   NOT NULL   
    , boardnm       NVARCHAR(40)   NOT NULL      
    , UseYN         TINYINT(1)     NULL     DEFAULT  1  

    , InsertUID     VARCHAR(40)    NULL 
    , InsertDT      DateTime       NULL  
    , UpdateUID     VARCHAR(40)    NULL 
    , UpdateDT      DateTime       NULL 
    
    , PRIMARY KEY(boardcd)
)
ENGINE=InnoDB 
AUTO_INCREMENT=1 
DEFAULT CHARACTER SET utf8 
COLLATE utf8_general_ci;

insert into TB_Bbs_Board(boardcd, boardnm) values ('free','자유게시판');
insert into TB_Bbs_Board(boardcd, boardnm) values ('qna' ,'QnA게시판' );
insert into TB_Bbs_Board(boardcd, boardnm) values ('data','자료실'    );
insert into TB_Bbs_Board(boardcd, boardnm) values ('bc01','자01'    );
insert into TB_Bbs_Board(boardcd, boardnm) values ('bc02','자02'    );
insert into TB_Bbs_Board(boardcd, boardnm) values ('bc03','자03'    );
insert into TB_Bbs_Board(boardcd, boardnm) values ('bc04','자04'    );
insert into TB_Bbs_Board(boardcd, boardnm) values ('bc05','자05'    );
insert into TB_Bbs_Board(boardcd, boardnm) values ('bc06','자06'    );
insert into TB_Bbs_Board(boardcd, boardnm) values ('bc07','자07'    );
insert into TB_Bbs_Board(boardcd, boardnm) values ('bc08','자08'    );
insert into TB_Bbs_Board(boardcd, boardnm) values ('bc09','자09'    );
insert into TB_Bbs_Board(boardcd, boardnm) values ('bc10','자10'    );
insert into TB_Bbs_Board(boardcd, boardnm) values ('bc11','자11'    );
insert into TB_Bbs_Board(boardcd, boardnm) values ('bc12','자12'    );
insert into TB_Bbs_Board(boardcd, boardnm) values ('bc13','자13'    );
insert into TB_Bbs_Board(boardcd, boardnm) values ('bc14','자14'    );
insert into TB_Bbs_Board(boardcd, boardnm) values ('bc15','자15'    );
insert into TB_Bbs_Board(boardcd, boardnm) values ('bc16','자16'    );
insert into TB_Bbs_Board(boardcd, boardnm) values ('bc17','자17'    );
insert into TB_Bbs_Board(boardcd, boardnm) values ('bc18','자18'    );
insert into TB_Bbs_Board(boardcd, boardnm) values ('bc19','자19'    );
insert into TB_Bbs_Board(boardcd, boardnm) values ('bc20','자20'    );
insert into TB_Bbs_Board(boardcd, boardnm) values ('bc21','자21'    );
insert into TB_Bbs_Board(boardcd, boardnm) values ('bc22','자22'    );
insert into TB_Bbs_Board(boardcd, boardnm) values ('bc23','자23'    );
insert into TB_Bbs_Board(boardcd, boardnm) values ('bc24','자24'    );
insert into TB_Bbs_Board(boardcd, boardnm) values ('bc25','자25'    );
insert into TB_Bbs_Board(boardcd, boardnm) values ('bc26','자26'    );
insert into TB_Bbs_Board(boardcd, boardnm) values ('bc27','자27'    );
insert into TB_Bbs_Board(boardcd, boardnm) values ('bc28','자28'    );
insert into TB_Bbs_Board(boardcd, boardnm) values ('bc29','자29'    );
insert into TB_Bbs_Board(boardcd, boardnm) values ('bc30','자30'    );
insert into TB_Bbs_Board(boardcd, boardnm) values ('bc31','자31'    );
insert into TB_Bbs_Board(boardcd, boardnm) values ('bc32','자32'    );
insert into TB_Bbs_Board(boardcd, boardnm) values ('bc33','자33'    );
insert into TB_Bbs_Board(boardcd, boardnm) values ('bc34','자34'    );
insert into TB_Bbs_Board(boardcd, boardnm) values ('bc35','자35'    );
insert into TB_Bbs_Board(boardcd, boardnm) values ('bc36','자36'    );
insert into TB_Bbs_Board(boardcd, boardnm) values ('bc37','자37'    );
insert into TB_Bbs_Board(boardcd, boardnm) values ('bc38','자38'    );
insert into TB_Bbs_Board(boardcd, boardnm) values ('bc39','자39'    );
insert into TB_Bbs_Board(boardcd, boardnm) values ('bc40','자40'    );
insert into TB_Bbs_Board(boardcd, boardnm) values ('bc41','자41'    );
insert into TB_Bbs_Board(boardcd, boardnm) values ('bc42','자42'    );
insert into TB_Bbs_Board(boardcd, boardnm) values ('bc43','자43'    );
insert into TB_Bbs_Board(boardcd, boardnm) values ('bc44','자44'    );
insert into TB_Bbs_Board(boardcd, boardnm) values ('bc45','자45'    );
insert into TB_Bbs_Board(boardcd, boardnm) values ('bc46','자46'    );
insert into TB_Bbs_Board(boardcd, boardnm) values ('bc47','자47'    );
insert into TB_Bbs_Board(boardcd, boardnm) values ('bc48','자48'    );
insert into TB_Bbs_Board(boardcd, boardnm) values ('bc49','자49'    );
insert into TB_Bbs_Board(boardcd, boardnm) values ('bc50','자50'    );
insert into TB_Bbs_Board(boardcd, boardnm) values ('bc51','자51'    );
insert into TB_Bbs_Board(boardcd, boardnm) values ('bc52','자52'    );
insert into TB_Bbs_Board(boardcd, boardnm) values ('bc53','자53'    );
insert into TB_Bbs_Board(boardcd, boardnm) values ('bc54','자54'    );
insert into TB_Bbs_Board(boardcd, boardnm) values ('bc55','자55'    );
insert into TB_Bbs_Board(boardcd, boardnm) values ('bc56','자56'    );
insert into TB_Bbs_Board(boardcd, boardnm) values ('bc57','자57'    );
insert into TB_Bbs_Board(boardcd, boardnm) values ('bc58','자58'    );
insert into TB_Bbs_Board(boardcd, boardnm) values ('bc59','자59'    );
insert into TB_Bbs_Board(boardcd, boardnm) values ('bc60','자60'    );
insert into TB_Bbs_Board(boardcd, boardnm) values ('bc61','자61'    );
insert into TB_Bbs_Board(boardcd, boardnm) values ('bc62','자62'    );
insert into TB_Bbs_Board(boardcd, boardnm) values ('bc63','자63'    );
insert into TB_Bbs_Board(boardcd, boardnm) values ('bc64','자64'    );
insert into TB_Bbs_Board(boardcd, boardnm) values ('bc65','자65'    );
insert into TB_Bbs_Board(boardcd, boardnm) values ('bc66','자66'    );
insert into TB_Bbs_Board(boardcd, boardnm) values ('bc67','자67'    );

select * from TB_Bbs_Board;



-- 게시글 테이블
CREATE TABLE IF NOT EXISTS  TB_Bbs_Article (
      articleno     INT UNSIGNED  NOT NULL AUTO_INCREMENT
    , boardcd       NVARCHAR(20)   
    , title         NVARCHAR(200) NOT NULL   
    , content       MEDIUMTEXT      
    , email         NVARCHAR(60)  
    , hit           INT UNSIGNED  DEFAULT  0
    , regdate       DateTime        
    , UseYN         TINYINT(1)    NOT NULL   DEFAULT  1 

    , countgood     INT  DEFAULT  0     
    , countbad      INT  DEFAULT  0   
    
    , InsertUID     VARCHAR(40)   NULL   
    , InsertDT      DateTime      NULL 
    , UpdateUID     VARCHAR(40)   NULL 
    , UpdateDT      DateTime      NULL
    
    , PRIMARY KEY(articleno)
    , FOREIGN KEY(boardcd) REFERENCES TB_Bbs_Board(boardcd)
)
ENGINE=InnoDB 
AUTO_INCREMENT=1 
DEFAULT CHARACTER SET utf8 
COLLATE utf8_general_ci;


insert into TB_Bbs_Article( boardcd, title, content, email, hit, regdate, UseYN ) values ( 'free', 'article free  01', 'article free  01', 'free@free.co.kr', 0, now(), 1 );
insert into TB_Bbs_Article( boardcd, title, content, email, hit, regdate, UseYN ) values ( 'free', 'article free  02', 'article free  02', 'free@free.co.kr', 0, now(), 1 );
insert into TB_Bbs_Article( boardcd, title, content, email, hit, regdate, UseYN ) values ( 'free', 'article free  03', 'article free  03', 'free@free.co.kr', 0, now(), 1 );
insert into TB_Bbs_Article( boardcd, title, content, email, hit, regdate, UseYN ) values ( 'free', 'article free  04', 'article free  04', 'free@free.co.kr', 0, now(), 1 );
insert into TB_Bbs_Article( boardcd, title, content, email, hit, regdate, UseYN ) values ( 'free', 'article free  05', 'article free  05', 'free@free.co.kr', 0, now(), 1 );
insert into TB_Bbs_Article( boardcd, title, content, email, hit, regdate, UseYN ) values ( 'free', 'article free  06', 'article free  06', 'free@free.co.kr', 0, now(), 1 );
insert into TB_Bbs_Article( boardcd, title, content, email, hit, regdate, UseYN ) values ( 'free', 'article free  07', 'article free  07', 'free@free.co.kr', 0, now(), 1 );
insert into TB_Bbs_Article( boardcd, title, content, email, hit, regdate, UseYN ) values ( 'free', 'article free  08', 'article free  08', 'free@free.co.kr', 0, now(), 1 );
insert into TB_Bbs_Article( boardcd, title, content, email, hit, regdate, UseYN ) values ( 'free', 'article free  09', 'article free  09', 'free@free.co.kr', 0, now(), 1 );
insert into TB_Bbs_Article( boardcd, title, content, email, hit, regdate, UseYN ) values ( 'free', 'article free  10', 'article free  10', 'free@free.co.kr', 0, now(), 1 );
insert into TB_Bbs_Article( boardcd, title, content, email, hit, regdate, UseYN ) values ( 'free', 'article free  11', 'article free  11', 'free@free.co.kr', 0, now(), 1 );
insert into TB_Bbs_Article( boardcd, title, content, email, hit, regdate, UseYN ) values ( 'free', 'article free  12', 'article free  12', 'free@free.co.kr', 0, now(), 1 );
insert into TB_Bbs_Article( boardcd, title, content, email, hit, regdate, UseYN ) values ( 'free', 'article free  13', 'article free  13', 'free@free.co.kr', 0, now(), 1 );
insert into TB_Bbs_Article( boardcd, title, content, email, hit, regdate, UseYN ) values ( 'free', 'article free  14', 'article free  14', 'free@free.co.kr', 0, now(), 1 );
insert into TB_Bbs_Article( boardcd, title, content, email, hit, regdate, UseYN ) values ( 'free', 'article free  15', 'article free  15', 'free@free.co.kr', 0, now(), 1 );
insert into TB_Bbs_Article( boardcd, title, content, email, hit, regdate, UseYN ) values ( 'free', 'article free  16', 'article free  16', 'free@free.co.kr', 0, now(), 1 );
insert into TB_Bbs_Article( boardcd, title, content, email, hit, regdate, UseYN ) values ( 'free', 'article free  17', 'article free  17', 'free@free.co.kr', 0, now(), 1 );
insert into TB_Bbs_Article( boardcd, title, content, email, hit, regdate, UseYN ) values ( 'free', 'article free  18', 'article free  18', 'free@free.co.kr', 0, now(), 1 );
insert into TB_Bbs_Article( boardcd, title, content, email, hit, regdate, UseYN ) values ( 'free', 'article free  19', 'article free  19', 'free@free.co.kr', 0, now(), 1 );
insert into TB_Bbs_Article( boardcd, title, content, email, hit, regdate, UseYN ) values ( 'free', 'article free  20', 'article free  20', 'free@free.co.kr', 0, now(), 1 );
insert into TB_Bbs_Article( boardcd, title, content, email, hit, regdate, UseYN ) values ( 'free', 'article free  21', 'article free  21', 'free@free.co.kr', 0, now(), 1 );
insert into TB_Bbs_Article( boardcd, title, content, email, hit, regdate, UseYN ) values ( 'free', 'article free  22', 'article free  22', 'free@free.co.kr', 0, now(), 1 );
insert into TB_Bbs_Article( boardcd, title, content, email, hit, regdate, UseYN ) values ( 'free', 'article free  23', 'article free  23', 'free@free.co.kr', 0, now(), 1 );
insert into TB_Bbs_Article( boardcd, title, content, email, hit, regdate, UseYN ) values ( 'free', 'article free  24', 'article free  24', 'free@free.co.kr', 0, now(), 1 );
insert into TB_Bbs_Article( boardcd, title, content, email, hit, regdate, UseYN ) values ( 'free', 'article free  25', 'article free  25', 'free@free.co.kr', 0, now(), 1 );
insert into TB_Bbs_Article( boardcd, title, content, email, hit, regdate, UseYN ) values ( 'free', 'article free  26', 'article free  26', 'free@free.co.kr', 0, now(), 1 );
insert into TB_Bbs_Article( boardcd, title, content, email, hit, regdate, UseYN ) values ( 'free', 'article free  27', 'article free  27', 'free@free.co.kr', 0, now(), 1 );
insert into TB_Bbs_Article( boardcd, title, content, email, hit, regdate, UseYN ) values ( 'free', 'article free  28', 'article free  28', 'free@free.co.kr', 0, now(), 1 );
insert into TB_Bbs_Article( boardcd, title, content, email, hit, regdate, UseYN ) values ( 'free', 'article free  29', 'article free  29', 'free@free.co.kr', 0, now(), 1 );
insert into TB_Bbs_Article( boardcd, title, content, email, hit, regdate, UseYN ) values ( 'free', 'article free  30', 'article free  30', 'free@free.co.kr', 0, now(), 1 );
insert into TB_Bbs_Article( boardcd, title, content, email, hit, regdate, UseYN ) values ( 'free', 'article free  31', 'article free  31', 'free@free.co.kr', 0, now(), 1 );
insert into TB_Bbs_Article( boardcd, title, content, email, hit, regdate, UseYN ) values ( 'free', 'article free  32', 'article free  32', 'free@free.co.kr', 0, now(), 1 );
insert into TB_Bbs_Article( boardcd, title, content, email, hit, regdate, UseYN ) values ( 'free', 'article free  33', 'article free  33', 'free@free.co.kr', 0, now(), 1 );
insert into TB_Bbs_Article( boardcd, title, content, email, hit, regdate, UseYN ) values ( 'free', 'article free  34', 'article free  34', 'free@free.co.kr', 0, now(), 1 );
insert into TB_Bbs_Article( boardcd, title, content, email, hit, regdate, UseYN ) values ( 'free', 'article free  35', 'article free  35', 'free@free.co.kr', 0, now(), 1 );
insert into TB_Bbs_Article( boardcd, title, content, email, hit, regdate, UseYN ) values ( 'free', 'article free  36', 'article free  36', 'free@free.co.kr', 0, now(), 1 );
insert into TB_Bbs_Article( boardcd, title, content, email, hit, regdate, UseYN ) values ( 'free', 'article free  37', 'article free  37', 'free@free.co.kr', 0, now(), 1 );
insert into TB_Bbs_Article( boardcd, title, content, email, hit, regdate, UseYN ) values ( 'free', 'article free  38', 'article free  38', 'free@free.co.kr', 0, now(), 1 );
insert into TB_Bbs_Article( boardcd, title, content, email, hit, regdate, UseYN ) values ( 'free', 'article free  39', 'article free  39', 'free@free.co.kr', 0, now(), 1 );
insert into TB_Bbs_Article( boardcd, title, content, email, hit, regdate, UseYN ) values ( 'free', 'article free  40', 'article free  40', 'free@free.co.kr', 0, now(), 1 );
insert into TB_Bbs_Article( boardcd, title, content, email, hit, regdate, UseYN ) values ( 'free', 'article free  41', 'article free  41', 'free@free.co.kr', 0, now(), 1 );
insert into TB_Bbs_Article( boardcd, title, content, email, hit, regdate, UseYN ) values ( 'free', 'article free  42', 'article free  42', 'free@free.co.kr', 0, now(), 1 );
insert into TB_Bbs_Article( boardcd, title, content, email, hit, regdate, UseYN ) values ( 'free', 'article free  43', 'article free  43', 'free@free.co.kr', 0, now(), 1 );
insert into TB_Bbs_Article( boardcd, title, content, email, hit, regdate, UseYN ) values ( 'free', 'article free  44', 'article free  44', 'free@free.co.kr', 0, now(), 1 );
insert into TB_Bbs_Article( boardcd, title, content, email, hit, regdate, UseYN ) values ( 'free', 'article free  45', 'article free  45', 'free@free.co.kr', 0, now(), 1 );
insert into TB_Bbs_Article( boardcd, title, content, email, hit, regdate, UseYN ) values ( 'free', 'article free  46', 'article free  46', 'free@free.co.kr', 0, now(), 1 );
insert into TB_Bbs_Article( boardcd, title, content, email, hit, regdate, UseYN ) values ( 'free', 'article free  47', 'article free  47', 'free@free.co.kr', 0, now(), 1 );
insert into TB_Bbs_Article( boardcd, title, content, email, hit, regdate, UseYN ) values ( 'free', 'article free  48', 'article free  48', 'free@free.co.kr', 0, now(), 1 );
insert into TB_Bbs_Article( boardcd, title, content, email, hit, regdate, UseYN ) values ( 'free', 'article free  49', 'article free  49', 'free@free.co.kr', 0, now(), 1 );
insert into TB_Bbs_Article( boardcd, title, content, email, hit, regdate, UseYN ) values ( 'free', 'article free  50', 'article free  50', 'free@free.co.kr', 0, now(), 1 );
insert into TB_Bbs_Article( boardcd, title, content, email, hit, regdate, UseYN ) values ( 'free', 'article free  51', 'article free  51', 'free@free.co.kr', 0, now(), 1 );
insert into TB_Bbs_Article( boardcd, title, content, email, hit, regdate, UseYN ) values ( 'free', 'article free  52', 'article free  52', 'free@free.co.kr', 0, now(), 1 );
insert into TB_Bbs_Article( boardcd, title, content, email, hit, regdate, UseYN ) values ( 'free', 'article free  53', 'article free  53', 'free@free.co.kr', 0, now(), 1 );
insert into TB_Bbs_Article( boardcd, title, content, email, hit, regdate, UseYN ) values ( 'free', 'article free  54', 'article free  54', 'free@free.co.kr', 0, now(), 1 );
insert into TB_Bbs_Article( boardcd, title, content, email, hit, regdate, UseYN ) values ( 'free', 'article free  55', 'article free  55', 'free@free.co.kr', 0, now(), 1 );
insert into TB_Bbs_Article( boardcd, title, content, email, hit, regdate, UseYN ) values ( 'free', 'article free  56', 'article free  56', 'free@free.co.kr', 0, now(), 1 );
insert into TB_Bbs_Article( boardcd, title, content, email, hit, regdate, UseYN ) values ( 'free', 'article free  57', 'article free  57', 'free@free.co.kr', 0, now(), 1 );
insert into TB_Bbs_Article( boardcd, title, content, email, hit, regdate, UseYN ) values ( 'free', 'article free  58', 'article free  58', 'free@free.co.kr', 0, now(), 1 );
insert into TB_Bbs_Article( boardcd, title, content, email, hit, regdate, UseYN ) values ( 'free', 'article free  59', 'article free  59', 'free@free.co.kr', 0, now(), 1 );
insert into TB_Bbs_Article( boardcd, title, content, email, hit, regdate, UseYN ) values ( 'free', 'article free  60', 'article free  60', 'free@free.co.kr', 0, now(), 1 );
insert into TB_Bbs_Article( boardcd, title, content, email, hit, regdate, UseYN ) values ( 'free', 'article free  61', 'article free  61', 'free@free.co.kr', 0, now(), 1 );
insert into TB_Bbs_Article( boardcd, title, content, email, hit, regdate, UseYN ) values ( 'free', 'article free  62', 'article free  62', 'free@free.co.kr', 0, now(), 1 );
insert into TB_Bbs_Article( boardcd, title, content, email, hit, regdate, UseYN ) values ( 'free', 'article free  63', 'article free  63', 'free@free.co.kr', 0, now(), 1 );
insert into TB_Bbs_Article( boardcd, title, content, email, hit, regdate, UseYN ) values ( 'free', 'article free  64', 'article free  64', 'free@free.co.kr', 0, now(), 1 );
insert into TB_Bbs_Article( boardcd, title, content, email, hit, regdate, UseYN ) values ( 'free', 'article free  65', 'article free  65', 'free@free.co.kr', 0, now(), 1 );
insert into TB_Bbs_Article( boardcd, title, content, email, hit, regdate, UseYN ) values ( 'free', 'article free  66', 'article free  66', 'free@free.co.kr', 0, now(), 1 );
insert into TB_Bbs_Article( boardcd, title, content, email, hit, regdate, UseYN ) values ( 'free', 'article free  67', 'article free  67', 'free@free.co.kr', 0, now(), 1 );
insert into TB_Bbs_Article( boardcd, title, content, email, hit, regdate, UseYN ) values ( 'free', 'article free  68', 'article free  68', 'free@free.co.kr', 0, now(), 1 );
insert into TB_Bbs_Article( boardcd, title, content, email, hit, regdate, UseYN ) values ( 'free', 'article free  69', 'article free  69', 'free@free.co.kr', 0, now(), 1 );
insert into TB_Bbs_Article( boardcd, title, content, email, hit, regdate, UseYN ) values ( 'free', 'article free  70', 'article free  70', 'free@free.co.kr', 0, now(), 1 );
insert into TB_Bbs_Article( boardcd, title, content, email, hit, regdate, UseYN ) values ( 'free', 'article free  71', 'article free  71', 'free@free.co.kr', 0, now(), 1 );
insert into TB_Bbs_Article( boardcd, title, content, email, hit, regdate, UseYN ) values ( 'free', 'article free  72', 'article free  72', 'free@free.co.kr', 0, now(), 1 );
insert into TB_Bbs_Article( boardcd, title, content, email, hit, regdate, UseYN ) values ( 'free', 'article free  73', 'article free  73', 'free@free.co.kr', 0, now(), 1 );
insert into TB_Bbs_Article( boardcd, title, content, email, hit, regdate, UseYN ) values ( 'free', 'article free  74', 'article free  74', 'free@free.co.kr', 0, now(), 1 );
insert into TB_Bbs_Article( boardcd, title, content, email, hit, regdate, UseYN ) values ( 'free', 'article free  75', 'article free  75', 'free@free.co.kr', 0, now(), 1 );
insert into TB_Bbs_Article( boardcd, title, content, email, hit, regdate, UseYN ) values ( 'free', 'article free  76', 'article free  76', 'free@free.co.kr', 0, now(), 1 );
insert into TB_Bbs_Article( boardcd, title, content, email, hit, regdate, UseYN ) values ( 'free', 'article free  77', 'article free  77', 'free@free.co.kr', 0, now(), 1 );
insert into TB_Bbs_Article( boardcd, title, content, email, hit, regdate, UseYN ) values ( 'free', 'article free  78', 'article free  78', 'free@free.co.kr', 0, now(), 1 );
insert into TB_Bbs_Article( boardcd, title, content, email, hit, regdate, UseYN ) values ( 'free', 'article free  79', 'article free  79', 'free@free.co.kr', 0, now(), 1 );
insert into TB_Bbs_Article( boardcd, title, content, email, hit, regdate, UseYN ) values ( 'free', 'article free  80', 'article free  80', 'free@free.co.kr', 0, now(), 1 );
insert into TB_Bbs_Article( boardcd, title, content, email, hit, regdate, UseYN ) values ( 'free', 'article free  81', 'article free  81', 'free@free.co.kr', 0, now(), 1 );
insert into TB_Bbs_Article( boardcd, title, content, email, hit, regdate, UseYN ) values ( 'free', 'article free  82', 'article free  82', 'free@free.co.kr', 0, now(), 1 );
insert into TB_Bbs_Article( boardcd, title, content, email, hit, regdate, UseYN ) values ( 'free', 'article free  83', 'article free  83', 'free@free.co.kr', 0, now(), 1 );
insert into TB_Bbs_Article( boardcd, title, content, email, hit, regdate, UseYN ) values ( 'free', 'article free  84', 'article free  84', 'free@free.co.kr', 0, now(), 1 );
insert into TB_Bbs_Article( boardcd, title, content, email, hit, regdate, UseYN ) values ( 'free', 'article free  85', 'article free  85', 'free@free.co.kr', 0, now(), 1 );
insert into TB_Bbs_Article( boardcd, title, content, email, hit, regdate, UseYN ) values ( 'free', 'article free  86', 'article free  86', 'free@free.co.kr', 0, now(), 1 );
insert into TB_Bbs_Article( boardcd, title, content, email, hit, regdate, UseYN ) values ( 'free', 'article free  87', 'article free  87', 'free@free.co.kr', 0, now(), 1 );
insert into TB_Bbs_Article( boardcd, title, content, email, hit, regdate, UseYN ) values ( 'free', 'article free  88', 'article free  88', 'free@free.co.kr', 0, now(), 1 );
insert into TB_Bbs_Article( boardcd, title, content, email, hit, regdate, UseYN ) values ( 'free', 'article free  89', 'article free  89', 'free@free.co.kr', 0, now(), 1 );
insert into TB_Bbs_Article( boardcd, title, content, email, hit, regdate, UseYN ) values ( 'free', 'article free  90', 'article free  90', 'free@free.co.kr', 0, now(), 1 );
insert into TB_Bbs_Article( boardcd, title, content, email, hit, regdate, UseYN ) values ( 'free', 'article free  91', 'article free  91', 'free@free.co.kr', 0, now(), 1 );
insert into TB_Bbs_Article( boardcd, title, content, email, hit, regdate, UseYN ) values ( 'free', 'article free  92', 'article free  92', 'free@free.co.kr', 0, now(), 1 );
insert into TB_Bbs_Article( boardcd, title, content, email, hit, regdate, UseYN ) values ( 'free', 'article free  93', 'article free  93', 'free@free.co.kr', 0, now(), 1 );
insert into TB_Bbs_Article( boardcd, title, content, email, hit, regdate, UseYN ) values ( 'free', 'article free  94', 'article free  94', 'free@free.co.kr', 0, now(), 1 );
insert into TB_Bbs_Article( boardcd, title, content, email, hit, regdate, UseYN ) values ( 'free', 'article free  95', 'article free  95', 'free@free.co.kr', 0, now(), 1 );
insert into TB_Bbs_Article( boardcd, title, content, email, hit, regdate, UseYN ) values ( 'free', 'article free  96', 'article free  96', 'free@free.co.kr', 0, now(), 1 );
insert into TB_Bbs_Article( boardcd, title, content, email, hit, regdate, UseYN ) values ( 'free', 'article free  97', 'article free  97', 'free@free.co.kr', 0, now(), 1 );
insert into TB_Bbs_Article( boardcd, title, content, email, hit, regdate, UseYN ) values ( 'free', 'article free  98', 'article free  98', 'free@free.co.kr', 0, now(), 1 );
insert into TB_Bbs_Article( boardcd, title, content, email, hit, regdate, UseYN ) values ( 'free', 'article free  99', 'article free  99', 'free@free.co.kr', 0, now(), 1 );
insert into TB_Bbs_Article( boardcd, title, content, email, hit, regdate, UseYN ) values ( 'free', 'article free 100', 'article free 100', 'free@free.co.kr', 0, now(), 1 );

insert into TB_Bbs_Article( boardcd, title, content, email, hit, regdate, UseYN ) values ( 'free', 'article free 101', 'article free 101', 'free@free.co.kr', 0, now(), 1 );
insert into TB_Bbs_Article( boardcd, title, content, email, hit, regdate, UseYN ) values ( 'free', 'article free 102', 'article free 102', 'free@free.co.kr', 0, now(), 1 );
insert into TB_Bbs_Article( boardcd, title, content, email, hit, regdate, UseYN ) values ( 'free', 'article free 103', 'article free 103', 'free@free.co.kr', 0, now(), 1 );
insert into TB_Bbs_Article( boardcd, title, content, email, hit, regdate, UseYN ) values ( 'free', 'article free 104', 'article free 104', 'free@free.co.kr', 0, now(), 1 );
insert into TB_Bbs_Article( boardcd, title, content, email, hit, regdate, UseYN ) values ( 'free', 'article free 105', 'article free 105', 'free@free.co.kr', 0, now(), 1 );
insert into TB_Bbs_Article( boardcd, title, content, email, hit, regdate, UseYN ) values ( 'free', 'article free 106', 'article free 106', 'free@free.co.kr', 0, now(), 1 );
insert into TB_Bbs_Article( boardcd, title, content, email, hit, regdate, UseYN ) values ( 'free', 'article free 107', 'article free 107', 'free@free.co.kr', 0, now(), 1 );
insert into TB_Bbs_Article( boardcd, title, content, email, hit, regdate, UseYN ) values ( 'free', 'article free 108', 'article free 108', 'free@free.co.kr', 0, now(), 1 );
insert into TB_Bbs_Article( boardcd, title, content, email, hit, regdate, UseYN ) values ( 'free', 'article free 109', 'article free 109', 'free@free.co.kr', 0, now(), 1 );
insert into TB_Bbs_Article( boardcd, title, content, email, hit, regdate, UseYN ) values ( 'free', 'article free 110', 'article free 110', 'free@free.co.kr', 0, now(), 1 );
insert into TB_Bbs_Article( boardcd, title, content, email, hit, regdate, UseYN ) values ( 'free', 'article free 111', 'article free 111', 'free@free.co.kr', 0, now(), 1 );
insert into TB_Bbs_Article( boardcd, title, content, email, hit, regdate, UseYN ) values ( 'free', 'article free 112', 'article free 112', 'free@free.co.kr', 0, now(), 1 );
insert into TB_Bbs_Article( boardcd, title, content, email, hit, regdate, UseYN ) values ( 'free', 'article free 113', 'article free 113', 'free@free.co.kr', 0, now(), 1 );
insert into TB_Bbs_Article( boardcd, title, content, email, hit, regdate, UseYN ) values ( 'free', 'article free 114', 'article free 114', 'free@free.co.kr', 0, now(), 1 );
insert into TB_Bbs_Article( boardcd, title, content, email, hit, regdate, UseYN ) values ( 'free', 'article free 115', 'article free 115', 'free@free.co.kr', 0, now(), 1 );
insert into TB_Bbs_Article( boardcd, title, content, email, hit, regdate, UseYN ) values ( 'free', 'article free 116', 'article free 116', 'free@free.co.kr', 0, now(), 1 );
insert into TB_Bbs_Article( boardcd, title, content, email, hit, regdate, UseYN ) values ( 'free', 'article free 117', 'article free 117', 'free@free.co.kr', 0, now(), 1 );
insert into TB_Bbs_Article( boardcd, title, content, email, hit, regdate, UseYN ) values ( 'free', 'article free 118', 'article free 118', 'free@free.co.kr', 0, now(), 1 );
insert into TB_Bbs_Article( boardcd, title, content, email, hit, regdate, UseYN ) values ( 'free', 'article free 119', 'article free 119', 'free@free.co.kr', 0, now(), 1 );
insert into TB_Bbs_Article( boardcd, title, content, email, hit, regdate, UseYN ) values ( 'free', 'article free 120', 'article free 120', 'free@free.co.kr', 0, now(), 1 );
insert into TB_Bbs_Article( boardcd, title, content, email, hit, regdate, UseYN ) values ( 'free', 'article free 121', 'article free 121', 'free@free.co.kr', 0, now(), 1 );
insert into TB_Bbs_Article( boardcd, title, content, email, hit, regdate, UseYN ) values ( 'free', 'article free 122', 'article free 122', 'free@free.co.kr', 0, now(), 1 );
insert into TB_Bbs_Article( boardcd, title, content, email, hit, regdate, UseYN ) values ( 'free', 'article free 123', 'article free 123', 'free@free.co.kr', 0, now(), 1 );
insert into TB_Bbs_Article( boardcd, title, content, email, hit, regdate, UseYN ) values ( 'free', 'article free 124', 'article free 124', 'free@free.co.kr', 0, now(), 1 );
insert into TB_Bbs_Article( boardcd, title, content, email, hit, regdate, UseYN ) values ( 'free', 'article free 125', 'article free 125', 'free@free.co.kr', 0, now(), 1 );
insert into TB_Bbs_Article( boardcd, title, content, email, hit, regdate, UseYN ) values ( 'free', 'article free 126', 'article free 126', 'free@free.co.kr', 0, now(), 1 );
insert into TB_Bbs_Article( boardcd, title, content, email, hit, regdate, UseYN ) values ( 'free', 'article free 127', 'article free 127', 'free@free.co.kr', 0, now(), 1 );
insert into TB_Bbs_Article( boardcd, title, content, email, hit, regdate, UseYN ) values ( 'free', 'article free 128', 'article free 128', 'free@free.co.kr', 0, now(), 1 );
insert into TB_Bbs_Article( boardcd, title, content, email, hit, regdate, UseYN ) values ( 'free', 'article free 129', 'article free 129', 'free@free.co.kr', 0, now(), 1 );
insert into TB_Bbs_Article( boardcd, title, content, email, hit, regdate, UseYN ) values ( 'free', 'article free 130', 'article free 130', 'free@free.co.kr', 0, now(), 1 );
insert into TB_Bbs_Article( boardcd, title, content, email, hit, regdate, UseYN ) values ( 'free', 'article free 131', 'article free 131', 'free@free.co.kr', 0, now(), 1 );
insert into TB_Bbs_Article( boardcd, title, content, email, hit, regdate, UseYN ) values ( 'free', 'article free 132', 'article free 132', 'free@free.co.kr', 0, now(), 1 );
insert into TB_Bbs_Article( boardcd, title, content, email, hit, regdate, UseYN ) values ( 'free', 'article free 133', 'article free 133', 'free@free.co.kr', 0, now(), 1 );
insert into TB_Bbs_Article( boardcd, title, content, email, hit, regdate, UseYN ) values ( 'free', 'article free 134', 'article free 134', 'free@free.co.kr', 0, now(), 1 );
insert into TB_Bbs_Article( boardcd, title, content, email, hit, regdate, UseYN ) values ( 'free', 'article free 135', 'article free 135', 'free@free.co.kr', 0, now(), 1 );
insert into TB_Bbs_Article( boardcd, title, content, email, hit, regdate, UseYN ) values ( 'free', 'article free 136', 'article free 136', 'free@free.co.kr', 0, now(), 1 );
insert into TB_Bbs_Article( boardcd, title, content, email, hit, regdate, UseYN ) values ( 'free', 'article free 137', 'article free 137', 'free@free.co.kr', 0, now(), 1 );
insert into TB_Bbs_Article( boardcd, title, content, email, hit, regdate, UseYN ) values ( 'free', 'article free 138', 'article free 138', 'free@free.co.kr', 0, now(), 1 );
insert into TB_Bbs_Article( boardcd, title, content, email, hit, regdate, UseYN ) values ( 'free', 'article free 139', 'article free 139', 'free@free.co.kr', 0, now(), 1 );
insert into TB_Bbs_Article( boardcd, title, content, email, hit, regdate, UseYN ) values ( 'free', 'article free 140', 'article free 140', 'free@free.co.kr', 0, now(), 1 );
insert into TB_Bbs_Article( boardcd, title, content, email, hit, regdate, UseYN ) values ( 'free', 'article free 141', 'article free 141', 'free@free.co.kr', 0, now(), 1 );
insert into TB_Bbs_Article( boardcd, title, content, email, hit, regdate, UseYN ) values ( 'free', 'article free 142', 'article free 142', 'free@free.co.kr', 0, now(), 1 );
insert into TB_Bbs_Article( boardcd, title, content, email, hit, regdate, UseYN ) values ( 'free', 'article free 143', 'article free 143', 'free@free.co.kr', 0, now(), 1 );
insert into TB_Bbs_Article( boardcd, title, content, email, hit, regdate, UseYN ) values ( 'free', 'article free 144', 'article free 144', 'free@free.co.kr', 0, now(), 1 );
insert into TB_Bbs_Article( boardcd, title, content, email, hit, regdate, UseYN ) values ( 'free', 'article free 145', 'article free 145', 'free@free.co.kr', 0, now(), 1 );
insert into TB_Bbs_Article( boardcd, title, content, email, hit, regdate, UseYN ) values ( 'free', 'article free 146', 'article free 146', 'free@free.co.kr', 0, now(), 1 );
insert into TB_Bbs_Article( boardcd, title, content, email, hit, regdate, UseYN ) values ( 'free', 'article free 147', 'article free 147', 'free@free.co.kr', 0, now(), 1 );
insert into TB_Bbs_Article( boardcd, title, content, email, hit, regdate, UseYN ) values ( 'free', 'article free 148', 'article free 148', 'free@free.co.kr', 0, now(), 1 );
insert into TB_Bbs_Article( boardcd, title, content, email, hit, regdate, UseYN ) values ( 'free', 'article free 149', 'article free 149', 'free@free.co.kr', 0, now(), 1 );
insert into TB_Bbs_Article( boardcd, title, content, email, hit, regdate, UseYN ) values ( 'free', 'article free 150', 'article free 150', 'free@free.co.kr', 0, now(), 1 );
insert into TB_Bbs_Article( boardcd, title, content, email, hit, regdate, UseYN ) values ( 'free', 'article free 151', 'article free 151', 'free@free.co.kr', 0, now(), 1 );
insert into TB_Bbs_Article( boardcd, title, content, email, hit, regdate, UseYN ) values ( 'free', 'article free 152', 'article free 152', 'free@free.co.kr', 0, now(), 1 );
insert into TB_Bbs_Article( boardcd, title, content, email, hit, regdate, UseYN ) values ( 'free', 'article free 153', 'article free 153', 'free@free.co.kr', 0, now(), 1 );
insert into TB_Bbs_Article( boardcd, title, content, email, hit, regdate, UseYN ) values ( 'free', 'article free 154', 'article free 154', 'free@free.co.kr', 0, now(), 1 );
insert into TB_Bbs_Article( boardcd, title, content, email, hit, regdate, UseYN ) values ( 'free', 'article free 155', 'article free 155', 'free@free.co.kr', 0, now(), 1 );
insert into TB_Bbs_Article( boardcd, title, content, email, hit, regdate, UseYN ) values ( 'free', 'article free 156', 'article free 156', 'free@free.co.kr', 0, now(), 1 );
insert into TB_Bbs_Article( boardcd, title, content, email, hit, regdate, UseYN ) values ( 'free', 'article free 157', 'article free 157', 'free@free.co.kr', 0, now(), 1 );
insert into TB_Bbs_Article( boardcd, title, content, email, hit, regdate, UseYN ) values ( 'free', 'article free 158', 'article free 158', 'free@free.co.kr', 0, now(), 1 );
insert into TB_Bbs_Article( boardcd, title, content, email, hit, regdate, UseYN ) values ( 'free', 'article free 159', 'article free 159', 'free@free.co.kr', 0, now(), 1 );
insert into TB_Bbs_Article( boardcd, title, content, email, hit, regdate, UseYN ) values ( 'free', 'article free 160', 'article free 160', 'free@free.co.kr', 0, now(), 1 );
insert into TB_Bbs_Article( boardcd, title, content, email, hit, regdate, UseYN ) values ( 'free', 'article free 161', 'article free 161', 'free@free.co.kr', 0, now(), 1 );
insert into TB_Bbs_Article( boardcd, title, content, email, hit, regdate, UseYN ) values ( 'free', 'article free 162', 'article free 162', 'free@free.co.kr', 0, now(), 1 );
insert into TB_Bbs_Article( boardcd, title, content, email, hit, regdate, UseYN ) values ( 'free', 'article free 163', 'article free 163', 'free@free.co.kr', 0, now(), 1 );
insert into TB_Bbs_Article( boardcd, title, content, email, hit, regdate, UseYN ) values ( 'free', 'article free 164', 'article free 164', 'free@free.co.kr', 0, now(), 1 );
insert into TB_Bbs_Article( boardcd, title, content, email, hit, regdate, UseYN ) values ( 'free', 'article free 165', 'article free 165', 'free@free.co.kr', 0, now(), 1 );
insert into TB_Bbs_Article( boardcd, title, content, email, hit, regdate, UseYN ) values ( 'free', 'article free 166', 'article free 166', 'free@free.co.kr', 0, now(), 1 );
insert into TB_Bbs_Article( boardcd, title, content, email, hit, regdate, UseYN ) values ( 'free', 'article free 167', 'article free 167', 'free@free.co.kr', 0, now(), 1 );
insert into TB_Bbs_Article( boardcd, title, content, email, hit, regdate, UseYN ) values ( 'free', 'article free 168', 'article free 168', 'free@free.co.kr', 0, now(), 1 );
insert into TB_Bbs_Article( boardcd, title, content, email, hit, regdate, UseYN ) values ( 'free', 'article free 169', 'article free 169', 'free@free.co.kr', 0, now(), 1 );
insert into TB_Bbs_Article( boardcd, title, content, email, hit, regdate, UseYN ) values ( 'free', 'article free 170', 'article free 170', 'free@free.co.kr', 0, now(), 1 );
insert into TB_Bbs_Article( boardcd, title, content, email, hit, regdate, UseYN ) values ( 'free', 'article free 171', 'article free 171', 'free@free.co.kr', 0, now(), 1 );
insert into TB_Bbs_Article( boardcd, title, content, email, hit, regdate, UseYN ) values ( 'free', 'article free 172', 'article free 172', 'free@free.co.kr', 0, now(), 1 );
insert into TB_Bbs_Article( boardcd, title, content, email, hit, regdate, UseYN ) values ( 'free', 'article free 173', 'article free 173', 'free@free.co.kr', 0, now(), 1 );
insert into TB_Bbs_Article( boardcd, title, content, email, hit, regdate, UseYN ) values ( 'free', 'article free 174', 'article free 174', 'free@free.co.kr', 0, now(), 1 );
insert into TB_Bbs_Article( boardcd, title, content, email, hit, regdate, UseYN ) values ( 'free', 'article free 175', 'article free 175', 'free@free.co.kr', 0, now(), 1 );
insert into TB_Bbs_Article( boardcd, title, content, email, hit, regdate, UseYN ) values ( 'free', 'article free 176', 'article free 176', 'free@free.co.kr', 0, now(), 1 );
insert into TB_Bbs_Article( boardcd, title, content, email, hit, regdate, UseYN ) values ( 'free', 'article free 177', 'article free 177', 'free@free.co.kr', 0, now(), 1 );
insert into TB_Bbs_Article( boardcd, title, content, email, hit, regdate, UseYN ) values ( 'free', 'article free 178', 'article free 178', 'free@free.co.kr', 0, now(), 1 );
insert into TB_Bbs_Article( boardcd, title, content, email, hit, regdate, UseYN ) values ( 'free', 'article free 179', 'article free 179', 'free@free.co.kr', 0, now(), 1 );
insert into TB_Bbs_Article( boardcd, title, content, email, hit, regdate, UseYN ) values ( 'free', 'article free 180', 'article free 180', 'free@free.co.kr', 0, now(), 1 );
insert into TB_Bbs_Article( boardcd, title, content, email, hit, regdate, UseYN ) values ( 'free', 'article free 181', 'article free 181', 'free@free.co.kr', 0, now(), 1 );
insert into TB_Bbs_Article( boardcd, title, content, email, hit, regdate, UseYN ) values ( 'free', 'article free 182', 'article free 182', 'free@free.co.kr', 0, now(), 1 );
insert into TB_Bbs_Article( boardcd, title, content, email, hit, regdate, UseYN ) values ( 'free', 'article free 183', 'article free 183', 'free@free.co.kr', 0, now(), 1 );
insert into TB_Bbs_Article( boardcd, title, content, email, hit, regdate, UseYN ) values ( 'free', 'article free 184', 'article free 184', 'free@free.co.kr', 0, now(), 1 );
insert into TB_Bbs_Article( boardcd, title, content, email, hit, regdate, UseYN ) values ( 'free', 'article free 185', 'article free 185', 'free@free.co.kr', 0, now(), 1 );
insert into TB_Bbs_Article( boardcd, title, content, email, hit, regdate, UseYN ) values ( 'free', 'article free 186', 'article free 186', 'free@free.co.kr', 0, now(), 1 );
insert into TB_Bbs_Article( boardcd, title, content, email, hit, regdate, UseYN ) values ( 'free', 'article free 187', 'article free 187', 'free@free.co.kr', 0, now(), 1 );
insert into TB_Bbs_Article( boardcd, title, content, email, hit, regdate, UseYN ) values ( 'free', 'article free 188', 'article free 188', 'free@free.co.kr', 0, now(), 1 );
insert into TB_Bbs_Article( boardcd, title, content, email, hit, regdate, UseYN ) values ( 'free', 'article free 189', 'article free 189', 'free@free.co.kr', 0, now(), 1 );
insert into TB_Bbs_Article( boardcd, title, content, email, hit, regdate, UseYN ) values ( 'free', 'article free 190', 'article free 190', 'free@free.co.kr', 0, now(), 1 );
insert into TB_Bbs_Article( boardcd, title, content, email, hit, regdate, UseYN ) values ( 'free', 'article free 191', 'article free 191', 'free@free.co.kr', 0, now(), 1 );
insert into TB_Bbs_Article( boardcd, title, content, email, hit, regdate, UseYN ) values ( 'free', 'article free 192', 'article free 192', 'free@free.co.kr', 0, now(), 1 );
insert into TB_Bbs_Article( boardcd, title, content, email, hit, regdate, UseYN ) values ( 'free', 'article free 193', 'article free 193', 'free@free.co.kr', 0, now(), 1 );
insert into TB_Bbs_Article( boardcd, title, content, email, hit, regdate, UseYN ) values ( 'free', 'article free 194', 'article free 194', 'free@free.co.kr', 0, now(), 1 );
insert into TB_Bbs_Article( boardcd, title, content, email, hit, regdate, UseYN ) values ( 'free', 'article free 195', 'article free 195', 'free@free.co.kr', 0, now(), 1 );
insert into TB_Bbs_Article( boardcd, title, content, email, hit, regdate, UseYN ) values ( 'free', 'article free 196', 'article free 196', 'free@free.co.kr', 0, now(), 1 );
insert into TB_Bbs_Article( boardcd, title, content, email, hit, regdate, UseYN ) values ( 'free', 'article free 197', 'article free 197', 'free@free.co.kr', 0, now(), 1 );
insert into TB_Bbs_Article( boardcd, title, content, email, hit, regdate, UseYN ) values ( 'free', 'article free 198', 'article free 198', 'free@free.co.kr', 0, now(), 1 );
insert into TB_Bbs_Article( boardcd, title, content, email, hit, regdate, UseYN ) values ( 'free', 'article free 199', 'article free 199', 'free@free.co.kr', 0, now(), 1 );
insert into TB_Bbs_Article( boardcd, title, content, email, hit, regdate, UseYN ) values ( 'free', 'article free 200', 'article free 200', 'free@free.co.kr', 0, now(), 1 );
insert into TB_Bbs_Article( boardcd, title, content, email, hit, regdate, UseYN ) values ( 'free', 'article free 201', 'article free 201', 'free@free.co.kr', 0, now(), 1 );


insert into TB_Bbs_Article( boardcd, title, content, email, hit, regdate, UseYN ) values ( 'data', 'article data 01', 'article data 01', 'data@data.co.kr', 0, now(), 1 );
insert into TB_Bbs_Article( boardcd, title, content, email, hit, regdate, UseYN ) values ( 'data', 'article data 02', 'article data 02', 'data@data.co.kr', 0, now(), 1 );
insert into TB_Bbs_Article( boardcd, title, content, email, hit, regdate, UseYN ) values ( 'data', 'article data 03', 'article data 03', 'data@data.co.kr', 0, now(), 1 );
insert into TB_Bbs_Article( boardcd, title, content, email, hit, regdate, UseYN ) values ( 'data', 'article data 04', 'article data 04', 'data@data.co.kr', 0, now(), 1 );
insert into TB_Bbs_Article( boardcd, title, content, email, hit, regdate, UseYN ) values ( 'data', 'article data 05', 'article data 05', 'data@data.co.kr', 0, now(), 1 );
insert into TB_Bbs_Article( boardcd, title, content, email, hit, regdate, UseYN ) values ( 'data', 'article data 06', 'article data 06', 'data@data.co.kr', 0, now(), 1 );
insert into TB_Bbs_Article( boardcd, title, content, email, hit, regdate, UseYN ) values ( 'data', 'article data 07', 'article data 07', 'data@data.co.kr', 0, now(), 1 );
insert into TB_Bbs_Article( boardcd, title, content, email, hit, regdate, UseYN ) values ( 'data', 'article data 08', 'article data 08', 'data@data.co.kr', 0, now(), 1 );
insert into TB_Bbs_Article( boardcd, title, content, email, hit, regdate, UseYN ) values ( 'data', 'article data 09', 'article data 09', 'data@data.co.kr', 0, now(), 1 );
insert into TB_Bbs_Article( boardcd, title, content, email, hit, regdate, UseYN ) values ( 'data', 'article data 10', 'article data 10', 'data@data.co.kr', 0, now(), 1 );


insert into TB_Bbs_Article( boardcd, title, content, email, hit, regdate, UseYN ) values ( 'qna', 'article qna 01', 'article qna 01', 'qna@qna.co.kr', 0, now(), 1 );
insert into TB_Bbs_Article( boardcd, title, content, email, hit, regdate, UseYN ) values ( 'qna', 'article qna 02', 'article qna 02', 'qna@qna.co.kr', 0, now(), 1 );
insert into TB_Bbs_Article( boardcd, title, content, email, hit, regdate, UseYN ) values ( 'qna', 'article qna 03', 'article qna 03', 'qna@qna.co.kr', 0, now(), 1 );
insert into TB_Bbs_Article( boardcd, title, content, email, hit, regdate, UseYN ) values ( 'qna', 'article qna 04', 'article qna 04', 'qna@qna.co.kr', 0, now(), 1 );
insert into TB_Bbs_Article( boardcd, title, content, email, hit, regdate, UseYN ) values ( 'qna', 'article qna 05', 'article qna 05', 'qna@qna.co.kr', 0, now(), 1 );
insert into TB_Bbs_Article( boardcd, title, content, email, hit, regdate, UseYN ) values ( 'qna', 'article qna 06', 'article qna 06', 'qna@qna.co.kr', 0, now(), 1 );
insert into TB_Bbs_Article( boardcd, title, content, email, hit, regdate, UseYN ) values ( 'qna', 'article qna 07', 'article qna 07', 'qna@qna.co.kr', 0, now(), 1 );
insert into TB_Bbs_Article( boardcd, title, content, email, hit, regdate, UseYN ) values ( 'qna', 'article qna 08', 'article qna 08', 'qna@qna.co.kr', 0, now(), 1 );
insert into TB_Bbs_Article( boardcd, title, content, email, hit, regdate, UseYN ) values ( 'qna', 'article qna 09', 'article qna 09', 'qna@qna.co.kr', 0, now(), 1 );
insert into TB_Bbs_Article( boardcd, title, content, email, hit, regdate, UseYN ) values ( 'qna', 'article qna 10', 'article qna 10', 'qna@qna.co.kr', 0, now(), 1 );



select * from TB_Bbs_Article;



-- 덧글 테이블
CREATE TABLE IF NOT EXISTS  TB_Bbs_Comments (
      commentno     INT UNSIGNED     NOT NULL AUTO_INCREMENT  
    , articleno     INT UNSIGNED     NOT NULL                 
    , email         NVARCHAR(60)                              
    , userid        VARCHAR( 50)     NULL                     
    , memo          NVARCHAR(4000)                            
    , regdate       DateTime                                  
    , UseYN         TINYINT(1)       NULL     DEFAULT  1      

    , InsertUID     VARCHAR(40)      NULL                     
    , InsertDT      DateTime         NULL                     
    , UpdateUID     VARCHAR(40)      NULL                     
    , UpdateDT      DateTime         NULL                     
    
    , PRIMARY KEY(commentno)
    , FOREIGN KEY (articleno) REFERENCES tb_bbs_article (articleno)
)
ENGINE=InnoDB 
AUTO_INCREMENT=1 
DEFAULT CHARACTER SET utf8 
COLLATE utf8_general_ci;

insert into TB_Bbs_Comments( articleno, email, memo, regdate, UseYN  ) values ( 1, 'free@free.co.kr', 'comment test', now(), 1 );
      
select * from TB_Bbs_Comments;     
           
           
-- 첨부파일 테이블
CREATE TABLE IF NOT EXISTS  TB_Bbs_AttachFile (
      attachfileno   INT UNSIGNED    NOT NULL AUTO_INCREMENT
    , filenameorig   NVARCHAR(50)    NOT NULL       
    , filenametemp   NVARCHAR(50)    NULL          
    , filetype       NVARCHAR(30)                           
    , filesize       INT                                    
    , articleno      INT UNSIGNED    NOT NULL               
    , imageData      LONGBLOB        NULL                   
    , UseYN          TINYINT(1)      NULL     DEFAULT  1    

    , InsertUID      VARCHAR(40)     NULL                   
    , InsertDT       DateTime        NULL                   
    , UpdateUID      VARCHAR(40)     NULL                   
    , UpdateDT       DateTime        NULL                   
    
    , PRIMARY KEY(attachfileno)
    , FOREIGN KEY (articleno) REFERENCES tb_bbs_article (articleno)
)
ENGINE=InnoDB 
AUTO_INCREMENT=1 
DEFAULT CHARACTER SET utf8 
COLLATE utf8_general_ci;

insert into TB_Bbs_AttachFile (filenameorig,filetype,filesize,articleno,UseYN) values ('어태치파일','파일타입',10,1,1);
insert into TB_Bbs_AttachFile (filenameorig,filetype,filesize,articleno,UseYN) values ('어태치파일','파일타입',10,1,1);
insert into TB_Bbs_AttachFile (filenameorig,filetype,filesize,articleno,UseYN) values ('어태치파일','파일타입',10,1,1);
insert into TB_Bbs_AttachFile (filenameorig,filetype,filesize,articleno,UseYN) values ('어태치파일','파일타입',10,1,1);
insert into TB_Bbs_AttachFile (filenameorig,filetype,filesize,articleno,UseYN) values ('어태치파일','파일타입',10,1,1);
insert into TB_Bbs_AttachFile (filenameorig,filetype,filesize,articleno,UseYN) values ('어태치파일','파일타입',10,1,1);
insert into TB_Bbs_AttachFile (filenameorig,filetype,filesize,articleno,UseYN) values ('어태치파일','파일타입',10,1,1);

select * from TB_Bbs_AttachFile; 



           
-- '좋아요/나빠요' 테이블
CREATE TABLE TB_Bbs_Recommend (
      userid        VARCHAR( 50)    NOT NULL            
    , articleno     INTEGER         NOT NULL            
    , good          TINYINT(1)      NULL     DEFAULT  0 
    , bad           TINYINT(1)      NULL     DEFAULT  0 
    
    , PRIMARY KEY(userid, articleno)
)
ENGINE=InnoDB 
AUTO_INCREMENT=1 
DEFAULT CHARACTER SET utf8 
COLLATE utf8_general_ci;

select * from TB_Bbs_Recommend;  

           
           
-- 회원  테이블
CREATE TABLE TB_User (
      userno        INT UNSIGNED    NOT NULL AUTO_INCREMENT
    , userid        VARCHAR( 50)    NOT NULL               
    , email         NVARCHAR(100)   NOT NULL               
    , passwd        NVARCHAR( 30)                          
    , name          NVARCHAR( 30)                          
    , mobile        VARCHAR(20)                            
    , retireYN      TINYINT(1)      NULL     DEFAULT  1    

    , InsertUID     VARCHAR(40)     NULL                         
    , InsertDT      DateTime        NULL                   
    , UpdateUID     VARCHAR(40)     NULL                         
    , UpdateDT      DateTime        NULL                   
    
    , PRIMARY KEY(userno)
    , UNIQUE KEY(userid)
)
ENGINE=InnoDB 
AUTO_INCREMENT=1 
DEFAULT CHARACTER SET utf8 
COLLATE utf8_general_ci;


insert into TB_User(userid, email, passwd, name, mobile, retireYN ) 
            values ('userid','userid@aa.co.kr','password','usr', '000-0000-0000', 0 );

select * from TB_User;



--  Phone 테이블
DROP TABLE IF EXISTS TB_Phone;
CREATE TABLE IF NOT EXISTS  TB_Phone (
      name           NVARCHAR(50)    NOT NULL
    , manufacturer   NVARCHAR(30)    NOT NULL
    , price          INT             NOT NULL 
)
ENGINE=InnoDB 
AUTO_INCREMENT=1 
DEFAULT CHARACTER SET utf8 
COLLATE utf8_general_ci;

insert into tb_phone values( '01', '01',  1 );
insert into tb_phone values( '02', '02',  2 );
insert into tb_phone values( '03', '03',  3 );
insert into tb_phone values( '04', '04',  4 );
insert into tb_phone values( '05', '05',  5 );
insert into tb_phone values( '06', '06',  6 );
insert into tb_phone values( '07', '07',  7 );
insert into tb_phone values( '08', '08',  8 );
insert into tb_phone values( '09', '09',  9 );
insert into tb_phone values( '10', '10', 10 );
insert into tb_phone values( '11', '11', 11 );
insert into tb_phone values( '12', '12', 12 );
insert into tb_phone values( '13', '13', 13 );
insert into tb_phone values( '14', '14', 14 );
insert into tb_phone values( '15', '15', 15 );
insert into tb_phone values( '16', '16', 16 );
insert into tb_phone values( '17', '17', 17 );
insert into tb_phone values( '18', '18', 18 );
insert into tb_phone values( '19', '19', 19 );
insert into tb_phone values( '20', '20', 20 );
insert into tb_phone values( '21', '21', 21 );
insert into tb_phone values( '22', '22', 22 );
insert into tb_phone values( '23', '23', 23 );
insert into tb_phone values( '24', '24', 24 );
insert into tb_phone values( '25', '25', 25 );
insert into tb_phone values( '26', '26', 26 );
insert into tb_phone values( '27', '27', 27 );
insert into tb_phone values( '28', '28', 28 );
insert into tb_phone values( '29', '29', 29 );
insert into tb_phone values( '30', '30', 30 );
insert into tb_phone values( '31', '31', 31 );
insert into tb_phone values( '32', '32', 32 );
insert into tb_phone values( '33', '33', 33 );
insert into tb_phone values( '34', '34', 34 );
insert into tb_phone values( '35', '35', 35 );
insert into tb_phone values( '36', '36', 36 );
insert into tb_phone values( '37', '37', 37 );
insert into tb_phone values( '38', '38', 38 );
insert into tb_phone values( '39', '39', 39 );
insert into tb_phone values( '40', '40', 40 );
insert into tb_phone values( '41', '41', 41 );
insert into tb_phone values( '42', '42', 42 );
insert into tb_phone values( '43', '43', 43 );
insert into tb_phone values( '44', '44', 44 );
insert into tb_phone values( '45', '45', 45 );
insert into tb_phone values( '46', '46', 46 );
insert into tb_phone values( '47', '47', 47 );
insert into tb_phone values( '48', '48', 48 );
insert into tb_phone values( '49', '49', 49 );
insert into tb_phone values( '50', '50', 50 );
insert into tb_phone values( '51', '51', 51 );
insert into tb_phone values( '52', '52', 52 );
insert into tb_phone values( '53', '53', 53 );
insert into tb_phone values( '54', '54', 54 );
insert into tb_phone values( '55', '55', 55 );
insert into tb_phone values( '56', '56', 56 );
insert into tb_phone values( '57', '57', 57 );
insert into tb_phone values( '58', '58', 58 );
insert into tb_phone values( '59', '59', 59 );
insert into tb_phone values( '60', '60', 60 );
insert into tb_phone values( '61', '61', 61 );
insert into tb_phone values( '62', '62', 62 );
insert into tb_phone values( '63', '63', 63 );
insert into tb_phone values( '64', '64', 64 );
insert into tb_phone values( '65', '65', 65 );
insert into tb_phone values( '66', '66', 66 );
insert into tb_phone values( '67', '67', 67 );
insert into tb_phone values( '68', '68', 68 );
insert into tb_phone values( '69', '69', 69 );
insert into tb_phone values( '70', '70', 70 );
insert into tb_phone values( '71', '71', 71 );
insert into tb_phone values( '72', '72', 72 );
insert into tb_phone values( '73', '73', 73 );
insert into tb_phone values( '74', '74', 74 );
insert into tb_phone values( '75', '75', 75 );
insert into tb_phone values( '76', '76', 76 );
insert into tb_phone values( '77', '77', 77 );
insert into tb_phone values( '78', '78', 78 );
insert into tb_phone values( '79', '79', 79 );
insert into tb_phone values( '80', '80', 80 );

select * from TB_Phone;   


commit;


-- log 테이블
CREATE TABLE TB_Logs (
      user_id     varchar(20)   NOT NULL
    , dated       datetime      NOT NULL
    , logger      varchar(50)   NOT NULL
    , level       varchar(10)   NOT NULL
    , message     varchar(1000) NOT NULL
)
ENGINE=InnoDB 
AUTO_INCREMENT=1 
DEFAULT CHARACTER SET utf8 
COLLATE utf8_general_ci;

select * from TB_Logs;   

commit;
