package br.com.wsp.drhealth.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition(info = @Info(title = "DrHealth API",
        version = "1.0",
        description = "DrHealth é uma API de cadastro de usuários, médicos, agendamento de consultas médicas",
        termsOfService = "",
        license = @License(url = "http://www.apache.org/licenses/LICENSE-2.0.html", name = "Apache 2.0"),
        contact = @Contact(name = "Wellik Perroni",
                email = "welliksp@gmail.com")))
public class OpenApiConfig {

}
