package lotto.controller;

import lotto.model.BonusNumber;
import lotto.model.Lotto;
import lotto.model.LottoRank;
import lotto.model.Player;
import lotto.service.LottoService;

import java.util.List;

public class LottoController {
    private final LottoService lottoService;
    private Player player;
    private List<Lotto> playerLottoList;
    private Lotto winLotto;
    private BonusNumber bonusNumber;
    private List<LottoRank> lottoRanks;

    public LottoController() {
        lottoService = new LottoService();
    }

    public void playLotto() {
        player = lottoService.createPlayer();
        playerLottoList = lottoService.createPlayerLottoList(player.getTicketNumber());
        winLotto = lottoService.createWinLotto();
        bonusNumber = lottoService.createBonusNumber(winLotto.getNumbers());
        lottoRanks = lottoService.getLottoRanks(playerLottoList, winLotto, bonusNumber);
        lottoService.printResult(lottoRanks);
    }
}
