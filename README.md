Sample JMS services for demonstrating [API Test Base](https://apitestbase.io/)'s JMS testing features.

Pre-requisites:
* Install and start Docker Desktop.
* Download the [docker-compose.yaml](https://raw.githubusercontent.com/apitestbase/sample-jms-services/refs/heads/master/docker-compose.yaml) file.
* Open a command line window, and cd to the directory where the docker-compose.yaml file is located.

To spin up the services, run `docker-compose up -d`. This starts two containers: activemq-classic and the Spring Boot app containing the sample JMS services.

To shut down and remove the services, run `docker-compose down`.

The JMS services
* Echo service
  * Receive a JMS message from an ActiveMQ input queue, and send a JMS message to an ActiveMQ output queue, with the message body and JMSCorrelationID header copied from the input message.
  * Input/output ActiveMQ queues: echo.in, echo.out.
  * This service can be used to test JMS Request/Reply pattern.
