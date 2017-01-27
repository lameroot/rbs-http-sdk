package ru.rbs.http.api.domain;

public class BankInfo {
    private String bankName;
    private String bankCountryCode;
    private String bankCountryName;

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getBankCountryCode() {
        return bankCountryCode;
    }

    public void setBankCountryCode(String bankCountryCode) {
        this.bankCountryCode = bankCountryCode;
    }

    public String getBankCountryName() {
        return bankCountryName;
    }

    public void setBankCountryName(String bankCountryName) {
        this.bankCountryName = bankCountryName;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("BankInfo{");
        sb.append("bankName='").append(bankName).append('\'');
        sb.append(", bankCountryCode='").append(bankCountryCode).append('\'');
        sb.append(", bankCountryName='").append(bankCountryName).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
