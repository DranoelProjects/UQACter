UQACter

UQACter est une application (web-app) composée d'un backend en java (Spring Boot Microservices, Gateway et Register) et d'un frontend en react. L'application est également conteneuriser avec Docker.
UQACter est une messeragerie instantanée avec des fonctionnalités simples permettant de gérer les utilisateurs, les messages et les conversations.

Il y a croncrètrement 2 microservices :
- User
- Message

Pour lancer un microservice, le gateway et le register on peut utiliser la commande suivante (en se plaçant à la racine d'un des composants):  
```mvnw spring-boot:run```  

Pour lancer l'application après s'est placé à la racine de l'application /app, lancer les commandes suivantes :  
```npm i```  
```npm start```  
