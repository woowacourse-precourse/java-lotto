package lotto;

import lotto.controller.LottoPurchase;
import lotto.domain.Lotto;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        LottoPurchase lottoPurchase = new LottoPurchase();
        List<Lotto> purchaseLottos = lottoPurchase.purchaseLottos();
    }
}
