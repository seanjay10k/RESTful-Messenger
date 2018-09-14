# RESTmessenger
Simple RESTful Web Service developed using JAX-RS for a Messenger app. API produces and consumes resources in JSON.  
CRUD operations on user profiles and messages and any comments associated to the messages. 




http://localhost:8084/messenger/
Jersey RESTful Web Application!
Jersey resource

Visit Project Jersey website for more information on Jersey!


http://localhost:8084/messenger/webapi/profiles
[
    {
        "firstName": "Robert",
        "id": 1,
        "lastName": "Downey J.R",
        "profileName": "Ironman"
    },
    {
        "firstName": "Benedict",
        "id": 1,
        "lastName": "Cumberbatch",
        "profileName": "Dr. Strange"
    },
    {
        "firstName": "Mark",
        "id": 1,
        "lastName": "Ruffalo",
        "profileName": "Hulk"
    }
]

http://localhost:8084/messenger/webapi/profiles/Ironman
{
    "firstName": "Robert",
    "id": 1,
    "lastName": "Downey J.R",
    "profileName": "Ironman"
}


http://localhost:8084/messenger/webapi/messages

[
    {
        "author": "Hello Mars!",
        "created": "2018-09-13T22:07:39.307",
        "id": 1,
        "message": "Superman"
    },
    {
        "author": "Hello Earth",
        "created": "2018-09-13T22:07:39.307",
        "id": 2,
        "message": "Batman"
    }
]

http://localhost:8084/messenger/webapi/messages/1
{
    "author": "Hello Mars!",
    "created": "2018-09-13T22:13:53.749",
    "id": 1,
    "message": "Superman"
}

http://localhost:8084/messenger/webapi/messages?offset=30&limit=10
[
    {
        "author": "Hello Mars!",
        "created": "2018-09-13T22:07:39.307",
        "id": 1,
        "message": "Superman"
    },
    {
        "author": "Hello Earth",
        "created": "2018-09-13T22:07:39.307",
        "id": 2,
        "message": "Batman"
    }
]
