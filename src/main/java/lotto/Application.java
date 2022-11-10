package lotto;

import lotto.domain.lotto.presentation.dto.LottoController;

public class Application {
    public static void main(String[] args) {
        LottoController lottoController = new LottoController();

        int lottoCount = lottoController.getLottoCount(lottoController.getInputMoney());
        for (int i = 0; i < lottoCount; i++) {
            lottoController.getLottoNumbers();
        }
    }
}
