### **User**
The User model keeps track of users information.
```java
public class User {
  private int userId; // primary key
  private String username; // not null, unique
  private String password; // not null
  private String firstName; // not null
  private String lastName; // not null
  private String email; // not null
  private Role role;
  
 CREATE TABLE userx (
	userId SERIAL PRIMARY KEY,
	username VARCHAR (50) NOT NULL UNIQUE,
	password VARCHAR (16) NOT NULL,
	firstName VARCHAR(30) NOT NULL,
	last_name VARCHAR(30) NOT NULL,
	email VARCHAR(30)  NOT NULL,
	role INTEGER 
);
 
CREATE TABLE avengers (
	superhero_id SERIAL PRIMARY KEY, 
	superhero_name VARCHAR (30),
	superhero_power VARCHAR (50) UNIQUE,
	first_name VARCHAR(30) NOT NULL,
	last_name VARCHAR(30) NOT NULL,
	power_level INTEGER,
	home_base VARCHAR(30) REFERENCES homes(home_name)	
);

public class Role {
  private int roleId; // primary key
  private String role; // not null, unique
}

public class Account {
  private int accountId; // primary key
  private double balance;  // not null
  private AccountStatus status;
  private AccountType type;
}

CREATE TABLE account (
	accountId INTEGER PRIMARY KEY,
	balance DOUBLE NOT NULL,
	status VARCHAR (4) NOT NULL,
	type VARCHAR (6)
);

public class AccountStatus {
  private int statusId; // primary key
  private String status; // not null, unique
}

CREATE TABLE accountstatus (
	statusId INTEGER PRIMARY KEY,	
	status VARCHAR (4) NOT NULL UNIQUE
);

public class AccountType {
  private int typeId; // primary key
  private String type; // not null, unique
}

CREATE TABLE accounttype (
	typeId INTEGER PRIMARY KEY,	
	type VARCHAR (16) NOT NULL UNIQUE
);
