/************************************************
		Project DataBase
************************************************/

USE BlueMoon;

/***********************************************/

/***************************************************
		ANALYSIS
***************************************************/

CREATE TABLE FeedBack(
	UserId varchar(14) NOT NULL,
	SubjectId varchar(14) NOT NULL,
	TopicId varchar(14) NOT NULL,
	QuizSetId varchar(14) NOT NULL,
	Rating TINYINT NOT NULL,
 
	PRIMARY KEY(UserId,SubjectId,TopicId,QuizSetId),
	FOREIGN KEY(SubjectId,TopicId,QuizSetId) REFERENCES BatchQuiz(SubjectId,TopicId,QuizSetId) ON DELETE CASCADE
);

/***************************************************/

CREATE TABLE DailyLog(
	SerialNumber BIGINT UNIQUE NOT NULL AUTO_INCREMENT,
	UserId varchar(14) NOT NULL,
	LogInTimeStamp TIMESTAMP NOT NULL,
	
	PRIMARY KEY(UserId,LogInTimeStamp),
	FOREIGN KEY(UserId)REFERENCES UserDetails(UserId) ON DELETE CASCADE
);

/****************************************************/