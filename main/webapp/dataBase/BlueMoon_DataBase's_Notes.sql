/************************************************
		Project DataBase
************************************************/
CREATE DATABASE BlueMoon;

USE BlueMoon;
/***********************************************

/************************************************
		NOTES TABLES
************************************************/

CREATE TABLE Notes(
	SubjectId varchar(14) PRIMARY KEY,
	SubjectName varchar(30) NOT NULL,
	SubjectAbout varchar(2400) NOT NULL
);

/***************************************************/

CREATE TABLE Topics(
	SubjectId varchar(14),
	TopicId varchar(14),
	TopicName varchar(30) NOT NULL,
	
	PRIMARY KEY(SubjectId,TopicId),
	FOREIGN KEY(SubjectId) REFERENCES Notes(SubjectId) ON DELETE CASCADE
);


/***************************************************/

CREATE TABLE BatchQuiz(
	SubjectId varchar(14),
	TopicId varchar(14),
	QuizSetId varchar(14),	
	BatchName varchar(30) NOT NULL,
	TotalQuestions INT NOT NULL, 
	TotalPoints INT NOT NULL,
	TotalTime INT NOT NULL,
	DifficultLevel varchar(30) NOT NULL,

	PRIMARY KEY(SubjectId,TopicId,QuizSetId),
	FOREIGN KEY(SubjectId,TopicId) REFERENCES Topics(SubjectId,TopicId) ON DELETE CASCADE
);

/***************************************************/

CREATE TABLE Question(
	SubjectId varchar(14),
	TopicId varchar(14),
	QuizSetId varchar(14),
	QuizId varchar(14),
	QuizContent varchar(300) NOT NULL,
	QuizPoint INT NOT NULL,

	PRIMARY KEY(SubjectId,TopicId,QuizSetId,QuizId),
	FOREIGN KEY(SubjectId,TopicId,QuizSetId) REFERENCES BatchQuiz(SubjectId,TopicId,QuizSetId) ON DELETE CASCADE
);

/***************************************************/

CREATE TABLE Options(
	SubjectId varchar(14),
	TopicId varchar(14),
	QuizSetId varchar(14),
	QuizId varchar(14),
	OptionId varchar(14),
	OptionContent varchar(200) NOT NULL,
	AnswerTrueFlase INT NOT NULL,
	
	PRIMARY KEY(SubjectId,TopicId,QuizSetId,QuizId,OptionId),
	FOREIGN KEY(SubjectId,TopicId,QuizSetId,QuizId) REFERENCES Question(SubjectId,TopicId,QuizSetId,QuizId) ON DELETE CASCADE
);

/***************************************************/

