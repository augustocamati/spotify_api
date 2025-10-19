package camati.spotify_api.clients.openFeing;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;

import camati.spotify_api.clients.openFeing.dto.AlbumResponse;

@FeignClient(name = "AlbumSpotifyClient", url = "https://api.spotify.com")

public interface AlbumSpotifyClient {

  @GetMapping("/v1/albums/{id}")
  String getAlbumById(@PathVariable("id") String id);

  @GetMapping("/v1/browse/new-releases")
  AlbumResponse getAllAlbums(@RequestHeader("Authorization") String authorization);

}
