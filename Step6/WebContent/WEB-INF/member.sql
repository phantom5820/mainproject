drop table member cascade constraint;

--아이디 - 25글자, 암호 - 50글자, 이름 - 10글자, 나이 - 숫자
create table member(
	id varchar2(25 byte) primary key,
	pass varchar2(50 byte) not null,
	name varchar2(30 byte),
	age number
);

alter table member add grade number default 1;

select * from nls_database_parameters where parameter like '%CHARACTERSET%';

select * from member;
delete from member;
insert into member values('A0001', '123456', '홍길동',33,1);

--회원 등급 나타내는 테이블 GRADE_LIST
-- BRONZE - 1, SILVER - 2, GOLD - 3, VIP - 4, VVIP - 5 MASTER -> 0  
create table grade_list(
	grade_no number primary key,
	grade_name varchar2(10 byte)
);
insert into GRADE_LIST values(1, 'BRONZE');
insert into GRADE_LIST values(2, 'SILVER');
insert into GRADE_LIST values(3, 'GOLD');
insert into GRADE_LIST values(4, 'VIP');
insert into GRADE_LIST values(5, 'VVIP');
insert into GRADE_LIST values(0, 'MASTER');

select * from grade_list;

select id, name, pass, age, grade_name from MEMBER, grade_list where grade_no = grade;

create table board(
	bno number primary key,
	title varchar2(150 byte),
	bdate date default sysdate,
	bcount number default 0,
	writer varchar2(25 byte),
	content varchar2(500 byte),
	blike number default 0,
	bhate number default 0,
	constraint fk_writer foreign key(writer) references member(id)
);

create table board_comment(
	cno number primary key,
	bno number,
	content varchar2(150 byte),
	cdate date default sysdate,
	writer varchar2(25 byte),
	blike number default 0,
	bhate number default 0,
	constraint fk_comment_writer foreign key(writer) references member(id),
	constraint fk_comment_bno foreign key(bno) references board(bno)
);

--게시판 시퀸스
create sequence bno_seq start with 1 nomaxvalue;
--댓글 시퀸스
create sequence cno_seq start with 1 nomaxvalue;







