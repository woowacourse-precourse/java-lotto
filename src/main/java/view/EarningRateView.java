package view;

public class EarningRateView {

    public EarningRateView(double earningRate) {
        this.earningRate = earningRate;
    }

    private final double earningRate;

    public void show() {
        System.out.println("총 수익률은 " + earningRate + "%입니다.");
    }
}
