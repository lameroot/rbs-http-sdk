package ru.rbs.http.api.domain;

public class SecureAuthInfo {

    private String eci;
    private String cavv;
    private String xid;

    public String getEci() {
        return eci;
    }

    public void setEci(String eci) {
        this.eci = eci;
    }

    public String getCavv() {
        return cavv;
    }

    public void setCavv(String cavv) {
        this.cavv = cavv;
    }

    public String getXid() {
        return xid;
    }

    public void setXid(String xid) {
        this.xid = xid;
    }

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
