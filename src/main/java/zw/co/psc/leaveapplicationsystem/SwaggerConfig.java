package zw.co.psc.leaveapplicationsystem;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import io.swagger.v3.oas.annotations.servers.Server;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {
    @OpenAPIDefinition(
            info = @Info(
                    title = "Leave Application System Client",version = "1.0.0",
                    description = "Leave Application System ", contact = @Contact(
                    name = "PSC Dev Team",
                    url = "pscservices.co.zw",
                    email = "systemsdev@pscservices.co.zw"
            ), license = @License(
                    name = "MIT License",
                    url = "https://pscservices.co.zw/LICENSE")),
            servers = @Server(url = "http:localhost:8080")
    )
    @SecurityScheme(
            name = "bearerAuth",
            type = SecuritySchemeType.HTTP,
            bearerFormat = "JWT",
            scheme = "bearer"
    )
    static class OpenAPIConfiguration {
    }
}
