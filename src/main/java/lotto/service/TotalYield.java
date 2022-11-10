package lotto.service;

public class TotalYield {
//    수익률 계산 수익률은 소수점 둘째 자리에서 반올림한다. (ex. 100.0%, 51.5%,
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
