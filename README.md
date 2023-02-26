# DefineX Java Spring Practicum Final Case 

## Spring Boot
HTML, Css, Javascript(Optional)

## Proje Konusu:
Bir kredi başvuru sistemi için, kredi başvuru isteklerini alıp ilgili kriterlere göre müşteriye kredi sonucunu dönen servisin içinde yer alacak restful bir uygulamanın Spring Boot framework kullanılarak yazılması ve isteğe bağlı olarak önyüzünün yazılması.

## Backend:
- Kimlik numarası, ad-soyad, aylık gelir, telefon bilgileri, doğum tarihi ve teminat(opsiyonel) kimlik numarasıyla daha önceden yazıldığı varsayılan kredi skoru servisine gidilir ve ilgili kişiye ait kredi skoru alınarak aşağıdaki kurallara göre kullanıcıya kredi sonucu gösterilir. (Onay veya Red olarak iki seçenek olabilir.) 

## Frontend (opsiyonel): 

- Kimlik numarası, ad-soyad, aylık gelir, telefon bilgileri, doğum tarihi ve teminat(opsiyonel) bilgileri form ile alınır ve kullanıcıya kredi sonucu ve kredi limiti gösterilir. 
- JavaScript, HTML, CSS en basit şekilde yeterlidir, isteğe bağlı olarak front-end framework kullanılabilir. Arayüz tasarımı ve deneyimi size bırakılmıştır.

## Kurallar 
- Sisteme yeni kullanıcılar tanımlanabilir, mevcut müşteriler güncellenebilir veya silinebilir.
- Kredi skoru 500’ün altında ise kullanıcı reddedilir. (Kredi sonucu: Red)
- Kredi skoru 500 puan ile 1000 puan arasında ise ve aylık geliri 5000 TL’nin altında ise kullanıcının kredi başvurusu onaylanır ve kullanıcıya 10.000 TL limit atanır. (Kredi Sonucu: Onay). Eğer teminat vermişse teminat bedelinin yüzde 10 u kadar tutar kredi limitine eklenir.
- Kredi skoru 500 puan ile 1000 puan arasında ise ve aylık geliri 5000 TL ile 10.000TL arasında ise kullanıcının kredi başvurusu onaylanır ve kullanıcıya 20.000 TL limit atanır. (Kredi Sonucu:Onay) Eğer teminat vermişse teminat bedelinin yüzde 20 si kadar tutar kredi limitine eklenir.
- Kredi skoru 500 puan ile 1000 puan arasında ise ve aylık geliri 10.000 TL’nin üstünde ise kullanıcının kredi başvurusu onaylanır ve kullanıcıya AYLIK GELİR BİLGİSİ * KREDİ LİMİT ÇARPANI/2 kadar limit atanır. (Kredi Sonucu:Onay) Eğer teminat vermişse teminat bedelinin yüzde 25 i kadar tutar kredi limitine eklenir.
- Kredi skoru 1000 puana eşit veya üzerinde ise kullanıcıya AYLIK GELİR BİLGİSİ * KREDİ LİMİT ÇARPANI kadar limit atanır. (Kredi Sonucu: Onay) Eğer teminat vermişse teminat bedelinin yüzde 50 si kadar tutar kredi limitine eklenir.
- Kredinin neticelenmesi sonucunda ilgili başvuru veritabanına kaydedilir. Daha sonrasında ise ilgili telefon numarasına bilgilendirme SMS’i gönderilir ve endpoint’ten onay durum bilgisi (red veya onay), limit bilgisi dönülür.
- Gerçekleştirilmiş bir kredi başvurusu sadece kimlik numarası ve doğum tarihi bilgisi ile sorgulanabilir. Doğum tarihi ve kimlik bilgisi eşleşmezse sorgulanamamalıdır. 

Notlar: Kredi limit çarpanı varsayılan olarak 4’tür.

## Projeden Beklenenler (Scorecard):
Backend projesinin belirtilen kurallara göre doğru çalışır olması (readme dosyasının eklenmesi ya da Dockerfile yazılması) 

Kodun kalitesine (Clean Code), yapılandırılmasına (Structure) dikkat edilmesi, yeni özellikler için geliştirmeye açık olması ve anlaşılabilir olması. (SOLID principles)

Test yazılması

Design Patterns kullanımı

Dokümantasyon(Swagger, OpenApi vb) 

NoSQL,RDBMS(ORM) ve Hibernate (JPA) gibi teknolojilerin kullanımı

Loglama mekanizmasının kurulması

Frontend projesinin çalışır olması

## Projede Kullanılan Teknolıjiler:
- Java Spring Boot
- PostgreSQL
- Postman

## Postman Çıktıları: 
- Add Customer 
<img src= "https://github.com/ATTNC/PatikaDefinexFinalCase/blob/main/loanApp/images/customerAdd.jpg" width=700>

- Customer Get All
<img src= "https://github.com/ATTNC/PatikaDefinexFinalCase/blob/main/loanApp/images/customerGetAll.jpg" width=500>

- Login Failed 
<img src= "https://github.com/ATTNC/PatikaDefinexFinalCase/blob/main/loanApp/images/loginFailed.jpg" width=700>

- Login Success
<img src= "https://github.com/ATTNC/PatikaDefinexFinalCase/blob/main/loanApp/images/loginSuccess.jpg" width=700>

- Transaction Failed
<img src= "https://github.com/ATTNC/PatikaDefinexFinalCase/blob/main/loanApp/images/transactionFailed.jpg" width=700>

- Transaction Success
<img src= "https://github.com/ATTNC/PatikaDefinexFinalCase/blob/main/loanApp/images/transactionSuccess.jpg" width=700>

- Transaction Get All
<img src= "https://github.com/ATTNC/PatikaDefinexFinalCase/blob/main/loanApp/images/transactionGetAll.jpg" width=700>

## Sms : 
<img src= "https://github.com/ATTNC/PatikaDefinexFinalCase/blob/main/loanApp/images/sms.jpeg" width=700>



