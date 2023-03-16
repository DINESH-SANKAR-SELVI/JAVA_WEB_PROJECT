/************************************************
		Project DataBase
************************************************/

USE BlueMoon;

/***********************************************/

/********************************************
		User Tables
********************************************/

CREATE TABLE userDetails(
	UserId varchar(14) PRIMARY KEY,
	UserAvatar varchar(20) NOT NULL,
	UserName varchar(30) NOT NULL, 
	UserBhd DATE NOT NULL,
	UserGender varchar(7) NOT NULL,
	UserNumber BIGINT UNIQUE NOT NULL,
	UserEmail varchar(50) UNIQUE NOT NULL,
	UserQualification varchar(50) NOT NULL,
	UserPincode INT NOT NULL,
	UserCity varchar(30) NOT NULL,
	UserArea varchar(30) NOT NULL,
	UserPassword varchar(30) NOT NULL,
	UserJoinDate DATE NOT NULL
);

/**********************************************/

CREATE TABLE userPersonalLogs(
	UserId varchar(14) PRIMARY KEY,
	/*UserRankGlobal BIGINT UNIQUE NOT NULL,
	UserRankRegion INT UNIQUE NOT NULL,*/
	UserAverageCorrect FLOAT NOT NULL,
	UserAverageWrong FLOAT NOT NULL,
	UserTotalAttempt INT NOT NULL,

 	FOREIGN KEY(UserId)REFERENCES UserDetails(UserId) ON DELETE CASCADE
);

/***********************************************/

CREATE TABLE userHistory(
	UserSerialNumber INT,
	UserId varchar(14),
	EventName varchar(30) NOT NULL,
	TopicName varchar(30) NOT NULL,
	EventAttendDate TIMESTAMP NOT NULL,
	EventQuestionsId varchar(16) UNIQUE NOT NULL, 
	EventPoint TINYINT NOT NULL,
	SkipedQuiz TINYINT NOT NULL,
	AttenedQuiz TINYINT NOT NULL,

	PRIMARY KEY(UserSerialNumber,UserId),
	FOREIGN KEY(UserId)REFERENCES UserDetails(UserId) ON DELETE CASCADE
);

/***********************************************/

CREATE TABLE Review(
	EventQuestionsId varchar(16) PRIMARY KEY,
	NumberOfCorrectAnswer FLOAT NOT NULL,
	NumberOfWrongAnswer FLOAT NOT NULL,
	SubjectId varchar(14) NOT NULL,
	TopicId varchar(14) NOT NULL,
	QuizSetId varchar(14) NOT NULL,

	FOREIGN KEY(EventQuestionsId)REFERENCES userHistory(EventQuestionsId) ON DELETE CASCADE
);

/***********************************************/

CREATE TABLE ReviewQuestionAnswer(
	EventQuestionsId varchar(16),
	SubjectId varchar(14),
	TopicId varchar(14),
	QuizSetId varchar(14),
	QuizId varchar(14),
	UserOptionId varchar(14) NOT NULL,

	PRIMARY KEY(EventQuestionsId,SubjectId,TopicId,QuizSetId,QuizId),
	FOREIGN KEY(EventQuestionsId)REFERENCES Review(EventQuestionsId) ON DELETE CASCADE
);

/************************************************/