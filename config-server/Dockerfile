# Utiliser une image de base avec Java 17
FROM openjdk:17-jdk-alpine

# Définir le répertoire de travail dans le conteneur
WORKDIR /app

# Copier le fichier JAR de l'application dans le conteneur
COPY target/config-server-0.0.1-SNAPSHOT.jar app.jar

# Exposer le port sur lequel l'application va écouter
EXPOSE 8888

# Commande pour exécuter l'application
ENTRYPOINT ["java", "-jar", "app.jar"]