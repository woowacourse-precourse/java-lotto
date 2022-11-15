package lotto.controller;

import lotto.console.Input;
import lotto.player.Host;
import lotto.player.Store;
import lotto.player.User;
import lotto.statistics.Statistics;
import lotto.ticket.Lotto;

public class GameController {

    private Store store;
    private User user;
    private Host host;
    private LottoController lottoController;

    public GameController(LottoController lottoController) {
        this.store = new Store();
        initGameController();
        this.lottoController = lottoController;
    }

    public void start() {
        lottoController.buyLotto(user, store);
        Statistics statistics = lottoController.drawLotto(host, user);
        lottoController.showStatistics(statistics, user);
    }

    private void initGameController() {
        this.user = new User(Input.enterMoney());
        this.host = new Host(new Lotto(Input.enterWinningNumbers()),
                Input.enterWinningBonusNumber());
    }

}
