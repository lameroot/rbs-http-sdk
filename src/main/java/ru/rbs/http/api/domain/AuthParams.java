package ru.rbs.http.api.domain;

public abstract class AuthParams {

    private String userName;
    private String password;
    private String hostProviderUrl;

    public AuthParams() {
    }

    public AuthParams(String userName, String password, String hostProviderUrl) {
        this.userName = userName;
        this.password = password;
        this.hostProviderUrl = hostProviderUrl;
    }

    public AuthParams(EndpointParams endpointParams) {
        this.userName = endpointParams.getUserName();
        this.password = endpointParams.getPassword();
        this.hostProviderUrl = endpointParams.getHostProviderUrl();
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getHostProviderUrl() {
        return hostProviderUrl;
    }

    public void setHostProviderUrl(String hostProviderUrl) {
        this.hostProviderUrl = hostProviderUrl;
    }
}
