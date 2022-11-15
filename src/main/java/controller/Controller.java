package controller;

import lotto.Lotto;
import model.Server;
import view.Client;
import view.PrintResult;

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
        int lottoPaper = server.decideToBuyLotto(money);
        PrintResult.printBuyLotto(lottoPaper);
        for (int lotto = 0; lotto < lottoPaper; lotto++) {
            List<Integer> lottoNumber = server.publishLotto();
            Set common = server.compareLottoNumber(lottoNumber, winLottoNumber);
            int matchNumber = server.countMatchNumber(common);
            if(matchNumber < 3){
                continue;
            }
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
