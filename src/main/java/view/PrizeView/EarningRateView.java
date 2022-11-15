package view.PrizeView;

public class EarningRateView {

    private final double earningRate;

    public EarningRateView(double earningRate) {
        this.earningRate = earningRate;
    }

    public void show() {
        System.out.println("총 수익률은 " + earningRate + "%입니다.");
    }
}
