package ma.usmba.paiementservice.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "token")
@Data
public class PaiementConfigParams {
    private long refreshTokenTimeout;
    private long accessTokenTimeout;
}
