package gmail.anastasiacoder.helpers;

import static io.restassured.RestAssured.given;

import gmail.anastasiacoder.config.BrowserStackConfig;
import org.aeonbits.owner.ConfigFactory;

public class Browserstack {

    public static BrowserStackConfig browserStackConfig = ConfigFactory.create(
            BrowserStackConfig.class, System.getProperties());

    public static String videoUrl(String sessionId) {
        return given()
                .auth().basic(browserStackConfig.user(), browserStackConfig.key())
                .when()
                .get("https://api-cloud.browserstack.com/app-automate/sessions/" + sessionId + ".json")
                .then()
                .statusCode(200)
                .log().body()
                .extract()
                .path("automation_session.video_url");
    }
}