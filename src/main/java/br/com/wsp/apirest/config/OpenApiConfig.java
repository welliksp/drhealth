package br.com.wsp.apirest.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition(info = @Info(title = "Person API",
        version = "1.0",
        description = "API de cadastro de Pessoas",
        termsOfService = "",
        license = @License(url = "http://www.apache.org/licenses/LICENSE-2.0.html", name = "Apache 2.0"),
        contact = @Contact(name = "Wellik Perroni",
                email = "welliksp@gmail.com")))
public class OpenApiConfig {

}
