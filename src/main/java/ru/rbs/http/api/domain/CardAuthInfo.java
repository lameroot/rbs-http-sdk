package ru.rbs.http.api.domain;


public class CardAuthInfo {

    public String pan;
    public String expiration;
    public String cardholderName;
    public String approvalCode;

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("CardAuthInfo{");
        sb.append("pan='").append(pan).append('\'');
        sb.append(", expiration='").append(expiration).append('\'');
        sb.append(", cardholderName='").append(cardholderName).append('\'');
        sb.append(", approvalCode='").append(approvalCode).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
