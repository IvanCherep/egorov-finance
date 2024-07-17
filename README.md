# egorov-finance

## Запуск

Инструменты:

- Apache Maven 3.6.3
- Java 11

Для подключения к базе данных необходимо добавить файл db.properties
в src/main/resources и прописать в нем ключи db, user, password, port

Для сборки приложения прописываем mvn clean install (находясь в директории с pom.xml)

После этого с запущенным docker движком прописываем docker-compose up и запускам приложение

Для остановки контенеров прописываем docker-compose down