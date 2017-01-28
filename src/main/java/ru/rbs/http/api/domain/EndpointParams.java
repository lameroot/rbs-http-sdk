package ru.rbs.http.api.domain;

public class EndpointParams {

    private String userName;
    private String password;
    private String hostProviderUrl;

    public EndpointParams(String userName, String password, String hostProviderUrl) {
        this.userName = userName;
        this.password = password;
        this.hostProviderUrl = hostProviderUrl;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    public String getHostProviderUrl() {
        return hostProviderUrl;
    }
}
