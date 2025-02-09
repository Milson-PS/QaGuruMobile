package helpers;

import java.net.MalformedURLException;
import java.net.URL;

import static config.ConfigHelper.BS_LOGIN;
import static config.ConfigHelper.BS_PASSWORD;
import static io.restassured.RestAssured.given;


public class Browserstack {

    public static URL getBrowserstackUrl() {
        try {
            return new URL("https://" + BS_LOGIN + ":" + BS_PASSWORD + "@hub-cloud.browserstack.com/wd/hub");
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }

    public static String videoUrl(String sessionId) {
        String url = String.format("https://api.browserstack.com/app-automate/sessions/%s.json", sessionId);

        return given()
                .auth().basic(BS_LOGIN, BS_PASSWORD)
                .get(url)
                .then()
                .statusCode(200)
                .extract().path("automation_session.video_url");
    }
}