package sdk;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;

import java.util.concurrent.Future;
import java.util.logging.Logger;

public class ReactivehubClient {

    private static final Logger LOGGER = Logger.getLogger(ReactivehubClient.class.getName());

    /**
     * @param namespace
     * @param clientKey
     * @param clientSecret
     * @return ClientConfig
     */
    public ClientConfig buildClient(String namespace, String clientKey, String clientSecret) {
        return new ClientConfig(namespace, clientKey, clientSecret);
    }

    /**
     * @param clientConfig
     * @param eventName
     * @param payload
     * @return  {@code Future}
     */
    public Future<HttpResponse<JsonNode>> publishEvent(ClientConfig clientConfig, String eventName, String payload) {

        String url = String.format("https://%s/reactibehub.io/%s", clientConfig.getNamespace(), eventName);

        LOGGER.info(String.format("Send HTTP { POST } to URL: %s", url));

        return Unirest.post(url)
                .header("Content-Type", "application/json")
                .header("client_key", clientConfig.getClientKey())
                .header("client_secret", clientConfig.getClientSecret())
                .body(payload)
                .asJsonAsync();

    }

}
