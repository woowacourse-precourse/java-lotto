package lotto.controller;

import lotto.domain.Service;
import lotto.model.Check;
import lotto.model.Lotto;
import lotto.model.Rank;

import java.util.List;

public class Controller {

    Service service = new Service();

    public void lottoStart() {

        int money = service.getMoney();
        int volume = service.getVolume(money);

        List<Lotto> lotto = service.getLotto(volume);
        List<List<Integer>> lottoList = service.getLottoList(lotto);
        String jackpotNum = service.getJackpotNumber();
        String[] jackpotNumArr = service.getJackpotNumberToArr(jackpotNum);
        int bonusNum = service.getBonusNumber(jackpotNumArr);

        Rank rank = new Rank(0,0,0,0,0);

        for (List<Integer> lottos : lottoList) {
            List<Check> checkList = service.checkLotto(lottos, jackpotNumArr, bonusNum);
            service.checkRank(checkList, rank);
        }

        int winningPrice = service.getWinningPrice(rank);
        service.getEarningsRate(winningPrice, money);
    }
}
