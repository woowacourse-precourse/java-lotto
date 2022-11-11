package lotto.domain;

import lotto.service.LottoService;

public class Game {

    private LottoService lottoService;

    public Game() {
        this.lottoService = new LottoService();
    }

    public void run() {
        lottoService.start();
    }
}
