# Quiz-Backend
microservice created using springboot, where you can add questions and create quiz based on various parameters and upon submit score can be viewed

-> adding question 
  api -> localhost:8080/api/v1/question/addQuestion
  body -> {
      "questionName": "Who is known as the father of modern physics?",
      "option1": "Isaac Newton",
      "option2": "Albert Einstein",
      "option3": "Galileo Galilei",
      "option4": "Stephen Hawking",
      "correctAnswer": "Albert Einstein",
      "category": "phy",
      "level": "Difficult"
    }
  -> get all questions
    api -> localhost:8080/api/v1/question/viewAll
  -> create quiz
    api -> localhost:8080/quiz/create?title=chemQuiz&numQ=3&category=chem
    params -> title = "",
              numQ = int,
              category = ""
  -> get quiz by id
    api -> localhost:8080/quiz/get/2
  -> submit quiz 
    api -> localhost:8080/quiz/submit/2
    body -> [
              {
                "id" : 3,
                "response" : "Alberts Einstein"
              },
              {
                "id" : 2,
                "response" : "Albert Einstein"
              },
              {
                "id" : 6,
                "response" : "Albert Einstsein"
              }
            ]
