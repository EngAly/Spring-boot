### SpringBoot + mongodb project target
* How to create springboot project with jpa mongo database
* How to create relations between documents in collection
* How to create most common relations in documents (nested Docs | reference Docs)

### Snippet
* Project has two relations
  * How to create nested relations (example Author and Book => author has many books in one document)
  * How to create reference relations (example Author and Book => each book doc has author id)

### Details
Project has two relations
1) create nested relations => in project there example clean this relation with author and book. create collection **author** that
has all authors when create document for one author it contain all author data and all books for that author as well. so that it called nested document

2) create reference document => same mentioned example we create **author** collection that has all authors information
and create another collection **book** that has all books for authors How that work   
when we create author will has id each book will created for that author will inject this id in book to be as reference for that author and so on.


### Prerequisites
* knowledge with spring boot framework (specific spring Data JPA)
* knowledge wih mongo database (collections, documents, CRUD, ....)

### Tools
* Editor (STS => Spring Tool Suite is recommended)
* install Mongo database to localhost.

### Cloning
* git clone -b spring-mongodb https://github.com/EngAly/SpringBoot
