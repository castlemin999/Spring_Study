# Spring Boot

## 프로젝트 생성

**스프링 부트 스타터 사이트로 이동해서 스프링 프로젝트 생성**
https://start.spring.io

### 프로젝트 선택

Project: Gradle Project  
Spring Boot: 2.3.x  
Language: Java  
Packaging: Jar  
Java: 11  

### Project Metadata

groupId: hello  
artifactId: hello-spring  

### Dependencies

Spring Web, Thymeleaf

## 빌드하고 실행

1. ./gradlew build
2. cd build/libs
3. java -jar hello-spring-0.0.1-SNAPSHOT.jar

## Spring Boot Welcome Page

static/index.html을 올려두면 Welcome Page기능을 제공
