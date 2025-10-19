package camati.spotify_api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.openfeign.EnableFeignClients;

import camati.spotify_api.config.SpotifyProperties;

@SpringBootApplication
@EnableFeignClients
@EnableConfigurationProperties(SpotifyProperties.class)
public class SpotifyApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpotifyApiApplication.class, args);
	}

}
