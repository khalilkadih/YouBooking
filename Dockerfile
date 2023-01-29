FROM openjdk:17
COPY target/YouBooking-0.0.1-SNAPSHOT.jar youbooking.jar
ENTRYPOINT ["java" , "-jar", "/youbooking.jar" ]
