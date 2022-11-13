package controller;


public class RandomNumberCreator {
    public static final int ONE_THOUSAND = 1000;

    public static int DivideMoneyBy1000(int purchasingMoney) {
        if (purchasingMoney % ONE_THOUSAND != 0) {
            throw new IllegalArgumentException();
        }
        int chance = purchasingMoney / ONE_THOUSAND;
        view.OutputView.showMadePurchase(chance);
        return chance;
    }
}
