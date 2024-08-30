package com.tremorkid.coreservice.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class SwaggerConfig {

    @Value("${springdoc.server.url}")
    private String[] serverUrl;

    @Value("${springdoc.info.version}")
    private String infoVersion;
    private final List<Server> serverList = new ArrayList<>();

    @Bean
    public OpenAPI openAPI() {
        return new OpenAPI();
    }

    @Bean
    public OpenAPI customizeOpenAPI(OpenAPI openApi) {
        openApi.info(new Info()
                .title("Assign IT API")
                .version(infoVersion)
                .description("Assign IT API documentation"));

        for (String server: serverUrl) {
            serverList.add(new Server()
                    .url(server)
                    .description("Server URL"));
        }

        openApi.servers(serverList);

        return openApi;
    }

}
