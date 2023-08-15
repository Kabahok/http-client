package task2;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class Content {
    private final String curDir = System.getProperty("user.dir");

    private String copyright;
    private String date;
    private String explanation;
    private String hdurl;
    private String mediaType;
    private String serviceVersion;
    private String title;
    private String url;

    public Content(
            @JsonProperty("copyright") String copyright,
            @JsonProperty("date") String date,
            @JsonProperty("explanation") String explanation,
            @JsonProperty("hdurl") String hdurl,
            @JsonProperty("media_type") String mediaType,
            @JsonProperty("service_version") String serviceVersion,
            @JsonProperty("title") String title,
            @JsonProperty("url") String url

    ) {
        this.copyright = copyright;
        this.date = date;
        this.explanation = explanation;
        this.hdurl = hdurl;
        this.mediaType = mediaType;
        this.serviceVersion = serviceVersion;
        this.title = title;
        this.url = url;
    }

    @Override
    public String toString() {
        return String.format("%s\n%s\n%s\n%s\n%s\n%s\n%s\n%s\n", copyright, date, explanation, hdurl, mediaType, serviceVersion, title, url);
    }

    public String getNameImg() {
        return hdurl.split("/")[ hdurl.split("/").length - 1];
    }

    public void downloadImg(){
        try(InputStream in = new URL(hdurl).openStream()) {
            Files.copy(in, Paths.get(String.format("%s/src/main/java/task2/%s", curDir, getNameImg())), StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
