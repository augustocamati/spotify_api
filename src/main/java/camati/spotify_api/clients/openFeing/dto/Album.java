package camati.spotify_api.clients.openFeing.dto;

import com.fasterxml.jackson.databind.PropertyNamingStrategies.SnakeCaseStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonNaming(SnakeCaseStrategy.class)

public class Album {

  private String id;
  private String name;
  private String artist;
  private String releaseDate;
  private Integer totalTracks;
  private String href;

}
