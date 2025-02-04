package helpers;

import java.net.MalformedURLException;
import java.net.URL;

import static helpers.Environment.bsLogin;
import static helpers.Environment.bsPassword;
import static io.restassured.RestAssured.given;


public class Browserstack {

    public static URL getBrowserstackUrl() {
        try {
            return new URL("https://" + bsLogin + ":" + bsPassword + "@hub-cloud.browserstack.com/wd/hub");
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }

    // curl -u "qaguru_ti9G5S:5yrxu4nFTKkRExUAhqxh" -X GET "https://api.browserstack.com/app-automate/sessions/0359d759d2aaa4f46401dac46bd281b6d9b24943.json"
    // automation_session.video_url

    public static String videoUrl(String sessionId) {
        String url = String.format("https://api.browserstack.com/app-automate/sessions/%s.json", sessionId);

        return given()
                .auth().basic("mps_JNOjrv", "wz2xS6EhDTJx4xWkckYp")
                .get(url)
                .then()
                .log().status()
                .log().body()
                .statusCode(200)
                .extract().path("automation_session.video_url");
    }
}