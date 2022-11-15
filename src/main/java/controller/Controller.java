package controller;

import lotto.Lotto;
import model.Server;
import view.Client;

import java.util.List;
import java.util.Set;

public class Controller {
    private final Client client = new Client();
    private final Server server = new Server();

    public void checkLotto() {
        int money = client.getLottoMoney();
        List<Integer> winLottoNumber = client.getWinLottoNumber();
        int bonusNumber = 0;
        do {
            bonusNumber = client.getWinBonusNumber();
        } while (server.isInclude(winLottoNumber, bonusNumber));
        for (int lotto = 0; lotto < server.decideToBuyLotto(money); lotto++) {
            List<Integer> lottoNumber = server.publishLotto();
            Lotto lottoCheck = new Lotto(lottoNumber);
            lottoNumber = lottoCheck.lottoNumberSort();
            Set common = server.compareLottoNumber(lottoNumber, winLottoNumber);
            server.countMatchNumber(common);
        }
    }
}
