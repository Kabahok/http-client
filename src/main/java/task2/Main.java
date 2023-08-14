package task2;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.client.HttpClient;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static final String URL = "https://api.nasa.gov/planetary/apod?api_key=0cjmxbsGlWJUIOygDh0p18FiarXPLCLSXeEc5n1o";
    public static final ObjectMapper mapper = new ObjectMapper();


    public static void main(String[] args) throws IOException {
        CloseableHttpClient httpClient = HttpClientBuilder.create()
                .setDefaultRequestConfig(RequestConfig.custom()
                        .setConnectTimeout(5000)
                        .setSocketTimeout(30000)
                        .setRedirectsEnabled(false)
                        .build())
                .build();

        HttpGet request = new HttpGet(URL);

        CloseableHttpResponse response = httpClient.execute(request);


        Content content = mapper.readValue(new String(response.getEntity().getContent().readAllBytes()), new TypeReference<Content>() {
        });

        content.downloadImg();

        System.out.println(content);

    }
}
