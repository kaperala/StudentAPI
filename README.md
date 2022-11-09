
# Student API (School project)

This is a final assignment of a Java course I did at school. It is an API for querying and posting student/course data. The API is made with Java and SpringBoot and the said data lives in text files under [/tiedostot/](https://github.com/kvllu/StudentAPI/tree/main/tiedostot). The project was made in 2021 and the repository is not maintained.



## Routes
**Routes for usage are as follows:**

GET Students:
```bash
  - This route returns all students from students.txt
  localhost:8080/students
  (Returns JSON)
```
```bash
  - Using this route you can query students and courses they are in by their ID.
  localhost:8080/students/{studentID}
  (Returns HTML)
```
GET Courses:

```bash
  - This route returns all courses and their students from courses.txt
  localhost:8080/courses
  (Returns JSON)
```

```bash
  - Using this route you can query course's subject and attending students with its ID.
  localhost:8080/courses/{courseID}
  (Returns HTML)
```

```bash
  - Using this route you can query all courses that are type OnlineCourse.
  localhost:8080/onlinecourses}
  (Returns JSON)
```

POST:
```bash
  - You can add student to a course with this POST route.
  localhost:8080/add
```
