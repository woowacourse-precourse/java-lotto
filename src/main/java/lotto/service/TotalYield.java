package lotto.service;

public class TotalYield {
    private double totalPay;
    private double totalGain;

    public TotalYield(int totalPay, int totalGain) {
        this.totalPay = totalPay;
        this.totalGain = totalGain;
    }

    public double getYield() {
        return Math.round(((totalGain*100/ totalPay)) * 10) / 10.0;
    }
}
