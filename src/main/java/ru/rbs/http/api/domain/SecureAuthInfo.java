package ru.rbs.http.api.domain;

public class SecureAuthInfo {

    public String eci;
    public String cavv;
    public String xid;

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("SecureAuthInfo{");
        sb.append("eci='").append(eci).append('\'');
        sb.append(", cavv='").append(cavv).append('\'');
        sb.append(", xid='").append(xid).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
