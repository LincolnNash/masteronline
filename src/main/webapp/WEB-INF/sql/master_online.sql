DROP DATABASE IF EXISTS master_online;
CREATE DATABASE master_online default CHARACTER SET utf8;

use master_online

CREATE TABLE course( 
	id int(11) NOT NULL AUTO_INCREMENT, 
	name varchar(255) DEFAULT NULL, 
	school varchar(255) DEFAULT null, 
	credit int(11) DEFAULT 0, 
	category int(11) DEFAULT null,
  PRIMARY KEY (id),
  UNIQUE KEY (NAME)
  )ENGINE=InnoDB DEFAULT CHARSET=utf8;
    
CREATE TABLE field( 
	id int(11) NOT NULL AUTO_INCREMENT, 
	code varchar(255) DEFAULT NULL, 
	name varchar(255) DEFAULT NULL,
	PRIMARY KEY(id),
	UNIQUE KEY (code)
	)ENGINE=InnoDB DEFAULT CHARSET=utf8;
	
CREATE TABLE teacher( 
	id int(11) NOT NULL AUTO_INCREMENT, 
	jobno varchar(255) DEFAULT NULL, 
	name varchar(255) DEFAULT NULL, 
	sex varchar(11) DEFAULT NULL, 
	ismaster_tutor BOOLEAN DEFAULT FALSE, 
	school varchar(255) default null, 
	birthday DATE DEFAULT NULL, 
	degree ENUM('学士','硕士','博士')DEFAULT NULL, 
	title ENUM(' 讲师','副教授','教授')DEFAULT NULL,
	password varchar(255)default '666666',
	PRIMARY KEY(id),
	unique key(jobno)
	)ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE material(
	id int(11) not null auto_increment,
	name varchar(255) default null,
	location varchar(255) default null,
	teacher_no int (11) default null,
	correspond_course int(11) default null,
	outline text default null,
	PRIMARY KEY(id)
	)ENGINE=InnoDB DEFAULT CHARSET=utf8;

create table student (
    id int(11) not null auto_increment,
    school_no varchar(255) default null,
    name varchar(31) default null,
    major varchar(255) default null,
    grade enum('研一','研二','研三') default null,
    school varchar(255) default null, 
    password varchar(255) default '666666',
    primary key(id),
    unique key(school_no)
    )ENGINE=InnoDB DEFAULT CHARSET=utf8;
	
create table task (
    id int(11) not null auto_increment, 
    name varchar(255) default null,
    location VARCHAR(255) default null,
    primary key(id)
    )ENGINE=InnoDB DEFAULT CHARSET=utf8;
    
create table course_field( 
	id int(11) not null auto_increment, 
	fid int(11) default null, 
	cid int(11) default null, 
	constraint fk_course_field_f foreign key(fid) references field(id), 
	constraint fk_course_field_c foreign key(cid) references course(id),
	primary key(id),
	unique key(fid,cid)
	)ENGINE=InnoDB DEFAULT CHARSET=utf8;
	
create table teach(
    id int(11) not null auto_increment,
   	cid int(11) default null,
    tid int(11) default null,
    constraint fk_teach_course foreign key(cid) references course(id),
    constraint fk_teach_teacher foreign key(tid) references teacher(id),
    primary key(id)
    )ENGINE=InnoDB DEFAULT CHARSET=utf8;

create table learn(
    id int(11) not null auto_increment,
    sid int(11) default null,
    cid int(11) default null,
    learn_time int(11) default 0,
    constraint fk_learn_student foreign key(sid) references student(id),
    constraint fk_learn_course foreign key(cid) references course(id),
    primary key(id)
    )ENGINE=InnoDB DEFAULT CHARSET=utf8;
    
create table publishedtask(
    id int(11) not null auto_increment,
    tid int(11) default null,
    task_id int(11) default null,
    requirement text default null,
    deadline date default null,
    constraint fk_pub_teacher foreign key(tid) references teacher(id),
    constraint fk_pub_task foreign key(task_id) references task(id),
    primary key(id)
    )ENGINE=InnoDB DEFAULT CHARSET=utf8;
 
 
create table submit(
    id int(11) not null auto_increment,
    name varchar(255) default null,
    sid int(11) default null,
    task_id int(11)default null,
    location VARCHAR(255) default null,
    constraint fk_sub_student foreign key(sid) references student(id),
    constraint fk_sub_task foreign key(task_id) references task(id),
    primary key(id)
    )ENGINE=InnoDB DEFAULT CHARSET=utf8;

    
create table admin(
    id int(11) not null auto_increment,
    name varchar(11) default 'admin',
    password varchar(11) default '123456',
    primary key(id)
   );
    
    
