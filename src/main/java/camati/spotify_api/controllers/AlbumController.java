package camati.spotify_api.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import camati.spotify_api.clients.openFeing.GoogleClient;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;


@RestController
@RequestMapping("spotify/api")
public class AlbumController {
  private final GoogleClient googleClient;

  public AlbumController(GoogleClient googleClient) {
      this.googleClient = googleClient;
  }

  @GetMapping("/albums") 
  public ResponseEntity<String> GetAlbums() {
      return ResponseEntity.ok(googleClient.getGoogleHomePage());
  }
  
  
}
