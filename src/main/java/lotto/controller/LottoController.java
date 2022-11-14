package lotto.controller;

import lotto.model.Player;
import lotto.service.LottoService;

public class LottoController {
    private final LottoService lottoService;
    private Player player;

    public LottoController() {
        lottoService = new LottoService();
    }

    public void playLotto() {
        player = lottoService.createPlayer();
    }
}
