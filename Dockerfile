# ===== СТАДИЯ 1: сборка приложения =====
FROM maven:3.9.9-eclipse-temurin-17 AS build
WORKDIR /app

# Копируем pom.xml и скачиваем зависимости
COPY pom.xml .
RUN mvn dependency:go-offline -B

# Копируем исходники и собираем jar
COPY src ./src
RUN mvn clean package -DskipTests

# ===== СТАДИЯ 2: запуск =====
FROM eclipse-temurin:17-jdk-alpine
WORKDIR /app

# Копируем jar из первой стадии
COPY --from=build /app/target/inter_pr5-0.0.1-SNAPSHOT.jar app.jar

# Указываем команду запуска
CMD ["java", "-jar", "app.jar"]
