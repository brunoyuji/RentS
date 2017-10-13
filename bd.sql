drop database rents;
create database rents;
use rents;

create table user_profile (id_user INTEGER  primary keY AUTO_INCREMENT,
			user_name varchar(255) not null,
            user_status boolean not null,
			email varchar(255) not null,
			user_password varchar(255) not null,
            image varchar(255),
			birthday date
);

create table landlord(
			id_user int,
			company_name varchar(255),
			operations int not null,
			rating double
);

create table renter(
			id_user int,
            operations int not null,
			rating double
);

create table supervisor (
			id_user int,
			check_number int,
            score int not null
);
create table address ( id_address integer primary key AUTO_INCREMENT,
			id_user int,
			street_name varchar(255) not null,
            complement varchar(255),
            local_number int not null,
            zip_code int not null,
			city varchar(255) not null,
            state_province_district varchar(255) not null,
            country varchar(255) not null
);
create table products (
			id_product INTEGER  primary keY AUTO_INCREMENT,
            id_user int,
            id_category int,
			product_name varchar(255) not null,
            product_status boolean not null,
            image varchar(200),
			title varchar(300) not null,
			price numeric(15,2) not null,
            money_type varchar(15),
            period varchar(255) not null,
			available_amount int not null,
            operation_amount int not null,
			description text not null,
			rating double
);

create table tags_and_ads (
			id_product int,
            id_tag int
);


create table categories (
			id_category integer primary key AUTO_INCREMENT,
			category_name varchar(255) not null,
			category_description text not null
);

create table tags (
			id_tag integer primary key AUTO_INCREMENT,
			tag_name varchar(255) not null,
			tag_description text not null
);

create table ad_complaint(
			id_complaint integer primary key AUTO_INCREMENT,
            id_product int not null,
			id_renter int not null,
            reason varchar(255) not null,
            description text not null,
            complaint_status varchar(255) not null,
            id_supervisor int
);


create table request(
			id_request integer primary key AUTO_INCREMENT ,
			id_renter int,
			id_product int,
            resquest_status varchar(255) not null,
            start_date datetime not null,
			devolution_date datetime not null
);

create table rental(
			id_request int,
            process_status varchar(255) not null
);

create table cancelled(
			id_request int,
            cancelled_date datetime not null,
            reason varchar(255)
);

create table landlord_rating(
		id_request int,
		rating int,
        title_rating varchar(255),
        description_rating varchar(255)
);


create table renter_rating(
		id_request int,
		rating int,
        title_rating varchar(255),
        description_rating varchar(255)
);


create table product_rating(
		id_request int,
		rating int,
        title_rating varchar(255),
        description_rating varchar(255)
);

ALTER TABLE landlord ADD FOREIGN KEY(id_user) REFERENCES user_profile(id_user);
ALTER TABLE renter ADD FOREIGN KEY(id_user) REFERENCES user_profile(id_user);
ALTER TABLE supervisor ADD FOREIGN KEY(id_user) REFERENCES user_profile(id_user);
ALTER TABLE address ADD FOREIGN KEY(id_user) REFERENCES user_profile(id_user);
ALTER TABLE products ADD FOREIGN KEY(id_user) REFERENCES user_profile(id_user);
ALTER TABLE products ADD FOREIGN KEY(id_category) REFERENCES categories(id_category);

ALTER TABLE tags_and_ads ADD FOREIGN KEY(id_product) REFERENCES products(id_product);
ALTER TABLE tags_and_ads ADD FOREIGN KEY(id_tag) REFERENCES tags(id_tag);

ALTER TABLE ad_complaint ADD FOREIGN KEY(id_product) REFERENCES products(id_product);
ALTER TABLE ad_complaint ADD FOREIGN KEY(id_renter) REFERENCES user_profile(id_user);
ALTER TABLE ad_complaint ADD FOREIGN KEY(id_supervisor) REFERENCES user_profile(id_user);

ALTER TABLE request ADD FOREIGN KEY(id_renter) REFERENCES user_profile(id_user);
ALTER TABLE request ADD FOREIGN KEY(id_product) REFERENCES products(id_product);


ALTER TABLE rental ADD FOREIGN KEY(id_request) REFERENCES request(id_request);

ALTER TABLE cancelled ADD FOREIGN KEY(id_request) REFERENCES request(id_request);

ALTER TABLE landlord_rating ADD FOREIGN KEY(id_request) REFERENCES rental(id_request);
ALTER TABLE renter_rating ADD FOREIGN KEY(id_request) REFERENCES rental(id_request);
ALTER TABLE product_rating ADD FOREIGN KEY(id_request) REFERENCES rental(id_request);

