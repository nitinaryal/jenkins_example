from openjdk:8
EXPOSE 8080
ADD target/my-jenkins-app.jar my-jenkins-app.jar
ENTRYPOINT [ "java","-jar","/my-jenkins-app.jar" ]
