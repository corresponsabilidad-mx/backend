# Blog API Rest

Este proyecto es una API Rest de un motor de blog para la asociación civil "Corresponsabilidad Social Mexicana".

## Requisitos

-Java SE 11

-Maven

-Git

## Pasos para ejecutar

 1. Clonar el repositorio
```
git clone https://github.com/corresponsabilidad-mx/backend.git
```
 2. Compilar con Maven
```
 mvn clean package
```
3. Ejecutar el fat-jar
```
java -jar blog-0.0.1-SNAPSHOT.jar
```
La URL de la app es: http://localhost:8080/blog

## Ejecucion de tests

```
 mvn test
```

## Endpoints

Devuelve una Lista de publicaciones:
```
GET http://localhost:8080/blog/posts
```
<<<<<<< HEAD
Devuelve el post por numero de Id:
```
GET http://localhost:8080/post/{id}
```
Crea un Post:
```
POST http://localhost:8080/blog/post
```
Modifica un Post por Id
```
PUT http://localhost:8080/blog/post/update/{id}
```
Borra un Post por Id
```
DEL http://localhost:8080/blog/post/delete/{id}
```
=======
```
GET http://localhost:8080/blog/post/{id}
```




>>>>>>> origin/develop

