FROM openjdk:19
COPY target/surveyJar.jar surveyJar.jar
ENTRYPOINT ["java","-jar","/surveyJar.jar"]
EXPOSE 8080 