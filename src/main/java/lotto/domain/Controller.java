package lotto.domain;

import lotto.model.Check;
import lotto.model.Lotto;
import lotto.model.Rank;

import java.util.List;

public class Controller {

    public static void lottoStart() {

        int money = Service.getMoney();
        int volume = Service.getVolume(money);

        List<Lotto> lotto = Service.getLotto(volume);
        List<List<Integer>> lottoList = Service.getLottoList(lotto);
        String jackpotNum = Service.getJackpotNumber();
        String[] jackpotNumArr = Service.getJackpotNumberToArr(jackpotNum);
        int bonusNum = Service.getBonusNumber();

        Rank rank = new Rank(0,0,0,0,0);

        for (List<Integer> lottos : lottoList) {
            List<Check> checkList = Service.checkLotto(lottos, jackpotNumArr, bonusNum);
            Service.checkRank(checkList, rank);
        }

        int winningPrice = Service.getWinningPrice(rank);
        Service.getEarningsRate(winningPrice, money);
    }
}
