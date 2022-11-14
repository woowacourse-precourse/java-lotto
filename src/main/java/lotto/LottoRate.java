package lotto;

public class LottoRate {
    private double rate;

    public LottoRate(long totalPrizeMoney, long payment) {
        rate = (double) totalPrizeMoney / (double) payment * 100.0;
    }
    public double getRate(){
        return rate;
    }
}
