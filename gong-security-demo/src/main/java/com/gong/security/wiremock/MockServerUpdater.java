package com.gong.security.wiremock;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.core.io.ClassPathResource;

import java.io.IOException;

import static com.github.tomakehurst.wiremock.client.WireMock.*;

/**
 * Created by GongWenHua on 17.12.25.
 */
public class MockServerUpdater {

    public static void main(String[] args) throws IOException {

        configureFor(8097);
        removeAllMappings();

        mock("/order/1","01");
        mock("/order/2","02");
    }

    public static void mock(String url, String fileName) throws IOException {
        ClassPathResource classPathResource = new ClassPathResource("mock/response/" + fileName + ".txt");

        String fileContent = StringUtils.join(FileUtils.readLines(classPathResource.getFile(), "UTF-8").toArray(), "\n");
        stubFor(
                get(urlPathEqualTo(url)).
                        willReturn(aResponse().
                                withBody(fileContent).
                                withStatus(200)
                        )
        );
    }
}
