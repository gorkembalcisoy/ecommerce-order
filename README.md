# Online Sipariş Sistemi - Order Microservice Modülü

Bu servis, Spring boot üzerinde DDD kullanılarak geliştirilmiştir.
application, domain ve infrastructure katmanları bulunmaktadır.

Product microservisi ile iletişim, event'ler üzerinden Apache Kafka ile sağlanmaktadır.
Apache Kafka uygulamasının localhost:9092'de çalışıyor olması gerekmektedir.

Bir Order oluşturulduğunda WAITING durumunda olmakta ve Product servisine orderCreateEvent'i gönderilmektedir.
Product servisinin yetersiz stok event'i göndermesi durumunda Order CANCELLED durumuna alınır.
Product servisinin başarılı dönmesi durumunda ise, Order COMPLETED durumuna alınır.

Database olarak PostgreSQL kullanılmaktadır, compose.yaml dosyası üzerinde yapılandırılmıştır ve
spring boot uygulaması ayağa kaldırılırken database servisi de başlatılmaktadır.

Spring boot uygulaması Run edildiğinde Product microservisi ve PostgreSQL servisi çalışır duruma gelmektedir.

REST API'ları:
Order findAll ve save ile ilişkili GET ve POST metodlarına Swagger üzerinden erişilebilir.
http://localhost:8081/swagger-ui/index.html

