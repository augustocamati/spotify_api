package camati.spotify_api.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import camati.spotify_api.clients.openFeing.AlbumSpotifyClient;
import camati.spotify_api.clients.openFeing.AuthSpotifyClient;
import camati.spotify_api.clients.openFeing.dto.AlbumResponse;
import camati.spotify_api.clients.openFeing.dto.LoginRequest;
import camati.spotify_api.config.SpotifyProperties;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("spotify/api")
@AllArgsConstructor
public class AlbumController {
  private final AuthSpotifyClient authSpotifyClient;
  private final AlbumSpotifyClient albumSpotifyClient;
  private final SpotifyProperties spotifyProperties;

  @GetMapping("/albums")
  
  @Operation(summary = "Buscar lista de álbuns", description = "Obtém os álbuns disponíveis usando o token da API do Spotify.")
  @ApiResponse(responseCode = "200", description = "Lista retornada com sucesso")
  public ResponseEntity<AlbumResponse> GetAlbums() {
    LoginRequest request = new LoginRequest(
        "client_credentials",
        spotifyProperties.getClientId(),
        spotifyProperties.getClientSecret());

    var token = authSpotifyClient.login(request).getAccessToken();
    var authorization = "Bearer " + token;

    var albums = albumSpotifyClient.getAllAlbums(authorization);
    return ResponseEntity.ok(albums);
  }

}
