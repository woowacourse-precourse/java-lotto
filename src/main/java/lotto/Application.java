package lotto;

import java.util.List;

public class Application {

    public static void main(String[] args) {
        LottoController lottoController = new LottoController();

        Integer lottoCount = lottoController.getUserLottoCount();
        List<Lotto> issuedLotto = lottoController.issueLotto(lottoCount);
    }
}
