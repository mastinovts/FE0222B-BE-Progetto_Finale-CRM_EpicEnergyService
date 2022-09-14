# FE0222B-BE-Progetto Finale CRM
Epic Energy Service

Applicazione per gestire i clienti di un'azienda di energia"EPIC ENERGY SERVICES".

La parte frontend è stata creata con Thymeleaf e quella backend con Spring

L'applicazione presenta un sistema di autenticazione e autorizzazione basato su token JWT che permette a diversi utenti di accedere alle funzioni del backend e di registrarsi al sistema. Un utente è caratterizzato dalle seguenti proprietà:
username
email
password
nome
cognome

admin-admin
user-user

Gli utenti possono essere di tipo USER, abilitato alle sole operazioni di lettura, oppure ADMIN, abilitato a tutte le operazioni. Un utente può avere più ruoli

Per la documentazione con SWAGGER:
http://localhost:8080/swagger-ui.html

Inoltre sono stati effettuati alcuni dei principali test di integrazione con l'utilizzo di MockMvc.

 
