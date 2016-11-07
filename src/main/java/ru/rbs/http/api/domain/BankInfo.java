package ru.rbs.http.api.domain;

public class BankInfo {
    public String bankName;
    public String bankCountryCode;
    public String bankCountryName;

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
