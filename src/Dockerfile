# Используем базовый образ с Java
FROM openjdk:17-jdk-alpine

# Создаем каталог приложения
RUN mkdir -p /src/main/java/com/arbinatesttask/arbina_test
WORKDIR /src/main/java/com/arbinatesttask/arbina_test

# Копируем JAR-файл приложения в контейнер
COPY target/Arbina_Test-0.0.1-SNAPSHOT.jar /src/main/java/com/arbinatesttask/arbina_test

# Указываем порт, который будет использоваться вашим приложением
EXPOSE 9000

# Команда для запуска приложения в контейнере
CMD ["java", "-jar", "Arbina_Test-0.0.1-SNAPSHOT.jar"]