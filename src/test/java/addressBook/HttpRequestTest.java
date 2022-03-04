package addressBook;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class HttpRequestTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void greetingShouldReturnDefaultMessage() throws Exception {
        assertThat(this.restTemplate.getForObject("http://localhost:" + port + "/result",
                String.class)).isEqualTo(
                        "<!DOCTYPE HTML>\r\n" +
                                "<html>\r\n" +
                                "<head>\r\n" +
                                "    <title>Submitted</title>\r\n" +
                                "    <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\"/>\r\n" +
                                "</head>\r\n" +
                                "<body>\r\n" +
                                "<h1>Address Book Uploaded</h1>\r\n" +
                                "</body>\r\n" +
                                "</html>"
        );
    }
}
