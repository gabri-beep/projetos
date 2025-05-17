# 💸 API de Controle de Despesas Pessoais

API REST desenvolvida com **Java 21** e **Spring Boot**, permitindo gerenciar usuários, categorias e despesas financeiras. Os dados são armazenados em um banco de dados **MySQL**, e os testes podem ser feitos com o **Postman**.

---

## 🚀 Tecnologias Utilizadas

- Java 21
- Spring Boot
- Spring Data JPA
- MySQL
- Lombok
- Swagger (Springdoc OpenAPI)
- Maven
- Postman (para testes da API)

---

## 🧰 Instalação e Configuração

### Pré-requisitos

- Java 21 instalado
- MySQL em execução
- Maven instalado
- Postman (https://www.postman.com/downloads/)

### Configuração do banco de dados

Crie o banco no MySQL:

```sql
create database if not exists despesas;
use despesas;

