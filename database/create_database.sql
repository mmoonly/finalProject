DROP DATABASE IF EXISTS final_project;

CREATE DATABASE IF NOT EXISTS final_project;

USE final_project;

CREATE TABLE IF NOT EXISTS users
(
  id INT AUTO_INCREMENT UNIQUE NOT NULL,
  login VARCHAR(255) UNIQUE NOT NULL,
  password VARCHAR(255) NOT NULL,
  role VARCHAR(255),
  PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS profiles
(
  id INT AUTO_INCREMENT NOT NULL,
  name VARCHAR(255) NOT NULL,
  surname VARCHAR(255) NOT NULL,
  rating INT NOT NULL,
  user_id INT UNIQUE,
  PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS categories
(
  id INT NOT NULL AUTO_INCREMENT,
  thread VARCHAR(255) NOT NULL,
  parent_id INT,
  PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS compositions
(
  id INT NOT NULL AUTO_INCREMENT,
  heading VARCHAR(200) NOT NULL,
  publication_date TIMESTAMP NOT NULL,
  description VARCHAR(1000),
  text VARCHAR(10000),
  category_id INT NOT NULL,
  profile_id INT NOT NULL,
  PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS comments
(
id INT NOT NULL AUTO_INCREMENT,
value VARCHAR(700) NOT NULL,
publication_date TIMESTAMP,
profile_id INT NOT NULL,
composition_id INT NOT NULL,
PRIMARY KEY (id)
);


ALTER TABLE profiles
	  ADD CONSTRAINT fk_profiles_user_id
      FOREIGN KEY (user_id) 
      REFERENCES users (id);

ALTER TABLE categories
      ADD CONSTRAINT fk_categories_parent_id  
      FOREIGN KEY (parent_id) 
      REFERENCES categories (id);
	
ALTER TABLE compositions
      ADD CONSTRAINT fk_adverts_user_id  
      FOREIGN KEY (profile_id) 
      REFERENCES profiles (id),
	  ADD CONSTRAINT fk_adverts_catalog_id  
      FOREIGN KEY (category_id) 
      REFERENCES categories (id);
      
ALTER TABLE comments
      ADD CONSTRAINT fk_comments_user_id  
      FOREIGN KEY (profile_id) 
      REFERENCES profiles (id),
      ADD CONSTRAINT fk_comments_advert_id  
      FOREIGN KEY (composition_id) 
      REFERENCES compositions (id);

COMMIT;