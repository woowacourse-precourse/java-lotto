package lotto.controller;

import java.util.List;
import lotto.console.Output;
import lotto.player.Host;
import lotto.player.Store;
import lotto.player.User;
import lotto.statistics.Statistics;
import lotto.ticket.Winning;

public class LottoController {

    public void buyLotto(User user, Store store) {
        user.buyLottoAll(store);
        Output.printLotto(user.getLottos());
    }

    public Statistics drawLotto(Host host, User user) {
        List<Winning> drawResults = host.drawLotto(user.getLottos());
        return new Statistics(drawResults);
    }

    public void showStatistics(Statistics statistics, User user) {
        Output.printStatistics(statistics);
        statistics.printProfit(user.getMoney());
    }
}
