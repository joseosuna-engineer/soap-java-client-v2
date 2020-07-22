package com.prottonne.soap;

import WSPackage.WSClient;
import java.io.IOException;
import java.net.URL;
import javax.xml.namespace.QName;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Main {

    @Value("${ws.endpoint}")
    private String endpoint;

    @Value("${read.timeup}")
    private String readTimeup;

    @Value("${connection.timeup}")
    private String connectionTimeup;

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }

    @Bean
    public URL getWSUrl() {

        try {
            URL WSUrl = new URL(endpoint + "?wsdl");
            WSUrl.openConnection().setConnectTimeout(Integer.valueOf(connectionTimeup));
            WSUrl.openConnection().setReadTimeout(Integer.valueOf(readTimeup));
            return WSUrl;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    @Bean
    public WSClient getService() {
        return new WSClient(getWSUrl(), new QName("path-data", "data"));
    }

}
