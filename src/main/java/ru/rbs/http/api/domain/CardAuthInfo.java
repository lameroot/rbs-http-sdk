package ru.rbs.http.api.domain;


public class CardAuthInfo {

    private String pan;
    private String expiration;
    private String cardholderName;
    private String approvalCode;

    public String getPan() {
        return pan;
    }

    public void setPan(String pan) {
        this.pan = pan;
    }

    public String getExpiration() {
        return expiration;
    }

    public void setExpiration(String expiration) {
        this.expiration = expiration;
    }

    public String getCardholderName() {
        return cardholderName;
    }

    public void setCardholderName(String cardholderName) {
        this.cardholderName = cardholderName;
    }

    public String getApprovalCode() {
        return approvalCode;
    }

    public void setApprovalCode(String approvalCode) {
        this.approvalCode = approvalCode;
    }

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
