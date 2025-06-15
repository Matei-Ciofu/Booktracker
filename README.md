#  BookTracker

BookTracker è una semplice applicazione REST realizzata con **Spring Boot** e **PostgreSQL**.  
Serve per tracciare i libri letti, da leggere o in lettura.

> Progetto creato per imparare a usare Spring Boot, JPA e le API REST.

## Tecnologie utilizzate

- Java 17
- Spring Boot
- Spring Web
- Spring Data JPA
- PostgreSQL
- Maven

## Funzionalità

- Aggiunta di libri
- Visualizzazione elenco
- Ricerca per ID
- Modifica
- Eliminazione

---

## ⚙️ Come avviare il progetto

### 1. Clona il progetto

```bash
git clone https://github.com/tuo-utente/booktracker.git
cd booktracker
```
2. Configura il database PostgreSQL
Assicurati di avere un DB chiamato booktracker.
Modifica src/main/resources/application.properties:

```bash
spring.datasource.url=jdbc:postgresql://localhost:5432/booktracker
spring.datasource.username=TUO_UTENTE
spring.datasource.password=LA_TUA_PASSWORD
spring.jpa.hibernate.ddl-auto=update
```
3. Avviare l'App
```bash
./mvnw spring-boot:run
```
