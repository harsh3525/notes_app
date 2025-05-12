# 📝 Notes Application

A simple Spring Boot application that provides RESTful APIs manage notes. Includes authentication using Basic Auth 

---

## 📦 Features

- Create, Read, Update, Delete notes via REST API
- Basic Authentication for REST API

---


### Run the application

```bash
# If using Maven
./mvnw spring-boot:run
```

---
#### User setup
- When application runs by default 2 users will created through command line runner, but still provide cURL for create Users
- userName : test@gmail.com password: password
- userName: test1@gmail.com password: password

---
#### cURL commands


- Create user
curl --location 'http://localhost:8080/api/users/createUser' \
--header 'Content-Type: application/json' \
--data-raw '{
  "email": "test2@gmail.com",
  "password": "newpassword"
}'


- Create a Note
	curl --location 'localhost:8080/api/notes/createNote' \
--header 'Content-Type: application/json' \
--header 'Authorization: Basic dGVzdDFAZ21haWwuY29tOnBhc3N3b3Jk' \
--header 'Cookie: JSESSIONID=1BDBD5F137A1532C9F2AAC6C97941D8C' \
--data '{
    "title":"title_1",
    "note":"title_1"
}'

- Get All Notes
	curl --location 'localhost:8080/api/notes/getAllNotes' \
--header 'Authorization: Basic dGVzdEBnbWFpbC5jb206cGFzc3dvcmQ=' \
--header 'Cookie: JSESSIONID=1BDBD5F137A1532C9F2AAC6C97941D8C'


- Get Note by ID
	curl --location 'localhost:8080/api/notes/3' \
--header 'Authorization: Basic dGVzdDFAZ21haWwuY29tOnBhc3N3b3Jk' \
--header 'Cookie: JSESSIONID=1BDBD5F137A1532C9F2AAC6C97941D8C'


- Update Note
	curl --location --request PUT 'localhost:8080/api/notes/updateNote/2' \
--header 'Content-Type: application/json' \
--header 'Authorization: Basic dGVzdEBnbWFpbC5jb206cGFzc3dvcmQ=' \
--header 'Cookie: JSESSIONID=1BDBD5F137A1532C9F2AAC6C97941D8C' \
--data '{
        "title": "updated title",
        "note": "update note"
}'


- Delete Note
	curl --location --request DELETE 'localhost:8080/api/notes/1' \
--header 'Authorization: Basic dGVzdDFAZ21haWwuY29tOnBhc3N3b3Jk' \
--header 'Cookie: JSESSIONID=1BDBD5F137A1532C9F2AAC6C97941D8C'
