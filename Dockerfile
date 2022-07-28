FROM maven:3.8.6-jdk-8

WORKDIR /projects

COPY . ./financial-control

WORKDIR ./financial-control

RUN mvn -T 2C -DskipTests clean install

EXPOSE 5656/tcp