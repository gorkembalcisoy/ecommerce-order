FROM amazoncorretto:21
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} ecommerce-order-module-1.jar
CMD apt-get update -y
ENTRYPOINT ["java", "-Xmx512M", "-jar", "/ecommerce-order-module-1.jar"]