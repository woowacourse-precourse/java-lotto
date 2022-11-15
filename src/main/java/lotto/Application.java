package lotto;

import lotto.domain.LottoRepository;
import lotto.service.LottoService;
import lotto.view.View;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        LottoGame lottoGame = new LottoGame(new View(), new LottoService(new LottoRepository()));
        lottoGame.start();

    }
}
