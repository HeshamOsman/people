FROM maven:3.6.3-openjdk-11

LABEL maintainer = "hesham.osman28@gmail.com"

EXPOSE 8080

ENV jwt-secret=
ENV admin-username=
ENV admin-password=
ENV nonadmin-username=
ENV nonadmin-password=
ENV db-url=
ENV db-username=
ENV db-password=

ADD . ~/people-app

WORKDIR ~/people-app
RUN mvn dependency:go-offline
RUN mvn package

WORKDIR ./target


CMD exec java -Ddb-url=${db-url} -Ddb-username=${db-username} -Ddb-password=${db-password} -Dspring.profiles.active=prod -Djwt-secret=${jwt-secret}  -Dadmin-username=${admin-username} -Dadmin-password=${admin-password} -Dnonadmin-username=${nonadmin-username} -Dnonadmin-password=${nonadmin-password}  -jar api-*.jar