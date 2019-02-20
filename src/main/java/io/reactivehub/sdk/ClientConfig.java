package io.reactivehub.sdk;

/**
 * @author luizcaciatori
 */
public class ClientConfig {

    private String namespace;

    private String clientKey;

    private String clientSecret;

    /**
     * @param namespace
     * @param clientKey
     * @param clientSecret
     */
    public ClientConfig(String namespace, String clientKey, String clientSecret) {
        this.namespace = namespace;
        this.clientKey = clientKey;
        this.clientSecret = clientSecret;
    }

    public String getNamespace() {
        return namespace;
    }

    public String getClientKey() {
        return clientKey;
    }

    public String getClientSecret() {
        return clientSecret;
    }

    @Override
    public String
    toString() {
        return "ClientConfig {" +
                "namespace='" + namespace + '\'' +
                ", clientKey='" + clientKey + '\'' +
                ", clientSecret='" + clientSecret + '\'' +
                '}';
    }
}
