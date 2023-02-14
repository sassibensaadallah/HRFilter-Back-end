FROM openjdk:17-alpine
WORKDIR /usr/app
VOLUME /usr/hrfilter
COPY target/hrfilter-0.0.1.jar ./
EXPOSE 8099
CMD ["java", "-jar", "-Dspring.profiles.active=staging", "hrfilter-0.0.1.jar"]

