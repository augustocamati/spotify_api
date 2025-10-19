package camati.spotify_api.clients.openFeing;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import camati.spotify_api.clients.openFeing.dto.LoginRequest;
import camati.spotify_api.clients.openFeing.dto.LoginResponse;

@FeignClient(name="AuthSpotifyClient", url="https://accounts.spotify.com")
public interface AuthSpotifyClient {

  @PostMapping(value = "/api/token", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
  LoginResponse login(@RequestBody LoginRequest loginRequest);
}
