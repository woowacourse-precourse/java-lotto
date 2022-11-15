package lotto;

import lotto.controller.LottoSystem;
import lotto.model.Lotto;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        LottoSystem lottoSystem = new LottoSystem();

        List<Lotto> userLottos = lottoSystem.purchaseLotto();
        List<?> wonLottoInfo = lottoSystem.drawLotto();

        lottoSystem.getLottoResult(userLottos, wonLottoInfo);
    }
}