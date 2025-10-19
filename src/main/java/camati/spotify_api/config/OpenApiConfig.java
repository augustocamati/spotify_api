package camati.spotify_api.config;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

  @Bean
  public OpenAPI spotifyApiDocumentation() {
    return new OpenAPI()
        .info(new Info()
            .title("Spotify API Integration")
            .description("API para autenticação e consumo dos endpoints do Spotify utilizando OpenFeign e Spring Boot.")
            .version("1.0.0")
            .contact(new Contact()
                .name("Augusto Camati")
                .email("augustocamati21@gmail.com")
                .url("https://github.com/augustocamati"))
            .license(new License()
                .name("MIT License")
                .url("https://opensource.org/licenses/MIT")))
        .externalDocs(new ExternalDocumentation()
            .description("Documentação Oficial do Spotify API")
            .url("https://developer.spotify.com/documentation/web-api"));
  }
}
