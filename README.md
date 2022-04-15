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






