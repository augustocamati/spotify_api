# 🎧 Spotify API Client — Java 21 + Spring Boot + OpenFeign

Este projeto é uma integração com a **API do Spotify**, construída em **Java 21** com **Spring Boot** e **Spring Cloud OpenFeign**, permitindo autenticação e consumo de endpoints como **álbuns, novas músicas e artistas**.

O objetivo é demonstrar uma arquitetura limpa e moderna para consumir APIs REST externas com o mínimo de código e alta legibilidade.

---

## 🚀 Tecnologias Utilizadas

- ☕ **Java 21**
- 🌱 **Spring Boot
- ☁️ **Spring Cloud OpenFeign**
- 🎵 **Spotify Web API**
- 🧰 **Maven**
- 📘 **Swagger / Springdoc OpenAPI 3**
---

## 🧩 Estrutura do Projeto

```
spotify_api/
├── src/
│   ├── main/java/camati/spotify_api/
│   │   ├── SpotifyApiApplication.java          # Classe principal
│   │   ├── controllers/                        # Endpoints REST locais
│   │   ├── clients/
│   │   │   └── openFeing/                      # Interfaces Feign para chamadas HTTP externas
│   │   ├── dto/                                # Classes DTO para requisições e respostas
│   │   └── services/                           # (opcional) Regras de negócio e lógica de integração
│   └── resources/
│       └── application.properties               # Configurações da aplicação
├── pom.xml
└── README.md
```

---

## ⚙️ Configuração

### 1️⃣ Obtenha suas credenciais no Spotify Developer Dashboard
Crie uma aplicação em [https://developer.spotify.com/dashboard](https://developer.spotify.com/dashboard)  
e copie seu **Client ID** e **Client Secret**.

### 2️⃣ Configure no `application.properties`
```properties
spotify.client-id=SEU_CLIENT_ID
spotify.client-secret=SEU_CLIENT_SECRET
```

---

## 🔐 Autenticação com Spotify

A autenticação é feita via **Client Credentials Flow**, enviando um POST com  
`Content-Type: application/x-www-form-urlencoded` para obter o token de acesso.

Exemplo da interface Feign usada:

```java
@FeignClient(name="AuthSpotifyClient", url="https://accounts.spotify.com")
public interface AuthSpotifyClient {

  @PostMapping(value = "/api/token", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
  LoginResponse login(@RequestBody LoginRequest loginRequest);
}
```

---

## 🎵 Consumo da API do Spotify

Após obter o token de autenticação, o projeto consome endpoints da API pública, como:

```java
@FeignClient(name = "AlbumSpotifyClient", url = "https://api.spotify.com")
public interface AlbumSpotifyClient {

    @GetMapping("/v1/albums/{id}")
    String getAlbumById(@PathVariable("id") String id);

    @GetMapping("/v1/browse/new-releases")
    AlbumResponse getAllAlbums(@RequestHeader("Authorization") String authorization);
}
```

---

## 🧠 Exemplos de Uso

### ▶️ Obter Token
```bash
curl -X POST "https://accounts.spotify.com/api/token" \
     -H "Content-Type: application/x-www-form-urlencoded" \
     -d "grant_type=client_credentials&client_id=your-client-id&client_secret=your-client-secret"

```

### ▶️ Buscar Álbuns
```bash
GET https://api.spotify.com/v1/browse/new-releases
Authorization: Bearer {token}
```



## 📡 Endpoints Locais (exemplo)

| Método | Endpoint | Descrição |
|--------|-----------|-----------|
| `GET`  | `/albums/{id}` | Busca um álbum específico pelo ID |
| `GET`  | `/albums` | Lista novos lançamentos disponíveis |

---

## 📜 Licença

Este projeto está licenciado sob a **MIT License**.  
Sinta-se à vontade para usar, modificar e compartilhar!

---

## 👨‍💻 Autor

**Augusto Camati**  
💼 Desenvolvedor Backend — Java | Spring | APIs  
🔗 [LinkedIn](https://www.linkedin.com/in/augustocamati)
