package controller;

import lotto.Lotto;
import model.Server;
import view.Client;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Controller {
    private final Client client = new Client();
    private final Server server = new Server();
    private Map<Integer, Integer> matchNumberCount = new HashMap<>();

    public void checkLotto() {
        int money = client.getLottoMoney();
        List<Integer> winLottoNumber = client.getWinLottoNumber();
        int bonusNumber = 0;
        do {
            bonusNumber = client.getWinBonusNumber();
        } while (server.isInclude(winLottoNumber, bonusNumber));
        setMatchNumberCount();
        for (int lotto = 0; lotto < server.decideToBuyLotto(money); lotto++) {
            List<Integer> lottoNumber = server.publishLotto();
            Lotto lottoCheck = new Lotto(lottoNumber);
            lottoNumber = lottoCheck.lottoNumberSort();
            Set common = server.compareLottoNumber(lottoNumber, winLottoNumber);
            int matchNumber = server.countMatchNumber(common);
            if(matchNumber == 5 && server.compareBonusNumber(lottoNumber, bonusNumber)){
                putMatchNumberCount(7);
                continue;
            }
            putMatchNumberCount(matchNumber);
        }
    }

    public void setMatchNumberCount() {
        for(int match = 3; match < 8; match++){
            matchNumberCount.put(match, 0);
        }
    }

    public void putMatchNumberCount(int matchNumber) {
        matchNumberCount.put(matchNumber, matchNumberCount.get(matchNumber) + 1);
    }
}
