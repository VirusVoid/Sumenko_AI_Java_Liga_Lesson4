# Sumenko_AI_Java_Liga_Lesson4

REST сервис, с помощью которого можно оформлять заказы для покупателей

## Используемые технологии:

* Spring Boot 2.3.4
* Gradle
* Java 11
* Spring Web
* Spring Data JDBC
* H2 Database (in memory)
* Lombok
* JUnit 5
* Mockito
* Spring Boot Test

## Установка и запуск приложения:

Для запуска веб-сервиса нужно развернуть его на своей локальной машине. Для этого необходимо:
* создать копию оригинального проекта: ```git clone https://github.com/VirusVoid/Sumenko_AI_Java_Liga_Lesson4.git```.
* перейти в директорию проекта и запустить команду в cmd: ```gradle bootRun```.

Приложение запустится на ```http://localhost:8080```.

## REST API

### Добавить заказ
#### Запрос
```POST /api/v1/order```

URL:
```http://localhost:8080/api/v1/order```

Request body:
{
    "id": 1,
    "customer_id": 1,
    "name": "fruits",
    "price": 500
}

#### Ответ
```HTTP/1.1 200 OK```

Response body (id):
1
