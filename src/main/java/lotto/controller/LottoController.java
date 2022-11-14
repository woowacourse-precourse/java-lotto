package lotto.controller;

import lotto.model.Lotto;
import lotto.model.Player;
import lotto.service.LottoService;

import java.util.List;

public class LottoController {
    private final LottoService lottoService;
    private Player player;
    private List<Lotto> playerLottoList;

    public LottoController() {
        lottoService = new LottoService();
    }

    public void playLotto() {
        player = lottoService.createPlayer();
        lottoService.createPlayerLottoList(player.getTicketNumber());
    }
}
