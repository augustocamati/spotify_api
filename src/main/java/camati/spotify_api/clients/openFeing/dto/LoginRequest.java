package camati.spotify_api.clients.openFeing.dto;


import feign.form.FormProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LoginRequest {
  @FormProperty("grant_type")
  private String grantType;
  @FormProperty("client_id")
  private String clientId;
  @FormProperty("client_secret")
  private String clientSecret;
}
