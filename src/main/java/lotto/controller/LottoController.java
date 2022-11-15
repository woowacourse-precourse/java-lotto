package lotto.controller;

import lotto.domain.player.Lottos;
import lotto.domain.player.Player;
import lotto.domain.statistic.Result;
import lotto.domain.winner.LottoWinner;
import lotto.view.View;

public class LottoController {
    private View view;
    private Player player;
    private Lottos lottoGame;
    private LottoWinner lottoWinner;

    public LottoController(Player player, Lottos lottoGame, LottoWinner lottoWinner) {
        this.view = new View(player, lottoWinner);
        this.lottoWinner = lottoWinner;
        this.player = player;
        this.lottoGame = lottoGame;
    }

    public void start() {
        view.inputPrice();
        view.printPurchaseCount();
        lottoGame.generateLottos(player.getLottoCount());
        view.printLottos(lottoGame);
        view.inputLottoNumber();
        view.inputBonusNumber();

        Result result = new Result(lottoWinner, lottoGame, player);
        result.getCorrectCount();

        view.printStats();
        view.printGross();
    }
}
